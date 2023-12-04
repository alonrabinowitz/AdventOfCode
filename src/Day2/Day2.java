package Day2;

import java.io.IOException;

public class Day2 {
    public static void main(String[] args) throws IOException {
        String[] games = Utils.FileIO.readFile("src/Day2/data.txt").split("\n");
        int sum = 0;
        boolean valid = true;
        for (int i = 0; i < games.length; i++) {
            valid = true;
            String[] sets = games[i].split(": ")[1].split("; ");
            int red = 1, green = 1, blue = 1;
            for (int j = 0; j < sets.length; j++) {
                String[] pulls = sets[j].split(", ");
                for (int k = 0; k < pulls.length; k++) {
                    String[] data = pulls[k].split(" ");
                    int num = Integer.parseInt(data[0]);
                    switch (data[1]){
                        case "red":
                            if (num > 12) valid = false;
                            red = Math.max(red, num);
                            break;
                        case "green":
                            if (num > 13) valid = false;
                            green = Math.max(green, num);
                            break;
                        case "blue":
                            if (num > 14) valid = false;
                            blue = Math.max(blue, num);
                            break;
                    }
                }
            }
            sum += red*green*blue;
        }
        System.out.println(sum);
    }
}
