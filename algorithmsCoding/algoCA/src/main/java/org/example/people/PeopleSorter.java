package org.example.people;

public class PeopleSorter {
    private final People[] people;

    public PeopleSorter(People[] people) {
        this.people = people;
    }

    public void BubbleSort() {
        int start = 0;
        int current = 0;
        int end = this.people.length - 1;

        while (start <= end) {
            if (start == end) break;

            // Check if a swap is needed based on the comparison result or ID comparison
            boolean currentIsGreater = this.people[current].compareTo(this.people[current + 1]) > 0;
            boolean currentIsEqual = (this.people[current].compareTo(this.people[current + 1]) == 0 && this.people[current].getID() > this.people[current + 1].getID());
            boolean needsSwap = currentIsGreater || currentIsEqual;

            if (needsSwap) {
                // Swap elements
                People temp = this.people[current];
                this.people[current] = this.people[current + 1];
                this.people[current + 1] = temp;

                // Reset the pointers
                start++;
                current = 0;
            } else {
                current++;
                if (current == end) {
                    start++;
                    current = 0;
                }
            }
        }
    }

    public void QuickSort(int low, int high) {
        if (low < high) {
            int partition = partition(low, high);

            QuickSort(low, partition - 1);
            QuickSort(partition + 1, high);
        }
    }

    private int partition(int low, int high) {
        People pivot = people[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (people[j].compareTo(pivot) <= 0) {
                i++;
                People temp = people[i];
                people[i] = people[j];
                people[j] = temp;
            }
        }

        People temp = people[i + 1];
        people[i + 1] = people[high];
        people[high] = temp;
        return i + 1;
    }

    public static void BinarySearch() {}
}
