package co.com.cfsm.domain.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

  public static String generateMD5(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(input.getBytes());
      byte[] digest = md.digest();
      return String.format("%032x", new BigInteger(1, digest));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error al generar hash MD5", e);
    }
  }

}
