package com.yiyang.enums.designpatterns;

import com.yiyang.enums.enumset.Pizza;

/**
 * Strategy Design Pattern
 */
public enum PizzaDeliveryStrategy {
    NORMAL {
        @Override
        public void deliver(Pizza pizza) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    },
    EXPRESS {
        @Override
        public void deliver(Pizza pizza) {
            System.out.println("Pizza will be delivered in express mode");
        }
    };

    public abstract void deliver(Pizza pizza);
}
