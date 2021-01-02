package com.designProject.Pastebin;

import com.p6spy.engine.spy.P6DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/pastebin");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("password123");



        return new P6DataSource(dataSourceBuilder.build());
        //return dataSourceBuilder.build();
    }
}
