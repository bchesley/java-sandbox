import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    private static final Logger logger = LogManager.getLogger(CSVReader.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java CSVReader <csvFilePath> <pauseMilliseconds>");
            System.exit(1);
        }

        String csvFilePath = args[0];
        int recordCount = 0;
        StopWatch watch = new StopWatch();
        watch.start();
        int pauseMilliseconds = Integer.parseInt(args[1]);
        logger.warn("Reading CSV file: " + csvFilePath);
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Pause for the specified number of milliseconds
                Thread.sleep(pauseMilliseconds);

                recordCount++;

                // Log the line to a local log file using log4j
                // logger.info(line);
                System.out.print('.');
            }
        } catch (IOException e) {
            logger.error("Error reading CSV file: " + csvFilePath, e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread interrupted", e);
        }
        watch.stop();
        System.out.println("\nTime Elapsed: " + watch.getTime()); // Prints: Time Elapsed: 2501
        logger.info("Finished reading CSV file: " + csvFilePath + " (" + recordCount + " records)");
    }
}
