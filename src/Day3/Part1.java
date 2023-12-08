package Day3;

import java.io.IOException;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String[] lines = Utils.FileIO.readFile("src/Day3/data.txt").split("\n");
//        String[][] grid = new String[lines.length][lines[0].length()];
//        for (int i = 0; i < lines.length; i++) {
//            grid[i] = lines[i].split("");
//        }

        int sum = 0;

        int start = 0, end = 0;
        ArrayList<Integer[]> numbers = new ArrayList<>();
        // Data will be [line, start, end]
        boolean inNumber = false;
        for (int row = 0; row < lines.length; row++) {
            for (int i = 0; i < lines[row].length(); i++) {
                if (Utils.Utils.isInteger(lines[row].charAt(i))) {
                    if (inNumber) {
                        end++;
                    } else {
                        start = i;
                        end = i;
                        inNumber = true;
                    }
                    if (i == lines[row].length() - 1) {
                        end--;
//                        if (symbolAdjacent(lines, row, start, end)) {
//                            sum += Integer.parseInt(lines[row].substring(start, end <= lines[row].length()-1? end + 1 : lines[row].length()-1));
//                        }
                        numbers.add(new Integer[]{row, start, end});
                        inNumber = false;
                    }
                } else {
                    if (inNumber) {
//                        if (symbolAdjacent(lines, row, start, end)) {
//                            sum += Integer.parseInt(lines[row].substring(start, end <= lines[row].length()-1? end + 1 : lines[row].length()-1));
//                        }
                        numbers.add(new Integer[]{row, start, end});
                        inNumber = false;
                    }
                }
            }
        }
        for (Integer[] number : numbers) {
            if (symbolAdjacent(lines, number[0], number[1], number[2])) {
//                sum += Integer.parseInt(lines[number[0]].substring(number[1], number[2] <= lines[number[0]].length()-1? number[2] + 1 : lines[number[0]].length()-1));
                sum += Integer.parseInt(lines[number[0]].substring(number[1], number[2] <= lines[number[0]].length()-1? number[2] + 1 : number[2]));
            }
        }
        System.out.println(sum);
    }

    public static boolean symbolAdjacent(String[] data, int row, int start, int end) {
        if (row != 0) {
            for (int i = start == 0 ? start : start - 1; i <= (end == data[row].length() ? end : end + 1); i++) {
                if (data[row-1].charAt(i) != '.') {
                    return true;
                }
            }
        }
        if (start != 0) {
            if (data[row].charAt(start - 1) != '.') {
                return true;
            }
        }
        if (end != data[row].length()) {
            if (data[row].charAt(end + 1) != '.') {
                return true;
            }
        }
        if (row != data.length - 1) {
            for (int i = start == 0 ? start : start - 1; i <= (end == data[row].length() ? end : end + 1); i++) {
                if (data[row + 1].charAt(i) != '.') {
                    return true;
                }
            }
        }
       return false;
    }
}
