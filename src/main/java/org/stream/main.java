package org.stream;

import java.io.LineNumberInputStream;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {


    }
// метод, который будет находить в стриме минимальный и максимальный
// элементы в соответствии с порядком, заданным Comporator'ом
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> items = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size()-1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    //метод, который принимает на вход список целых чисел,
// определяет в списке количество четных чисел и выводит их в консоль
    public static long findCount(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .count();
    }


}