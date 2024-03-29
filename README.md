# Spring Bean Demo
This demo shows different ways of looking at the Spring beans contained in the Spring IoC container.

## ListableBeanFactory Interface
The `ListableBeanFactory` interface has a method `getBeanDefinitionNames()`, which allows you to query all of the beans currently being managed by the Spring IoC container.  These bean names can be seen in the log file upon startup.  This is generated by the `displayAllBeans()` method in the SpringBeansApplication class.

## Actuator
It's also possible to view the beans using Spring Boot Actuator.  This can be accomplished by navigating to 
```
http://localhost:8080/actuator/beans
```
If you're using IntelliJ Ultimate, you can use the Endpoints --> Mappings in the Run console to view the /actuator/beans endpoint

## REST Endpoint
It's also possible to call the REST endpoint at...
```
http://localhost:8080/displayBeans
```
...to get a list of Spring beans and some info about them.  The `BeanService` class has the code that queries the Spring IoC container using a `BeanFactory` as well as a `BeanDefinition` and marshals the info into a list of `SpringBean` objects which is then returned as JSON.
