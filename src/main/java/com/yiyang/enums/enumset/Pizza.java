package com.yiyang.enums.enumset;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A specialized {@link java.util.Set} implementation for use with enum types.  All of
 * the elements in an enum set must come from a single enum type that is
 * specified, explicitly or implicitly, when the set is created.  Enum sets
 * are represented internally as bit vectors.  This representation is
 * extremely compact and efficient. The space and time performance of this
 * class should be good enough to allow its use as a high-quality, typesafe
 * alternative to traditional <tt>int</tt>-based "bit flags."  Even bulk
 * operations (such as <tt>containsAll</tt> and <tt>retainAll</tt>) should
 * run very quickly if their argument is also an enum set.
 */
public class Pizza {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
        EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus pizzaStatus;

    public Pizza() {}

    public boolean isDeliverable() {
        return this.pizzaStatus.isReady();
    }

    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> pizzas) {
        return pizzas.stream().filter(
                (pizza) -> undeliveredPizzaStatuses.contains(pizza.getPizzaStatus())
        ).collect(Collectors.toList());
    }

    public PizzaStatus getPizzaStatus() {
        return pizzaStatus;
    }

    public void setPizzaStatus(PizzaStatus pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
    }

    public static void main(String[] args) {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

        Pizza pz1 = new Pizza();
        pz1.setPizzaStatus(Pizza.PizzaStatus.DELIVERED);
        pizzas.add(pz1);

        Pizza pz2 = new Pizza();
        pz2.setPizzaStatus(Pizza.PizzaStatus.ORDERED);
        pizzas.add(pz2);

        Pizza pz3 = new Pizza();
        pz3.setPizzaStatus(Pizza.PizzaStatus.ORDERED);
        pizzas.add(pz3);

        Pizza pz4 = new Pizza();
        pz4.setPizzaStatus(Pizza.PizzaStatus.READY);
        pizzas.add(pz4);

        List<Pizza> allUndeliveredPizzas = Pizza.getAllUndeliveredPizzas(pizzas);
        System.out.println(allUndeliveredPizzas.size());
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
}
