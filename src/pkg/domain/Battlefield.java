package pkg.domain;

public interface Battlefield {
    void addShip(int x, int y, boolean direction,ShipType shipType);

    void fireOn(int x, int y);

    FieldType[][] getBattlefield();
}
