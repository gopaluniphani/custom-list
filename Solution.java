public class Solution {
    public static void main(String[] args) {
        CustomList<Integer> l = new CustomList<Integer>(5);
        for (int i = 0; i < 10; i++)
            l.add(i * 2);
        l.printList();

        CustomList<Integer> m = new CustomList<Integer>(l);
        for (int i = 10; i < 15; i++)
            m.add(i * 2);
        m.printList();

        System.out.println("element in l at index 5: " + l.get(5));
        System.out.println("element in m at index 15: " + m.get(14));
    }
}