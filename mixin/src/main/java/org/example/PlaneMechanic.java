package org.example;

public interface PlaneMechanic {

    default void recoverPlain() {
        System.out.println("plain recover");
    }
}
