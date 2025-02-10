package co.com.cfsm.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;


@Configuration
@Getter
public class MarvelPropertiesConfig {

  @Value("#{T(java.time.Instant).now().toEpochMilli()}")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private String ts;

  @Value("${marvel.api.key.private}")
  private String privateApikey;

  @Value("${marvel.api.key.public}")
  private String publicApikey;

}
