import java.util.*;

public class Driver {

	static int TRIALS = 500;

	public static void main(String[] args) {
		System.out.println("Size\t\tPerformance");

		long stime, qtime, btime;
		float ratio_sum = 0;

		for (int size = 31250; size < 1000001; size <<= 1) {
			qtime = btime = 0;

			for (int t = 0; t < TRIALS; t++) {

				int[] data1 = new int[size];
				int[] data2 = new int[size];

				for(int i = 0; i < data1.length; i++){
					data2[i] = data1[i] = (int)(Math.random()*Integer.MAX_VALUE);
				}

				stime = System.currentTimeMillis();
				Merge.mergesort(data2);
				qtime += System.currentTimeMillis()-stime;

				stime = System.currentTimeMillis();
				Arrays.sort(data1);
				btime += System.currentTimeMillis()-stime;

				if (!Arrays.equals(data1, data2)) {
					System.out.println("FAIL TO SORT!");
					System.exit(0);
				}
			}
			ratio_sum += 1.0*qtime/btime;
			System.out.printf("%d\t\t%.3f\n", size, 1.0*qtime/btime);
		}
		System.out.printf("\nAverage\t\t%.3f\n", ratio_sum/6);
	}
}
