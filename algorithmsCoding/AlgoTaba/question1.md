A. Explain in detail, with examples, the concept of Multithreading. (5 Marks)
* Multithreading is a concept in software engineering that referes to the execution of multiple threads in parrellel to eachother; whereby a thread represents a lightweight subprocess in execution [1].
* Multithreading is distinct from multiprocessing becasue threads have a shared memory area and context-switching takes less time than changing between processes [1].
* Multithreading allows for non-blocking operations to occur thus enhancing performace for the user as multiple operations can occur at the same time [1].
* Threads are often indepenedant meaning that if an exception is thrown in one thread, it wont affect the execution of other threads [1]. 
* In Java, we can aggregate threads into a thread pool, which is a collection of workers that wait to process jobs in the queue which can simplify the process of managing thread execution [1].

--------------------------------------------------------------

B. Discuss the type of problems, with examples, where multithreading fails to improve performance. (5 Marks)
* On a single processor server, it does not make sense to use multithreading as we do not have multiple processors/cores to make use of, therefore context switching will incur reduced performance due to necessity of sequentail operations. [2].
* When threads need access to a shared resource, such as a database or shared datastructure, often time multithreading does not make sense as it can lead to locking situations to avoid data corruption [2].
* If we are dealing with a small amount of data to process, it does not make sense to use multithreading as the overhead of thread management will likely not outweight the performance benefits of multithreading [2].
* Any task that requires sequential execution, such as a sorting algorithm whereby the next operation is dependant on the result of its predeccesor, will not benefit from multithreading [2].
* Any process that involves a lot of I/O such as a large amount of reading/writing to a file will not benefit from multithreading as the bottleneck is the I/O, not the computation itself [2].

--------------------------------------------------------------

C. Discuss the difference between threads that extend the Thread class and threads that implement the Runnable interface. (5 Marks)
* When extending the thread class, we are not overriding any of its methods, instead we override the method of Runnable, which is happened to be implemented by Thread, which is a violation IS-A principle
* Implementing the Runnable interface and passing it to the thread class is an example of composition of inheritance and is therefore more flexible
* We can't extend any other classes if using Thread due to Single inheritance in Java
* Runnable is often considered better design because it separates thread behavior from thread execution
* Access to more methods if implementing the Runnable interface as we can still implement other interfaces

--------------------------------------------------------------

# References

[1]	“Multithreading in java,” www.javatpoint.com. [Online]. Available: https://www.javatpoint.com/multithreading-in-java. [Accessed: 21-Aug-2024].
[2]	“When is multi-threading not a good idea?,” Stack Overflow. [Online]. Available: https://stackoverflow.com/questions/93834/when-is-multi-threading-not-a-good-idea. [Accessed: 22-Aug-2024].
[3]	“Implementing a Runnable vs Extending a Thread,” Baeldung.com. [Online]. Available: https://www.baeldung.com/java-runnable-vs-extending-thread. [Accessed: 22-Aug-2024].
