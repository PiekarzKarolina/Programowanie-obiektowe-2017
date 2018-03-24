package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Klasa zapisuj¹ca do HashMapy wszystkie prawid³owo zadeklarowane Stringi w pliku.
 * @author Karolina Piekarz
 */
public class FileStringAccumulator {
		/**
		 * Oczyszczony z komentarzy plik.
		 */
		private FileCleaner cleanFile;

		/**
		 * @return Zwraca oczyszczony z komentarzy plik.
		 */
		public FileCleaner getCleanFile() {
			return cleanFile;
		}

		/**
		 * @param cleanFile Oczyszczony z komentarzy plik.
		 */
		public void setCleanFile(FileCleaner cleanFile) {
			this.cleanFile = cleanFile;
		}
		
		/**
		 * Tworzy obiekt klasy FileStringAccumulator
		 * @param cleanFile Oczyszczony z komentarzy plik.
		 */
		public FileStringAccumulator(FileCleaner cleanFile){
			this.cleanFile = cleanFile;
		}
		
		/**
		 * Metoda wyszukuj¹ca wszystkie poprawnie zadeklarowane Stringi w pliku i wpisuj¹ca je do HashMapy.
		 * @return HashMapa zadeklarowanych w pliku Stringów. Kluczami s¹ ich zadeklarowane nazwy.
		 * @see FileCleaner#cleanFile()
		 */
		public HashMap<String,String> getAccumulator() {
			ArrayList<String> fileCleaned = cleanFile.cleanFile();
			HashMap<String,String> Accumulator = new HashMap<String,String>();
			
			
			for(String line:fileCleaned) {
				int i = 8;
				if(line.startsWith("@STRING{", 0) || line.startsWith("@string{", 0)){
					String hash = "";
					while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
					while(i<line.length() && (line.charAt(i)!= ' ' && line.charAt(i)!= '=' && line.charAt(i)!= '	')) {
						hash+=line.charAt(i);
						i++;
					}
					if(i<line.length() && line.charAt(i)== '=' ) i++;
					String s = "";
					while(i<line.length()) {
						while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
						if(i<line.length() && line.charAt(i)=='"') {
							i++;
							while(i<line.length() && line.charAt(i)!= '"') {
								s+=line.charAt(i);
								i++;
							}
						}
						else if(i<line.length() && line.charAt(i)=='#') {
							i++;
							while(i<line.length() && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
							String name = "";
							while(i<line.length() && (line.charAt(i)!= ' ' && line.charAt(i)!= '	')) {
								name+=line.charAt(i);
								i++;
							}
						s += Accumulator.get(name);	
						}
						i++;
					}
					Accumulator.put(hash, s);
				}
			}
			return Accumulator;
		}
}
