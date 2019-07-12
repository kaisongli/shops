package com.shpos.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by likaisong on 2019-07-11.
 */
public class DynamicDataSourceHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    /**
     * 获取连接type
     * @return
     */
    public static String getDBType() {
        String db = contextHolder.get();
        if (db == null){
            db = DB_MASTER;
        }
        return db;
    }


    /**
     * 设置线程连接type
     * @param db
     */
    public static void setDBType(String db) {
        logger.debug("所选数据源是：" + db);
        contextHolder.set(db);
    }

    /**
     * 清理连接类型
     */
    public static void clearDB(){
        contextHolder.remove();
    }

}
