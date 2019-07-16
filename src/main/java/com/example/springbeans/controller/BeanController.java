package com.example.springbeans.controller;

import com.example.springbeans.model.SpringBean;
import com.example.springbeans.service.BeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Simple REST controller
 */
@RestController
public class BeanController {

    private static final Logger logger = LoggerFactory.getLogger(BeanController.class.getName());

    private BeanService beanService;

    public BeanController(BeanService beanService) {

        this.beanService = beanService;
    }

    /**
     * displayBeans endpoint
     *
     * @return List of SpringBeans
     */
    @RequestMapping(value = "/displayBeans")
    public List<SpringBean> displayBeans() {

        logger.info("displayBeans endpoint called");
        return beanService.getBeans();
    }
}
