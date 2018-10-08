package ru.sms.task2;

import ru.sms.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "Без труда не выловишь и рыбку из пруда.";

        System.out.println(revertString(str));
    }

    private static String revertString(String str) {
        final int length = str.length();
        final Stack stack = new Stack(length);
        for (int i = 0; i < length; i++) {
            stack.insert(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append((char) stack.getMax());
        } while (!stack.isEmpty());
        return sb.toString();
    }
}
