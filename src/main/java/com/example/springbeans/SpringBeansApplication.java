package com.example.springbeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Main Spring Boot class.
 * <p>
 * Adapted from tutorial at
 * https://www.baeldung.com/spring-show-all-beans
 */
@SpringBootApplication
public class SpringBeansApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBeansApplication.class.getName());

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        applicationContext = SpringApplication.run(SpringBeansApplication.class, args);
        displayAllBeans();
    }

    /*
     * This method uses the ListableBeanFactory interface (which ApplicationContext extends)
     * to get the bean definition names.
     */
    private static void displayAllBeans() {

        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        int counter = 1;
        for (String beanName : allBeanNames) {
            logger.info(counter++ + ": " + beanName);
        }
    }

}
