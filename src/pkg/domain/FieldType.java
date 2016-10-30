package pkg.domain;

public enum FieldType {
    NOTHING(""),
    SHIP(""),
    HIT(""),
    MISS("");


    private String caption;

    private FieldType(String a) {
        this.caption = a;
    }

    public String getCaption() {
        return caption;
    }
}
