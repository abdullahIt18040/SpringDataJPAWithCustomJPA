package com.sdlcpro.sdlcprospringjpaapp.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
public class PgsqlDatabaseConfig {


    @Bean("pgsqlTransactionManager")
    public PlatformTransactionManager pgsqlTransationManager (EntityManagerFactory  pgsqlEntityManagerFactory)

    {
      var manager = new JpaTransactionManager();
      manager.setEntityManagerFactory(pgsqlEntityManagerFactory);
      return  manager;
    }

    @Bean
    public TransactionTemplate transactionTemplate ( PlatformTransactionManager pgsqlTransactionManager)
    {
        return new TransactionTemplate(pgsqlTransactionManager);

    }




}
