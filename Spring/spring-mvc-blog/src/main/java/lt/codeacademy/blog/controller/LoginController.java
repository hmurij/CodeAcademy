package lt.codeacademy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "/main-templates/login";
    }

    @PostMapping("/login")
    public String processLogin() {
//        return "redirect:/main";
        return "/main-templates/login";
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "/main-templates/logout";
    }

    @GetMapping("/secured")
    public String securityStatus() {
        return "/main-templates/secured";
    }
}
