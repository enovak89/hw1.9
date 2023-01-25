import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        taskOld();
        task1_3();
        task4();
        taskAdd1();
        taskAdd2();
        taskAdd3();
        taskAdd4();
        taskAdd5();
        taskAdd6();

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

    public static void taskAdd2() {
        System.out.println("taskAdd2");
        int[] arr = getRandomArray(0, 1, 11);
        System.out.println(Arrays.toString(arr));
        int counter = 0;
        for (int i : arr) {
            counter = i == 1 ? ++counter : counter;
        }
        System.out.println(counter);
        System.out.println(counter > 5 ? "1 больше" : "0 больше");
    }

    public static void taskAdd3() {
        System.out.println("taskAdd3");
        int[][] twoDimensionArr = new int[8][5];
        for (int i = 0; i < twoDimensionArr.length; i++) {
            twoDimensionArr[i] = getRandomArray(10, 99, 5);
        }
        System.out.println(Arrays.deepToString(twoDimensionArr));
        for (int[] i : twoDimensionArr) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void taskAdd4() {
        System.out.println("taskAdd4");
        int[][] twoDimensionsArr = new int[5][8];
        int maxElement = twoDimensionsArr[0][0];
        //    for (int[] subArr : twoDimensionsArr) {
        //        subArr = getRandomArray(-99, 99, 8);
        //    }
        for (int i = 0; i < twoDimensionsArr.length; i++) {
            twoDimensionsArr[i] = getRandomArray(-99, 99, 8);
        }
        for (int[] subArr : twoDimensionsArr) {
            System.out.println(Arrays.toString(subArr));
            for (int i = 0; i < subArr.length; i++) {
                maxElement = Math.max(maxElement, subArr[i]);
            }
        }
        Arrays.deepToString(twoDimensionsArr);
        System.out.println(maxElement);
    }

    public static void taskAdd5() {
        System.out.println("taskAdd5");
        int[][] twoDimensionsArr = new int[7][4];
        int[] multiplicationLineArr = new int[twoDimensionsArr.length];
        int maxLineIndex = 0;
        Arrays.fill(multiplicationLineArr, 1);
        for (int i = 0; i < twoDimensionsArr.length; i++) {
            twoDimensionsArr[i] = getRandomArray(-5, 5, 4);
        }
        for (int i = 0; i < twoDimensionsArr.length; i++) {
            for (int j = 0; j < twoDimensionsArr[i].length; j++) {
                multiplicationLineArr[i] *= twoDimensionsArr[i][j];
            }
        }

        for (int[] subArr : twoDimensionsArr) {
            System.out.println(Arrays.toString(subArr));
        }
        System.out.println("Массив с произведениями строк - " + Arrays.toString(multiplicationLineArr));
        int[] multiplicationLineArrCopy = Arrays.copyOf(multiplicationLineArr, multiplicationLineArr.length);
        Arrays.sort(multiplicationLineArrCopy);
        for (int i = 0; i < multiplicationLineArr.length; i++) {
            maxLineIndex = multiplicationLineArr[i] == multiplicationLineArrCopy[multiplicationLineArrCopy.length - 1] ? i : maxLineIndex;
        }
        System.out.println("Индекс строки с максимальным произведением - " + maxLineIndex);
    }

    public static void taskAdd6() {
        System.out.println("taskAdd6");
        int[][] twoDimensionsArr = new int[6][7];
        for (int i = 0; i < twoDimensionsArr.length; i++) {
            twoDimensionsArr[i] = getRandomArray(0, 9, 7);
        }
        for (int[] i : twoDimensionsArr) {
            System.out.println(Arrays.toString(i));
            Arrays.sort(i);
            int tmp = i[0];
            i[0] = i[6];
            i[6] = tmp;
        }
        System.out.println();
        for (int[] i : twoDimensionsArr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
