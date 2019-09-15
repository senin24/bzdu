package com.github.senin24.bzdu.formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Formatter {

  public static void main(String[] args) {

    BigDecimal bigDecimal = BigDecimal.valueOf(323232);

    System.out.println(bigDecimal);

    DecimalFormat df = new DecimalFormat();
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(2);
    df.setGroupingUsed(true);
//    df.setGroupingSize(3);

    System.out.println(df.format(bigDecimal).replace(",", " "));

    Locale currentLocale = Locale.getDefault();
    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
    otherSymbols.setDecimalSeparator('.');
    otherSymbols.setGroupingSeparator(' ');
    DecimalFormat df2 = new DecimalFormat("#.00", otherSymbols);
    df.setGroupingUsed(true);

    System.out.println(df2.format(bigDecimal));
  }

}
