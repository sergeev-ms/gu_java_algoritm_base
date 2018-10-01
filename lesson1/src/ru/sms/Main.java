package ru.sms;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(pow(3, 5));

        final int[] array = {3, 5, -2, 1, 10};
        System.out.println(findMinimalInArray(array));
        System.out.println(arrayAvg(array));
    }

    private static float pow(float number, int exponent){
        if (exponent < 0) return pow(1/number, -exponent);
        else if (exponent == 0)  return 1;
        else if (exponent == 1) return number;
        else if (exponent % 2 == 0) return pow(number*number, exponent/2 );
        else return pow(number*number, (exponent-1)/2);
    }

    private static int findMinimalInArray(int[] array) throws Exception {
        if (array.length == 0)
            throw new Exception("Array size is 0");
        int minimal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimal)
                minimal = array[i];
        }
        return minimal;
    }

    private static float arrayAvg(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (float) sum/array.length;
    }
}
