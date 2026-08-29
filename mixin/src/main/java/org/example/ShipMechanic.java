package org.example;

public interface ShipMechanic {

    default void recoverShip() {
        System.out.println("Recover Ship");
    }
}
