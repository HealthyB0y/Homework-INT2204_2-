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
				System.out.println("-------------Chương trình từ điển-------------");
				System.out.println("1.Thêm từ");
				System.out.println("2.Sửa từ");
				System.out.println("3.Xóa từ");
				System.out.println("4.Xuất ra file");
				System.out.println("5.Thêm từ file");
				System.out.println("6.Tìm kiếm từ");
				System.out.println("7.In danh sách từ");
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
//					dictionaryManagement.dictionarySearcher();
					dictionaryManagement.dictionarySearcher2();
					break;
				case 7:
					dictionaryManagement.printListWord();
					break;
				default:
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Có lỗi bất thường!");
		}
	}
}
