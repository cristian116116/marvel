package co.com.cfsm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pruebas {


  static List<Integer> numbers = Arrays.asList(5, 12, 9, 4, 7, 6, 8, 3, 1, 10);

  public static void main(String[] args) {

    numbers.stream().filter(n -> n % 2 == 0).sorted().toList().parallelStream()
        .forEachOrdered(System.out::println);



    List<String> names = Arrays.asList("juan", "ana", "pedro", "carlos", "maria");

    names.stream().parallel().map(name -> name.toUpperCase()).toList().forEach(System.out::println);


    List<Integer> values = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 6, 7, 5, 8, 9, 1);


    values.stream().distinct().toList().size();


    // List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);


    // System.out.println(numbers.stream().reduce(0, Integer::sum));

    // List<String> words = Arrays.asList("Avión", "Barco", "Automóvil", "Tren", "Autobús", "Moto",
    // "Bicicleta");

    // words.stream().filter(word -> word.startsWith("A")).forEach(System.out::println);

    // List<String> words = Arrays.asList("rojo", "azul", "verde", "amarillo", "negro");

    // System.out.println( words.stream().collect(Collectors.joining(", ")));


    List<String> words = Arrays.asList("sol", "planeta", "estrella", "luz", "galaxia", "universo");


    words.stream().filter(word -> word.length() > 4).forEach(System.out::println);

    List<Integer> numbers = Arrays.asList(3, 7, 1, 9, 4, 2);

    System.out.println(
        numbers.stream().map(n -> n * 2).toList().stream().mapToInt(Integer::intValue).sum());



  }



}
