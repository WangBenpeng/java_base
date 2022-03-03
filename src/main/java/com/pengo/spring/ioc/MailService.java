package com.pengo.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author pengo
 * @description:
 * @date 2022/2/28 23:49
 */
@Component
public class MailService {
    @Autowired(required = false)
    @Qualifier("utc8")
    private ZoneId zoneId = ZoneId.systemDefault();

//    public void setZoneId(ZoneId zoneId) {
//        this.zoneId = zoneId;
//    }

    @PostConstruct
    public void init() {
        System.out.println("init mailService...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("destroy mailService...");
    }

    public String getTime() {
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public void sendLoginMail(User user) {
        System.err.println(String.format("Hi, %s! You are logged in at %s", user.getName(), getTime()));
    }

    public void sendRegistrationMail(User user) {
        System.err.println(String.format("Welcome, %s!", user.getName()));

    }
}
