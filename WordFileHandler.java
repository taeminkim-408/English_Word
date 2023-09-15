package com.taemin.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFileHandler {
    private final String fname = "Dictionary.txt";

    public void loadFile(ArrayList<Word> list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;
            while (true) {
                line = br.readLine();
                if (line == null) break;
                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;
            }
            br.close();
            System.out.println("==> " + count + "개 로딩완료!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(ArrayList<Word> list) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for (Word one : list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> 데이터 저장완료!!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
