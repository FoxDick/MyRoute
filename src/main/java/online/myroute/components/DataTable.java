package online.myroute.components;

import online.myroute.model.anotations.DataTableColumnMeta;
import online.myroute.model.anotations.DataTableMeta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DataTable<T> {

    private String tableName;
    private String cssClass;
    private String emptyDataText;
    private List<Column> columns;
    private List<T> data;
    private String className;

    public DataTable(Class<T> type, String cssClass, Iterable<T> data) {
        if (type == null) {
            throw new IllegalArgumentException("type must be not null");
        }
        if (data == null) {
            throw new IllegalArgumentException("list must be not null");
        }
        this.className = type.getSimpleName();
        this.cssClass = cssClass;
        this.data = StreamSupport.stream(data.spliterator(), false).collect(Collectors.toList());
        if (type.isAnnotationPresent(DataTableMeta.class)) {
            this.tableName = type.getAnnotation(DataTableMeta.class).name();
            this.emptyDataText = type.getAnnotation(DataTableMeta.class).emptyDataText();
        }
        this.columns = Arrays.stream(type.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(DataTableColumnMeta.class))
                .map(field -> {
                    DataTableColumnMeta columnMeta = field.getAnnotation(DataTableColumnMeta.class);
                    return new Column(field.getName(), columnMeta.name(), columnMeta.description(), columnMeta.priority());
                }).sorted(Comparator.comparing(Column::getPriority)).collect(Collectors.toList());
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getEmptyDataText() {
        return emptyDataText;
    }

    public void setEmptyDataText(String emptyDataText) {
        this.emptyDataText = emptyDataText;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
