public class BubbleSort{
    /**
     * This method performs bubble sort
     * @param a is the collection of elements that has to sorted
     */
    public static void sort(SinglyLinkedList a){
        if(a.getSize() <= 0)
            throw new IllegalArgumentException();

        int countSwap = 0;

        int r = a.getSize() - 2;
        boolean swapped = true;

        while(r >= 0 && swapped){
            swapped = false;
            SinglyLinkedList.Node currNode = a.getFirst();

            for(int i = 0; i <= r; i++){
                if(currNode.getValue().compareTo(currNode.getNext().getValue()) > 0) {
                    swapped = true;
                    currNode.swapValueWithNext();
                    countSwap++;
                }
                currNode = currNode.getNext();
            }
            r--;
        }

        System.out.println("\nBubble sort swap count: " + countSwap);
    }
}