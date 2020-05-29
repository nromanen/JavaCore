package src;
//HoneWork1


import java.util.TreeSet;

//        read number of HTTP Error (400, 401,402, ...)
//        and write the name of this error (Declare enumHTTPError)
public class ReadNumbers {
    public enum HTTPError {
        BAD_REQUEST, UNAUTHORIZED, PAYMENT_REQUIRED
    }

    public static void httpError(int error) {
        switch (error) {
            case 400:
                System.out.println(HTTPError.BAD_REQUEST);
                break;

            case 401:
                System.out.println(HTTPError.UNAUTHORIZED);
                break;
            case 402:
                System.out.println(HTTPError.PAYMENT_REQUIRED);
                break;
            default:
                System.out.println("Unknown error");

        }
    }

    //read 3 float numbers and check: are they all belong to the range [-5,5];
// That method return 0 when numbers are not belon range, and 1 when belong
    public static boolean chekfloat(float a, float b, float c) {


        return (a >= -5 && a <= 5) && (b >= -5 && b <= 5) && (c >= -5 && c <= 5);

    }

    // read 3 integer numbers and write max and min of them;
    public static void max_min_int(int... numbers) {
        TreeSet<Integer> num = new TreeSet<>();
        for (Integer set : numbers
        ) {
            num.add(set);
        }

        System.out.println("min= " + num.first() + " max= " + num.last());


    }


}
