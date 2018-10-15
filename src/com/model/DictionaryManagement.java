package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.file.FileManager;

public class DictionaryManagement {
	private Scanner scanner;
	private List<Word> arrWord;
	private FileManager fileManager;

	public DictionaryManagement() {
		super();
		scanner = new Scanner(System.in);
		arrWord = new ArrayList<>();
		fileManager = new FileManager(arrWord);
	}

	public DictionaryManagement(Scanner scanner) {
		super();
		this.scanner = scanner;
		arrWord = new ArrayList<>();
		fileManager = new FileManager(arrWord);
	}

	public DictionaryManagement(List<Word> arrWord, Scanner scanner) {
		super();
		this.arrWord = arrWord;
		this.scanner = scanner;
		fileManager = new FileManager(arrWord);
	}

	// thêm từ
	public void insertFromCommandline() {
		System.out.println("-----Add a new word-----");
		System.out.println("Add a word ");
		String wordTarget = scanner.nextLine();
		Word word = new Word(wordTarget);
		if (arrWord.contains(word)) {
			System.out.println("Add new failed! Word already exist");
			return;
		}
		System.out.println("Add English Word: ");
		String wordTargetNew = scanner.nextLine();
		word.setWordTarget(wordTargetNew);
		;
		System.out.println("Add Vietnamese mean:");
		String wordExplainNew = scanner.nextLine();
		word.setWordExplain(wordExplainNew);
		arrWord.add(word);
		System.out.println("-----Add successfully-----");
	}

	public void editFromCommandline() {
		System.out.println("-----Edit a word-----");
		System.out.println("Add a word: ");
		String wordTarget = scanner.nextLine();
		Word word = new Word(wordTarget);
		if (!arrWord.contains(word)) {
			System.out.println("Word not already exist");
			return;
		}
		System.out.println("Fix Vietnamese mean: ");
		String wordExplain = scanner.nextLine();
		word.setWordExplain(wordExplain);
		int index = arrWord.indexOf(word);
		arrWord.set(index, word);

	}

	// xóa từ
	public void deleteWordFromCommandline() {
		System.out.println("-----Delete a word-----");
		System.out.println("Add a word to delete ");
		String wordTarget = scanner.nextLine();
		Word word = new Word(wordTarget);
		if (arrWord.contains(word)) {
			arrWord.remove(word);
			System.out.println("-----Delete successfully-----");
		} else {
			System.out.println("Word not already exist");
		}
	}

	// xuất ra file
	public void dictionaryExportToFile() {
		// fileManager.saveWordAsObject();
		fileManager.saveFileAsTextByBufferWrite();
		// fileManager.saveWordAsTextByRandomAccessFile();
		System.out.println("Save file successfully");
	}

	// thêm từ file
	public void insertFromFile() {
		arrWord.clear();
//		arrWord.addAll(fileManager.readWordAsObject());
		arrWord.addAll(fileManager.readWordAsTextByBufferReader());
		// arrWord.addAll(fileManager.readWordAsTextByRandomAccessFile());
		System.out.println("Read file successfully");
//		printListWord();
	}

	public void dictionarySearcher() {
		System.out.println("Search: ");
		String wordTarget = scanner.nextLine();
		Word word = new Word(wordTarget);
		if (arrWord.contains(word)) {
			int index = arrWord.indexOf(word);
			System.out.println(arrWord.get(index).toString());
		} else {
			System.out.println("Not already exist");
		}
	}

	public void dictionarySearcher2() {
		List<String> MySortStrings = new ArrayList<String>();
		Word word;
		System.out.println("Search");
		String input = scanner.nextLine();
		for (int i = 0; i < arrWord.size(); i++) {
			word = arrWord.get(i);
			if (word.getWordTarget().startsWith(input)) {
				MySortStrings.add(word.getWordTarget());
			}
		}
		System.out.println(MySortStrings);
	}

	public void printListWord() {
		Comparator<Word> compare = new Comparator<Word>() {

			@Override

			public int compare(Word w1, Word w2) {
				if (w1.getWordTarget().compareTo(w2.getWordTarget()) > 0) {
					return 1;
				} else if (w1.getWordTarget().compareTo(w2.getWordTarget()) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		Collections.sort(arrWord, compare);
		System.out.println("List word:");
		for (int i = 0; i < arrWord.size(); i++) {
			System.out.println(arrWord.get(i));
		}
		System.out.println("------------------------------");
	}
}
