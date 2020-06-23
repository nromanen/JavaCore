import java.util.Random;
//Run three threads and output there different messages for 5 times. The third thread supposed to start after finishing working of the two previous threads.

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();
        Thread thread1 = new Thread(message::printMessage);
        Thread thread2 = new Thread(message::printMessage);
        Thread thread3 = new Thread(message::printMessage);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}

class Message {
    private final Random random = new Random();
    private final String[] list = {"Devid", "Mickel", "Bonny", "Emi", "Stuart"};

    public void printMessage() {
        for (int i = 0; i < 5; i++) {
            System.out.println("This is massage of " + list[random.nextInt(list.length)] + " in " + Thread.currentThread().getName());
        }

    }
}