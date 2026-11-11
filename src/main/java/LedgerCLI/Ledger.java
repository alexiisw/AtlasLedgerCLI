package LedgerCLI;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static LedgerCLI.Transaction.timeFormatter;

public class Ledger {
    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> ledger = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"));

            String transactionInfo;
            reader.readLine(); // will skip the first line in the note

            while ((transactionInfo = reader.readLine()) != null) {
                String[] info = transactionInfo.split("\\|");// going to split the lines by "|"
                LocalDate date = LocalDate.parse(info[0]);
                LocalTime time = LocalTime.parse(info[1]);
                String description = info[2];
                String vendor = info[3];
                double amount = Double.parseDouble(info[4]);

                Transaction transaction = new Transaction(date, time, description,vendor, amount);
                ledger.add(transaction);
            }
            reader.close(); // outside the while/for/if loop

        } catch (IOException e) {
            System.out.println("Transaction file not found.");
        }
        return ledger;
    }
    public static void storeTransaction(Transaction transaction) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true));

            //structures input how I want
            writer.write(transaction.getDate() + "|" + // \n will start and store input on the new line
                            transaction.getTime().format(Transaction.timeFormatter) + "|" +
                            transaction.getDescription() + "|" +
                            transaction.getVendor() + "|" +
                            String.format("%.2f|", transaction.getAmount())  // ensures there is at the end to separate from next transaction input
            );

            writer.newLine();

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }
}

