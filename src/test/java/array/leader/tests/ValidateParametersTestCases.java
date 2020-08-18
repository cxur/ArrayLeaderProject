package array.leader.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import array.leader.process.Solution;

public class ValidateParametersTestCases {

	@Test
	public void validateParametersSuccessTest() {
		Integer[] B = { 1, 2, 2, 1, 2 };
		Integer K = 4;
		Integer M = 2;
		Solution solutionProcessTest = new Solution();
		boolean validateParameterResult = solutionProcessTest.validateParameters(K, M, B);
		assertEquals(true, validateParameterResult);
	}

	/**
	 * According to the provided documentation An invalid array could be when on of
	 * the elements of the array is bigger than the variable M
	 */
	@Test
	public void InvalidArrayRuntimeExceptionTest() {
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 4;
		Integer M = 2;
		Solution solutionProcessTest = new Solution();
		String ErrorMessage = "The array contains invalid elements";
		try {
			solutionProcessTest.validateParameters(K, M, A);
		} catch (RuntimeException e) {
			assertEquals(ErrorMessage, e.getMessage());
		}
		
	}

	/**
	 * According to the provided documentation An the parameter M must be between 1
	 * and 100,000
	 */
	@Test
	public void M_ParameterRuntimeExceptionTest() {
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 4;
		Integer M = 0;
		String ErrorMessage = "The value of M must be between 1 and 100,000";
		Solution solutionProcessTest = new Solution();
		try {
			solutionProcessTest.validateParameters(K, M, A);
		} catch (RuntimeException e) {
			assertEquals(ErrorMessage, e.getMessage());
		}

	}

	/**
	 * According to the provided documentation An the parameter K is between 1 and
	 * array.length
	 */
	@Test
	public void K_ParameterRuntimeExceptionTest() {
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 8;
		Integer M = 3;
		String ErrorMessage = "The value of K can't be bigger or smaller than the array";
		Solution solutionProcessTest = new Solution();
		try {
			solutionProcessTest.validateParameters(K, M, A);
		} catch (RuntimeException e) {
			assertEquals(ErrorMessage, e.getMessage());
		}

	}

	@Test
	public void ArrayLengthRuntimeExceptionTest() {
		Integer[] A = {  };
		Integer K = 4;
		Integer M = 3;
		String ErrorMessage = "The length of the array must be between 1 and 100,000";
		Solution solutionProcessTest = new Solution();
		try {
			solutionProcessTest.validateParameters(K, M, A);
		} catch (RuntimeException e) {
			assertEquals(ErrorMessage, e.getMessage());
		}

	}

}
