package com.algorithm;

import java.util.Scanner;

public class EightPlus {
	static long a = 2, b = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 0;
		long sum = 0;
		while (i < n) {
			b = b + a;
			sum = sum + b;
			a = a * 10;
			++i;
		}
		System.out.println("input number: " + n);
		System.out.println(sum);
	}
}