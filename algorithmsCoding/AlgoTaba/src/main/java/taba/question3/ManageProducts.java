package taba.question3;

import java.io.*;

public class ManageProducts {
    private static final System.Logger logger = System.getLogger(ManageProducts.class.getName());

    // Part A
    public void readAndPrintFile(String filePath) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    // Part B
    public void writeMissingDepartment(String inputFilePath, String outputFilePath) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] fields = line.split(",");
                String department = fields[3];

                if (department == null || department.trim().isEmpty()) {
                    outputFile.write(line);
                    outputFile.newLine();
                }
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    // Part D
    public void writePlasticProducts(String inputFilePath, String outputFilePath) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] fields = line.split(",");
                String material = fields[2];

                if ("Plastic".equalsIgnoreCase(material.trim())) {
                    outputFile.write(line);
                    outputFile.newLine();
                }
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    public static void main(String[] args) {
        ManageProducts mp = new ManageProducts();
        mp.readAndPrintFile("products.txt");
        mp.writeMissingDepartment("products.txt", "MissingDepartment.txt");
        mp.writePlasticProducts("products.txt", "plastic_products.txt");
    }
}
