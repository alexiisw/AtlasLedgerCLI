package LedgerCLI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transactions { // stores the properties defined by csv file
    public static final DateTimeFormatter  dateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
    // changes the date to how I want it to be shown - final means it can't be adjusted

        private LocalDate date;
        private LocalTime time;
        private String description;
        private String vendor;
        private double amount;

        // Constructor - stores values
        public Transactions (LocalDate date,
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
        }public String getDescription() { // calculates the gross pay
            return description;
        }public String getVendor(){
            return vendor;
        }public double getAmount(){
            return amount;
        }
        void displayInfo(){
            System.out.printf("%s | %s | %s | %s | $%.2f%n", date.format(dateFormatter), time , description,
                    vendor, amount);
        }
    }


