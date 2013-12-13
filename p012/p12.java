import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class p12 {

    private static final int THREADS = Runtime.getRuntime().availableProcessors();

    private static final BlockingQueue<Long> queue = new ArrayBlockingQueue<Long>(THREADS * 2);
    private static final ExecutorService pool = Executors.newCachedThreadPool();
    private static final AtomicBoolean foundIt = new AtomicBoolean(false);
    
    private static final int LIMIT = 500;
	
	private static long start;

    public static void main(String[] args) throws InterruptedException {
        setupThreads();

		start = System.nanoTime();
        long i = 0;
        long prev = 0;
        while (!foundIt.get()) {
            long number = prev + (++i);
            queue.put(number);
            prev = number;
        }
    }
    
    private static final void setupThreads() {
       System.out.println("Computing with " + THREADS + " threads...");
        for (int i = 0; i < THREADS; ++i) {
            pool.execute(new Runnable() {
                public void run() {
                    try {
                        while (!foundIt.get()) {
                            Long number = queue.take();
                            if (numberOfDivisors(number) > LIMIT) {
                                foundIt.set(true);
                                System.out.println(number);
								System.out.println((System.nanoTime() - start)/(double)1E6 + " milliseconds");
                                System.exit(0);
                            }
                        }
                    } catch (InterruptedException iex) {
                        System.out.println(iex.toString());
                    }
                }
            });
        
        }
    
    }
    
    private static final int numberOfDivisors(long number) {
        int divisors = 2;
        for (long i = number - 1; i > 1; --i) {
            if (number % i == 0) ++divisors;
        }
        return divisors;
    }
}

