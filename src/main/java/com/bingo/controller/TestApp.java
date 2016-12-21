package com.bingo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class TestApp {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
//        System.out.print(applicationContext.getId());

        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.ping());
        //设置key-value
        jedis.set("school", "航电");
        System.out.println("my school is: " + jedis.get("school"));

        //设置list
        jedis.lpush("language", "nodejs");
        List<String> list = jedis.lrange("language", 0, 10);
        for (String _l : list) {
            System.out.println(_l);
        }
    }
}
