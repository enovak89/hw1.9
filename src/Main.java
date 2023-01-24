import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        taskOld();
        task1_3();
        task4();
        taskAdd1();

    }

    public static int[] getRandomArray(int min, int max, int size) {
        int[] randomArr = new int[size];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        //Почему-то не работает for-each для заранее не наполненных массивов - хотя по идее мог бы брать значения элементов по умолчанию((
        //for (int i : randomArr) {
        //            i = ThreadLocalRandom.current().nextInt(min, max + 1);
        //        }
        return randomArr;
    }

    // И почему-то не работает Arrays.toString() при заполненнии массива через for-each строка 41
    // Данная задача taskOld - из прошлой домашки, просто для демонстрации - что массив по факту заполнен, через цикл его элементы выводятся, четность вычисляется
    // а через Arrays.toString() выводится незаполненный массив
    public static void taskOld() {
        System.out.println("TaskOld");
        int[] arrayFirst = new int[15];
        int countOfEven = 0;
        for (int i : arrayFirst) {
            i = ThreadLocalRandom.current().nextInt(0, 100);
            if (i % 2 == 0) {
                countOfEven++;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arrayFirst));
        System.out.println(countOfEven);
    }

    public static void task1_3() {
        System.out.println("task 1_3");
        int[] arr = getRandomArray(100_000, 200_000, 30);
        int monthSum = 0;
        for (int i : arr) {
            monthSum += i;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Сумма трат за месяц составила - " + monthSum);
        int maxElement = 0;
        int minElement = 200_001;
        for (int i : arr) {
            if (i > maxElement) {
                maxElement = i;
            }
            if (i < minElement) {
                minElement = i;
            }
        }
        System.out.println("Минимальная сумма трат за день составила - " + minElement);
        System.out.println("Максимальная сумма трат за день составила - " + maxElement);
        System.out.printf("Среднее значение трат за месяц составило - %.2f\n", (double) monthSum / arr.length);
    }

    public static void task4() {
        System.out.println("task4");
        char[] reverseFullName = {'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i] + " ");
        }
        System.out.println();
    }

    public static void taskAdd1() {
        System.out.println("taskAdd1");
        int[] arr = getRandomArray(-15, 15, 12);
        int maxElement = -16;
        int ind = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxElement) {
                maxElement = arr[i];
                ind = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Максимум = " + maxElement);
        System.out.println("Index maximuma - " + ind);
    }
}
