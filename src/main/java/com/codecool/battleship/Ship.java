package com.codecool.battleship;

import java.util.List;

public class Ship {

    private List<Square> NewShip;
    private ShipType ShipType;

    public Ship(List<Square> newShip,  ShipType shipType) {
        NewShip = newShip;
        ShipType = shipType;
    }

    public List<Square> getFields() {
        return NewShip;
    }

    public ShipType getShipType() {
        return ShipType;
    }

    public void add(Square square) {
        NewShip.add(square);
    }

    public boolean isPlacementOk (Ship ship1, List<Ship> ships, Board board) {
        int count = 0;
        for (int i = 0; i < ship1.getFields().size(); i++) {
            if (ship1.getFields().get(i).getY() > board.getSizeY() ||
                ship1.getFields().get(i).getX() > board.getSizeX()) {
                count++;
            }
            for (int j = 0; j < ships.size(); j++) {
                for (int k = 0; k < ships.get(j).getFields().size(); k++){
                    if (ship1.getFields().get(i).getX() == ships.get(j).getFields().get(k).getX() &&
                        ship1.getFields().get(i).getY() == ships.get(j).getFields().get(k).getY()) {
                        count++;
                    }
                }
            }
        }
//        return count == 0 ? true : false;

        if(count == 0){
            return true;
        }
        return false;
    }
}
