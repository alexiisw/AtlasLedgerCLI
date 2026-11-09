package LedgerCLI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

//import static OnlineStore.Search.*;

public class Menu {
    public static void homeMenu(ArrayList<Transaction> ledger) {// uses the inventory it receives
        Scanner read = new Scanner(System.in); // name scanner what its doing

        boolean systemsRunning = true;
        while (systemsRunning) {
            System.out.print("+--------------------------------------+\n");
            System.out.print("+          ATLAS LEDGER CLI            +\n");
            System.out.print("+   Financial Transaction Management   +\n");
            System.out.print("+--------------------------------------+\n");
            System.out.print("Please input your selection from the following menu choices:\n");
            System.out.println("(D)Add Deposit \n(P)Make Payment \n(L)Ledger \n(X)Exit"); // X: closes out of the application

            char selection = Character.toUpperCase(read.next().charAt(0)); // pulls the first letter from the input and saves it as a char
            read.nextLine();

            //switch ???

            switch (selection) {

                case 'D':
                    addDeposit(read);
                    ledger = Ledger.loadTransactions();
                    break;

                case 'P':
                    makePayment(read);
                    ledger = Ledger.loadTransactions();
                    break;

                case 'L':
                    ledgerScreen(ledger, read);
                    ledger = Ledger.loadTransactions();
                    break;

                case 'X':
                    systemsRunning = false;
                    System.out.println("Thank you for using Atlas Ledger CLI.");
                    break;

                default:
                    System.out.println("Invalid Selection");
            }
        }
    }

    public static void addDeposit(Scanner read) {

        System.out.print("Description: ");
        String description = read.nextLine();

        System.out.print("Vendor: ");
        String vendor = read.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(read.nextLine());

        Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(),
                        description, vendor, amount);

        Ledger.storeTransaction(deposit);

        System.out.print("Deposit Recorded Successfully");
    }

    public static void makePayment(Scanner read) {

        System.out.print("Description: ");
        String description = read.nextLine();

        System.out.print("Vendor: ");
        String vendor = read.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(read.nextLine());

        Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(),
                    description, vendor, -Math.abs(amount));

        Ledger.storeTransaction(payment);

        System.out.println("Payment Recorded Successfully");
    }

    public static void ledgerScreen(ArrayList<Transaction> ledger, Scanner read) {

        boolean displayLedger = true;
        while (displayLedger) {

            System.out.println();
            System.out.println("===== LEDGER =====");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            char choice = Character.toUpperCase(read.next().charAt(0));

            read.nextLine();

            switch (choice) {

                case 'A':
                    for (int i = ledger.size() - 1; i >= 0; i--) {
                        ledger.get(i).displayInfo();
                    }
                    break;

                case 'D':
                    for (int i = ledger.size() - 1; i >= 0; i--) {
                        if (ledger.get(i).getAmount() > 0) {
                            ledger.get(i).displayInfo();
                        }
                    }
                    break;

                case 'P':
                    for (int i = ledger.size() - 1; i >= 0; i--) {
                        if (ledger.get(i).getAmount() < 0) {
                            ledger.get(i).displayInfo();
                        }
                    }
                    break;

                case 'R':
                    reportsScreen(ledger, read);
                    break;

                case 'H':
                    displayLedger = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
            }
        }
    }

    public static void reportsScreen(ArrayList<Transaction> ledger, Scanner read) {

        boolean reportsRunning = true;
        while (reportsRunning) {

            System.out.println();
            System.out.println("===== REPORTS =====");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");

            String selection =
                    read.nextLine();

            switch (selection) {

                case "1":
                    ArrayList<Transaction> monthResults = Search.monthToDate(ledger);

                    if (monthResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : monthResults) {
                        transaction.displayInfo();
                    }
                    break;

                case "2":
                    ArrayList<Transaction> previousMonthResults = Search.previousMonth(ledger);

                    if (previousMonthResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : previousMonthResults) {
                        transaction.displayInfo();
                    }
                    break;

                case "3":
                    ArrayList<Transaction> yearResults = Search.yearToDate(ledger);

                    if (yearResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : yearResults) {
                        transaction.displayInfo();
                    }
                    break;

                case "4":
                    ArrayList<Transaction> previousYearResults = Search.previousYear(ledger);

                    if (previousYearResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : previousYearResults) {
                        transaction.displayInfo();
                    }
                    break;

                case "5":
                    System.out.print("Vendor Name: ");
                    String vendor = read.nextLine();

                    ArrayList<Transaction> vendorResults = Search.searchByVendor(ledger, vendor);

                    if (vendorResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : vendorResults) {
                        transaction.displayInfo();
                    }
                    break;

                case "6":
                    System.out.print("Start Date (yyyy-MM-dd): ");
                    String startDate = read.nextLine();

                    System.out.print("End Date (yyyy-MM-dd): ");
                    String endDate = read.nextLine();

                    System.out.print("Description: ");
                    String description = read.nextLine();

                    System.out.print("Vendor: ");
                    String vendorSearch = read.nextLine();

                    System.out.print("Amount: ");
                    String amount = read.nextLine();

                    ArrayList<Transaction> customResults = Search.customSearch(ledger, startDate, endDate,
                            description, vendorSearch, amount);

                    if (customResults.isEmpty()) {
                        System.out.print("No transactions found.");
                        break;
                    }
                    for (Transaction transaction : customResults) {
                            transaction.displayInfo();
                    }
                    break;

                case "0":
                    reportsRunning = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
            }
        }
    }
}