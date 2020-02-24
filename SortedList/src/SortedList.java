import java.util.Iterator;
import java.util.Random;


public class SortedList<E extends Comparable<? super E>> extends List<E> {
    public void insert(E data) {
        insert(null, head, data);
    }
    public void remove(E data) {
        remove(data, head);
    }
    public E retrieve(int index) {

        return retrieve(index, head);
    }
    public boolean search(E data) {
        return search(data,head);
    }

        private void insert(Node<E> prev, Node<E> curr, E data){
        Node<E> temp = new Node<E>(data);
        if(prev == null && curr==null) {
            head = temp;
        }
        else if(prev == null && curr.data.compareTo(data)>= 0){
            temp.next = head;
            head = temp;
        }
        else if(curr == null && prev.data.compareTo(data) <= 0){
            prev.next = temp;
        }
        else if(prev != null && curr != null && prev.data.compareTo(data)<= 0 && curr.data.compareTo(data) > 0){
            prev.next = temp;
            temp.next = curr;
        }
        else insert(curr, curr.next, data);
    }

    private void remove(E data, Node<E> curr){
        if(curr==null){
            return;
        }
        else if(curr.next == null){
            if(curr.data.compareTo(data) == 0) {
                head = null;
                return;

            }
        }

        else if(curr.next.data.compareTo(data) == 0){
            curr.next = curr.next.next;
        }
       else{
            remove(data, curr.next);
        }
    }



    public E retrieve(int index, Node<E> curr){
        if (curr == null){
            return null;
        }
        else{
            if(index==0){
                return curr.data;
            }
            else {
                return retrieve(index-1, curr.next);
            }
        }
    }
    public boolean search(E data, Node<E> curr){
     if (curr == null){
         return false;
     }
     else if(curr.data == data){
         return true;
     }
     else {
         return search(data, curr.next);
     }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            private Node<E> curr = head;
        };
    }

    public static void main(String[] args) {
        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 10;
        long start, stop;

        System.out.println("insert");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            list.insert(rand.nextInt(num));
            System.out.print(i + ": ");
            for (int j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        //rand = new Random(1);
        System.out.println("remove");

        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(num);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        stop = System.currentTimeMillis();

        System.out.println(stop-start);


        int j;
        for (int i = 0; list.retrieve(i) != null; ++i) {
            System.out.println((j = list.retrieve(i)) + " => " + list.search(j));
        }

        for (int i = 0; i < num; ++i) {
            System.out.println(i + " => " + list.search(i));
        }
    }
}