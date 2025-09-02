package domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String file = "src/main/resources/DataDriven1.csv";

        // Specify which cell to read (0-based indexing)
        int targetRow = 1;    // Row index (0 = first row, 1 = second row, etc.)
        int targetColumn = 0; // Column index (0 = first column, 1 = second column, etc.)

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int currentRow = 0;

            while ((line = reader.readLine()) != null) {
                if (currentRow == targetRow) {
                    // Found the target row
                    String[] row = line.split(",");

                    if (targetColumn < row.length) {
                        String cellValue = row[targetColumn];
                        System.out.println(cellValue);
                    } else {
                        System.out.println("Error: Column " + targetColumn + " doesn't exist in row " + targetRow);
                    }
                    break; // Exit the loop since we found our row
                }
                currentRow++;
            }

            if (currentRow < targetRow) {
                System.out.println("Error: Row " + targetRow + " doesn't exist in the file");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
