package com.shpos.entity;

import java.util.Date;

/**
 * Created by likaisong on 2019/4/6.
 */
public class WeChatAuth {
    private Long wechatAuthId;
    private String openId;
    private Date createTime;
    private UserInfo userInfo;

    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
