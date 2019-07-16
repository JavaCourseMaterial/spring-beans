package com.example.springbeans.service;

import com.example.springbeans.model.SpringBean;
import com.example.springbeans.util.SpringApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bean Service class used to query Spring context for Bean information.
 */
@Service
public class BeanService {

    // logger
    private static final Logger logger = LoggerFactory.getLogger(BeanService.class.getName());

    // We need to use a bean factory to get information about Spring beans
    private ConfigurableListableBeanFactory beanFactory;

    public BeanService(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public List<SpringBean> getBeans() {

        logger.info("getBeans called");

        // setup
        ApplicationContext context = SpringApplicationContext.getContext();
        List<SpringBean> listOfBeans = new ArrayList<>();

        // get bean definition names
        String[] beans = context.getBeanDefinitionNames();

        // for each bean...
        for (String bean : beans) {

            // create new SpringBean to hold information
            SpringBean sb = new SpringBean();

            // we need a BeanDefinition to query info about this bean
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(bean);

            // get aliases for this bean
            String[] aliases = beanFactory.getAliases(bean);
            sb.setAliases(aliases != null ? Arrays.asList(aliases) : new ArrayList<>());

            // get dependencies for this bean
            String[] dependencies = beanFactory.getDependenciesForBean(bean);
            sb.setDependencies(dependencies != null ? Arrays.asList(dependencies) : new ArrayList<>());

            // get the bean name, resource, scope and type
            sb.setName(bean);
            sb.setResource(beanDefinition.getResourceDescription());
            sb.setScope(beanDefinition.getScope());
            sb.setType(beanFactory.getType(bean).getName());

            // add SpringBean to our list of beans
            listOfBeans.add(sb);
        }

        logger.info(new StringBuilder().append("Returning ").append(listOfBeans.size()).append(" Spring beans.").toString());
        return listOfBeans;
    }

}
