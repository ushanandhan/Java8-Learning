package com.dateAndTime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class NewDateTimeExample {

    @Test
    public void localDateTimeTest(){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
    }

    @Test
    public void localDateTest(){
        System.out.println("1. LocalDate.Of() : "+LocalDate.of(2020,02,02));
        System.out.println("2. LocalDate.ofYearDay() : "+LocalDate.ofYearDay(2020,365));
        LocalDate localDate = LocalDate.now();
        System.out.println("3. getMonth() : "+localDate.getMonth());
        System.out.println("4. getMonthValue() : "+localDate.getMonthValue());
        System.out.println("5. getDayOfWeek() : "+localDate.getDayOfWeek());
        System.out.println("6. getDayOfYear() : "+localDate.getDayOfYear());
        System.out.println("7. Day Of Month Using get() : "+localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("8. Plus Days() : "+localDate.plusDays(2));
        System.out.println("9. Plus Months() : "+localDate.plusMonths(2));

        System.out.println("10. withYear() : "+localDate.withYear(2019));
        System.out.println("11. withYear() Chrono : "+localDate.with(ChronoField.YEAR,2022));
        System.out.println("12. withYear() TemporalAdjusters : "+localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("13. minus() : "+localDate.minus(1, ChronoUnit.YEARS));

        System.out.println("14. Is LeapYear : "+LocalDate.ofYearDay(2020,01).isLeapYear());
        LocalDate localDate1 = LocalDate.of(2021,02,03);
        System.out.println("15. isEqual() : "+localDate.isEqual(localDate1));
        System.out.println("16. isBefore() : "+localDate.isBefore(localDate1));

        System.out.println("17. isSupported() : "+localDate.isSupported(ChronoUnit.MINUTES));
    }

    @Test
    public void localTimeTest(){
        LocalTime localTime = LocalTime.now();
        System.out.println("1. LocalTime.of() : "+LocalTime.of(23,33));
        System.out.println("2. Chrono get() : "+localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
    }
}
