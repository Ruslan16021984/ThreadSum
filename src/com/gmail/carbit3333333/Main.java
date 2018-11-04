package com.gmail.carbit3333333;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		long time;
		Random rand = new Random();
		int[] array = new int[200_000];
		int[] arrayPart1 = new int[100_000];
		int[] arrayPart2 = new int[100_000];

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(11);
		}
		time = System.currentTimeMillis();
		System.out.println("Main thread sum is :" + calculateSum(array));
		System.out.println("Main thread time is: " + (time = System.currentTimeMillis() - time) + "\n");

		System.arraycopy(array, 0, arrayPart1, 0, 100_000);
		System.arraycopy(array, 100_000, arrayPart2, 0, 100_000);

		ThreadSum sumOne = new ThreadSum(arrayPart1);
		ThreadSum sumTwo = new ThreadSum(arrayPart2);
		Thread thrOne = new Thread(sumOne);
		Thread thrTwo = new Thread(sumTwo);
		thrOne.start();
		thrTwo.start();

		time = System.currentTimeMillis();

		try {
			thrOne.join();
			thrTwo.join();

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Threads sum is : " + (sumOne.getSum() + sumTwo.getSum()));
		System.out.println("Threads is time: " + (time = System.currentTimeMillis() - time) + "\n");
	}

	public static int calculateSum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;

	}

}
