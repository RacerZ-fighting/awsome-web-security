package com.example.sstidemo.controller;

/**
 * @author by RacerZ
 * @date 2024/2/19.
 */

import jakarta.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Controller
public class NotifyController {
    private final ApplicationContext applicationContext;
    private String templatePrefix = "classpath:/templates/";
    private String templateSuffix = ".html";

    @Autowired
    public NotifyController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping({"/notify"})
    public String notify(@RequestParam String fname, HttpSession session) throws IOException {
        Integer userId = (Integer)session.getAttribute("userId");
        userId = 1;
        if (userId != null && userId == 1) {
            if (fname.contains("../")) {
                return "error";
            } else {
                FileInputStream inputStream = new FileInputStream("/Users/racerz/Desktop/JavaSec/ctf/Real-World-CTF-6th-Challenges-main/ChatterBox/SSTIDemo/src/main/resources/templates/test.html");
//                InputStream inputStream = this.applicationContext.getResource(this.templatePrefix + fname + this.templateSuffix).getInputStream();
                fname = "test2";
                if (inputStream != null && this.safeCheck(inputStream)) {
                    String result = this.getTemplateEngine().process(fname, new Context());
                    return result;
                } else {
                    return "error";
                }
            }
        } else {
            return "redirect:login";
        }
    }

    public boolean safeCheck(InputStream stream) {
//        try {
//            String templateContent = new String(stream.readAllBytes());
//            return !templateContent.contains("<") && !templateContent.contains(">") && !templateContent.contains("org.apache") && !templateContent.contains("org.spring");
//        } catch (IOException var3) {
//            return false;
//        }
        return true;
    }

    private SpringTemplateEngine getTemplateEngine() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.applicationContext);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resolver.setPrefix(this.templatePrefix);
        resolver.setSuffix(this.templateSuffix);
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }
}

