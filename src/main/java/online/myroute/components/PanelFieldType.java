package online.myroute.components;

public enum PanelFieldType {
    TEXT("text"),
    PASSWORD("password")
    ;
    private String type;

    PanelFieldType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
