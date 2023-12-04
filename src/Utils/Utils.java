package Utils;

public class Utils {
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }

    public static boolean isInteger(char character) {
        try {
            Integer.parseInt(String.valueOf(character));
            return true;
        } catch (NumberFormatException error) {
            return false;
        }
    }
}
