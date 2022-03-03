package com.pengo.spring;

import com.pengo.spring.ioc.User;
import com.pengo.spring.ioc.UserService;
import com.pengo.spring.ioc.Validators;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZoneId;
import java.util.stream.Collectors;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 11:23
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    @Value("classpath:/spring/logo.txt")
    private Resource resource;
    private String logo;
    @PostConstruct
    public void init() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            logo = bufferedReader.lines().collect(Collectors.joining("\n"));
            System.out.println(logo);
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        Validators validators = context.getBean(Validators.class);
        validators.validate("bob@example.com", "password", "abc");
        User user = userService.login("bob@example.com", "password");
        User spring = userService.register("123@spring.com", "1234", "spring");
        System.out.println("login:" + user);
        System.out.println("register:" + spring);
    }
    @Bean
    @Qualifier("z")
    ZoneId createZoneOfZ() {
        return ZoneId.of("Z");
    }

    @Bean
    @Qualifier("utc8")
    ZoneId createZoneOfUTC8() {
        return ZoneId.of("UTC+08:00");
    }
}
