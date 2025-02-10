package co.com.cfsm.infrastructure.outbound.feign;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${marvel.url}", value = "marvelclient")
public interface MarvelFeignClient {

  @GetMapping("/v1/public/characters")
  Map<String, Object> findPostById(@RequestParam Map<String, Object> params);

  @GetMapping("/v1/public/comics")
  Map<String, Object> getComicsByUpc(@RequestParam Map<String, Object> params);

}
