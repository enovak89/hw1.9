import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        task1_3();
        task4();
    }

    public static int[] getRandomArray(int min, int max, int size) {
        int[] randomArr = new int[size];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
        //Почему-то не работает for-each для заранее не наполненных массивов((
        //for (int i : randomArr) {
        //            i = ThreadLocalRandom.current().nextInt(min, max + 1);
        //        }
        return randomArr;
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
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; i >= 0; i--) {
            System.out.print(reverseFullName[i] + " ");
        }
    }
}
