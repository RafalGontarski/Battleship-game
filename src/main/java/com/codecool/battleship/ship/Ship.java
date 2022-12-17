package com.codecool.battleship.ship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.square.Square;

import java.util.List;

public class Ship {

    private final List<Square> NewShip1;
    private final ShipType ShipType;

    public Ship(List<Square> newShip,  ShipType shipType) {
        NewShip1 = newShip;
        ShipType = shipType;
    }

    public List<Square> getFields() {
        return NewShip1;
    }

    public ShipType getShipType() {
        return ShipType;
    }

    public void add(Square square) {
        NewShip1.add(square);
    }

    public boolean isPlacementOk (Ship ship1, List<Ship> ships, Board board) {

        int count = 0;
        for (int i = 0; i < ship1.getFields().size(); i++) {
            if (ship1.getFields().get(i).getY() > board.getSizeY() ||
                ship1.getFields().get(i).getX() > board.getSizeX()) {
                count++;
            }
            for (Ship ship : ships) {
                for (int k = 0; k < ship.getFields().size(); k++) {
                    if (ship1.getFields().get(i).getX() == ship.getFields().get(k).getX() &&
                            ship1.getFields().get(i).getY() == ship.getFields().get(k).getY()) {
                        count++;
                    }
                }
            }
        }

        return count != 0;
    }
}
