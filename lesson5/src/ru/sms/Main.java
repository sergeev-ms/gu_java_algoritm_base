package ru.sms;

public class Main {
    public static void main(String[] args) {

        System.out.println(pow(3, 5));

        System.out.println(backpack(new int[]{11, 8, 7, 5}, 20));

    }

    private static float pow(float number, int exponent){
        if (exponent < 0) return pow(1/number, -exponent);
        else if (exponent == 0)  return 1;
        else if (exponent == 1) return number;
        else if (exponent % 2 == 0) return pow(number*number, exponent/2 );
        else return number * pow(number*number, (exponent-1)/2);
    }

    private static int backpack(int[] items, int capacity){
        if (items.length == 1)
            return items[0] >= capacity ? 0 : items[0];
        else {
            final int item = items[0];
            final int[] newItems = new int[items.length - 1];
            System.arraycopy(items, 1, newItems, 0, newItems.length);
            if (item < capacity) {
                int notTake = backpack(newItems, capacity);
                int take = backpack(newItems, capacity - item) + item;
                return Math.max(notTake, take);
            }
            else return backpack(newItems, capacity);
        }
    }
}
