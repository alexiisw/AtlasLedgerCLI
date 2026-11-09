package LedgerCLI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction { // stores the properties defined by csv file
    public static final DateTimeFormatter  dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // changes the date to how I want it to be shown - final means it can't be adjusted

        private LocalDate date;
        private LocalTime time;
        private String description;
        private String vendor;
        private double amount;

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
        }
        public void displayInfo(){
            System.out.printf("%s | %s | %s | %s | $%.2f%n", date.format(dateFormatter), time , description,
                    vendor, amount);
        }
    }


