package pkg.domain;

public interface Battlefield {
    void addShip(int x, int y);

    void fireOn(int x, int y);

    FieldType[][] getBattlefield();
}
