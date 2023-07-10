package com.smartapps.loginwithspring.utills;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams extends extendss{
  static List<Integer> list = new ArrayList<>();

  // Adding elements to above object of Arraylist
  // Custom inputs
  static void tesst() {

    list.add(32);
    list.add(20);
    list.add(4);
    list.add(76);
    list.add(21);
    list.add(3);
    list.add(80);

    var stream = list.stream();
    var number = stream.filter(n -> n > 10)
            .filter(z -> z % 3 == 2).toList();
    System.out.println(number);
  }
  public static void main(String[] args){
    tesst();
  }

  @Override
  void getvalues() {
    System.out.println();
  }
}
