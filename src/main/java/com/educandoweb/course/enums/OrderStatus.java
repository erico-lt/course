package com.educandoweb.course.enums;

public enum OrderStatus {
    
    WAINTING(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static OrderStatus valueOf(int code) {
        for(OrderStatus orde : OrderStatus.values()) {
            if(orde.getCode() == code) {
                return orde;
            }
        }
        throw new IllegalArgumentException("OrderStatus invalid code");
    }
}
