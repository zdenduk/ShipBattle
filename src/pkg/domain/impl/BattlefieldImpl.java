package pkg.domain.impl;

import pkg.domain.Battlefield;
import pkg.domain.FieldType;

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
    public void addShip(int x, int y) {
        battlefield[x][y] = FieldType.SHIP;
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
