package array.leader.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import array.leader.process.Solution;

public class GenerateSegmentsTestCases {
	
	
	@Test
	public void generateSegmentsSuccessTest() {
		Integer[] A = { 2, 1, 3, 1, 2, 2, 3 };
		Integer K = 4;
		int[] expectedSegment1 = {0, 1, 2, 3};
		int[] expectedSegment2 = {1, 2, 3, 4};
		int[] expectedSegment3 = {2, 3, 4, 5};
		int[] expectedSegment4 = {3, 4, 5, 6};
		
		Solution solutionProcessTest = new Solution();
		List<int[]> segments = solutionProcessTest.generateSegments(K, A);
		
			assertArrayEquals(expectedSegment1, segments.get(0));
			assertArrayEquals(expectedSegment2, segments.get(1));
			assertArrayEquals(expectedSegment3, segments.get(2));
			assertArrayEquals(expectedSegment4, segments.get(3));
		
		
	}
}
