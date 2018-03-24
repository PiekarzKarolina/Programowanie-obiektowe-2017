package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Klasa tworz¹ca bazê rekordów. Pola obecne w rekordzie zapisywane s¹ w HashMapie, kluczem jest nazwa pola. 
 * @author Karolina Piekarz
 */
public class Parser {
		/**
		 * Wczytany plik.
		 */
		private CleanBibTexFile file;

		/**
		 * @return Zwraca wczytany plik.
		 */
		public CleanBibTexFile getFile() {
			return file;
		}

		/**
		 * @param file Wczytany plik.
		 */
		public void setFile(CleanBibTexFile file) {
			this.file = file;
		}

		/**
		 * Tworzy obiekt klasy Parser.
		 * @param file Wczytany plik.
		 */
		public Parser(CleanBibTexFile file) {
			this.file = file;
		}
		
		/**
		 * Metoda tworz¹ca bazê rekordów. Pola obecne w rekordzie zapisywane s¹ w HashMapie, kluczem jest nazwa pola. Metoda ta obs³uguje ta¿e pola crossref, ³¹cz¹c je z odpowiedaj¹cymi im rekordami.
		 * @return Zwraca bazê rekordów.
		 * @see CleanBibTexFile#swapStrings()
		 */
		public Base parse(){
			HashMap<String, Record> records = new HashMap<String, Record>();
			HashMap<String, Record> crossrefRecords = new HashMap<String, Record>();
			ArrayList<String> cleanBibTexFile = file.swapStrings();
			
			HashMap<String, String> fields = new HashMap<String, String>();
			String key = "";
			Type type = Type.MISC;
			boolean previousRecord = false;
			
			for(String line : cleanBibTexFile) {
				int i=0;
				if(line.charAt(0)=='@') {
					if(previousRecord) {
						if(key.contains("crossref")) {
							Record record = new Record(type, key, fields);
							crossrefRecords.put(record.getKey(), record);
						}
						else {
							if(type == Type.BOOK) {
								if(fields.containsKey("author")) type = Type.BOOK1;
								else type = Type.BOOK2;
							}
							if(type == Type.INBOOK) {
								if(fields.containsKey("author")) {
									if(fields.containsKey("pages")) {
										type = Type.INBOOK3;
									}
									else {
										type = Type.INBOOK1;
									}
								}
								else if(fields.containsKey("pages")) {
									type = Type.INBOOK4;
								}
								else {
									type = Type.INBOOK2;
								}
							}
							Record record = new Record(type, key, fields);
							records.put(record.getKey(), record);
						}
					}
					previousRecord = true;
					String typeString = "";
					i++;
					while(i<line.length() && line.charAt(i)!='{') {
						typeString += line.charAt(i);
						i++;
					}
					switch(typeString) {
						case "BOOK":  type = Type.BOOK; break;
						case "book":  type = Type.BOOK; break;
						case "ARTICLE":  type = Type.ARTICLE; break;
						case "article":  type = Type.ARTICLE; break;
						case "INPROCEEDINGS":  type = Type.INPROCEEDINGS; break;
						case "inproceedings":  type = Type.INPROCEEDINGS; break;
						case "PROCEEDINGS":  type = Type.PROCEEDINGS; break;
						case "proceedings":  type = Type.PROCEEDINGS; break;
						case "BOOKLET":  type = Type.BOOKLET; break;
						case "booklet":  type = Type.BOOKLET; break;
						case "INBOOK":  type = Type.INBOOK; break;
						case "inbook":  type = Type.INBOOK; break;
						case "INCOLLECTION":  type = Type.INCOLLECTION; break;
						case "incollection":  type = Type.INCOLLECTION; break;
						case "MANUAL":  type = Type.MANUAL; break;
						case "manual":  type = Type.MANUAL; break;
						case "MASTERTHESIS":  type = Type.MASTERTHESIS; break;
						case "masterthesis":  type = Type.MASTERTHESIS; break;
						case "PHDTHESIS":  type = Type.PHDTHESIS; break;
						case "phdthesis":  type = Type.PHDTHESIS; break;
						case "TECHREPORT":  type = Type.TECHREPORT; break;
						case "techreport":  type = Type.TECHREPORT; break;
						case "MISC":  type = Type.MISC; break;
						case "misc":  type = Type.MISC; break;
						case "UNPUBLISHED":  type = Type.UNPUBLISHED; break;
						case "unpublished":  type = Type.UNPUBLISHED; break;
						case "CONFERENCE":  type = Type.CONFERENCE; break;
						case "conference":  type = Type.CONFERENCE; break;
						default: type = Type.MISC;
					}
					i++;
					key = "";
					while(i<line.length() && (line.charAt(i)!=' ' && line.charAt(i)!='	' && line.charAt(i)!=',')) {
						key+=line.charAt(i);
						i++;
					}
					fields = new HashMap<String, String>();
					
				}
				if(line.charAt(0)!='}' && line.charAt(0)!='@') {
					String value = "";
					String hash = "";
					while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
					while(i<line.length() && (line.charAt(i)!= ' ' && line.charAt(i)!= '=' && line.charAt(i)!= '	')) {
						hash+=line.charAt(i);
						i++;
					}
					while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
					i++;
					while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
					while(i<line.length()) {
						value += line.charAt(i);
						i++;
					}
					fields.put(hash, value);
				}
				
			}
			if(key.contains("crossref")) {
				Record record = new Record(type, key, fields);
				crossrefRecords.put(record.getKey(), record);
			}
			else {
				if(type == Type.BOOK) {
					if(fields.containsKey("author")) type = Type.BOOK1;
					else {
						type = Type.BOOK2;
					}
				}
				if(type == Type.INBOOK) {
					if(fields.containsKey("author")) {
						if(fields.containsKey("pages")) {
							type = Type.INBOOK3;
						}
						else {
							type = Type.INBOOK1;
						}
					}
					else if(fields.containsKey("pages")) {
						type = Type.INBOOK4;
					}
					else {
						type = Type.INBOOK2;
					}
				}
				Record record = new Record(type, key, fields);
				records.put(record.getKey(), record);
			}
			try {
			for(Record recordCrossref : crossrefRecords.values() ) {
				if(recordCrossref.getFields().get("crossref") == null) throw new NoCrossrefFieldException();
				Record mainRecord = records.get(recordCrossref.getFields().get("crossref").toLowerCase());
				if(mainRecord == null) throw new NoCrossrefParentException();
				records.remove(recordCrossref.getFields().get("crossref").toLowerCase());
				HashMap<String, String> fields2 = mainRecord.getFields();
				fields2.putAll(recordCrossref.getFields());
				mainRecord.setFields(fields2);
				records.put(mainRecord.getKey(), mainRecord);
			}
			}
			catch (NoCrossrefParentException e) {
				System.err.println("The crossref parent that this record referes to doesn't exist.");
				e.printStackTrace();
			}
			catch (NoCrossrefFieldException e) {
				System.err.println("The crossref field to what this record referes to doesn't exist.");
				e.printStackTrace();
			}
			Base base = new Base(records);
			return base;
		}
}
