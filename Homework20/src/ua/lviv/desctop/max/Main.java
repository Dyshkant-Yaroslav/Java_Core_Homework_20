package ua.lviv.desctop.max;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executable = Executors.newFixedThreadPool(20);
		executable.execute(new Runnable() {

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
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();

			}
		});

		executable.shutdown();

	}

}
