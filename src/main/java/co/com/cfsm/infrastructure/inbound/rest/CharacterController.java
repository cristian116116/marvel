package co.com.cfsm.infrastructure.inbound.rest;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.cfsm.application.marvel.port.in.CharterUseCase;

@RestController
@RequestMapping("character")
public class CharacterController {

  private final CharterUseCase charterUseCase;

  public CharacterController(CharterUseCase charterUseCase) {
    this.charterUseCase = charterUseCase;
  }

  @GetMapping
  public Map<String, Object> getCharacters() {
    return charterUseCase.getCharacters();
  }

}
