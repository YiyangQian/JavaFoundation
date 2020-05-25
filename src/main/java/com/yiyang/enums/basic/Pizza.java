package com.yiyang.enums.basic;

/**
 * 1. enum will be compiled to a class
 * 2. compare enum with ==, do not use equals
 *      cause enum objects are singleton globally, so it's safe to compare with ==
 *      == is safer at run-time, as it can deal with Null case
 *      == is safer at compile time, as it will complain before compile
 */
public class Pizza {

    private PizzaStatus pizzaStatus;

    public Pizza() {}

    public boolean isDeliverable() {
        return this.pizzaStatus.isReady();
    }

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());
        System.out.println(PizzaStatus.ORDERED);
        System.out.println(PizzaStatus.ORDERED.name().getClass());
        System.out.println(PizzaStatus.ORDERED.getClass());

        Pizza testPizza = new Pizza();
        System.out.println(null == null); //true
        System.out.println(testPizza.getPizzaStatus() == PizzaStatus.ORDERED); //false
//        System.out.println(testPizza.getPizzaStatus().equals(PizzaStatus.ORDERED)); //NullPointerException
        testPizza.setPizzaStatus(PizzaStatus.ORDERED);
        System.out.println(testPizza.getPizzaStatus().equals(TestColor.GREEN)); // still can be compiled
        // System.out.println(testPizza.getPizzaStatus() == TestColor.GREEN); // cannot even be compiled
    }

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(3) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered() {return false;}

        public int getTimeToDelivery() {return timeToDelivery;}

        PizzaStatus (int timeToDelivery) {this.timeToDelivery = timeToDelivery;}
    }

    public enum TestColor {
        GREEN;
    }
}
