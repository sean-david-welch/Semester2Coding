package question3.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LatexValidator {

    public static void latexValidator(String filename) {
        Stack stack = new Stack(100);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (line.contains("\\begin")) {
                    stack.push("\\begin");
                }

                if (line.contains("\\end")) {
                    if (stack.isEmpty()) {
                        System.out.println("Error: Unmatched \\end tag at line " + lineNumber);
                        return;
                    } else {
                        String topElement = (String) stack.peek();
                        if (topElement.equals("\\begin")) {
                            stack.pop();
                        } else {
                            System.out.println("Error: Unmatched \\end tag at line " + lineNumber);
                            return;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: Unmatched \\begin tag(s) found.");
        } else {
            System.out.println("Success: All \\begin tags are matched with corresponding \\end tags.");
        }
    }

    public static void main(String[] args) {
        String filename = Objects.requireNonNull(LatexValidator.class.getResource("/resources/latex.txt")).getPath();
        latexValidator(filename);

        String filename2 = Objects.requireNonNull(LatexValidator.class.getResource("/resources/invalidLatex.txt")).getPath();
        latexValidator(filename2);
    }
}
