package cn.itcast.listener;

import cn.itcast.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("success");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
