package com.boj.q2884;

import java.util.Scanner;

/**
 * 알람 시계
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
