package ua.lviv.lgs.task003;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		System.out.println("Enter first integer number:");

		Scanner sc1 = new Scanner(System.in);
		double n1 = sc1.nextDouble();

		if (n1 % 1 != 0) {
			System.out.println("First mumber is not integer!");
		} else {
			System.out.println("Enter second integer number:");

			Scanner sc2 = new Scanner(System.in);
			double n2 = sc2.nextDouble();

			if (n2 % 1 != 0) {
				System.out.println("Second number is not integer");
			} else {

				System.out.println("Sum of two integer number - " + (int)(n1 + n2));
			}
		}
	}

}
