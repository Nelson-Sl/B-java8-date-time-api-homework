package com.thoughtworks.capability.gtb;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class MeetingSystemV3 {

  public static void main(String[] args) {
    String timeStr = "2020-04-01 14:30:00";

    // 根据格式创建格式化类
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // 从字符串解析得到会议时间
    LocalDateTime meetingTime = LocalDateTime.parse(timeStr, formatter);

    //转化为北京时间
    ZonedDateTime zonedDateTimeOfLondon = ZonedDateTime.of(meetingTime,ZoneId.of("Europe/London"));
    ZonedDateTime zonedDateTimeOfBeijing = zonedDateTimeOfLondon.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
    LocalDateTime localDateTimeOfBeijingForMeeting = zonedDateTimeOfBeijing.toLocalDateTime();

    LocalDateTime now = LocalDateTime.now();
    if (now.isAfter(meetingTime)) {
      //Period计算下个会议的时间
      Period period = Period.ofDays(1);
      LocalDateTime tomorrow = now.plus(period);
      int newDayOfYear = tomorrow.getDayOfYear();
      localDateTimeOfBeijingForMeeting = localDateTimeOfBeijingForMeeting.withDayOfYear(newDayOfYear);

      //转化为芝加哥时间
      ZonedDateTime zonedDateTimeOfBeijingForMeeting = ZonedDateTime.of(localDateTimeOfBeijingForMeeting,ZoneId.of("Asia/Shanghai"));
      ZonedDateTime zonedDateTimeOfChicagoForMeeting = zonedDateTimeOfBeijingForMeeting.withZoneSameInstant(ZoneId.of("America/Chicago"));
      LocalDateTime localDateTimeOfChicagoForMeeting = zonedDateTimeOfChicagoForMeeting.toLocalDateTime();

      //格式化
      String showTimeStr = formatter.format(localDateTimeOfChicagoForMeeting);
      System.out.println(showTimeStr);
    } else {
      System.out.println("");
    }
  }
}
