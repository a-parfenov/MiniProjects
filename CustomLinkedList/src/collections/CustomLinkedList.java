package collections;

import java.util.Iterator;

public class CustomLinkedList<Element> implements Iterable<Element> {

    private Node<Element> first;
    private Node<Element> last;
    private int size;

    private static class Node<Element> {
        Element item;
        Node<Element> next;
        Node<Element> prev;

        Node(Node<Element> prev, Element element, Node<Element> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<Element> iterator() {
        return new Iterator<>() {
            private Node<Element> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
                Node<Element> tmp = current;
                current = current.next;
                return tmp.item;
            }
        };
    }

    public void add(Element element) {
        Node<Element> node;
        if (first == null) {
            node = new Node<>(null, element, null);
            first = node;
        } else {
            node = new Node<>(last, element, null);
            last.next = node;
        }
        last = node;
        size++;
    }

    public void addFirst(Element element) {
        Node<Element> newElement = new Node<>(null, element, null);
        Node<Element> tmp = first;
        tmp.prev = newElement;
        newElement.next = tmp;
        first = newElement;
        size++;
    }

    public Element get(int index) {
        if (getNodeByIndex(index) != null)
            return getNodeByIndex(index).item;
        else return null;
    }

    private Node<Element> getNodeByIndex(int index) {
        Node<Element> result = first;
        for (int i = 0; i < index; i++) {
            if (result.next != null)
                result = result.next;
            else
                return null;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public Element first() {
        return first.item;
    }

    public Element last() {
        return last.item;
    }

    public void delete(int index) {
        if (index >= size){
            System.out.println("Error");
            return;
        }
        Node<Element> deleteNode = getNodeByIndex(index);
        assert deleteNode != null;
        Node<Element> elBefore = deleteNode.prev;
        Node<Element> elAfter = deleteNode.next;
        elBefore.next = elAfter;
        elAfter.prev = elBefore;
        size--;
    }

    public void printLists(CustomLinkedList<String> customLinkedList) {
        System.out.println();
        System.out.println("size: " + customLinkedList.size());
        for (String e : customLinkedList) {
            System.out.println("Iterable: " + e);
        }
    }

}
