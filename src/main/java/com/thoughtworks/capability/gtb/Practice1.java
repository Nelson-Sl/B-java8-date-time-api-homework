package com.thoughtworks.capability.gtb;

import java.time.LocalDate;

/**
 * 计算任意日期与下一个劳动节相差多少天
 *
 * @author itutry
 * @create 2020-05-15_16:33
 */
public class Practice1 {

  public static long getDaysBetweenNextLaborDay(LocalDate date) {
    int dateMonth = date.getMonth().getValue();
    int nextLaborYear = dateMonth >= 5 ? date.plusYears(1).getYear() : date.getYear();
    LocalDate nextNeighborDay = LocalDate.of(nextLaborYear,5,1);
    return nextNeighborDay.toEpochDay() - date.toEpochDay();
  }
}
