package ua.lviv.desctop.min;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		MyThread m = new MyThread("myThread", 1000);
		m.start();
		MyRunnable myRunnable = new MyRunnable("myRunnable", 1000);
	}

}

class MyThread extends Thread {

	private String name;
	private int delay;

	public MyThread(String name, int delay) {
		super();
		this.name = name;
		this.delay = delay;

	}

	@Override
	public void run() {
		System.out.println("Please enter count of fibonacchi numbers: ");
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();
		int n0 = 1;
		int n1 = 1;
		int n2;
		System.out.print(n0 + " " + n1 + " ");
		for (int i = 3; i <= z; i++) {
			n2 = n0 + n1;
			System.out.print(n2 + " ");
			n0 = n1;
			n1 = n2;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}
}

class MyRunnable implements Runnable {

	private String name;
	private int delay;
	private Thread thread;

	public MyRunnable(String name, int delay) {
		super();
		this.name = name;
		this.delay = delay;
		this.thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Please enter count of fibonacchi numbers: ");
		Scanner sc = new Scanner(System.in);
		int z = sc.nextInt();

		int a[] = new int[z];
		a[0] = 1;
		a[1] = 1;

		for (int i = 2; i < z; i++) {

			a[i] = a[i - 2] + a[i - 1];
		}

		for (int i = z - 1; i >= 0; i--) {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(a[i] + " ");

		}
		System.out.println();

	}

}
