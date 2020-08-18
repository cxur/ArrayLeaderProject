package array.leader.main;

import java.util.Arrays;

import array.leader.process.Solution;

public class ArrayLeaderMain {

	public static void main(String[] args) {
		/** FIST SCENARIO **/
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 3;
		Integer M = 5;

		/** SECOND SCENARIO **/
//		Integer[] A = { 1, 2, 2, 1, 2 };
//		Integer K = 4;
//		Integer M = 2;
		
		/** THIRD SCENARIO NO LEADER NUMBERS**/
//		Integer[] A = { 1, 2, 3, 4, 5, 6, 7 };
//		Integer K = 3;
//		Integer M = 7;

		Solution solutionProcess = new Solution();

		System.out.println("Final Result " + 
		Arrays.toString(solutionProcess.solution(K, M, A)));

	}

}
