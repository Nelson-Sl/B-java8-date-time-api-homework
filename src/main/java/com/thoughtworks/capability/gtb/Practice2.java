package com.thoughtworks.capability.gtb;

import java.time.LocalDate;

/**
 * 对任意日期获取下一个工作日, 不考虑节假日
 *
 * @author itutry
 * @create 2020-05-15_17:20
 */
public class Practice2 {
  private static final int lastWeekDay = 5;
  private static final int nextFirstWeekDay = 7;

  public static LocalDate getNextWorkDate(LocalDate date) {
    int weekDay = date.getDayOfWeek().getValue();
    System.out.println(weekDay);
    if(weekDay < lastWeekDay) {
      return date.plusDays(lastWeekDay - weekDay);
    }
    return date.plusDays(nextFirstWeekDay + 1 - weekDay);
  }
}
