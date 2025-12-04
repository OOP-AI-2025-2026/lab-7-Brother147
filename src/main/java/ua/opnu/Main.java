package ua.opnu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Лабораторна робота №7: лямбда-вирази, анонімні класи, параметризація поведінки.
 *
 * У цьому класі реалізовані приклади до завдань 5–7:
 *  - processIf (Predicate + Consumer)
 *  - powerOfTwoFunction (Function<Integer, Integer>)
 *  - stringify (Function<Integer, String>)
 */
public class Main {

    public static void main(String[] args) {
        // Невелика демонстрація роботи методів.
        demoTask5();
        demoTask6();
        demoTask7();
    }

    /* =========================================================
     *  Завдання 5
     * ========================================================= */

    /**
     * Загальний метод, який приймає масив елементів, Predicate та Consumer.
     * Для кожного елемента масиву, який задовольняє умову predicate,
     * виконується дія consumer.accept(element).
     */
    public static <T> void processIf(T[] data,
                                     Predicate<T> predicate,
                                     Consumer<T> consumer) {
        for (T element : data) {
            if (predicate.test(element)) {
                consumer.accept(element);
            }
        }
    }

    private static void demoTask5() {
        System.out.println("=== Завдання 5 ===");
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Лямбда №1: вивести всі парні числа
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> print = n -> System.out.print(n + " ");
        System.out.print("Парні числа: ");
        processIf(numbers, isEven, print);
        System.out.println();

        // Лямбда №2: вивести всі числа > 5 у квадраті
        Predicate<Integer> greaterThanFive = n -> n > 5;
        Consumer<Integer> printSquared = n -> System.out.print((n * n) + " ");
        System.out.print("Числа > 5 у квадраті: ");
        processIf(numbers, greaterThanFive, printSquared);
        System.out.println();
        System.out.println();
    }

    /* =========================================================
     *  Завдання 6
     * ========================================================= */

    /**
     * Повертає Function, яка обчислює 2^n для цілого n.
     */
    public static Function<Integer, Integer> powerOfTwoFunction() {
        return n -> (int) Math.pow(2, n);
    }

    private static void demoTask6() {
        System.out.println("=== Завдання 6 ===");
        Function<Integer, Integer> pow2 = powerOfTwoFunction();

        int[] source = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = new int[source.length];

        for (int i = 0; i < source.length; i++) {
            result[i] = pow2.apply(source[i]);
        }

        System.out.println("Вхідний масив: " + Arrays.toString(source));
        System.out.println("2^n для кожного елемента: " + Arrays.toString(result));
        System.out.println();
    }

    /* =========================================================
     *  Завдання 7
     * ========================================================= */

    /**
     * Метод stringify()
     * Приймає масив цілих чисел і Function, яка перетворює Integer у String.
     * Повертає масив рядків, де кожен елемент — це перетворене число.
     */
    public static String[] stringify(int[] data, Function<Integer, String> converter) {
        String[] result = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = converter.apply(data[i]);
        }
        return result;
    }

    private static void demoTask7() {
        System.out.println("=== Завдання 7 ===");
        int[] data = {1, 2, 3, 4, 5, 10, 15, 20, 25, 30};

        // Простий приклад: перетворюємо число на рядок виду "value = X"
        Function<Integer, String> toLabeledString = n -> "value = " + n;

        String[] asStrings = stringify(data, toLabeledString);

        System.out.println("Вхідний масив: " + Arrays.toString(data));
        System.out.println("Рядкове подання: " + Arrays.toString(asStrings));
        System.out.println();
    }
}
