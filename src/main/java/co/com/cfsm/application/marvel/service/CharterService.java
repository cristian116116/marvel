package co.com.cfsm.application.marvel.service;

import java.util.Map;
import co.com.cfsm.application.marvel.port.in.CharterUseCase;
import co.com.cfsm.application.marvel.port.out.MarvelOutputPort;

public class CharterService implements CharterUseCase {

  private MarvelOutputPort marvelOutputPort;

  public CharterService(MarvelOutputPort marvelOutputPort) {
    this.marvelOutputPort = marvelOutputPort;
  }

  @Override
  public Map<String, Object> getCharacters() {
    return marvelOutputPort.getCharacters();
  }

}
