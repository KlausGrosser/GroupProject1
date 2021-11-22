package com.dci.mcomm.utils;

import java.util.Scanner;

public class Utils {

	private static final Scanner scanner = new Scanner(System.in);


	public static boolean confirm(String message) {
		System.out.println(message);
		String answer = scanner.nextLine();
		return answer.toLowerCase().startsWith("y");
	}

	public static void clear(Scanner scanner) {
	}
}
