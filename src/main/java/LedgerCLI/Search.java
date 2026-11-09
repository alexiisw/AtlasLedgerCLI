package LedgerCLI;

import java.time.LocalDate;
import java.util.ArrayList;

public class Search {

    public static ArrayList<Transaction> monthToDate(ArrayList<Transaction> ledger) {
        ArrayList<Transaction> matchingDate = new ArrayList<>();

        LocalDate today = LocalDate.now(); // gets current date

        for (Transaction transaction : ledger) { // runs through the ledger
            if (transaction.getDate().getMonth().equals(today.getMonth()) &&
                    transaction.getDate().getYear() == today.getYear()) { // compares the input vs the transactions; both statements have to be true

                matchingDate.add(transaction); // if the transaction is found it will return result
            }
        }
        return matchingDate; // if the transaction isn't found, it will return nothing
    }
    public static ArrayList<Transaction> previousMonth(ArrayList<Transaction> ledger) {
        ArrayList<Transaction> matchingMonth = new ArrayList<>();

        LocalDate previousMonth = LocalDate.now().minusMonths(1); // gets current month and subtracts by 1

        for (Transaction transaction : ledger) { // runs through the ledger
            if (transaction.getDate().getMonth().equals(previousMonth.getMonth()) &&
                    transaction.getDate().getYear() == previousMonth.getYear()) { // compares the input vs the transactions; both statements have to be true

                matchingMonth.add(transaction); // if the product is found it will return result
            }
        }
        return matchingMonth; // if the transaction isn't found, it will return nothing
    }
    public static ArrayList<Transaction> yearToDate(ArrayList<Transaction> ledger) {
        ArrayList<Transaction> matchingYear = new ArrayList<>();

       int currentYear = LocalDate.now().getYear(); // gets current year
        for (Transaction transaction : ledger) { // runs through the ledger
            if (transaction.getDate().getYear() == currentYear) { // compares the input vs the transactions

                matchingYear.add(transaction); // if the product is found it will return result
            }
        }
        return matchingYear; // if the transaction isn't found, it will return nothing
    }
    public static ArrayList<Transaction> previousYear(ArrayList<Transaction> ledger) {
        ArrayList<Transaction> matchingYear = new ArrayList<>();

        int previousYear = LocalDate.now().getYear() - 1; // gets current year and subtracts by 1

        for (Transaction transaction : ledger) { // runs through the ledger
            if (transaction.getDate().getYear() == previousYear) { // compares the input vs the transactions

                matchingYear.add(transaction); // if the product is found it will return result
            }
        }
        return matchingYear; // if the transaction isn't found, it will return nothing
    }
    public static ArrayList<Transaction> searchByVendor(ArrayList<Transaction> ledger, String vendorSearch) {
        ArrayList<Transaction> matchingVendor = new ArrayList<>();

        for (Transaction transaction : ledger) { // cycles through the ledger
            if (transaction.getVendor().toUpperCase().contains(vendorSearch.toUpperCase())) { // compares the input vs the transactions
                matchingVendor.add(transaction); // if the transaction is found it will return result
            }
        }
        return matchingVendor; // if the transaction isn't found, it will return nothing
    }
    public static ArrayList<Transaction> customSearch(ArrayList<Transaction> ledger, String startDateInput,
                                        String endDateInput, String descriptionInput, String vendorInput, String amountInput) {
        ArrayList<Transaction> results = new ArrayList<>();

        for (Transaction transaction : ledger) {

            boolean matches = true;

            if (!startDateInput.isBlank()) {
                LocalDate startDate = LocalDate.parse(startDateInput);

                if (transaction.getDate().isBefore(startDate)) {
                    matches = false;
                }
            }
            if (!endDateInput.isBlank()) {
                LocalDate endDate = LocalDate.parse(endDateInput);

                if (transaction.getDate().isAfter(endDate)) {
                    matches = false;
                }
            }
            if (!descriptionInput.isBlank()) {

                if (!transaction.getDescription().toUpperCase().contains(descriptionInput.toUpperCase())){
                    matches = false;
                }
            }
            if (!vendorInput.isBlank()) {

                if (!transaction.getVendor().equalsIgnoreCase(vendorInput)){
                    matches = false;
                }
            }
            if (!amountInput.isBlank()) {

                double searchAmount = Double.parseDouble(amountInput);

                if (transaction.getAmount() != searchAmount) {
                    matches = false;
                }
            }
            if (matches) {
                results.add(transaction);
            }
        }
        return results;
    }
}

