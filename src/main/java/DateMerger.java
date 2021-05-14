package main.java;

import java.util.List;

public class DateMerger {

    public List<DateRange> mergeDate(List<DateRange> dateRanges) {
        if(dateRanges == null) {
            return null;
        }
        dateRanges = sortDateRanges(dateRanges);

        for (int i = 0; i < dateRanges.size() - 1; i++) {

            for (int j = i+1; j < dateRanges.size(); j++) {

                DateRange d1 = dateRanges.get(i);
                DateRange d2 = dateRanges.get(j);

                if (d2.getStartDate().before(d1.getEndDate())
                        || d2.getStartDate().equals(d1.getEndDate())) {

                    if (d2.getEndDate().before(d1.getEndDate()) || d2.getEndDate().equals(d1.getEndDate())) {
                        //new DateRange(d1.getStartDate(), d1.getEndDate()); //No need for this as d1 element stays as is.
                        //removing element at j index as it is between or equals to previous DateRange.
                        dateRanges.remove(j);
                        j--;
                    } else {
                        //d1.startDate is smaller than d2.startDate and d2.endDate is larger than d1.endDate
                        //hence merged DateRange is d1.startDate and d2.endDate
                        dateRanges.set(i, new DateRange(d1.getStartDate(), d2.getEndDate()));
                        dateRanges.remove(j);
                        j--;
                    }
                }
            }
        }
        return dateRanges;
    }

    public List<DateRange> sortDateRanges(List<DateRange> dateRanges) {
        if(dateRanges == null) {
            return null;
        }
        for (int i = 0; i < dateRanges.size() - 1; i++) {
            for (int j = i+1; j < dateRanges.size(); j++) {
                DateRange d1 = dateRanges.get(i);
                DateRange d2 = dateRanges.get(j);
                if (d2.getStartDate().before(d1.getStartDate())
                        || ( d2.getStartDate().equals(d1.getStartDate())
                             && d2.getEndDate().before(d1.getEndDate()) ) ) {
                    swapDateRange(dateRanges, i, j);
                }
            }
        }
        return dateRanges;
    }

    private void swapDateRange(List<DateRange> dateRanges, int i, int j) {
        DateRange dateRange1 = dateRanges.get(i);
        DateRange dateRange2 = dateRanges.get(j);
        dateRanges.set(i, dateRange2);
        dateRanges.set(j, dateRange1);
    }

}
