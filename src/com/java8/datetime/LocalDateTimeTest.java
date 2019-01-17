package com.java8.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 〈功能简述〉<br>
 * 〈
 * 1、LocalDate,LocalTime,LocalDateTime
 * 2、Instant：时间戳（使用Unix元年1970年1月1日 00:00:00 所经历的毫秒值）
 * 3、
 * Duration：用于计算两个"时间"间隔
 * Period：用于计算两个"日期"间隔
 * 〉
 *
 * @author Administrator
 * @create 2019/1/17
 */
public class LocalDateTimeTest {

    /**
     * 1、LocalDate  LocalTime   LocalDateTime
     * 这里只练习LocalDateTime
     * LocalDate,LocalTime和LocalDateTime使用方式没什么区别
     */
    @Test
    public void test01() {
        //获取当前日期和时间
        LocalDateTime ld1 = LocalDateTime.now();
        System.out.println(ld1);

        //获取指定的日期的时间
        LocalDateTime ld2 = LocalDateTime.of(2018, 8, 12, 4, 12, 34);
        System.out.println(ld2);

        //在ld2时间的基础上增加2年
        LocalDateTime ld3 = ld2.plusYears(2);
        System.out.println(ld3);

        //在ld3时间的基础上减去3年
        LocalDateTime ld4 = ld2.minusYears(3);
        System.out.println(ld4);

        System.out.println("年：" + ld4.getYear());
        System.out.println("月：" + ld4.getMonthValue());
        System.out.println("日：" + ld4.getDayOfMonth());
        System.out.println("时：" + ld4.getHour());
        System.out.println("分：" + ld4.getMinute());
        System.out.println("秒：" + ld4.getSecond());
    }

    /**
     * Instant：时间戳
     */
    @Test
    public void test02() {
        //默认使用 UTC 时区
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins.getNano());
    }

    /**
     * Duration：计算两个"时间"的间隔
     * Period：计算两个"日期"的间隔
     */
    @Test
    public void test03() {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        System.out.println(Duration.between(ins1, ins2));

        LocalDate ldt1 = LocalDate.now();
        LocalDate ldt2 = LocalDate.of(2016, 6, 6);
        Period pe = Period.between(ldt2, ldt1);
        System.out.println(pe.getYears());
        System.out.println(pe.getMonths());
        System.out.println(pe.getDays());
    }


    /**
     * TemporalAdjuster : 时间校正器
     */
    @Test
    public void test04() {
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        LocalDateTime ldt5 = ldt1.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }


    /**
     * DateTimeFormatter : 解析和格式化日期或时间
     */
    @Test
    public void test05() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt1 = LocalDateTime.now();
        String strDate = ldt1.format(dtf);
        System.out.println(strDate);

        LocalDateTime parse = LocalDateTime.parse(strDate, dtf);
        System.out.println(parse);
    }
}
