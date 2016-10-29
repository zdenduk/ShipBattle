package pkg.domain;

public enum FieldType {
    NOTHING(""),
    SHIP(""),
    HIT("I destroyed a ship!"),
    MISS("It's a miss.");


    private String caption;

    private FieldType(String a) {
        this.caption = a;
    }

    public String getCaption() {
        return caption;
    }
}
