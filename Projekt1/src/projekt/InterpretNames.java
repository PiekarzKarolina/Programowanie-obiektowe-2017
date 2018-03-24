package projekt;

import java.util.ArrayList;

/**
 * 
 * Klasa zajmuj¹ca siê obs³ug¹ nazwisk.
 * @author Karolina Piekarz
 */
public class InterpretNames {
		/**
		 * Rekord, który ma zostaæ przetworzony.
		 */
		private Record record;
		/**
		 * Tworzy obiekt klasy InterpretNames.
		 * @param record Rekord, który ma zostaæ przetworzony.2
		 */
		public InterpretNames(Record record) {
			this.record = record;
		}

		/**
		 * @return Zwraca rekord, który ma zostaæ przetworzony.
		 */
		public Record getRecord() {
			return record;
		}

		/**
		 * @param record Rekord, który ma zostaæ przetworzony.
		 */
		public void setRecord(Record record) {
			this.record = record;
		}

		/**
		 * Metoda interpretuj¹ca nazwiska, parsuj¹ca je na format: First, von, Last, Jr.
		 * @param category Nazwa pola, w którym znajduj¹ siê nazwiska do zinterpretowania. Najczêœciej "author" lub "editor".
		 * @return Lista nazwisk w postaci, dla ka¿ego nazwiska: First, von, Last, Jr...
		 */
		public ArrayList<String> refactorNames(String category) {
				if(record.getFields().get(category)!=null) {
					ArrayList<String> Name = new ArrayList<String>();
					
					String s = record.getFields().get(category);
					
					String[] authors = s.split("and");
					for(String author : authors) {
						String First = "", von = "", Last = "", Jr = "";
						String[] parts = author.split(",");
						if(parts.length==1) {
							String[] words = parts[0].split(" ");
							boolean isVon = false;
							boolean isLast = false;
							for(String word: words) {
								//System.out.println(word);
								int i=0;
								if(!isVon && word.equals(words[words.length-1])) {
									Last+=word;
								}
								else {
									
									while(i<word.length()&&!((word.charAt(i)>='a' && word.charAt(i)<='z') || (word.charAt(i)>='A' && word.charAt(i)<='Z'))) {
										if(word.charAt(i)=='{') {
											while(i<word.length()&&word.charAt(i)!='}') i++;
										}
										if(word.charAt(i)=='\\') i++;
										i++;
									}
									
									if(i==word.length()) {
										if(isVon) {
											Last+=word + " ";
										}
										else {
											First+=word + " ";
										}
									}
									
									if(i<word.length()) {
											if(word.charAt(i)>='A' && word.charAt(i)<='Z' && !isVon) {
											First+=word+ " ";
											}
											else if(isLast) {
												Last+=word+ " ";
											}
											else if(word.charAt(i)>='A' && word.charAt(i)<='Z' && isVon ) {
												isLast = true;
												Last+=word+ " ";
											}
											else {
												isVon = true;
												von+=word+ " ";
											}
									}
								}
							}
							String[] Lasts = Last.split(" ");
							boolean vonStarts = false;
							String von2 = "";
							String Stasl = "";
							for(int j=Lasts.length - 1; j>=0; j--) {
								if(!vonStarts) {
									int l = 0;
									while(l<Lasts[j].length()&&!((Lasts[j].charAt(l)>='a' && Lasts[j].charAt(l)<='z') || (Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z'))) {
										if(Lasts[j].charAt(l)=='{') {
											while(l<Lasts[j].length()&&Lasts[j].charAt(l)!='}') l++;
										}
										if(Lasts[j].charAt(l)=='\\') l++;
										l++;
									}
									
									if(l==Lasts[j].length()) {
										Stasl += Lasts[j] + " ";
									}
									else {
										if(Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z') {
											Stasl += Lasts[j] + " ";
										}
										else {
											von2+=Lasts[j] + " ";
											vonStarts = true;
										}
									}
								}
								else {
									von2+=Lasts[j]+ " ";
								}
							}
							String[] von3 = von2.split(" ");
							for(int k=von3.length - 1; k>=0; k--) {
								von+=von3[k]+ " ";	
							}
							String[] last3 = Stasl.split(" ");
							Last = "";
							for(int t=last3.length - 1; t>=0; t--) {
								Last+= last3[t] + " ";	
							}
							if(isVon && !isLast || Last.equals(" ")) {
								String[] takeLast = von.split(" ");
								von = "";
								int xx = 0;
								for(String word2 : takeLast) {
									if(xx!=takeLast.length-1) {
										xx++;
										von += word2 + " ";
									}
									else {
										Last = takeLast[xx];
									}
								}
							}
						}
						else if(parts.length==2) {
							First = parts[1];
							String[] words = parts[0].split(" ");
							boolean isLast = false;
							for(String word: words) {
								if(word.charAt(0)<='z' && word.charAt(0)>='a' && !isLast) {
									von+=word+" ";
								}
								else {
									isLast = true;
									Last+=word+" ";
								}
							}
							String[] Lasts = Last.split(" ");
							boolean vonStarts = false;
							String von2 = "";
							String Stasl = "";
							for(int j=Lasts.length - 1; j>=0; j--) {
								if(!vonStarts) {
									int l = 0;
									while(l<Lasts[j].length()&&!((Lasts[j].charAt(l)>='a' && Lasts[j].charAt(l)<='z') || (Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z'))) {
										if(Lasts[j].charAt(l)=='{') {
											while(l<Lasts[j].length()&&Lasts[j].charAt(l)!='}') l++;
										}
										if(Lasts[j].charAt(l)=='\\') l++;
										l++;
									}
									
									if(l==Lasts[j].length()) {
										Stasl += Lasts[j] + " ";
									}
									else {
										if(Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z') {
											Stasl += Lasts[j] + " ";
										}
										else {
											von2+=Lasts[j] + " ";
											vonStarts = true;
										}
									}
								}
								else {
									von2+=Lasts[j]+ " ";
								}
							}
							String[] von3 = von2.split(" ");
							for(int k=von3.length - 1; k>=0; k--) {
								von+=von3[k]+ " ";	
							}
							String[] last3 = Stasl.split(" ");
							Last = "";
							for(int t=last3.length - 1; t>=0; t--) {
								Last+= last3[t] + " ";	
							}
						}
						else {
							Jr = parts[1];
							First = parts[2];
							String[] words = parts[0].split(" ");
							boolean isLast = false;
							for(String word: words) {
								if(word.charAt(0)<'A' && !isLast) {
									von+=word+" ";
								}
								else {
									isLast = true;
									Last+=word+" ";
								}
							}
							String[] Lasts = Last.split(" ");
							boolean vonStarts = false;
							String von2 = "";
							String Stasl = "";
							for(int j=Lasts.length - 1; j>=0; j--) {
								if(!vonStarts) {
									int l = 0;
									while(l<Lasts[j].length()&&!((Lasts[j].charAt(l)>='a' && Lasts[j].charAt(l)<='z') || (Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z'))) {
										if(Lasts[j].charAt(l)=='{') {
											while(l<Lasts[j].length()&&Lasts[j].charAt(l)!='}') l++;
										}
										if(Lasts[j].charAt(l)=='\\') l++;
										l++;
									}
									
									if(l==Lasts[j].length()) {
										Stasl += Lasts[j] + " ";
									}
									else {
										if(Lasts[j].charAt(l)>='A' && Lasts[j].charAt(l)<='Z') {
											Stasl += Lasts[j] + " ";
										}
										else {
											von2+=Lasts[j] + " ";
											vonStarts = true;
										}
									}
								}
								else {
									von2+=Lasts[j]+ " ";
								}
							}
							String[] von3 = von2.split(" ");
							for(int k=von3.length - 1; k>=0; k--) {
								von+=von3[k]+ " ";	
							}
							String[] last3 = Stasl.split(" ");
							Last = "";
							for(int t=last3.length - 1; t>=0; t--) {
								Last+= last3[t] + " ";	
							}
						}
					Last.trim();
					First.trim();
					von.trim();
					Jr.trim();
					Name.add(First);
					Name.add(von);
					Name.add(Last);
					Name.add(Jr);
					}
					return Name;
				}
				return null;			
		}
}
