package com.boj.bronze.q2884;

import java.util.Scanner;

/**
 * ěë ěęł
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int AlarmHour = sc.nextInt();
        int beforeAlarmMinute = sc.nextInt();
        int changeAlarmMinute = beforeAlarmMinute - 45;

        if (changeAlarmMinute < 0) {
            AlarmHour = AlarmHour - 1;
            changeAlarmMinute = 60 + changeAlarmMinute;
        }
        if(AlarmHour < 0 )
            AlarmHour = 24  + AlarmHour;

        System.out.println(AlarmHour + " " + changeAlarmMinute);
    }
}
