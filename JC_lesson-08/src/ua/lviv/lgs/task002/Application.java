package ua.lviv.lgs.task002;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		isNumberEven();

	}

	public static void isNumberEven() {

		System.out.println("Enter integer number");

		Scanner scanner = new Scanner(System.in);
		double number = scanner.nextDouble();

		if (number % 1 == 0) {
			if (number % 2 == 0) {
				System.out.println("The entered number is even");
			} else {
				System.out.println("The entered number is odd");
			}
		} else {
			System.out.println("Error! The entered number is not an integer!");
		}

	}

}
