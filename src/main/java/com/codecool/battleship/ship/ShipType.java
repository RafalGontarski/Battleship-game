package com.codecool.battleship.ship;

public enum ShipType {
    CARRIER(2),
    CRUISER(3),
    BATTLESHIP(3),
    DESTROYER(4),
    SUBMARINE(5);

    public final Integer uniqueLength;

    ShipType(Integer uniqueLength) {
        this.uniqueLength = uniqueLength;
    }
}
