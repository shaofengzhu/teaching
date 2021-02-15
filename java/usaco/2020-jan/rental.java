import java.io.*;
import java.util.*;

class Store {
    public long milk;
    public long price;
}

public class rental {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("rental.in"));
        PrintWriter output = new PrintWriter(new FileWriter("rental.out"));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int cowCount = Integer.parseInt(st.nextToken());
        int storeCount = Integer.parseInt(st.nextToken());
        int rentCount = Integer.parseInt(st.nextToken());

        long[] cowMilks = new long[cowCount];
        for (int i = 0; i < cowCount; i++) {
            st = new StringTokenizer(input.readLine());
            cowMilks[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cowMilks);

        Store[] stores = new Store[storeCount];
        for (int i = 0; i < storeCount; i++) {
            st = new StringTokenizer(input.readLine());
            Store store = new Store();
            store.milk = Long.parseLong(st.nextToken());
            store.price = Long.parseLong(st.nextToken());
            stores[i] = store;
        }

        Arrays.sort(stores, (s1, s2) -> {
            return (int)(s1.price - s2.price);
        });

        long[] rents = new long[rentCount];
        for (int i = 0; i < rentCount; i++) {
            st = new StringTokenizer(input.readLine());
            rents[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(rents);

        long maxProfit = 0;
        for (int i = 0; i < cowCount && i < rentCount; i++) {
            long profit = calculateProfit(cowMilks, stores, rents, i);
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        output.println(maxProfit);

        input.close();
        output.close();
    }

    static long calculateProfit(long[] cowMilks, Store[] stores, long[] rents, int cowsToRent) {
        long profit = 0;
        for (int i = 0; i < cowsToRent; i++) {
            profit += rents[rents.length - 1 - i];
        }

        long totalMilk = 0;
        for (int i = 0; i < cowMilks.length - cowsToRent; i++) {
            totalMilk += cowMilks[cowMilks.length - 1 - i];
        }

        long totalMilkToStore = 0;
        for (int i = stores.length - 1; i >= 0 && totalMilkToStore < totalMilk; i--) {
            long milkToStore = stores[i].milk;
            if (totalMilkToStore + milkToStore > totalMilk) {
                milkToStore = totalMilk - totalMilkToStore;
            }

            profit += milkToStore * stores[i].price;

            totalMilkToStore += milkToStore;
        }

        return profit;
    }
    
}
