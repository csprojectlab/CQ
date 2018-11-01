package dynamic;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Given certain jobs and start time and end time with profit you make when you finish the job, what is the maximum
 * profit you can make.   Don't overlap jobs
 */

class Job {
	int startTime;
	int endTime;
	int profit;
	public Job(int s, int e, int p) {
		this.startTime = s;
		this.endTime = e;
		this.profit = p;
	}
	
	public String toString() {
		return "([" + this.startTime + ", " + this.endTime + "]: " + this.profit +")";
	}
}
public class JobSchedulingProblem {

	public int scheduleJobs(int[] startTime, int[] endTime, int[] profit) {
		// Sort the jobs according to their end time.
		List<Job> jobs = new LinkedList<>();
		for(int i = 0; i < profit.length; i++)
			jobs.add(new Job(startTime[i], endTime[i], profit[i]));
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job first, Job second) {
				if(first.endTime < second.endTime)
					return -1;
				else if(first.endTime > second.endTime)
					return 1;
				return 0;
			}
			
		});
		System.out.println("Sort jobs by endTime: " + jobs);
		Job[] jobArray = new Job[jobs.size()];
		
		jobs.toArray(jobArray);  // sorted jobs in the arrray.
		
		int[] k = new int[jobArray.length];
		for(int i = 0; i < k.length; i++)
			k[i] = profit[i];    //  Storing the profit if the job is done alone.
		
		for(int i = 1; i < jobArray.length; i++) {
			for(int j = 0; j < i; j++) {
				// Non overlapping jobs.
				if(jobArray[i].startTime >= jobArray[j].endTime) {
					// If don't consider the job, consider the job
					k[i] = Math.max(k[i], profit[i] + k[j]);
				}
			}
		}
		// Find the max from this array.
		util.Util.print(k);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < k.length; i++)
			if(k[i] > max)
				max = k[i];
		System.out.println("Maximum profit: " + max);
		return max;
	}
	
	public static void main(String[] args) {
		int[] startTime = new int[] {1,2,7,6,5,4};
		int[] endTime = new int[] {3,5,9,7,8,6};
		int[] profit = new int[] {5,6,2,4,11,5};
		
		JobSchedulingProblem j = new JobSchedulingProblem();
		j.scheduleJobs(startTime, endTime, profit);
	}
	
}
