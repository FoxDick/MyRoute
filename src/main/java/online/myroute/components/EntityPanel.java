package online.myroute.components;

import online.myroute.model.anotations.PanelFieldMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EntityPanel {

    public static final String ENTITY_PACKET_PATH = "online.myroute.model.db.";

    private Class<?> type;
    private Object object;
    private List<PanelField> fields;
    private String cssClass;


    public EntityPanel(Object object, String cssClass) {
        this.object = object;
        this.type = object.getClass();
        this.fields = Arrays.stream(this.type.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PanelFieldMeta.class))
                .map(field -> {
                    PanelFieldMeta columnMeta = field.getAnnotation(PanelFieldMeta.class);
                    return new PanelField(field.getName(), columnMeta.name(), columnMeta.description(),
                            columnMeta.priority(), columnMeta.type(), columnMeta.readOnly(), getColumnData(field.getName(), object));
                }).sorted(Comparator.comparing(PanelField::getPriority)).collect(Collectors.toList());
    }

    private String getColumnData(String fieldName, Object data) {
        Field field = Arrays.stream(data.getClass().getDeclaredFields()).filter(item -> item.getName().equals(fieldName)).findAny()
                .orElseThrow(() -> new RuntimeException("Field not found"));
        field.setAccessible(true);
        try {
            return field.get(data).toString();
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<PanelField> getFields() {
        return fields;
    }

    public void setFields(List<PanelField> fields) {
        this.fields = fields;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
}
