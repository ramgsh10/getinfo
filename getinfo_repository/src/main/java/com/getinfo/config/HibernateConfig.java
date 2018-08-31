package com.getinfo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.DriverManagerDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.getinfo.model"})
@PropertySource({"classpath:hibernate.properties"})
public class HibernateConfig 
{
	/*@Autowired
    private Environment environment;*/
 
	 @Bean
	 public DataSource getDataSource()
	 {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClass("com.mysql.jdbc.Driver");
	        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/virtual");
	        dataSource.setUser("root");
	        dataSource.setPassword("root");
	        return dataSource;
	  }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource)
    {
    	LocalSessionFactoryBuilder sfbuilder=new LocalSessionFactoryBuilder(dataSource);
    	sfbuilder.addProperties(hibernateProperties());
    	sfbuilder.scanPackages("com.getinfo.model");
    	return sfbuilder.buildSessionFactory();
     }
      
    private Properties hibernateProperties() 
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;        
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
       HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
       return txManager;
    }	
    
}	     
	      
	      // Setting Hibernate properties
	      
	     /* // Setting C3P0 properties
	      props.put("C3P0_MIN_SIZE", env.getProperty("hibernate.c3p0.min_size"));
	      props.put("C3P0_MAX_SIZE", env.getProperty("hibernate.c3p0.max_size"));
	      props.put("C3P0_ACQUIRE_INCREMENT", env.getProperty("hibernate.c3p0.acquire_increment"));
	      props.put("C3P0_TIMEOUT", env.getProperty("hibernate.c3p0.timeout"));
	      props.put("C3P0_MAX_STATEMENTS", env.getProperty("hibernate.c3p0.max_statements"));*/
