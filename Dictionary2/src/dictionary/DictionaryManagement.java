package dictionary;

import java.io.BufferedReader;
//import com.sun.speech.freetts.Voice;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Scanner;

import com.sun.speech.freetts.VoiceManager;


public class DictionaryManagement {
    Dictionary d = new Dictionary();
    Scanner scan = new Scanner(System.in);

    public void insertFromCommandline(Dictionary d) {
        System.out.println("nhap so tu can them:");
        int s1 = scan.nextInt();
        scan.nextLine();
        for(int i=0;i<s1;i++) {
            String tu;
            String nghia;
            System.out.println("nhap tu moi:");
            tu= scan.nextLine().toLowerCase();           
            System.out.println("Nhap nghia moi:");
            nghia= scan.nextLine().toLowerCase();          
            Word words = new Word(tu,nghia);
            d.list.add(words);
        }
    }

    public void dictionaryLookup(Dictionary d) {// ham tim kiem tu
        System.out.println("nhap tu can tim:");
        String tucamtim =scan.next().toLowerCase();
        System.out.println(dictionaryLookup(d, tucamtim));
    }
    

    public void insertFromFile(Dictionary d) {  // ham doc file   
		BufferedReader br = null;
		File f = new File("abc/AnhVietdict.txt");
		String filename = f.getAbsolutePath();
		try {
			
			FileInputStream fileInPutStream = new FileInputStream(filename);
            Reader reader = new InputStreamReader(fileInPutStream, "utf8");
            br = new BufferedReader(reader);
            
			String s1 = "";
			Word wordtemp = new Word();
			while((s1 = br.readLine()) != null) {
				if(s1.startsWith(" ")) {
					if(!wordtemp.getWord_explain().equals(""))
						wordtemp.setWord_explain(wordtemp.getWord_explain() + "\n" + s1);
					else
						wordtemp.setWord_explain(s1);
				}
				else
				{
					wordtemp = new Word();
					d.list.add(wordtemp);
					wordtemp.setWord_target(s1);
				}
			 }
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    

    public void deleteWord(Dictionary d) {
        String tucanxoa;
        int test=1;
        System.out.println("nhap tu can xoa:");
        tucanxoa=scan.next().toLowerCase();
        for(int i=0;i<d.list.size();i++) {
            if(d.list.get(i).getWord_target().equalsIgnoreCase(tucanxoa))
            {
                d.list.remove(d.list.get(i));
                System.out.println("xoa thanh cong.");
                test++;
            }
        }
        if(test==1)
        {
            System.out.println("khong tim thay tu can xoa.");
        }
    }

    public void suatu(Dictionary d) {
        String tucansua;
        String tu;
        String nghia;
        int test=1;
        System.out.println("nhap tu can sua:");
        tucansua=scan.next().toLowerCase();
        for(int i=0;i<d.list.size();i++){
            if(d.list.get(i).getWord_target().equalsIgnoreCase(tucansua))
            {
                System.out.println("sua tu.");
                System.out.println("tu moi:");
                tu=scan.next().toLowerCase();
                System.out.println("nghia moi:");
                nghia=scan.next().toLowerCase();
                d.list.get(i).setWord_target(tu);
                d.list.get(i).setWord_explain(nghia);
                System.out.println("Sửa");
                test++;
            }
        }
        if(test==1)
        {
        	
        }
    }

    public void dictionaryExportToFile(Dictionary d) throws IOException {// ham ghi du lieu tu mang vao file
    	File f = new File("abc/AnhVietdict.txt");
		String filename = f.getAbsolutePath();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
		
		for (Word word : d.list) {
			bw.write(word.getWord_target() + "\n");
			if(!word.getWord_explain().equals(""))
				bw.write(" " + word.getWord_explain() + "\n");
		} 
		bw.close();
	}
	
    public void speaks(String str) {
    	System.setProperty("mbrola.base", "abc/mbrola");
		VoiceManager voiceManager = VoiceManager.getInstance();
		com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("mbrola_us1");
		syntheticVoice.allocate();
		syntheticVoice.speak(str);
		syntheticVoice.deallocate();
    }
    public void Speaks() {
        String str = scan.nextLine().toLowerCase();
        speaks(str);
    }

    public void addword(Dictionary d,String a,String b)
    {
        Word word = new Word(a,b);
        d.list.add(word);
    }

    public String dictionaryLookup(Dictionary d,String str) {// ham tim kiem tu
        int test=1;
        for (int i=0;i<d.list.size();i++)
        {
            if (d.list.get(i).getWord_target().equalsIgnoreCase(str)) {
                test++;
                return d.list.get(i).getWord_explain();
            }
        }
        if (test==1) {
            
        }
        return null;
    }
    public int dictionaryLookup1(Dictionary d,String str) {
        int test=1;
        for (int i=0;i<d.list.size();i++)
        {
            if (d.list.get(i).getWord_target().equalsIgnoreCase(str)) {
                test++;
                return i;
            }
        }
        if (test==1) {
            return -1;
        }
        return -1;
    }
}