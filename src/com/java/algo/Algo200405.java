package com.java.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 정렬
 */
public class Algo200405 {
	public static void main(String[] args) {
		kIndexNumber(); // 문제1
	}
	
	public static void kIndexNumber() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answers = {};
        List<Integer> answerList = new ArrayList<Integer>();

        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int targetIdx = command[2];
            
            List<Integer> splited = new ArrayList<Integer>();
            for(int i = start-1; i < end; i++) {
                splited.add(array[i]);
            }
            Collections.sort(splited);
            answerList.add(splited.get(targetIdx-1));
        }
        
        answers = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answers[i] = answerList.get(i);
        }
        
        for(int answer : answers) {
        	System.out.println("문제1.K번째 수 : " + answer);
        }
	}
}
