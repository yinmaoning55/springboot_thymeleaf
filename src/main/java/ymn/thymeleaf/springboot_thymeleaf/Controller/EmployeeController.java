package ymn.thymeleaf.springboot_thymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ymn.thymeleaf.springboot_thymeleaf.dao.EmployeeDao;
import ymn.thymeleaf.springboot_thymeleaf.entities.Employee;

import java.util.Collection;
import java.util.Collections;

@Controller
public class EmployeeController {

   @Autowired
    EmployeeDao employeeDao;
    @GetMapping("/emps")
    public String list(Model model){
       Collection<Employee>employees=employeeDao.getAll();
      model.addAttribute("emps",employees);
        return "emp/list";
    }


}
