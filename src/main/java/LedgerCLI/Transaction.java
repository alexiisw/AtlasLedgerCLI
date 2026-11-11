package LedgerCLI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction { // stores the properties defined by csv file
    public static final DateTimeFormatter  dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter  timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    // changes the date and time to how I want it to be shown - final means it can't be adjusted

        private final LocalDate date;
        private final LocalTime time;
        private final String description;
        private final String vendor;
        private final double amount;

        // Constructor - stores values
        public Transaction(LocalDate date,
                           LocalTime time,
                           String description,
                           String vendor,
                           double amount){
            this.date = date;
            this.time = time;
            this.description = description;
            this.vendor = vendor;
            this.amount = amount;
        }
        //Methods - returns stored values
        //Getters
        public LocalDate getDate() {
            return date;

        }public LocalTime getTime() {
            return time;

        }public String getDescription() {
            return description;

        }public String getVendor(){
            return vendor;

        }public double getAmount(){
            return amount;

        }public void displayInfo(){
            System.out.printf("%n%s | %s | %s | %s | $%.2f%n", date.format(dateFormatter), time.format(timeFormatter) , description,
                    vendor, amount); // first %n will store input on the new line
        }
    }


