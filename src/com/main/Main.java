package com.main;

import java.util.Scanner;
import com.model.DictionaryManagement;

public class Main {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			DictionaryManagement dictionaryManagement = new DictionaryManagement(scanner);
			dictionaryManagement.insertFromFile();
			do {
				System.out.println("-------------Dictionary-------------");
				System.out.println("1.Add new word");
				System.out.println("2.Edit word");
				System.out.println("3.Delete word");
				System.out.println("4.Export to file");
				System.out.println("5.Import from file");
				System.out.println("6.Lookup commandline");
				System.out.println("7.Search");
				System.out.println("8.Print list");
				System.out.println(" ----------------------------------------------------");
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					dictionaryManagement.insertFromCommandline();
					break;
				case 2:
					dictionaryManagement.editFromCommandline();
					break;
				case 3:
					dictionaryManagement.deleteWordFromCommandline();
					break;
				case 4:
					dictionaryManagement.dictionaryExportToFile();
					break;
				case 5:
					dictionaryManagement.insertFromFile();
					break;
				case 6:
					dictionaryManagement.dictionaryLookup();
					break;
				case 7:
					dictionaryManagement.dictionarySearcher2();
					break;
				case 8:
					dictionaryManagement.printListWord();
					break;
				default:
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Error unexpected!");
		}
	}
}
