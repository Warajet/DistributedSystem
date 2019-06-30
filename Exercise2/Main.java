import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        try {

            System.out.println("Execise2 Task1");
            Car car = new Car("Red", 1000, 2000);
            Publication publication = new Publication("Warakorn J.", "Thai", 1000);
            Book bookie = new Book("Hello Germany", "English", 1000.00, "Warakorn Jetlohasiri", "1234-5678-9012");

            ArrayList<Display> display = new ArrayList<Display>();
            display.add(car);
            display.add(publication);
            display.add(bookie);

            FileOutputStream fs = new FileOutputStream("/Users/wara_1234/Desktop/SEYear3/Sem2/Software Design and Architecture/lect06/DistributedSystemExercise2/out/production/DistributedSystemExercise2/exercise_task2.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(display);
            os.close();


            System.out.println("Execise2 Task2");
            System.out.println("Read from .ser file");
            FileInputStream fin = new FileInputStream("/Users/wara_1234/Desktop/SEYear3/Sem2/Software Design and Architecture/lect06/DistributedSystemExercise2/out/production/DistributedSystemExercise2/exercise_task2.ser");
            ObjectInputStream is = new ObjectInputStream(fin);

            for (Display item: (ArrayList<Display>)is.readObject()) {
                item.print();
                System.out.println();
            }
            is.close();

            } catch (IOException e) {
            System.out.println(e);
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
