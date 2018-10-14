package com.file;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.util.*;
import com.model.Word;

public class FileManager {
	private List<Word> arrWord;
	private File fileText = new File(Const.PATH_FILE_TEXT);
	private File fileObject = new File(Const.pathFileObject);

	public FileManager(List<Word> arrWord) {
		super();
		this.arrWord = arrWord;
		createFile();
	}

	private void createFile() {
		try {
			if (!fileText.exists()) {
				fileText.createNewFile();
			}
			if (!fileObject.exists()) {
				fileObject.createNewFile();
			}
		} catch (Exception e) {
		}
	}

	public void saveWordAsTextByRandomAccessFile() {
		try {
			RandomAccessFile rdAccessFile = new RandomAccessFile(fileText, "rw");
			for (int i = 0; i < arrWord.size(); i++) {
				rdAccessFile.writeUTF(arrWord.get(i).toString() + "\n");
			}
			rdAccessFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Word> readWordAsTextByRandomAccessFile() {
		List<Word> arrTemp = new ArrayList<>();
		try {
			RandomAccessFile rdAccessFile = new RandomAccessFile(fileText, "r");
			String line = rdAccessFile.readLine();
			while (line != null) {
				Word word = convertLineToWord(line);
				arrTemp.add(word);
				line = rdAccessFile.readLine();
			}
			rdAccessFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrTemp;
	}

	public void saveFileAsTextByBufferWrite() {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileText, false));
			for (int i = 0; i < arrWord.size(); i++) {
				bufferedWriter.write(arrWord.get(i).toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Word> readWordAsTextByBufferReader() {
		List<Word> arrTemp = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileText));
			String line = bufferedReader.readLine();
			while (line != null) {
				Word word = convertLineToWord(line);
				arrTemp.add(word);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrTemp;
	}

	private Word convertLineToWord(String line) {
		String[] arrValues = line.split("---");
		Word word = new Word();
		word.setWordTarget(arrValues[0]);
		word.setWordExplain(arrValues[1]);
		return word;
	}

	public void saveWordAsObject() {
		FileOutputStream outputStream;
		ObjectOutputStream objectOutputStream;
		try {
			outputStream = new FileOutputStream(fileObject, false);
			objectOutputStream = new ObjectOutputStream(outputStream);
			for (int i = 0; i < arrWord.size(); i++) {
				objectOutputStream.writeObject(arrWord.get(i));
			}
			objectOutputStream.writeObject(null);
			objectOutputStream.flush();
			objectOutputStream.close();
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Word> readWordAsObject() {
		List<Word> arrTemp = new ArrayList<>();
		FileInputStream inputStream;
		ObjectInputStream objectInputStream;
		try {
			inputStream = new FileInputStream(fileObject);
			objectInputStream = new ObjectInputStream(inputStream);
			Word word = (Word) objectInputStream.readObject();
			while (word != null) {
				arrTemp.add(word);
				word = (Word) objectInputStream.readObject();
			}
			objectInputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return arrTemp;
	}

}
