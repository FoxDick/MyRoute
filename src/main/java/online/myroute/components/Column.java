package online.myroute.components;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Column {
    private String fieldName;
    private String name;
    private String description;
    private int priority;

    public Column(String fieldName, String name, String description, int priority) {
        this.fieldName = fieldName;
        this.name = name != null ? name : fieldName;
        this.description = description != null ? description : fieldName;
        this.priority = priority;
    }

    public String getColumnData(Object data) throws IllegalAccessException {
        Field field = Arrays.stream(data.getClass().getDeclaredFields()).filter(item -> item.getName().equals(this.fieldName)).findAny()
                .orElseThrow(() -> new RuntimeException("Field not found"));
        field.setAccessible(true);
        return field.get(data).toString();
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
}
