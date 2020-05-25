package com.yiyang.enums.designpatterns;

/**
 * Singleton
 * PizzaDeliverySystemConfiguration.getInstance returns a singleton PizzaDeliverySystemConfiguration instance
 */
public enum PizzaDeliverySystemConfiguration {
    INSTANCE;

    PizzaDeliverySystemConfiguration() {}

    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

    public static PizzaDeliverySystemConfiguration getInstance() {
        return INSTANCE;
    }

    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}
