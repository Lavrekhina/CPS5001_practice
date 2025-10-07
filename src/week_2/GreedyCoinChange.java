package week_2;

import java.util.ArrayList;

public class GreedyCoinChange {

    public static ArrayList<Integer> greedyChange(int amount, int[] coins) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int coin : coins) {
            while (amount >= coin) {  // while coin can fit in remaining amount
                amount -= coin;       // subtract coin from amount
                result.add(coin);     // add coin to result
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int amount = 287;  // example: £2.87
        int[] coins = {100, 50, 20, 10, 5, 2, 1};

        ArrayList<Integer> change = greedyChange(amount, coins);

        System.out.println("Amount: " + amount + "p");
        System.out.println("Coins used: " + change);
        System.out.println("Number of coins: " + change.size());
    }
}
