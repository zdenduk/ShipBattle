package pkg.domain.impl;

import pkg.domain.Battlefield;
import pkg.domain.FieldType;
import pkg.domain.Player;

public class PlayerImpl implements Player {
    Battlefield battlefield;

    public PlayerImpl(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    @Override
    public Battlefield getBattlefield() {
        return battlefield;
    }

}
