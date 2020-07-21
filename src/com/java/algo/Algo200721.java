package com.java.algo;

import java.util.Arrays;
import java.util.List;

public class Algo200721 {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(20, 40, 50, 30, 10);
		selectionSort(input);
	}
	
	/*
	 * 선택정렬 알고리즘
	 */
	public static void selectionSort(List<Integer> input) {
		int smallest = findSmallest(input);
		System.out.println(smallest);
	}
	
	/*
	 *  리스트 안의 가장 작은 수를 추출
	 */
	public static int findSmallest(List<Integer> input) {
		int smallest = input.get(0);
		int smallestIndex = 0;
		
		for(int i = 0; i < input.size(); i++) {
			if(input.get(i) < smallest) {
				smallest = input.get(i);
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
}
