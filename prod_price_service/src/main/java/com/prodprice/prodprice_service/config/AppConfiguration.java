package com.prodprice.prodprice_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application configuration.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.prodprice.prodprice_service.dao"})
public class AppConfiguration
{
}
