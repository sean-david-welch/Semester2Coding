package subjects;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList<Subject> list = new LinkedList<>();

        System.out.println("######## Created LList #########");
        System.out.println("Is list empty? " + list.isEmpty());
        System.out.println("LL size: " + list.size()); // 0

        System.out.println("##### Add first subject #####");
        Subject ds = new Subject("DS", 83.7);
        list.add(ds);
        System.out.println("Is LL empty: " + list.isEmpty()); // false
        System.out.println("LL size: " + list.size()); // 1
        System.out.println("LL: " + list.toString());

        System.out.println("##### Add second subject #####");
        Subject oop = new Subject("OOP", 63.5);
        list.add(oop);
        System.out.println("Is LL empty: " + list.isEmpty()); // false
        System.out.println("LL size: " + list.size()); // 1
        System.out.println("LL: " + list.toString());

        System.out.println("##### Remove subject #####");
        System.out.println("Remove DS: " + list.remove("DS"));
        System.out.println("Is LL empty: " + list.isEmpty()); // false
        System.out.println("LL size: " + list.size()); // 1
        System.out.println("LL: " + list.toString());
    }
}
