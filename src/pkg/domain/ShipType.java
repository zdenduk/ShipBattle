package pkg.domain;

public enum ShipType {
    BOAT(1),
    SUBMARINE(2),
    CRUISER(3);

    private int lenght;

    private ShipType(int a) {
        this.lenght = a;
    }

    public int getLenght() {
        return lenght;
    }

}
