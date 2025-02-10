package co.com.cfsm.infrastructure.outbound.adaptaer;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import co.com.cfsm.application.marvel.port.out.MarvelOutputPort;
import co.com.cfsm.domain.util.HashGenerator;
import co.com.cfsm.infrastructure.config.MarvelPropertiesConfig;
import co.com.cfsm.infrastructure.outbound.feign.MarvelFeignClient;


public class MarvelRestAdapter implements MarvelOutputPort {

  @Autowired
  private MarvelFeignClient marvelFeignClient;

  private final MarvelPropertiesConfig marvelPropertiesConfig;

  public MarvelRestAdapter(MarvelPropertiesConfig marvelPropertiesConfig) {
    this.marvelPropertiesConfig = marvelPropertiesConfig;
  }

  @Override
  public Map<String, Object> getCharacters() {
    return marvelFeignClient.findPostById(buildBody());
  }

  private Map<String, Object> buildBody() {
    return Map.of("hash", buildHash(), "ts", marvelPropertiesConfig.getTs(), "apikey",
        marvelPropertiesConfig.getPublicApikey());
  }

  private String buildHash() {
    String ts = marvelPropertiesConfig.getTs();
    String privateKey = marvelPropertiesConfig.getPrivateApikey();
    String publicKey = marvelPropertiesConfig.getPublicApikey();

    return HashGenerator.generateMD5(ts + privateKey + publicKey);
  }



}
