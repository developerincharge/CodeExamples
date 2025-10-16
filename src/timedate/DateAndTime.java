package timedate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {
    public static void main(String[] args) {

        int day, month, year;
        int second, minute, hour;
        // Gregorian Calendar
        GregorianCalendar calendar = new GregorianCalendar();
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        month = calendar.get(java.util.Calendar.MONTH) + 1; // Months are 0-based
        year = calendar.get(java.util.Calendar.YEAR);
        second = calendar.get(java.util.Calendar.SECOND);
        minute = calendar.get(java.util.Calendar.MINUTE);
        hour = calendar.get(java.util.Calendar.HOUR_OF_DAY);
        System.out.println("Current Date is: " + day + "/" + month + "/" + year);
        System.out.println("Current Time is: " + hour + ":" + minute + ":" + second);
        System.out.println();
        System.out.println("###################################### \n");

        // Current Date
        Date date = new Date();
        System.out.println("Current Date: " + date);

        // Current Time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("Current Time in milliseconds: " + currentTimeMillis);

        // Using java.time package (Java 8 and later)
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("Current Local Date: " + currentDate);
        System.out.println("Current Local Time: " + currentTime);
        System.out.println("Current Local Date and Time: " + currentDateTime);

        // Formatting date and time
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted Current Date and Time: " + formattedDateTime);

    }
}
