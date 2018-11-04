package com.gmail.carbit3333333;

public class ThreadSum implements Runnable {
	private int sum;
    private int[] arrayPart;


	public ThreadSum(int[] array) {
		super();
		
		this.arrayPart = array;


	}



    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        this.sum = Main.calculateSum(arrayPart);
    }

}
