package com.taemin.word;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;
	WordManager(){
		wordCRUD = new WordCRUD(s);
		
	}
	public void start() {
		wordCRUD.loadFile();
		while(true) {
			int menu = SelectMenu();
			if(menu==0) {
				System.out.print("프로그램 종료! 다음에 만나요~");
				break;
			}
			if(menu==1) {
				wordCRUD.listall();
			}
			else if(menu==2) {
				wordCRUD.SearchLevel();
			}
			else if(menu==3) {
				wordCRUD.SearchWord();
			}
			else if(menu==4) {
				wordCRUD.addWord();
			}
			else if(menu==5) {
				wordCRUD.updateItem();
				//update
			}
			else if(menu==6) {
				wordCRUD.deleteItem();
			}
			else if(menu==7) {
				wordCRUD.saveFile();
			}
			else {
				System.out.println("에러 다시 입력해주세요. ");
			}
			
		}
		
	}
	public int SelectMenu() {
		System.out.print("*** 영단어 마스터 ***\n"
						+"************\n"
						+"1. 모든 단어 보기\n"
						+"2. 수준별 단어보기\n"
						+"3. 단어검색\n"
						+"4.단어 추가\n"
						+"5.단어 수정\n"
						+"6.단어 삭제\n"
						+"7.파일 저장\n"
						+"0.나가기\n"
						+"************\n"
						+"원하는 메뉴는? "
						);
		return s.nextInt();
		
	}
}
