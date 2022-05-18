package lt.codeacademy.blog.advice;

import lt.codeacademy.blog.NotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public String productNotFound(NotFoundException e, Model model) {
        model.addAttribute("id", e.getId());
        model.addAttribute("message", e.getMessage());
        return "error/not-found";
    }
}
