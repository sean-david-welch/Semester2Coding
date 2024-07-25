package question2;

public class Main {
    public static void main(String[] args) {

        // will return true - (3, 30 are adjacent and are 10x)
        int[] nums = {2, 22, 3, 30};
        System.out.println(recursiveArray(nums, 0));

        // will return true - (3, 30 are adjacent and are 10x)
        int[] nums2 = {4, 6, 66, 8, 80};
        System.out.println(recursiveArray(nums2, 0));

        // will return false - condition not met
        int[] nums3 = {5, 7, 9, 10, 12};
        System.out.println(recursiveArray(nums3, 0));
    }

    // recusive method implementation
    public static boolean recursiveArray(int[] nums, int i) {
        // base case
        if (i >= nums.length - 1) {
            System.out.println("There are no adjacent number indices where one is a 10x multiple of its predecessor");
            return false;
        }

        // check for 10x multiple condition
        if (nums[i] * 10 == nums[i+ 1]) {
            System.out.printf("This is true, the adjacent numbers are: (%s, %s)%n", nums[i], nums[i +1]);
            return true;
        }

        // base case progrssion and recursive call
        return recursiveArray(nums, i + 1);
    }
}
