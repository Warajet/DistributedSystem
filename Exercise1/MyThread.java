import java.util.Scanner;

public class MyThread extends java.lang.Thread {
    private int number;
    public MyThread(int number)
    {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Thread number: " + this.number);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread number " + this.number + " has been terminated" );
    }
}

class MySecondClass
{
    public void run()
    {
        int num = 0;
        while(true)
        {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            MyThread my_thread = new MyThread(num);
            num++;
            my_thread.start();

        }

    }
}
