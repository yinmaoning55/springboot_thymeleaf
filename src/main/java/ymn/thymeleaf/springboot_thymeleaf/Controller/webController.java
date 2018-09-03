package ymn.thymeleaf.springboot_thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class webController {
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//return "index";
//    }
    @RequestMapping("/login")
        public String hello(){



        return "login";
        }
}
