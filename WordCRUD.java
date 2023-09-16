	package com.taemin.word;
	
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class WordCRUD implements ICRUD{
		ArrayList<Word> list;
		Scanner s;

		private WordUpdate Update;
	    private WordFileLoader Load;
	    private WordFileSaver Save;
		final String fname = "Dictionary.txt";
		WordCRUD(Scanner s){
			list = new ArrayList<>();
			this.s =s; 
			Update = new WordUpdate(s);
			Load = new WordFileLoader();
			Save = new WordFileSaver();
		} 
		
		@Override
		public Object add() {
			System.out.print("\n=> 난이도(1,2,3) & 새 단어 입력 : ");
			int level = s.nextInt();
			String word = s.nextLine();
			
			System.out.print("뜻 입력 : ");
			String meaning = s.nextLine();
			
			return new Word(0, level, word, meaning);
		}
		
		public void addWord() {
			Word one = (Word)add();
			list.add(one);
			System.out.println("\n새 단어가 정상적으로 추가되었습니다. \n");
		}
	
		
		
		
		@Override
		public int update(Object obj) {
			// TODO Auto-generated method stub
			return 0;
		}
	
		@Override
		public int delete(Object obj) {
			// TODO Auto-generated method stub
			return 0;
		}
	
		@Override
		public void selectOne(int id) {
			// TODO Auto-generated method stub
			
		}
		public void listall() {
			System.out.println("\n--------------------------------------");
			for(int i=0;i<list.size();i++) {
				System.out.print(i+1+" ");
				System.out.println(list.get(i).toString());
			}
			System.out.println("--------------------------------------\n");
		}
	
		public ArrayList<Integer> listall(String keyboard) {
			int j=0;
			ArrayList<Integer> idlist = new ArrayList<>();
			System.out.println("\n--------------------------------------");
			for(int i=0;i<list.size();i++) {
				String word = list.get(i).getWord();
				if(!word.contains(keyboard)) continue;
				System.out.print(j+1+" ");
				System.out.println(list.get(i).toString());
				idlist.add(i);
				j++;
			}
			System.out.println("--------------------------------------\n");
			return idlist;
		}
		
		public void listall(int level) {
			int j=0;
			ArrayList<Integer> idlist = new ArrayList<>();
			System.out.println("\n--------------------------------------");
			for(int i=0;i<list.size();i++) {
				int ilevel = list.get(i).getLevel();
				if(ilevel != level ) continue;
				System.out.print(j+1+" ");
				System.out.println(list.get(i).toString());
				j++;
			}
			System.out.println("--------------------------------------\n");
			
		}
		
	
	
		public void updateItem() {
			Update.update(list);
		}
		public void loadFile() {
	        Load.loadFile(fname, list);
	    }
	
	
		public void deleteItem() {
			System.out.printf("=> 삭제할 단어 검색 : ");
			String keyboard = s.next();
			ArrayList<Integer> idlist = this.listall(keyboard);
			System.out.print("=> 삭제할 번호 선택 : ");
			int id = s.nextInt();
			s.nextLine();
			
			System.out.print("정말로 삭제하실래요?(Y/n) ");
			String ans = s.next();
			if(ans.equalsIgnoreCase("y")) {
				list.remove((int)idlist.get(id-1));
				System.out.println("단어가 삭제되었습니다. ");
			}
			else {
				System.out.println("취소되었습니다. ");
			}
			
		}
		public void saveFile() {
	        Save.saveFile(fname, list);
	    }

	
	
	
		public void SearchLevel() {
			System.out.print("=> 원하는 레밸은? (1~3) ");
			int level = s.nextInt();
			listall(level);
			
			
		}
		public void SearchWord() {
			System.out.print("=> 원하는 단어? ");
			String keyword = s.next();
			listall(keyword);
			
		}
	
	}
