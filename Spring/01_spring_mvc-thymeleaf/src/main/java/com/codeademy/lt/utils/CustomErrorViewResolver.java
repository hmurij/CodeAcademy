package com.codeademy.lt.utils;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class CustomErrorViewResolver extends DefaultErrorAttributes implements ErrorViewResolver {
    private Map<String, Object> attributes;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        this.attributes = super.getErrorAttributes(webRequest, options);
        return attributes;
    }

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if (status == HttpStatus.NOT_FOUND) {
            return new ModelAndView("error/404");
//            return new ModelAndView("redirect:/products/list");
        }

//        Map<String, String> myMap = new HashMap<>();
//        myMap.put("messageFromResolver", "Custom message from CustomErrorViewResolver");
        attributes.put("messageFromResolver", "Custom message from CustomErrorViewResolver");
        return new ModelAndView("customErrorPage", attributes);
    }
}
