import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Сравнение числа с цифрой 7");
            System.out.println("2. Проверка имени");
            System.out.println("3. Вывод элементов массива, кратных 3");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkNumberGreaterThan7(scanner);
                    break;
                case 2:
                    checkName(scanner);
                    break;
                case 3:
                    printArrayElementsDivisibleBy3(scanner);
                    break;
                case 0:

                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз");
                    break;
            }
        }
    }

    public static void checkNumberGreaterThan7(Scanner scanner) {
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        if (number > 7) {
            System.out.println("Привет");
        } else {
            System.out.println("Число не больше 7");
        }
    }

    public static void checkName(Scanner scanner) {
        System.out.print("Введите Ваше имя: ");
        String name = scanner.next();

        if (name.matches(".*\\d.*")) {
            System.out.println("Имя не должно содержать цифры");
        } else if (name.equalsIgnoreCase("Вячеслав") || name.equalsIgnoreCase("вячеслав")) {
            System.out.println("Привет, Вячеслав");
        } else {
            System.out.println("Жаль, что Вы не Вячеслав, но всё равно приятно познакомиться!");
        }
    }

    public static void printArrayElementsDivisibleBy3(Scanner scanner) {
        int size = 0;
        int count = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите размер массива (целое число): ");

            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Вы ввели некорректное значение. Пожалуйста, введите целое число");
                scanner.next();
            }
        }

        int[] array = new int[size];

        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("Вы ввели не число,оно учитываться не будет,продолжите ввод");
                scanner.next();
            }
            array[i] = scanner.nextInt();
        }

        System.out.println("Элементы данного массива, кратные 3:");

        for (int value : array) {
            if (value % 3 == 0) {
                count++;
                System.out.print(value + " ");
            }

        }     if (count==0){
            System.out.print("Таковых нет");
        }

        System.out.println();
    }
}