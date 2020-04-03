package com.java.algo;

import java.util.LinkedList;
import java.util.Stack;

/*
 * 스택/큐
 * LIFO, FIFO, push & pop!
 */
public class Algo200403 {
	public static void main(String[] args) {

		tower(); // 문제1
		
		printer(); // 문제2
		
		steelStick(); // 문제3
	}
	
	/*
	 * 문제1
	 * 타워
	 */
	public static void tower() {
		int[] heights = {6,9,5,7,4};
		int[] answers = new int[heights.length];

        for(int i = 0; i < heights.length; i++) {
            for(int j = i+1; j < heights.length; j++) {
                if(heights[i] > heights[j]) answers[j] = i+1;
            }
        }
        
        for(int answer : answers) {
        	System.out.println("문제1.타워 : " + answer);
        }
	}
	
	/*
	 * 문제2
	 * 프린터
	 */
	public static void printer() {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
        int answer = 0;
        
        LinkedList<Priority> linkedList = new LinkedList<Priority>();
        
        for (int i = 0; i < priorities.length; i++) {
            linkedList.add(new Priority(priorities[i], i));    
        }
        
        int idx = 0;
        while  (linkedList.size() > 0) {
            Priority poped = linkedList.pop();
            
            boolean sizeFlg = false;
            for (Priority left : linkedList) {
                if (poped.getValue() < left.getValue()) sizeFlg = true;
            }
            
            if (sizeFlg) {
                linkedList.addLast(poped);
            } else {
                idx++;
                if (poped.getLocation() == location) answer = idx;
            }
        }
        System.out.println("문제2.프린터 : " + answer);
	}
	
	/*
	 * 문제3
	 * 쇠막대기
	 */
	public static void steelStick() {
		String arrangement = "()(((()())(())()))(())";
		int answer = 0;
        int raser = 0;
        
        Stack<String> stack = new Stack<>();
        String[] splited = arrangement.replace("()", "*").split("");
        
        for(String sign : splited) {
            switch(sign) {
                case "(" :
                case "*" :
                    stack.push(sign);
                    break;
                case ")" :
                    String poped = stack.pop();
                    while("*".equals(poped)) {
                        raser++;
                        poped = stack.pop();
                    }
                    if("(".equals(poped)) {
                        answer += raser+1;
                        for(int i = 0; i < raser; i++) stack.push("*");
                        raser = 0;
                    }
                    break;
            }
        }
        System.out.println("문제3.쇠막대기 : " + answer);
	}
}

class Priority {
    private int value;
    private int location;
    
    public Priority(int value, int location) {
        this.value = value;
        this.location = location;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public int getLocation() {
        return this.location;
    }
}
