public class SinglyLinkedList <E>{
    private Node<E> head= null;
    private Node<E> tail= null;
    private int size= 0;

    public SinglyLinkedList() {}
    public boolean isEmpty(){return size==0;}
    public int size(){return size;}
    public E first(){if (isEmpty()){return null;}
    else {
        return head.getElement();
    }
    }
    public E last(){
        if (isEmpty()){return null;}
        else {
            return tail.getElement();}
    }
    public void addFirst(E e){
        head=new Node<>(e,head);
        if(size==0){
            tail=head;}

        size++;
    }



    public void addLast(Node<?> e){
        Node<E>newest= (Node<E>) new Node<>(e,null);
        if(size==0){
            head=newest;
        }else{
            tail.setNext(newest);}
        tail=newest;
        size++;
    }
    public Node<E> reverseList(Node<E> head) {
        if (head == null || head.getNext() == null) {
            return head; // List is empty or contains only one node
        }

        Node<E> previous = null;
        Node<E> current = head;
        Node<E> next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous; // Update the head of the reversed list

        return head;
    }
    public E removeFirst(){
        if(isEmpty()){return null;}
        E head_=  head.getElement();
        head=head.getNext();
        return head_;
    }
    public void rotate() {
    if (head == null || head.getNext() == null) {
        return; // Nothing to rotate
        }

    Node<E> newHead = head.getNext();
    Node<E> current = head;

    while (current.getNext() != null) {
        current = current.getNext();
        }

    current.setNext(head);
    head.setNext(null);
    head = newHead;
    }
    public Node<E> findSecondToLastNode(Node<E> head) {
    if (head == null || head.getNext() == null) {
        return null;
        }

    Node<E> current = head;
    Node<E> previous = null;

    while (current.getNext() != null) {
        previous = current;
        current = current.getNext();
        }

    return previous;
    }
   @Override
    public boolean equals(Object obj) {
       if (this == obj) {
           return true;
       }

       if (obj == null || getClass() != obj.getClass()) {
           return false;
       }

       SinglyLinkedList<?> otherList = (SinglyLinkedList<?>) obj;

       Node<E> currentNode = head;
       Node<?> otherCurrentNode = otherList.head;

       while (currentNode != null && otherCurrentNode != null) {
           if (!currentNode.getElement().equals(otherCurrentNode.getElement())) {
               return false;
           }

           currentNode = currentNode.getNext();
           otherCurrentNode = otherCurrentNode.getNext();
       }

       return (currentNode == null && otherCurrentNode == null);
    }
    public static SinglyLinkedList<?> concat(SinglyLinkedList<?> L,SinglyLinkedList<?> M){
        if (L.size==0) {
            return M;
        }

        if (M.size==0) {
            return L;
        }
        Node<?> newest=M.head;
        for (int i=0;i<M.size;i++){
           L.addLast(newest);
           newest=newest.getNext();
        }
        return L;
    }
    public int size_(){
       Node<E> x=head;
       int counter =0;
       while (x!=null ){
           counter++;
           x=x.getNext();
       }
    return counter;
    }

    public static class Node<E>{
        private E element ;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
