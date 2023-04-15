package com.skillsoft.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration("mainBean")
@EnableJpaRepositories(basePackages = "com.skillsoft.springdatajpa")
@Import(JpaConfig.class)
public class App 
{
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DataSource dataSource;

    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(App.class);
        ctx.refresh();

        App s = (App) ctx.getBean("mainBean");

        s.addEmployees();

        ctx.close();
    }

    private void addEmployees() {

        Employee richard = new Employee("Richard", 2);
        Employee shari = new Employee("Shari", 4);
        Employee john = new Employee("John", 2);
        Employee rose = new Employee("Rose", 1);

        repository.save(richard);
        repository.save(shari);
        repository.save(john);
        repository.save(rose);
    }
}
