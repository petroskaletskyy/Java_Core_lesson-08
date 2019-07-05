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
				System.out.println("������ �����: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (!flag) {
					System.out.println("������ ����� �� ����...");
				}
				break;
			}
			case "2": {
				System.out.println("������ ���� ����:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isMonthSeasonPresent(masMonths, season);

				if (!flag) {
					System.out.println("���� ���� ���� �� ����...");
				}
				break;
			}
			case "3": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysPreset(masMonths, days);

				if (!flag) {
					System.out.println("�� ���� ������ ���...");
				}
				break;
			}
			case "4": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysLess(masMonths, days);

				if (!flag) {
					System.out.println("� ����, ������, � ���� ����� ���, �� ������� ����� - �� ����");
				}
				break;
			}
			case "5": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysOver(masMonths, days);

				if (!flag) {
					System.out.println("� ����, ������, � ���� ����� ���, �� ������� ����� - �� ����");
				}
				break;
			}
			case "6": {
				System.out.println("������ ���� ����:");
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
					System.out.println("���� ���� ���� �� ����");
				}
				break;
			}
			case "7": {
				System.out.println("������ ���� ����:");
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
					System.out.println("���� ���� ���� �� ����");
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
				System.out.println("������ �����: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (flag) {
					for (Month m : masMonths) {
						if (m.name().equals(month)) {
							if (m.getDay() % 2 == 0) {
								System.out.println("̳���� �� ����� ������� ���");
							} else {
								System.out.println("̳���� �� ������� ������� ���");
							}
						}
					}
				}

				if (!flag) {
					System.out.println("������ ����� �� ����...");
				}
				break;
			}
			}
		}

	}

//	
//�������� �� �����, �� ����� ������� ������� ���	
//	
	private static void allMonthOddDays(Month[] masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 != 0) {
				System.out.println(m.name());
			}
		}
	}

//	
//�������� �� �����, �� ����� ����� ������� ���	
//	
	private static void allMonthEvenDays(Month[] masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 == 0) {
				System.out.println(m.name());
			}
		}
	}

//
//��������, �� ���� ������� ���� ����	
//	
	private static boolean isSeasonPresent(Seasons[] masSeasons, String season) {
		boolean flag = false;
		for (Seasons s : masSeasons) {
			if (s.name().equals(season)) {
				System.out.println("���� ���� ���� ����");
				flag = true;
			}
		}
		return flag;
	}

//
//��������, �� ������� �����, � ������ ������� ���, �� ������� �����
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
//��������, �� ������� �����, � ������ ������� ���, �� ������� �����
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
//��������, �� ������� ����� � �������� ������� ���
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
//��������, �� ������� ����� � �������� ����� ����
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
//��������, �� ���� �������� �����
//	
	private static boolean isMonthPresent(Month[] masMonths, String month) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.name().equals(month)) {
				System.out.println("����� ����� ����");
				flag = true;
			}
		}
		return flag;
	}

	static void menu() {
		System.out.println("�������� 1, ��� ��������� �� ���� �����:");
		System.out.println("�������� 2, ��� ������� �� ����� � ����� ����� ����:");
		System.out.println("�������� 3, ��� ������� �� ����� � �������� ������� ���:");
		System.out.println("�������� 4, ��� ������� �� ����� � ������ ������� ���:");
		System.out.println("�������� 5, ��� ������� �� ����� � ������ ������� ���:");
		System.out.println("�������� 6, ��� ������� �������� ���� ����:");
		System.out.println("�������� 7, ��� ������� ��������� ���� ����:");
		System.out.println("�������� 8, ��� ������� �� �����, �� ����� ����� ������� ���");
		System.out.println("�������� 9, ��� ������� �� �����, �� ����� ������� ������� ���");
		System.out.println("�������� 10, ��� ���������, �� �� ����� ����� ������� ���");
	}

}
