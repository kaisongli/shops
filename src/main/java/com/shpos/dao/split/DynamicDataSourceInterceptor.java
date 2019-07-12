package com.shpos.dao.split;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by likaisong on 2019-07-11.
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class})})
public class DynamicDataSourceInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //当前是否是事务
        boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
        String lookupKey = null;
        MappedStatement mappedStatement = null;
        if (synchronizationActive != true){
            Object[] objects = invocation.getArgs();
            //增删改查操作
            mappedStatement = (MappedStatement) objects[0];
            //读方法
            if (mappedStatement.equals(SqlCommandType.SELECT)){
                //如果selectkey为自增id查询主键（SELECT LAST_INSERT_KEY()方法，使用主库
                if (mappedStatement.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                    lookupKey = DynamicDataSourceHolder.DB_MASTER;
                }else {
                    BoundSql boundSql = mappedStatement.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    //写主库,从库读
                    if (sql.matches(REGEX)){
                        lookupKey = DynamicDataSourceHolder.DB_MASTER;
                    } else {
                        lookupKey =  DynamicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        }else {
            lookupKey = DynamicDataSourceHolder.DB_MASTER;
        }
        logger.debug("设置方法[{}] use [{}] strategy, SqlCommandType[{}]", mappedStatement.getId(),
                lookupKey, mappedStatement.getSqlCommandType().name());
        DynamicDataSourceHolder.setDBType(lookupKey);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        //增删改查拦截,拦截下来交由intercept执行
        if (target instanceof Executor){
            return Plugin.wrap(target, this);
        }else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
