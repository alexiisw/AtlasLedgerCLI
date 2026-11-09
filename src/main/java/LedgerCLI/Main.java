package LedgerCLI;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Transaction> ledger =
                Ledger.loadTransactions();

        Menu.homeMenu(ledger);
    }
}
