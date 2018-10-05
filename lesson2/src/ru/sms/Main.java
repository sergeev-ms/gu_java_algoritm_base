package ru.sms;

public class Main {
    public static void main(String[] args) {
        final Array array = new Array(1, 2, 3, 4, 3, 2, 1);
        System.out.println(array.toString());
//        array.delete(3);
//        System.out.println(array.toString());

//        array.deleteAll(3);
//        System.out.println(array.toString());
//        array.deleteAll(1);
//        System.out.println(array.toString());
//        array.deleteAll(4);
//        System.out.println(array.toString());

//        array.deleteAll();
        array.sortBubbleCocktail();

//        try {
//            array.sortCounting();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(array.toString());
    }
}
