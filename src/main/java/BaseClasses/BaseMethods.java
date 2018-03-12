package BaseClasses;

import java.util.Random;

public class BaseMethods {


    private final static char[] chars = "abcdefghijklmnoprstqwuxyz".toCharArray();

    public static String generateRandomString(int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars[r.nextInt(25)]);
        }
        return sb.toString();
    }


    public static String generateRandomEmail() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.nextInt(7) + 5; i++) {
            sb.append(chars[r.nextInt(25)]);
        }
        sb.append("@gmail.com");
        return sb.toString();
    }
}
