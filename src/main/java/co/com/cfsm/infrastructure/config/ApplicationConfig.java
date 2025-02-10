package co.com.cfsm.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.com.cfsm.application.marvel.port.out.MarvelOutputPort;
import co.com.cfsm.application.marvel.service.CharterService;
import co.com.cfsm.infrastructure.outbound.adaptaer.MarvelRestAdapter;
import feign.Logger;

@Configuration
public class ApplicationConfig {


  private final MarvelPropertiesConfig marvelPropertiesConfig;


  public ApplicationConfig(MarvelPropertiesConfig marvelPropertiesConfig) {
    this.marvelPropertiesConfig = marvelPropertiesConfig;
  }

  @Bean
  CharterService charterService() {
    return new CharterService(getMarvelRestAdapter());
  }

  @Bean
  MarvelOutputPort getMarvelRestAdapter() {
    return new MarvelRestAdapter(marvelPropertiesConfig);
  }

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

}
