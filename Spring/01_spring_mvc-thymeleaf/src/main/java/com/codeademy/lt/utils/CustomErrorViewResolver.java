package com.codeademy.lt.utils;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorViewResolver implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if (status == HttpStatus.NOT_FOUND) {
            return new ModelAndView("error/404");
//            return new ModelAndView("redirect:/products/list");
        }

        Map<String, String> myMap = new HashMap<>();
        myMap.put("messageFromResolver", "Custom message from CustomErrorViewResolver");
        return new ModelAndView("customErrorPage", myMap);
    }
}
