package collections;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();

        customLinkedList.add("123");
        customLinkedList.add("456");
        customLinkedList.add("78d");
        customLinkedList.printLists(customLinkedList);

        customLinkedList.delete(1);
        System.out.println("get: " + customLinkedList.get(0));
        System.out.println("get: " + customLinkedList.get(1));
        customLinkedList.add("901");
        customLinkedList.addFirst("45f");
        customLinkedList.addFirst("23f");
        customLinkedList.printLists(customLinkedList);

        System.out.println("get: " + customLinkedList.get(1));
        System.out.println("get: " + customLinkedList.get(2));
        System.out.println("first: " + customLinkedList.first());
        System.out.println("last: " + customLinkedList.last());

        customLinkedList.printLists(customLinkedList);
    }
}
