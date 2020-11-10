package JavaAdvancedLecture6.ExProblem9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> list = new CustomList<>();

        String line = reader.readLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("Add")) {
                list.add(tokens[1]);
            } else if (tokens[0].equals("Remove")) {
                list.remove(Integer.parseInt(tokens[1]));
            } else if (tokens[0].equals("Contains")) {
                System.out.println(list.contains(tokens[1]));
            } else if (tokens[0].equals("Swap")) {
                list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            } else if (tokens[0].equals("Greater")) {
                System.out.println(list.countGreaterThen(tokens[1]));
            } else if (tokens[0].equals("Max")) {
                System.out.println(list.getMax());
            } else if (tokens[0].equals("Min")) {
                System.out.println(list.getMin());
            } else if (tokens[0].equals("Print")) {
                for (String s : list) {
                    System.out.println(s);
                }



            } else if (tokens[0].equals("Sort")) {
                Sorter.sort(list);
            }
            line = reader.readLine();
        }


    }
}