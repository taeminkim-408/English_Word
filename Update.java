package com.taemin.word;

import java.util.ArrayList;
import java.util.Scanner;

public class Update {
    private Scanner s;

    public Update(Scanner s) {
        this.s = s;
    }

    public void update(ArrayList<Word> list) {
        System.out.printf("=> 수정할 단어 검색 : ");
        String keyboard = s.next();
        ArrayList<Integer> idlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if (word.contains(keyboard)) {
                idlist.add(i);
            }
        }

        if (idlist.isEmpty()) {
            System.out.println("일치하는 단어가 없습니다.");
            return;
        }

        System.out.println("일치하는 단어 목록:");
        for (int i = 0; i < idlist.size(); i++) {
            int id = idlist.get(i);
            System.out.println(i + 1 + " " + list.get(id).toString());
        }

        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        if (id < 1 || id > idlist.size()) {
            System.out.println("유효하지 않은 번호입니다.");
            return;
        }

        int selectedId = idlist.get(id - 1);
        Word selectedWord = list.get(selectedId);

        System.out.print("=> 수정할 곳은?(1번 뜻, 2번 단어, 3번 전체 단어변경) : ");
        int input = s.nextInt();
        s.nextLine();
        if (input == 1) {
            System.out.print("=> 뜻 입력 : ");
            String meaning = s.nextLine();
            selectedWord.setMaening(meaning);
        } else if (input == 2) {
            System.out.print("=> 단어 입력 : ");
            String newWord = s.nextLine();
            selectedWord.setWord(newWord);
        } else if (input == 3) {
            System.out.print("=> 단어 입력 : ");
            String newWord = s.nextLine();
            System.out.print("=> 뜻 입력 : ");
            String meaning = s.nextLine();
            selectedWord.setWord(newWord);
            selectedWord.setMaening(meaning);
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.println("단어가 수정되었습니다.");
    }
}
