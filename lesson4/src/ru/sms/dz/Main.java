package ru.sms.dz;

import ru.sms.lecture.Cat;

public class Main {
    public static void main(String[] args) {
        DoubleRelatedList<Cat> cats = new DoubleRelatedList<>();
        cats.putHead(new Cat(2, "cat-1"));
        final Cat cat2 = new Cat(2, "cat-2");
        cats.putHead(cat2);
        cats.putHead(new Cat(2, "cat-3"));
        cats.putHead(new Cat(2, "cat-4"));

//        System.out.println(cats.popHead());
//        System.out.println(cats.popHead());
        cats.remove(cat2);

        cats.putTail(new Cat(2, "cat-5"));
    }

}
