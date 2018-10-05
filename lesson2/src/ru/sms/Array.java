package ru.sms;

/*
 Дописать методы удаления в классе массива
 Улучшить пузырьковую сортировку
 Подсчитать количество операций в сортировках и сравнить с их О-большое
 * Реализовать сортировку подсчётом
 * */

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        final int[] tmpArr = new int[size - 1];
        System.arraycopy(arr, 0, tmpArr, 0, index);
        System.arraycopy(arr, index + 1, tmpArr, index, size - index - 1);
        size--;
        System.arraycopy(tmpArr, 0, arr, 0, size);
        return true;
    }

    boolean deleteAll(int value) { // by value
        int[] foundedIndexes = new int[size];
        int foundedCount = 0;
        for (int i = 0; i < size; i++)
            if (arr[i] == value){
                foundedIndexes[foundedCount] = i;
                foundedCount++;
            }

        if (foundedCount > 0) {
            for (int i = foundedCount-1; i >= 0; i--)
                delete(foundedIndexes[i]);
            return true;
        }
        else return false;
    }

    void deleteAll() {
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //O(n^2)
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
    }
    //O(n^2)
    public void sortBubbleCocktail() {
        int left = 0;
        int right = size - 1;
        do {
            for (int i = left; i < right; i++) {
                    if (arr[i] > arr[i + 1])
                        swap(i, i + 1);
            }
            right--;
            for (int i = right; i > left; i--) {
                    if (arr[i] < arr[i - 1])
                        swap(i, i - 1);
            }
            left++;
        }while (left < right);

        isSorted = true;
    }

    //O(n^2)
    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }
    //O(n^2)
    public void sortInsert() {
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] <= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    public int getMaxValue() {
        int maxValue = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > maxValue)
                maxValue = arr[i];
        }
        return maxValue;
    }

    //O(n^2)
    public void sortCounting() throws Exception {
        final int maxValue = getMaxValue();
        int[] tmpArr = new int[maxValue + 1];
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0)
                throw new Exception("Array can`t contains not natural numbers to use this sort");
            tmpArr[arr[i]] ++;
        }

        for (int i = 0, j = 0; i < size;) {
            int count = tmpArr[j];
            if (count == 0)
                j++;
            else {
                while (count > 0) {
                    arr[i] = j;
                    i++;
                    count--;
                }
                j++;
            }
        }
        isSorted = true;
    }
}
