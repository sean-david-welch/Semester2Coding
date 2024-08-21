# C. Explain in writing the efficiency of your program by comparing it with a single-threaded program. Use appropriate references where necessary. (5 Marks)

## Explanation

####
The code for part a uses multithreading in order to achieve a more efficient processing speed.
Multithreading refers to the process of using multiple cores on a CPU in order to run tasks in parrallel to eachother.
To do this, I have implemented the use of an Executor Service to manage the threads which automates the submitting of tasks to the queue.
We Then pool together these threads in the thread pool to avoid creating a new thread everytime a task is to be executed in the queue.
The future tasks are implemented as a callable object which are added to a map along with index to represent each statistic or their future asynchronous result.
A concurrent hashmap is then used to store the computed statistics in a thread safe manner.

In the single threaded version of the method, we are simply adding each future result to the statistics array in a loop.
The code below and test results show the outcome of both operations, with the results showing that the async approach is on average 1.5x faster.
#### 

--------------------------------------------------------------


## Test Code

--------------------------------------------------------------


```java
package taba.question2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

class Question2Test {

    @Test
    void compareSingleThreadedAndMultiThreadedPerformance() {
        // Generate data for 10 drawers
        List<List<Integer>> drawers = Question2.generateData();

        // Measure time for async execution
        long asyncStartTime = System.nanoTime();
        Map<Integer, DrawerStatistics> asyncResults = Question2.computeStatisticsAsync(drawers);
        long asyncEndTime = System.nanoTime();
        long asyncDuration = asyncEndTime - asyncStartTime;

        // Measure time for synchronous execution
        long synchronousStartTime = System.nanoTime();
        List<DrawerStatistics> synchronousResults = Question2.computeStatisticsSync(drawers);
        long synchronousEndTime = System.nanoTime();
        long synchronousDuration = synchronousEndTime - synchronousStartTime;

        // Ensure both methods return the same results
        assertEquals(synchronousResults.size(), asyncResults.size(), "Both methods should produce same number of results");

        // Print results to console
        System.out.println("\nTime taken by async version: " + asyncDuration + " ns");
        System.out.println("Time taken by synchronous version: " + synchronousDuration + " ns");
        System.out.println("\nEfficiency comparison:");
        System.out.println("Async execution is " + (synchronousDuration / (double) asyncDuration) + " times faster");

        assertTrue(asyncDuration < synchronousDuration, "Async execution should be faster");
    }
}
```

# Test Code Results

### Result 1

--------------------------------------------------------------
* Drawer A: Sum: -1403, Average: -0.1403, Max: 9999, Min: -9995
* Drawer B: Sum: 100811, Average: 10.0811, Max: 9998, Min: -9999
* Drawer C: Sum: -527075, Average: -52.7075, Max: 9998, Min: -9998
* Drawer D: Sum: 131911, Average: 13.1911, Max: 9997, Min: -10000
* Drawer E: Sum: -749405, Average: -74.9405, Max: 9996, Min: -10000
* Drawer F: Sum: -43741, Average: -4.3741, Max: 9991, Min: -10000
* Drawer G: Sum: -579892, Average: -57.9892, Max: 9998, Min: -10000
* Drawer H: Sum: -649010, Average: -64.901, Max: 9999, Min: -9999
* Drawer I: Sum: -277948, Average: -27.7948, Max: 9998, Min: -10000
* Drawer J: Sum: -407252, Average: -40.7252, Max: 9995, Min: -10000

Time taken by async version: 5135959 ns
Time taken by synchronous version: 7517542 ns

Efficiency comparison:
Async execution is 1.4637075568554967 times faster

### Result 2

--------------------------------------------------------------
* Drawer A: Sum: -412660, Average: -41.266, Max: 9997, Min: -10000
* Drawer B: Sum: 160125, Average: 16.0125, Max: 9998, Min: -9999
* Drawer C: Sum: -793994, Average: -79.3994, Max: 9999, Min: -9999
* Drawer D: Sum: 894926, Average: 89.4926, Max: 9998, Min: -10000
* Drawer E: Sum: -517631, Average: -51.7631, Max: 9992, Min: -10000
* Drawer F: Sum: 407670, Average: 40.767, Max: 9999, Min: -9999
* Drawer G: Sum: -907340, Average: -90.734, Max: 9998, Min: -9998
* Drawer H: Sum: 21972, Average: 2.1972, Max: 9998, Min: -10000
* Drawer I: Sum: 646527, Average: 64.6527, Max: 9998, Min: -10000
* Drawer J: Sum: -229551, Average: -22.9551, Max: 9989, Min: -10000

Time taken by async version: 4928791 ns
Time taken by synchronous version: 7401625 ns

Efficiency comparison:
Async execution is 1.5017120831457451 times faster

### Result 3

--------------------------------------------------------------
* Drawer A: Sum: -755120, Average: -75.512, Max: 9999, Min: -10000
* Drawer B: Sum: -351901, Average: -35.1901, Max: 9996, Min: -9998
* Drawer C: Sum: -120262, Average: -12.0262, Max: 9993, Min: -9995
* Drawer D: Sum: -199275, Average: -19.9275, Max: 9996, Min: -9999
* Drawer E: Sum: 250066, Average: 25.0066, Max: 9998, Min: -9996
* Drawer F: Sum: -278982, Average: -27.8982, Max: 9999, Min: -9999
* Drawer G: Sum: -24974, Average: -2.4974, Max: 9999, Min: -9999
* Drawer H: Sum: 465794, Average: 46.5794, Max: 9994, Min: -9999
* Drawer I: Sum: -1159984, Average: -115.9984, Max: 9999, Min: -9999
* Drawer J: Sum: 548317, Average: 54.8317, Max: 9997, Min: -10000

Time taken by async version: 4991042 ns
Time taken by synchronous version: 10109292 ns

Efficiency comparison:
Async execution is 2.0254872629803558 times faster
--------------------------------------------------------------