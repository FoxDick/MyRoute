package online.myroute.model.anotations;


import online.myroute.components.PanelFieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface PanelFieldMeta {
    String name();
    String description();
    int priority() default 0;
    PanelFieldType type();
    boolean readOnly() default false;
}
