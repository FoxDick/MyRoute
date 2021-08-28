package online.myroute.components;

public class PanelField {

    private String fieldName;
    private String name;
    private String description;
    private int priority;
    private PanelFieldType type;
    private boolean readOnly;
    private String value;

    public PanelField(String fieldName, String name, String description, int priority, PanelFieldType type, boolean readOnly, String value) {
        this.fieldName = fieldName;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.readOnly = readOnly;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PanelFieldType getType() {
        return type;
    }

    public void setType(PanelFieldType type) {
        this.type = type;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
