package com.shpos.enume;

/**
 * Created by likaisong on 2019/4/12.
 */
public enum ShopStateEnum {
    /**
     * 店铺操作返回状态码
     */
    CHECK(0, "审核中"), OFFLINE(-1, "非法店铺"), SUCCESS(1, "操作成功"), PASS(2, "通过验证"),
    INNER_ERROR(-1001, "内部错误"), NULL_SHOPID(-1002, "shopId为空"), NULL_SHOP(1003, "店铺为空");

    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 根据传入的状态返回enum值
     *
     * @param state
     * @return
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
