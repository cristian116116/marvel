package co.com.cfsm.infrastructure.inbound.rest;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.cfsm.domain.util.HashGenerator;
import co.com.cfsm.infrastructure.outbound.feign.MarvelFeignClient;

@RestController
@RequestMapping("comics")
public class ComicController {


  @Autowired
  private MarvelFeignClient marvelFeignClient;


  @GetMapping("/{upc}")
  public Map<String, Object> getComicsByUpc(@PathVariable("upc") String upc) {



    String ts = String.valueOf((new Date().getTime()));
    String privateKey = "10c3f1b71dad6edf79cc4b445e6d4463a81acd07";
    String publicKey = "be0f9e64125c6132433af9e908e6187a";


    String hash = buildHash(ts, privateKey, publicKey);


    return marvelFeignClient.getComicsByUpc(buildBody(hash, ts, publicKey, upc));



  }

  private Map<String, Object> buildBody(String hash, String ts, String publicKey, String upc) {
    return Map.of("hash", hash, "ts", ts, "apikey", publicKey, "upc", upc);
  }



  private String buildHash(String ts, String privateKey, String publicKey) {
    return HashGenerator.generateMD5(ts + privateKey + publicKey);
  }


}
