package org.finctionalInterfacesAndLambdas;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //Prediicate training
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        System.out.println(predicate.test(-5));
        System.out.println(predicate.test(5));

        Predicate<Integer> predicate1 = integer -> {
            if (integer > 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(predicate1.test(-5));
        System.out.println(predicate1.test(5));

        //Consumer training
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, " + s + "!");
            }
        };
        consumer.accept("Иван");
        Consumer<String> consumer1 = s -> System.out.println("Привет, " + s + "!");
        consumer1.accept("Павел");

        //Function training
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(25.256));

        Function<Double, Long> function1 = aDouble -> aDouble.longValue();
        System.out.println(function1.apply(69.33));

        //Supplier training
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();

                return random.nextInt(101);
            }
        };
        System.out.println(supplier.get());
        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();

            return random.nextInt(101);
        };
        System.out.println(supplier1.get());
    }

    //Combination
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        if (condition.equals(true)) {
            return (Function<T, U>) ifTrue;
        } else {
            return (Function<T, U>) ifFalse;

        }


    }
}