package Lab2;

import java.util.concurrent.locks.ReentrantLock;

public class InterferenceCheckerWithLock implements Runnable {
    public static int shared;
    public int id;
    static ReentrantLock reentrantLock = new ReentrantLock();

    InterferenceCheckerWithLock(int id) {
        this.id = id;
    }

    static final int REPETITIONS = 1000 * 1000;

    public void run() throws RuntimeException {
        int i = 0;


        while (i < REPETITIONS) {
            reentrantLock.lock();
            try{
                shared = id;
                if (shared != id) {
                    break;
                }
                i++;
            }
            catch(Exception e){
                e.getMessage();
            }
            finally {
                reentrantLock.unlock();
            }
        }

        System.out.printf("Thread %d: i=%d%n", id, i);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterferenceCheckerWithLock(1));
        Thread t2 = new Thread(new InterferenceCheckerWithLock(2));
        t1.start();
        t2.start();
    }
}