package com.dateAndTime;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {

    @Test
    public void comparingDatePeriodTest(){
        LocalDate localDate = LocalDate.of(2020,01,01);
        LocalDate  localDate1 = LocalDate.of(2020,12,31);

        /**
         * until - Period
         */
        Period period = localDate.until(localDate1);
        System.out.println("getDays : " + period.getDays()); // results in 30 days performs (31-1)
        System.out.println("getMonths : " + period.getMonths()); // results in 0 days (12-01)

        Period period1 = Period.ofDays(10);
        System.out.println("getDays : " + period1.getDays());
        Period period2 = Period.ofYears(20);
        System.out.println("getYears : " + period2.getYears());
        System.out.println("toTotalMonths : " + period2.toTotalMonths());
        System.out.println("getDays : " + period2.getDays());



        Period period3 = Period.between(localDate, localDate1);
        System.out.println("Period : " +period3.getDays()+" : " +period3.getMonths()+" : "+period3.getYears());
    }

    @Test
    public void findDayOfGivenDate(){
        LocalDate localDate = LocalDate.now();
        System.out.println(findPreviousDate(localDate));
        LocalDate localDate1 = localDate.minusDays(1);
        System.out.println(findPreviousDate(localDate1));
    }

    public LocalDate findPreviousDate(LocalDate date){
         DayOfWeek dayOfWeek = date.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.MONDAY)){
            return date.minusDays(2);
        }else{
            return date.minusDays(1);
        }
    }
}
