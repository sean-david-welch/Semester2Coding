package taba.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManageProductsTest {

    private static final String INPUT_FILE = "products.txt";
    private static final String MISSING_DEPT_FILE = "MissingDepartment.txt";
    private static final String PLASTIC_PRODUCTS_FILE = "PlasticProducts.txt";

    private ManageProducts manageProducts;

    @BeforeEach
    public void setUp() {
        manageProducts = new ManageProducts();
    }

    @Test
    public void testReadAndPrintFile() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        manageProducts.readAndPrintFile(INPUT_FILE);

        System.setOut(originalOut);

        String[] lines = outputStream.toString().split(System.lineSeparator());
        assertEquals(lines.length, 25, "File should read 25 lines");
    }

    @Test
    public void testWriteMissingDepartment() throws IOException {
        Path path = Path.of(MISSING_DEPT_FILE);
        Files.deleteIfExists(path);

        manageProducts.writeMissingDepartment(INPUT_FILE, MISSING_DEPT_FILE);

        List<String> lines = Files.readAllLines(path);
        assertEquals(lines.size(), 5, "Should be 5 missing departments");

    }

    @Test
    public void testWritePlasticProducts() throws IOException {
        Path path = Path.of(PLASTIC_PRODUCTS_FILE);
        Files.deleteIfExists(path);

        manageProducts.writePlasticProducts(INPUT_FILE, PLASTIC_PRODUCTS_FILE);

        List<String> lines = Files.readAllLines(path);
        assertEquals(lines.size(), 4, "Should be 4 Plastic products");
    }
}
