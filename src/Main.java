import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fibonacci {
    private final int number;
    private final long value;
    private final List<String> individualQuest;

    public Fibonacci(int n) {
        number = n;
        individualQuest = new ArrayList<>();
        value = calculateFibonacci(n);
    }

    public int getNumber() {
        return number;
    }

    public long getValue() {
        return value;
    }

    private long calculateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Некоректний ввід. Число повинно бути додатнім.");
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            long fib1 = 1;
            long fib2 = 1;
            long fib = 0;

            for (int i = 3; i <= n; i++) {
                fib = fib1 + fib2;

                if (isW3Plus1(fib)) {
                    individualQuest.add("Фібоначчі(" + i + ") = " + fib);
                }

                fib1 = fib2;
                fib2 = fib;
            }

            return fib;
        }
    }

    private boolean isW3Plus1(long num) {
        long w = (long) Math.cbrt(num - 1);
        return w * w * w + 1 == num;
    }

    public void printConditionsMet() {
        System.out.println("Числа, які відповідають умові w^3 + 1:");
        for (String condition : individualQuest) {
            System.out.println(condition);
        }
    }
}

class Lucas {
    private final int number;
    private final long value;

    public Lucas(int n) {
        number = n;
        value = calculateLucas(n);
    }

    public int getNumber() {
        return number;
    }

    public long getValue() {
        return value;
    }

    private long calculateLucas(int n) {
        if (n <= 0) {
            System.out.println("Некоректний ввід. Число повинно бути додатнім.");
            return 0;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 1;
        } else {
            long luc1 = 2;
            long luc2 = 1;
            long luc = 0;

            for (int i = 3; i <= n; i++) {
                luc = luc1 + luc2;
                luc1 = luc2;
                luc2 = luc;
            }

            return luc;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice1, choice2, n;

        do {
            System.out.println("З якими числами працювати?:");
            System.out.println("1. Числа Люка");
            System.out.println("2. Числа Фібоначчі");
            System.out.print("Ваш вибір: ");

            choice1 = scanner.nextInt();
        } while (choice1 != 1 && choice1 != 2);

        do {
            System.out.println("Яке число брати за n?:");
            System.out.println("1. Число з командного рядку");
            System.out.println("2. Число введене з клавіатури");
            System.out.print("Ваш вибір: ");

            choice2 = scanner.nextInt();
        } while (choice2 != 1 && choice2 != 2);

        if(choice2 == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.print("Введіть значення більше 0: ");
            n = scanner.nextInt();
        }

        if (choice1 == 1) {
            Lucas lucas = new Lucas(n);
            System.out.println("Кількість: " + lucas.getNumber());
            System.out.println("Значення: " + lucas.getValue());
        } else {
            Fibonacci fibonacci = new Fibonacci(n);
            System.out.println("Кількість: " + fibonacci.getNumber());
            System.out.println("Значення: " + fibonacci.getValue());
            fibonacci.printConditionsMet();
        }

        scanner.close();
    }
}
