package Day4;

import Utils.FileIO;

import java.io.IOException;
import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) throws IOException {
        String[] cards = FileIO.readFile("src/Day4/data.txt").split("\n");
        ArrayList<Integer> matchesList = new ArrayList<>(), copies = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            copies.add(1);
        }
        int[][] values = new int[cards.length][3];
        // each row is one card with the following format: [points, # of matches(could be calculated based on points, this is simpler), multiplier]
        for (int i = 0; i < values.length; i++) {
            values[i][2] = 1;
        }
        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];
            int points = 0, matches = 0;
            String[] data = card.split(":")[1].trim().split("\\|");
            String[] winningTemp = data[0].trim().split(" ");
            ArrayList<Integer> winningNums = new ArrayList<>();
            for (String num : winningTemp) {
                if (!num.isEmpty()) winningNums.add(Integer.parseInt(num.trim()));
            }
            String[] haveTemp = data[1].trim().split(" ");
            ArrayList<Integer> haveNums = new ArrayList<>();
            for (String num : haveTemp) {
                if (!num.isEmpty()) haveNums.add(Integer.parseInt(num.trim()));
            }
            for (int num : haveNums) {
                if (winningNums.contains(num)) {
                    points = points != 0 ? 2*points : 1;
                    matches++;
                }
            }
            values[i][0] = points;
            values[i][1] = matches;
            matchesList.add(matches);
        }
        for (int i = 0; i < matchesList.size(); i++) {
            for (int j = i+1; j <= i + matchesList.get(i); j++) {
                copies.set(j, copies.get(j)+ copies.get(i));
            }
        }
        int temp = 0;
        for (int i = 0; i < copies.size(); i++) {
            temp += copies.get(i);
        }
        System.out.println(temp);
    }
}
