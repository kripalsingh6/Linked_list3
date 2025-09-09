
public class linkedlist1 {
    static class Node {
    int data;
    Node next;
    public  Node(int data){
        this.data=data;
        this.next=null;
    }
        
    }
    public static Node head;
    public static Node tail;
    public static void zig_zag(){
        Node fast= head.next;
        Node slow= head;
        while (fast != null && fast.next !=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid= slow;
        //
        Node prev = null;
        Node curr = mid.next;
        mid.next=null;
        Node next;
        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;
        }
        Node right= prev;
        Node left= head;
        Node nextl, nextr;
        while (right !=null && left!=null) {
            nextl= left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;

            right=nextr;
            left=nextl;

        }
    }
    public static void printll(){
        Node temp= head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println();
    }
    public static void addlast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public static void main(String[] args) {
        linkedlist1 ll = new linkedlist1();
        ll.addlast(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        

        ll.printll();
        ll.zig_zag();
        ll.printll();


         
    }
    
}
