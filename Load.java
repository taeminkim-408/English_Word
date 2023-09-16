package com.taemin.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Load {
    public void loadFile(String filePath, ArrayList<Word> list) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
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
}
