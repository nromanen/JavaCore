package Mathematics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Sum {
    public static int main(String[] args) throws IOException {
        BufferedReader number = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter three digit number  = ");
    int num = Integer.parseInt(number.readLine());
        int a, b, c;
        a = num % 10; // единички
        b = (num - a) % 100 / 10; // десятки
        c = num / 100; // сотни
        return a + b + c;
    }
}
