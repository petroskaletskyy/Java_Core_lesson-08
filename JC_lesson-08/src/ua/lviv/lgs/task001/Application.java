package ua.lviv.lgs.task001;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Month[] masMonths = Month.values();
		Seasons[] masSeasons = Seasons.values();
		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (!flag) {
					System.out.println("Такого місяця не існує...");
				}
				break;
			}
			case "2": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isMonthSeasonPresent(masMonths, season);

				if (!flag) {
					System.out.println("Такої пори року не існує...");
				}
				break;
			}
			case "3": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysPreset(masMonths, days);

				if (!flag) {
					System.out.println("Не вірно введені дані...");
				}
				break;
			}
			case "4": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysLess(masMonths, days);

				if (!flag) {
					System.out.println("Н жаль, місяців, в яких менше днів, ніж введене число - не існує");
				}
				break;
			}
			case "5": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysOver(masMonths, days);

				if (!flag) {
					System.out.println("Н жаль, місяців, в яких більше днів, ніж введене число - не існує");
				}
				break;
			}
			case "6": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(masSeasons, season);

				if (flag) {
					Seasons season2 = Seasons.valueOf(season);
					int ordinal = season2.ordinal();

					if (ordinal == (masSeasons.length - 1)) {
						ordinal = 0;
						System.out.println(masSeasons[ordinal]);
					} else {
						System.out.println(masSeasons[ordinal + 1]);
					}
				}

				if (!flag) {
					System.out.println("Такої пори року не існує");
				}
				break;
			}
			case "7": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(masSeasons, season);

				if (flag) {
					Seasons season2 = Seasons.valueOf(season);
					int ordinal = season2.ordinal();

					if (ordinal == 0) {
						ordinal = (masSeasons.length - 1);
						System.out.println(masSeasons[ordinal]);
					} else {
						System.out.println(masSeasons[ordinal - 1]);
					}
				}

				if (!flag) {
					System.out.println("Такої пори року не існує");
				}
				break;
			}
			case "8": {
				allMonthEvenDays(masMonths);
				break;
			}
			case "9": {
				allMonthOddDays(masMonths);
				break;
			}
			case "10": {
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (flag) {
					for (Month m : masMonths) {
						if (m.name().equals(month)) {
							if (m.getDay() % 2 == 0) {
								System.out.println("Місяць має парну кількість днів");
							} else {
								System.out.println("Місяць має непарну кількість днів");
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Такого місяця не існує...");
				}
				break;
			}
			}
		}

	}

//	
//Виводить всі місяці, які мають непарну кількість днів	
//	
	private static void allMonthOddDays(Month[] masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 != 0) {
				System.out.println(m.name());
			}
		}
	}

//	
//Виводить всі місяці, які мають парну кількість днів	
//	
	private static void allMonthEvenDays(Month[] masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 == 0) {
				System.out.println(m.name());
			}
		}
	}

//
//Перевірка, чи існує введена пора року	
//	
	private static boolean isSeasonPresent(Seasons[] masSeasons, String season) {
		boolean flag = false;
		for (Seasons s : masSeasons) {
			if (s.name().equals(season)) {
				System.out.println("Така пора року існує");
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці, з більшою кількістю днів, ніж введене число
//	
	private static boolean isDaysOver(Month[] masMonths, int days) {
		boolean flag = false;
		for (Month m : masMonths) {
			if (m.getDay() > days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці, з меншою кількістю днів, ніж введене число
//	
	private static boolean isDaysLess(Month[] masMonths, int days) {
		boolean flag = false;
		for (Month m : masMonths) {
			if (m.getDay() < days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//	
//Перевірка, чи існують місяці з введеною кількість днів
//
	private static boolean isDaysPreset(Month[] masMonths, int days) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.getDay() == days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці з введеною порою року
//	
	private static boolean isMonthSeasonPresent(Month[] masMonths, String season) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.getSeasons().name().equals(season)) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існує введений місяць
//	
	private static boolean isMonthPresent(Month[] masMonths, String month) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.name().equals(month)) {
				System.out.println("Такий місяць існує");
				flag = true;
			}
		}
		return flag;
	}

	static void menu() {
		System.out.println("Натисніть 1, щоб перевірити чи існує місяць:");
		System.out.println("Натисніть 2, щоб вивести всі місяці з такою порою року:");
		System.out.println("Натисніть 3, щоб вивести всі місяці з введеною кількістю днів:");
		System.out.println("Натисніть 4, щоб вивести всі місяці з меншою кількістю днів:");
		System.out.println("Натисніть 5, щоб вивести всі місяці з більшою кількістю днів:");
		System.out.println("Натисніть 6, щоб вивести наступну пору року:");
		System.out.println("Натисніть 7, щоб вивести попередню пору року:");
		System.out.println("Натисніть 8, щоб вивести всі місяці, які мають парну кількість днів");
		System.out.println("Натисніть 9, щоб вивести всі місяці, які мають непарну кількість днів");
		System.out.println("Натисніть 10, щоб перевірити, чи має місяць парну кількість днів");
	}

}
