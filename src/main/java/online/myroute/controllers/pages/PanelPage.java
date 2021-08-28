package online.myroute.controllers.pages;


import online.myroute.components.EntityPanel;
import online.myroute.model.anotations.PanelMeta;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class PanelPage {

    ApplicationContext context;

    public PanelPage(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/panels/{className}/{id}")
    public String greeting(@PathVariable String className, @PathVariable String id, Model model) throws ClassNotFoundException {
        Class<?> type = Class.forName(EntityPanel.ENTITY_PACKET_PATH + className);
        Class<?> repositoryClass;
        if (type.isAnnotationPresent(PanelMeta.class)) {
            repositoryClass = type.getAnnotation(PanelMeta.class).repositoryClass();
        } else {
            throw new IllegalArgumentException("class must be decorated @PanelMeta");
        }
        Object repository = context.getBean(repositoryClass);
        Object object = ((CrudRepository) repository).findById(Integer.valueOf(id));
        if (!((Optional)object).isPresent()) {
            throw new RuntimeException("object not found by id");
        }
        EntityPanel entityPanel = new EntityPanel(((Optional)object).get(), "table table-borderless");
        model.addAttribute("panel", entityPanel);
        return "entityPanelPage";
    }

}
