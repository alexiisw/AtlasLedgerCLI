package LedgerCLI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadingInfo {
    public static ArrayList<Transactions> addProducts() {
        ArrayList<Products> inventory = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("products.csv"));
            System.out.print("Employee Info:\n");

            String productInfo;
            reader.readLine(); // will skip the first line in the note

            while ((productInfo = reader.readLine()) != null) {
                String[] info = productInfo.split("\\|");// going to split the lines by "|"
                String sku = info[0];
                String name = info[1];
                double price = Double.parseDouble(info[2]);
                String department = info[3];

                Products product = new Products(sku, name, price, department);
                inventory.add(product);
            }
            reader.close(); // outside the while/for/if loop

        } catch (IOException e) {
            System.out.println("Product not found.");
        }
        return inventory;
    }
}

}
