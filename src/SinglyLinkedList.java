public class SinglyLinkedList <Item extends Comparable<Item>>{
    private Node first;
    private Node last;
    private int size = 0;

    /**
     * Node class
     */
    public class Node{
        private Item value;
        private Node next;

        /**
         * Constructor for every node
         * @param value is the value of the Node
         */
        public Node(Item value){
            this.value = value;
            next = null;
        }

        /**
         * This method returns value of the node
         * @return value
         */
        public Item getValue(){
            return value;
        }

        /**
         * Return reference to the next node
         * @return reference to the next node
         */
        public Node getNext(){
            return next;
        }

        /**
         * This method sets new next reference to the node
         * @param next is the reference to the next node
         */
        public void setNext(Node next){
            this.next = next;
        }

        /**
         * This method sets new value to the node
         * @param value is the new value
         */
        public void setValue(Item value){
            this.value = value;
        }

        /**
         *
         */
        public void swapValueWithNext(){
            Item temp = next.value;
            next.value = value;
            value = temp;

        }

        /**
         * This method allows to print this object as a string
         * @return string representation of the object
         */
        public String toString(){
            return this.value.toString();
        }
    }

    /**
     * Constructor of a singly linked list that takes first node and last node
     * and will create a new list for all nodes between those two nodes
     * @param first is a Node
     */
    public SinglyLinkedList(Node first , Node last){
        Node node = new Node(first.value);
        this.first = node;
        size = 1;
        if(last != null){
            while(first != last){
                node.setNext(new Node(first.next.value));
                first = first.getNext();
                node = node.getNext();
                this.last = node;
                size++;
            }
        }
    }

    /**
     * Constructor of a singly linked list
     * @param array that has to be converted to a singly linked list
     */
    public SinglyLinkedList(Item[] array){
        if (array.length > 0) {
            Node node = new Node(array[0]);
            this.first = node;
            size = 1;
            while (size < array.length) {
                node.next = new Node(array[size++]);
                node = node.next;
                last = node;
            }
        }
    }

    /**
     * This method returns reference to first node in the singly linked list
     * @return reference to first node
     */
    public Node getFirst(){
        return first;
    }

    /**
     * This method returns reference to last node in the singly linked list
     * @return reference to last node
     */
    public Node getLast(){
        return last;
    }

    /**
     * This method return size of the singly linked list
     * @return int size of the singly linked list
     */
    public int getSize(){
        return size;
    }

    /**
     * This method print single linked list out
     */
    public void show(){
        SinglyLinkedList.Node test = first;
        for(int i = 0; i < size; i++) {
            System.out.print(test + " ");
            test = test.getNext();
        }
    }
}