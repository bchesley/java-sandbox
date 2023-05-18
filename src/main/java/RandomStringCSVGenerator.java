import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomStringCSVGenerator {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide the number of rows, columns count, and the output file name as command-line arguments.");
            return;
        }

        int numRows = Integer.parseInt(args[0]);
        int numColumns = Integer.parseInt(args[1]);
        String outputFileName = args[2];

        generateCSV(numRows, numColumns, outputFileName);

        System.out.println("CSV file generated successfully.");
    }

    private static void generateCSV(int numRows, int numColumns, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            Random random = new Random();

            for (int i = 0; i < numRows; i++) {
                String[] row = generateRandomRow(random, numColumns);
                String rowString = String.join(",", row);
                writer.write(rowString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating the CSV file.");
            e.printStackTrace();
        }
    }

    private static String[] generateRandomRow(Random random, int numColumns) {
        String[] row = new String[numColumns];

        for (int i = 0; i < numColumns; i++) {
            row[i] = generateRandomString(random, 10); // Adjust the string length as needed
        }

        return row;
    }

    private static String generateRandomString(Random random, int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
