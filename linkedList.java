public class linkedList{
    public static Node head;
    public static Node tail;
   static class Node {
        int data;
        Node next;
        public  Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static  boolean iscycle(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void remove_cycle(){
        //detect 
         Node fast = head;
        Node slow = head;
        boolean cycle=false;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        // find meeting point 
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev=fast;
            slow= slow.next;
            fast=fast.next;
        }
        // remove cycle 
        prev.next=null;
    }
    public void print(int data){
        Node temp=head;
        while(temp != null){
            System.out.print(temp+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        head = new Node(1);
        Node temp = new Node(2);
        head.next= temp;
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next=temp;
        System.out.println(iscycle());
        remove_cycle();
        System.out.println(iscycle());



    }
}