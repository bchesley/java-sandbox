import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomStringCSVGenerator {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the number of rows and the output file name as command-line arguments.");
            return;
        }

        int numRows = Integer.parseInt(args[0]);
        String outputFileName = args[1];

        generateCSV(numRows, outputFileName);

        System.out.println("CSV file generated successfully.");
    }

    private static void generateCSV(int numRows, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            Random random = new Random();

            for (int i = 0; i < numRows; i++) {
                String randomString = generateRandomString(random, 10); // Adjust the string length as needed
                writer.write(randomString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating the CSV file.");
            e.printStackTrace();
        }
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
