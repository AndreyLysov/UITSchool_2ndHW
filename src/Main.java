import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Andrey.Lysov on 10/29/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Please select a number of task:");
        System.out.println("1. Приветствовать любого пользователя при вводе его имени через командную строку.");
        System.out.println("2. Отобразить в окне консоли аргументы командной строки в обратном порядке.");
        System.out.println("3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку.");
        System.out.println("4. Ввести пароль из командной строки и сравнить его со строкой-образцом.");
        System.out.println("5. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) " +
                "и вывести результат на консоль.");
        System.out.println("6.Ввести с консоли n целых чисел. На консоль вывести:");
        System.out.println("6.1. Четные и нечетные числа.");
        System.out.println("6.2. Наибольшее и наименьшее число.");
        System.out.println("6.3. Числа, которые делятся на 3 или на 9.");
        System.out.println("6.4. Числа, которые делятся на 5 и на 7.");
        System.out.println("6.5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        System.out.println("6.6. «Счастливые» числа.");
        System.out.println("6.7. Элементы, которые равны полусумме соседних элементов.");
        Scanner scaner = new Scanner(System.in);
        String task = scaner.nextLine();
        switch (task) {
            case "1":
                System.out.println("Please enter your name");
                String name = scaner.nextLine();
                System.out.println("Hello " + name);
                break;
            case "2":
                for (int i = args.length; i > 0; i--) {
                    System.out.print(args[i - 1]);
                    System.out.print(" ");
                }
                break;
            case "3":
                System.out.println("Please enter count of random numbers");
                int countNumber = Integer.parseInt(scaner.nextLine());
                Random randomizer = new Random();
                for (; countNumber > 0; countNumber--) {
                    System.out.println(randomizer.nextDouble());
                }
                break;
            case "4":
                System.out.println("Please enter the password");
                String enteredPassword = scaner.nextLine();
                String password = "123456789";
                if (enteredPassword.equals(password)) {
                    System.out.println("You entered correct password");
                } else {
                    System.out.println("You entered invalid password");
                }
                break;
            case "5":
                int sum = 0, multiple = 1;
                for (String commandNumbers :
                        args) {
                    int variable = Integer.parseInt(commandNumbers);
                    sum += variable;
                    multiple *= variable;
                }
                System.out.println("Sum of elements equals: " + sum);
                System.out.println("Multiplication of elements equals: " + multiple);
                break;
            case "6":
                System.out.println("Please enter numbers with space as separator. If you ");
                String strNumbers = scaner.nextLine();
                int[] numbers = new int[]{};
                if (strNumbers.equals("")) {
                    numbers = new int[10000];
                    for (int i = 0; i < 10000; i++) {
                        numbers[i] = i;
                    }
                } else {
                    String[] strNumberArray = strNumbers.split(" ");
                    numbers = new int[strNumberArray.length];
                    for (int i = 0; i < strNumberArray.length; i++) {
                        numbers[i] = Integer.parseInt(strNumberArray[i]);
                    }
                }
                System.out.print(6.1 + " Even numbers:");
                for (int number :
                        numbers) {
                    if (number % 2 == 0)
                        System.out.print(number + " ");
                }
                System.out.println();
                System.out.print("Odd numbers: ");
                for (int number :
                        numbers) {
                    if (number % 2 == 1)
                        System.out.print(number + " ");
                }
                System.out.println();
                System.out.println("6.2 Maximum is " + Arrays.stream(numbers).max());
                System.out.println("Minimum is " + Arrays.stream(numbers).min());
                System.out.println("6.3 Numbers divided to 3 or 9 without excess: ");
                for (int number :
                        numbers) {
                    if (number % 3 == 0)
                        System.out.print(number + " ");
                }
                System.out.println();
                System.out.println("Numbers divided to 5 and 7 without excess");
                for (int number :
                        numbers) {
                    if (number % 5 == 0 && number % 7 == 0)
                        System.out.print(number + " ");
                }
                System.out.println();
                System.out.println("6.4");
                for (int number :
                        numbers) {
                    if (number > 99 && number < 1000) {
                        if (number / 100 != (number / 10) % 10 && number / 100 != number % 10 &&
                                (number / 10) % 10 != number % 10)
                            System.out.print(number + " ");
                    }
                }
                System.out.println();
                System.out.println(6.5);
                for (int number :
                        numbers) {
                    int numberLength = (Integer.toString(number)).length();
                    if (numberLength % 2 == 0) {
                        int halfOfLength = numberLength / 2;
                        String strNumber = Integer.toString(number);
                        char[] chrFirstHalf = strNumber.substring(0, halfOfLength).toCharArray();
                        char[] chrSecondHalf = strNumber.substring(halfOfLength, 2 * halfOfLength).toCharArray();
                        int sumOfFirstHalf = 0, sumOfSecondHalf = 0;
                        for (int i = 0; i < halfOfLength; i++) {
                            sumOfFirstHalf += Character.getNumericValue(chrFirstHalf[i]);
                            sumOfSecondHalf += Character.getNumericValue(chrSecondHalf[i]);
                            if (i == halfOfLength - 1 && sumOfFirstHalf == sumOfSecondHalf)
                                System.out.print(number + " ");
                        }
                    }
                }
                System.out.println();
                System.out.println("6.6");
                for (int number :
                        numbers) {
                    if (number > 99 && number < 1000 && (number / 100 + number % 10) / 2d == number / 10 % 10){
                        System.out.print(number + " ");
                    }
                }
                break;
            default:
                System.out.println("Wrong input");
        }
    }
}