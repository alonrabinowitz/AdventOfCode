package Day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {
        String[] data = FileIO.readFile("src/Day1/data.txt").split("\n");

        int sum = 0;
        for (String line : data) {
            sum += getCalibrationValue(line);
        }

        System.out.println(sum);
    }

    private static int getCalibrationValue(String str) {
        ArrayList<String> nums = new ArrayList<>(List.of(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}));
        String tmp = "";
        boolean ctrl = true;
        for (int i = 0; i < str.length(); i++) {
            if (!ctrl) break;
            for (String num : nums) {
                if (str.indexOf(num, i) == i) {
                    if (num.length() == 1) {
                        tmp += num;
                        ctrl = false;
                        break;
                    } else {
                        switch (num) {
                            case "one":
                                tmp += "1";
                                break;
                            case "two":
                                tmp += "2";
                                break;
                            case "three":
                                tmp += "3";
                                break;
                            case "four":
                                tmp += "4";
                                break;
                            case "five":
                                tmp += "5";
                                break;
                            case "six":
                                tmp += "6";
                                break;
                            case "seven":
                                tmp += "7";
                                break;
                            case "eight":
                                tmp += "8";
                                break;
                            case "nine":
                                tmp += "9";
                                break;
                        }
                        ctrl = false;
                        break;
                    }
                }
            }
        }
        ctrl = true;
        for (int i = str.length()-1; i >= 0; i--) {
            if (!ctrl) break;
            for (String num : nums) {
                if (str.indexOf(num, i) == i) {
                    if (num.length() == 1) {
                        tmp += num;
                        ctrl = false;
                        break;
                    } else {
                        switch (num) {
                            case "one":
                                tmp += "1";
                                break;
                            case "two":
                                tmp += "2";
                                break;
                            case "three":
                                tmp += "3";
                                break;
                            case "four":
                                tmp += "4";
                                break;
                            case "five":
                                tmp += "5";
                                break;
                            case "six":
                                tmp += "6";
                                break;
                            case "seven":
                                tmp += "7";
                                break;
                            case "eight":
                                tmp += "8";
                                break;
                            case "nine":
                                tmp += "9";
                                break;
                        }
                    }
                    ctrl = false;
                    break;
                }
            }
        }
        if (!tmp.equals("")) return Integer.parseInt(tmp);
        return 0;
    }
}
