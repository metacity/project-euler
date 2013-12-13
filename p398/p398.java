import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class p398 {

	private static final int ROPE_LENGTH = 10000000;
	private static final int CUT_POINTS = 100;
	private static final int TOTAL_ITERATIONS = 50000;

	private static final AtomicLong secondShortestLength = new AtomicLong();
	private static final AtomicLong completedIterations = new AtomicLong();
	private static final List<Thread> threads = new ArrayList<Thread>();

	
	public static void main(String[] args) {
		setupThreads();
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException iex) { }
			
		}
		
		System.out.println(String.valueOf(1.0 * secondShortestLength.get() / completedIterations.get()));
	}
	
	private static final void setupThreads() {
		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("Running with " + numberOfThreads + " threads...");
		for (int i = 0; i < numberOfThreads; ++i) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					final BitSet rope = new BitSet(ROPE_LENGTH);
					final ArrayList<Integer> cutLengths = new ArrayList<Integer>();
					while (completedIterations.incrementAndGet() < TOTAL_ITERATIONS) {
						for (int j = 0; j < CUT_POINTS; ++j) {
							final int cutPoint = (int)(Math.random() * (ROPE_LENGTH-1)) + 1;
							//System.out.println(cutPoint + "");
							if (rope.get(cutPoint))
								--j;
							else
								rope.set(cutPoint);
						}
						secondShortestLength.getAndAdd(findSecondShortest(rope, cutLengths));
						//System.out.println(secondShortestLength + "");
						rope.clear();
						cutLengths.clear();
					}
				}
			});
			threads.add(thread);
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
	
	private static final int findSecondShortest(final BitSet rope, final ArrayList<Integer> cutLengths) {
		int shortest = rope.size();
		int prevCut = 0;
		for (int i = 0; i <= ROPE_LENGTH; ++i) {
			if (i == ROPE_LENGTH || rope.get(i)) {
				int length = i - prevCut;
				cutLengths.add(length);
				prevCut = i;
				if (length < shortest)
					shortest = length;
					
				//System.out.println(shortest + "");
			}
		}

		final int lengthsLen = cutLengths.size();
		int secondShortest = ROPE_LENGTH;
		for (int i = 0; i < lengthsLen; ++i) {
			int length = cutLengths.get(i);
			if (length >= shortest && length <= secondShortest) {
				secondShortest = length;
			}
		}
		return secondShortest;
	}
	
}
