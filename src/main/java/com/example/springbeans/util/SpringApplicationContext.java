package com.example.springbeans.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Utility class used for context operations
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * Return application context.
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getContext() {
        return SpringApplicationContext.context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
