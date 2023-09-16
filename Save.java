package com.taemin.word;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {
    public void saveFile(String filePath, ArrayList<Word> list) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(filePath));
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
