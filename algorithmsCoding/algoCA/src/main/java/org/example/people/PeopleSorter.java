package org.example.people;

public class PeopleSorter {
    private final People[] people;

    public PeopleSorter(People[] people) {
        this.people = people;
    }

public void BubbleSort() {
    int n = this.people.length;
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
        swapped = false;

        for (int j = 0; j < n - i - 1; j++) {
            int compareResult = this.people[j].compareTo(this.people[j + 1]);
            boolean needsSwap = compareResult > 0 ||
                                (compareResult == 0 && this.people[j].getID() > this.people[j + 1].getID());

            if (needsSwap) {
                // Swap elements
                People temp = this.people[j];
                this.people[j] = this.people[j + 1];
                this.people[j + 1] = temp;
                swapped = true;
            }
        }

        // If no swapping occurred, array is sorted
        if (!swapped) {
            break;
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
