import java.util.Iterator;
import java.util.Random;

public class Main {

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
