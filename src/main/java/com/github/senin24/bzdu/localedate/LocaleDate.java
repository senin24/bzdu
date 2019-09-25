package com.github.senin24.bzdu.localedate;

import static java.util.Objects.isNull;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LocaleDate {

  private static final DateTimeFormatter DD_MM_YYYY = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  public static void main(String[] args) {

    ZonedDateTime now = ZonedDateTime.now();

    System.out.println(now.format(DD_MM_YYYY));

//    now = null;
//    System.out.println(now.format(DD_MM_YYYY));

    System.out.println(getOpennedAccountDateFormatted(null, DD_MM_YYYY));

//    ArrayList<String> strings = new ArrayList<>();
//    String s = strings.get(0);


  }

  private static String getOpennedAccountDateFormatted(ZonedDateTime time, DateTimeFormatter df) {
    return isNull(time) ? "---" : time.format(df);
  }
}
