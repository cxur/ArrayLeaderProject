package array.leader.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.math3.util.CombinatoricsUtils;

public class Solution {
	public Solution() {
	}

	public Integer[] solution(Integer K, Integer M, Integer[] A) {
		Set<Integer> setLeadNumber = new TreeSet<Integer>();
		
		if (validateParameters(K, M, A)) {
			List<int[]> segments = generateSegments(K, A);
			System.out.println("Changes will be applied to the following segments\n");

			segments.forEach(action -> System.out.println(Arrays.toString(action) + "\n"));

			for (int[] segment : segments) {
				Integer[] clonedArrayA = A.clone();
				for (int segmentKey : segment) {
					if (clonedArrayA[segmentKey] < M)
						clonedArrayA[segmentKey] = clonedArrayA[segmentKey] + 1;
				}

				System.out.println("Edited Array\n");
				System.out.println(Arrays.toString(clonedArrayA) + "\n");
				Stream.of(clonedArrayA).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream().filter(predicate -> predicate.getValue() >= (clonedArrayA.length / 2))
						.forEach(action -> setLeadNumber.add(action.getKey()));
			}
		}

		Integer[] leadNumbers = new Integer[setLeadNumber.size()];
		setLeadNumber.toArray(leadNumbers);
		return leadNumbers;

	}

	public boolean validateParameters(Integer K, Integer M, Integer[] A) {

		Predicate<Integer> isWithinRange = value -> (value <= 100000 && value >= 1);
		Predicate<Integer> isArrayElementValid = value -> (value <= M && value >= 1);
		Predicate<Integer> isKparameterValid = value -> (value <= A.length && value >= 1);

		if (M == null || !isWithinRange.test(M))
			throw new RuntimeException("The value of M must be between 1 and 100,000");
		if (A == null || !isWithinRange.test(A.length))
			throw new RuntimeException("The length of the array must be between 1 and 100,000");
		if (K == null || !isKparameterValid.test(K))
			throw new RuntimeException("The value of K can't be bigger or smaller than the array");
		for (Integer arrayElement : A) {
			if (!isArrayElementValid.test(arrayElement))
				throw new RuntimeException("The array contains invalid elements");
		}

		return true;
	}

	public List<int[]> generateSegments(Integer K, Integer[] A) {

		Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(A.length, K);
		int count = 0;
		List<int[]> segments = new ArrayList<int[]>();
		while (iterator.hasNext()) {
			int[] combination = iterator.next();
			if (combination[0] == count) {
				segments.add(combination);
				count++;
			}
		}

		return segments;
	}
}
