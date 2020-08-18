package array.leader.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import array.leader.process.Solution;

public class SolutionTestCases {
	
	@Test
	public void solutionExpectedResultScenario1OnSucess() {
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 3;
		Integer M = 5;
		Integer[] expectedSolution = {2,3};
		Solution solutionProcessTest = new Solution();
		Integer[] solution = solutionProcessTest.solution(K, M, A);
		
		assertArrayEquals(expectedSolution, solution);
	}
	
	@Test
	public void solutionExpectedResultScenario2OnSucess() {
		Integer[] B = { 1, 2, 2, 1, 2 };
		Integer K = 4;
		Integer M = 2;
		Integer[] expectedSolution = {2};
		Solution solutionProcessTest = new Solution();
		Integer[] solution = solutionProcessTest.solution(K, M, B);
		
		assertArrayEquals(expectedSolution, solution);
	}

}
