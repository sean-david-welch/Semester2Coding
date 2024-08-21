# Attempt all the three questions.

### Whenever available: Scenario 4. All products whose material is Plastic saved to a file called `plastic_products.txt`.

---

## 1. Answer the following questions in detail. (15 Marks)

### A. Explain in detail, with examples, the concept of Multithreading. (5 Marks)

### B. Discuss the type of problems, with examples, where multithreading fails to improve performance. (5 Marks)

### C. Discuss the difference between threads that extend the `Thread` class and threads that implement the `Runnable` interface. (5 Marks)

---

## 2. Suppose that:

- There are ten drawers labeled from A-J.
- A is represented as `drawer[0]`, B as `drawer[1]`…, J as `drawer[9]`.
- Each drawer contains 10,000 records.

**Note**: The Java code that generates the data for each drawer is provided to you on Moodle in the `TABA2024.zip` file.

### A. Your task is to compute, as efficiently as possible, the sum, average, maximum, and minimum of the data contained in each drawer. Write a multithreaded Java program that takes the data in each drawer (`drawer[0]` to `drawer[9]`) and computes the above by using 10 separate threads. (20 Marks)

### B. Write a Java program that combines the statistics computed from each thread above (Q2.A) and presents the grand total, average, maximum, and minimum of all the drawers. (10 Marks)

### C. Explain in writing the efficiency of your program by comparing it with a single-threaded program. Use appropriate references where necessary. (5 Marks)

---

## 3. A global company has product records containing `id`, `name`, `material`, `department`, `price` in one big single file called `products.txt`. 

Create a Java class called `ManageProducts.java` and answer the following questions by creating corresponding methods in the `ManageProducts` class. (50 Marks)

### A. Write a Java method that reads the file line by line and prints the content of the file to the standard output. (15 Marks)

### B. Write a Java method that writes all the products with missing department information to a file called `MissingDepartment.txt`. (10 Marks)

### C. Discuss the difference and similarities between byte stream readers and character stream readers in Java. (10 Marks)

### D. Select one scenario from the list on the next page and write a Java method that saves the corresponding product data to a separate file. (15 Marks)
