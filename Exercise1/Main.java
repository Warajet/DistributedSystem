import java.lang.Math;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static int factorial(int n)
    {
        if(n < 0)
        {
            n = Math.abs(n);
        }

        if(n == 0)
        {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    public static void remove_duplicates(String inp)
    {
        String[] word_list = inp.split(" ");

        HashSet<String> removed_duplicated_string = new HashSet<String>();
        for(int i = 0; i < word_list.length ; i++)
        {
            removed_duplicated_string.add(word_list[i]);
        }

        Iterator i = removed_duplicated_string.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
    public static void main(String[] args) {
        //Java exercise 1
        //int n = 3;
        //int result = factorial(n);
        //System.out.println("The factorial val of " + n + " is " + result);

        //Java Exercise 2
//        ArrayList<Publication> publication_list = new ArrayList<>();
//
//        //System.out.println("Publication");
//        Publication publication = new Publication("Warakorn Jetlohasiri", "Thai", 10000.00);
//        //System.out.println(publication.toString());
//
//        //System.out.println("Book");
//        Book bookie = new Book("Hello Germany" , "English", 1000.00 ,"Warakorn Jetlohasiri", "1234-5678-9012" );
//        //System.out.println(bookie.toString());
//
//        publication_list.add(publication);
//        publication_list.add(bookie);
//
//        Iterator i = publication_list.iterator();
//        System.out.println("The ArrayList elements are:");
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }




        //Java Exercise 3
//        System.out.println("Exercise3");
//        Scanner scanner = new Scanner(System.in);
//        String user_input = scanner.nextLine();
//        remove_duplicates(user_input);

        //Java Exercise 4
        System.out.println("Exercise4");

        MySecondClass my_second_class = new MySecondClass();
        my_second_class.run();



    }
}
