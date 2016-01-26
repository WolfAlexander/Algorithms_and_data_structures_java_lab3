/**
 * Starting class for testing of BubbleSort implementation and InversionCount
 */
public class Test {
    public static void main(String[] args){
        Integer[] intTestArray = {1,2,4,3,5,0};
        SinglyLinkedList<Integer> integerLinkedList = new SinglyLinkedList<>(intTestArray);
        doSortAndShow(integerLinkedList);

        String[] stringTestArray = {"n", "b", "a", "j", "s", "d"};
        SinglyLinkedList<String> stringLinkedList = new SinglyLinkedList<>(stringTestArray);
        doSortAndShow(stringLinkedList);

        Integer[] inversionTestArray = {1,2,4,3};
        SinglyLinkedList<Integer> inversionTestLinkedList = new SinglyLinkedList<>(inversionTestArray);
        doInvertioCount(inversionTestLinkedList);
    }

    private static void doSortAndShow(SinglyLinkedList linkedList){
        double startTime = System.currentTimeMillis();

        System.out.println("Before sort: ");
        linkedList.show();

        BubbleSort.sort(linkedList);

        System.out.println("After sort: ");
        linkedList.show();

        System.out.println("\nTime taken: " + (System.currentTimeMillis() - startTime)/1000 + " \n");
    }

    private static void doInvertioCount(SinglyLinkedList linkedList){
        System.out.println("Inversion count: " + InversionCount.invertionCount(linkedList));
    }
}
