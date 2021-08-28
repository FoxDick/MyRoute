package online.myroute.controllers.pages;

import online.myroute.components.DataTable;
import online.myroute.model.db.AdminEntity;
import online.myroute.repositories.AdminRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    ApplicationContext context;

    public DemoController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/demo")
    public String greeting(@RequestParam(name="text", required=false, defaultValue="Hello") String text, Model model) {
        AdminRepository adminRepository = context.getBean(AdminRepository.class);
        AdminEntity admin = adminRepository.findById(Integer.valueOf(text));
        Iterable<AdminEntity> admins = adminRepository.findAll();
        DataTable<AdminEntity> adminsTable = new DataTable<>(AdminEntity.class, "table table-striped table-hover table-sm", admins);
        model.addAttribute("adminsTable", adminsTable);
        return "demo";
    }
}
