package Lab2;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoJobsAtomicInteger implements Runnable {

    private static final int N = 10;
    private int id;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public TwoJobsAtomicInteger(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        firstJob();
        while (true){
            if (atomicInteger.getAndIncrement() <= N) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
            else break;
        }

        secondJob();
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            new Thread(new TwoJobsAtomicInteger(i)).start();
        }
    }

    public void firstJob() {
        System.out.println("Thread " + id + ", first job done");
    }

    public void secondJob() {
        System.out.println("Thread " + id + ", second job done");
    }
}