package pkg.domain.impl;

import pkg.domain.Battlefield;
import pkg.domain.FieldType;
import pkg.domain.ShipType;

public class BattlefieldImpl implements Battlefield {
    FieldType[][] battlefield;

    public BattlefieldImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be bigger than 0.");
        }
        battlefield = new FieldType[size][size];
        createBattlefield();
    }

    private void createBattlefield() {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[0].length; j++) {
                battlefield[i][j] = FieldType.NOTHING;
            }
        }
    }

    @Override
    public void addShip(int x, int y, boolean direction, ShipType shipType) {
        if (direction == false) {
            for (int i = 0; i < shipType.getLenght(); i++) {
                battlefield[x][y] = FieldType.SHIP;
                x++;
            }
        } else {
            for (int i = 0; i < shipType.getLenght(); i++) {
                battlefield[x][y] = FieldType.SHIP;
                y++;
            }
        }
    }

    @Override
    public void fireOn(int x, int y) {
        if (battlefield[x][y] == FieldType.NOTHING) {
            battlefield[x][y] = FieldType.MISS;
            System.out.println("Miss");
        } else if (battlefield[x][y] == FieldType.SHIP) {
            battlefield[x][y] = FieldType.HIT;
            System.out.println("Hit");
        }
    }

    @Override
    public FieldType[][] getBattlefield() {
        return battlefield;
    }
}
