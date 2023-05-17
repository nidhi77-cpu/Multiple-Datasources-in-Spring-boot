/**
 * 
 */
package com.example.Springdatasources.config;



import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author srinidhi.k
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "productEntityManagerFactory",
	transactionManagerRef = "productTransactionManager",
	basePackages = {
	"com.example.Springdatasources.product.repositry"
	})


public class Productconfig {
	
	
	/*
	 * @Primary
	 * 
	 * @Bean(name="productdataSource")
	 * 
	 * @ConfigurationProperties(prefix = "spring.datasource") public DataSource
	 * dataSource() { return DataSourceBuilder.create().build(); }
	 */
	@Primary
    @Bean(name="productProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {

        return new DataSourceProperties();
    }

    @Primary
    @Bean(name="productDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource(@Qualifier("productProperties") DataSourceProperties properties){

        return  properties.initializeDataSourceBuilder().build();
    }
	
	
	@Primary
	@Bean(name="productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
    (EntityManagerFactoryBuilder builder, @Qualifier("productDatasource") DataSource dataSource)
	{
		  return  builder.dataSource(dataSource)
		            .packages("com.example.Springdatasources.product")
		            .persistenceUnit("ProductEntity").build();
			
	}

	@Primary
    @Bean(name = "productTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("productEntityManagerFactory") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
	 

}
