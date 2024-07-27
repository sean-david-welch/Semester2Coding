public class PeopleSorter {

    public static void BubbleSort(People[] people) {
        int low = 0;
        int mid = 0;
        int high = people.length - 1;

        while (low <= high) {
            if (low == high) break;

            if (people[mid].compareTo(people[mid + 1]) > 0 || (people[mid].compareTo(people[mid + 1]) == 0 && people[mid].getID() > people[mid + 1].getID())) {
                People temp = people[mid];
                people[mid] = people[mid + 1];
                people[mid + 1] = temp;
                low++;
                mid = 0;
            } else {
                mid++;
                if (mid == high) {
                    low++;
                    mid = 0;
                }
            }
        }
    }

    public static void QuickSort() {}

    public static void BinarySearch() {}
}
