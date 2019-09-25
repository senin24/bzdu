package com.github.senin24.bzdu.hashmap;

import static java.util.Objects.isNull;


import java.util.HashMap;
import java.util.Map;

public class MapExample {

  public static void main(String[] args) {

    Map<String, Object> data = new HashMap<>();
    data.put("bankName", null);
    data.put("bankInn", "not--Null");
    data.put("bankOgrn", null);
    data.put("bankKPP", "not--Null");
    data.put("bankBIC", null);

    System.out.println(data);

    initEmptyFields(data);
    System.out.println();

    System.out.println(data);

    System.out.println();

    System.out.println(initEmptyFields(data));

    System.out.println();

    System.out.println(initEmptyFields2(data));


  }

  private static Map<String, Object> initEmptyFields(Map<String, Object> data) {
    data.forEach((field, value) -> value = isNull(value) ? "" : value);
    return data;
  }

  private static Map<String, Object> initEmptyFields2(Map<String, Object> data) {
    Map<String, Object> adjustedMap = new HashMap<>();
    data.forEach((s, o) -> adjustedMap.put(s, o = isNull(o) ? "" : o));
    return adjustedMap;
  }



}
