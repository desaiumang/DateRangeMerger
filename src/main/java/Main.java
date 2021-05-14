package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<DateRange> dateRanges = getDefaultDateRanges();
        DateMerger dateMerger = new DateMerger();
        List<DateRange> mergedDateRanges = dateMerger.mergeDate(dateRanges);
        for (DateRange dateRange : mergedDateRanges) {
            System.out.println(dateRange.toString());
        }

    }

    private static List<DateRange> getDefaultDateRanges() throws ParseException {
        List<DateRange> dateRanges = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        dateRanges.add(new DateRange(sdf.parse("01 Jan 2014"), sdf.parse("30 Jan 2014")));
        dateRanges.add(new DateRange(sdf.parse("01 Jan 2014"), sdf.parse("29 Jan 2014")));
        dateRanges.add(new DateRange(sdf.parse("10 Mar 2014"), sdf.parse("15 Apr 2014")));
        dateRanges.add(new DateRange(sdf.parse("10 Apr 2014"), sdf.parse("15 May 2014")));
        dateRanges.add(new DateRange(sdf.parse("14 Feb 2014"), sdf.parse("20 Feb 2014")));
        return dateRanges;
    }
}
