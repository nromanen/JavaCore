// Tasks*** 2
// Write a method to compute the sum of the digits in a three-digits
// positive integer number

public class LargerNumber {

    public static void main(String[] args) {

        int a = 1111112;
// Вариант 1 ( лише для 3х значного числа
        int b = (a % 10);
        int c = (a / 10) % 10;
        int d = (a / 100) % 10;
        System.out.println(b + c + d);

// Вариант 2 для любих чисел
        String numbers = String.valueOf(a);
        char[] number = numbers.toCharArray();
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += Character.getNumericValue(number[i]);
        }
        System.out.println(sum);
    }
}