package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are the "computer expert" of a local Athletic Association (C.A.A.). Many teams of runners come to compete.
 * Each time you get a string of all race results of every team who has run. For example here is a string showing
 * the individual results of a team of 5 runners:
 * <p>
 * "01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17"
 * <p>
 * Each part of the string is of the form: h|m|s where h, m, s (h for hour, m for minutes, s for seconds) are positive
 * or null integer (represented as strings) with one or two digits. Substrings in the input string are separated
 * by ,  or ,.
 * <p>
 * To compare the results of the teams you are asked for giving three statistics; range, average and median.
 * <p>
 * Range : difference between the lowest and highest values. In {4, 6, 9, 3, 7} the lowest value is 3, and the
 * highest is 9, so the range is 9 − 3 = 6.
 * <p>
 * Mean or Average : To calculate mean, add together all of the numbers and then divide the sum by the total count
 * of numbers.
 * <p>
 * Median : In statistics, the median is the number separating the higher half of a data sample from the lower half.
 * The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest
 * value and picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5) when there is an odd number
 * of observations. If there is an even number of observations, then there is no single middle value; the median is
 * then defined to be the mean of the two middle values (the median of {3, 5, 6, 9} is (5 + 6) / 2 = 5.5).
 * <p>
 * Your task is to return a string giving these 3 values. For the example given above, the string result will be
 * <p>
 * "Range: 00|47|18 Average: 01|35|15 Median: 01|32|34"
 * <p>
 * of the form: "Range: hh|mm|ss Average: hh|mm|ss Median: hh|mm|ss"`
 * <p>
 * where hh, mm, ss are integers (represented by strings) with each 2 digits.
 * <p>
 * Remarks:
 * if a result in seconds is ab.xy... it will be given truncated as ab.
 * if the given string is "" you will return ""
 */
public class StatisticsForAnAthleticAssociation {

    public static String stat(String strg) {
        if (strg == null || strg.isBlank()) {
            return "";
        }
        List<Integer> time = timeStringToSecons(strg);
        IntSummaryStatistics statistics = time.stream().mapToInt(i -> i).summaryStatistics();

        String median = formatTime(getMedian(time));
        String avg = formatTime((int) statistics.getAverage());
        String range = formatTime(statistics.getMax() - statistics.getMin());
        return "Range: %s Average: %s Median: %s".formatted(range, avg, median);
    }

    private static List<Integer> timeStringToSecons(String strg) {
        return Arrays.stream(strg.split(", "))
                .map(i -> {
                    String[] times = i.split("\\|");
                    int hours = Integer.parseInt(times[0]) * 3600;
                    int minutes = Integer.parseInt(times[1]) * 60;
                    int seconds = Integer.parseInt(times[2]);
                    return hours + minutes + seconds;
                })
                .sorted()
                .toList();
    }

    private static int getMedian(List<Integer> list) {
        int middle = list.size() / 2;
        if (list.size() % 2 == 0) {
            Integer middle1 = list.get(middle);
            Integer middle2 = list.get(middle - 1);
            return (middle1 + middle2) / 2;
        } else {
            return list.get(middle);
        }
    }

    private static String formatTime(int time) {
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;
        return "%02d|%02d|%02d".formatted(hours, minutes, seconds);
    }

    @Test
    public void BasicTests() {
        assertEquals("Range: 01|01|18 Average: 01|38|05 Median: 01|32|34",
                stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
        assertEquals("Range: 00|31|17 Average: 02|26|18 Median: 02|22|00",
                stat("02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41"));
    }

}
