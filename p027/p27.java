import java.util.concurrent.*;

public class p27 {
	private static final int THREADS = Runtime.getRuntime().availableProcessors();
	
	private static final BlockingQueue<Quadratic> queue = new LinkedBlockingQueue<Quadratic>(THREADS * 5);
	private static final ExecutorService pool = Executors.newCachedThreadPool();
	
	private static int maxNumberOfPrimes = 0;
	private static Quadratic maxPrimeFormula = new Quadratic(0, 0, 0);

	public static void main(String[] args) throws InterruptedException {
		setupThreads();
		for (int n = 0; n < 1000; ++n) {
			for (int a = -999; a < 1000; ++a) {
				for (int b = -999; b < 1000; ++b) {
					queue.put(new Quadratic(n, a, b));
				}
			}
		}
	}
	
	 private static final void setupThreads() {
	   System.out.println("Computing with " + THREADS + " threads...");
		for (int i = 0; i < THREADS; ++i) {
			pool.execute(new Runnable() {
				public void run() {
					try {
						while (true) {
							final Quadratic formula = queue.take();
							if (formula.isLast()) {
								System.out.println("Got to the last...");
								System.out.println(maxPrimeFormula.a + "  " + maxPrimeFormula.b);
								System.exit(0);
							} else {
								int numberOfConsePrimes = getNumberOfConsecutivePrimes(formula);
								checkAndSet(numberOfConsePrimes, formula);
							}
						}
					} catch (InterruptedException iex) {
						System.out.println(iex.toString());
					}
				}
			});
		
		}
	
	}
	
	private static final int getNumberOfConsecutivePrimes(Quadratic formula) {
		int numberOfPrimes = 0;
		for (int n = formula.n; n < 1000; ++n) {
			if (isPrime(n*n + formula.a*n + formula.b)) {
				++numberOfPrimes;
			} else {
				break;
			}
		}
		return numberOfPrimes;
	}
	
	private static final boolean isPrime(int number) {
		if (number <= 1) return false;
		
		int limit = (int)Math.floor(Math.sqrt(number));
		for (int i = 2; i <= limit; ++i) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static final synchronized void checkAndSet(int numberOfPrimes, Quadratic formula) {
		if (numberOfPrimes > maxNumberOfPrimes) {
			maxNumberOfPrimes = numberOfPrimes;
			maxPrimeFormula = formula;
			System.out.println("Formula " + formula + ": " + numberOfPrimes + " primes!");
		}
	}
	
	
	private static class Quadratic  {
		int n;
		int a;
		int b;
		public Quadratic(int n, int a, int b) {
			this.n = n;
			this.a = a;
			this.b = b;
		}
		
		public boolean isLast() {
			return n == 999 && a == 999 && b == 999;
		}
		
		@Override
		public String toString() {
			return "n^2 + " + a + "n + " + b;
		}
	}
	
	
}