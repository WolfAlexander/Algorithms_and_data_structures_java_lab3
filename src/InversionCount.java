public class InversionCount {
    /**
     * This method count amount is invertions for linked list
     * @param a is the linked list
     * @return int which is the invertion count
     */
    public static int invertionCount(SinglyLinkedList a){
        if(a.getSize() < 2)
            return 0;
        else{
            SinglyLinkedList.Node leftLast = getMiddleNode(a);
            SinglyLinkedList.Node rightFirst = leftLast.getNext();

            SinglyLinkedList left = new SinglyLinkedList(a.getFirst(), leftLast);
            SinglyLinkedList right = new SinglyLinkedList(rightFirst, a.getLast());

            return invertionCount(left) + invertionCount(right) + merge(a, left, right);
        }
    }

    private static int merge(SinglyLinkedList a, SinglyLinkedList left, SinglyLinkedList right){
        int count = 0;
        int index = 0;
        SinglyLinkedList.Node leftPointer = left.getFirst();
        SinglyLinkedList.Node rightPointer = right.getFirst();
        SinglyLinkedList.Node arrayPointer = a.getFirst();

        while (leftPointer != null || rightPointer != null) {
            if (leftPointer == null) {
                arrayPointer.setValue(rightPointer.getValue());
                rightPointer = rightPointer.getNext();
                arrayPointer = arrayPointer.getNext();
            } else if (rightPointer == null) {
                arrayPointer.setValue(leftPointer.getValue());
                index++;
                leftPointer = leftPointer.getNext();
                arrayPointer = arrayPointer.getNext();
            } else if (leftPointer.getValue().compareTo(rightPointer.getValue()) <= 0) {
                arrayPointer.setValue(leftPointer.getValue());
                index++;
                leftPointer = leftPointer.getNext();
                arrayPointer = arrayPointer.getNext();
            } else {
                arrayPointer.setValue(rightPointer.getValue());
                count += left.getSize() - index;
                rightPointer = rightPointer.getNext();
                arrayPointer = arrayPointer.getNext();
            }
        }
        return count;
    }

    private static SinglyLinkedList.Node getMiddleNode(SinglyLinkedList a){
        SinglyLinkedList.Node middleNode = a.getFirst();

        for(int i = 0; i < (a.getSize()+1)/2-1; i++)
            middleNode = middleNode.getNext();

        return middleNode;
    }
}