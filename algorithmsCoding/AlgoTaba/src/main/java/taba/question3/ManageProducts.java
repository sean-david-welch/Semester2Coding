package taba.question3;

import taba.question2.Question2;

import java.io.*;

public class ManageProducts {
    private static final System.Logger logger = System.getLogger(ManageProducts.class.getName());


    public void readAndPrintFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    public void writeMissingDepartmentToFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String department = fields[3];

                if (department == null || department.trim().isEmpty()) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    public void writePlasticProductsToFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String material = fields[2];

                if ("Plastic".equalsIgnoreCase(material.trim())) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred!", e.getMessage());
        }
    }

    public static void main(String[] args) {
        ManageProducts mp = new ManageProducts();
        mp.readAndPrintFile("products.txt");
        mp.writeMissingDepartmentToFile("products.txt", "MissingDepartment.txt");
        mp.writePlasticProductsToFile("products.txt", "PlasticProducts.txt");
    }
}
