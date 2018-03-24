package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Klasa zamieniaj¹ca zmienne tekstowe(Stringi) w pliku na odpowiadaj¹ce im napisy.
 *  @author Karolina Piekarz
 */
public class CleanBibTexFile {
		/**
		 * Akumulator zmiennych tekstowych.
		 */
		private FileStringAccumulator accumulator;
		/**
		 * Plik, który jest przetwarzany.
		 */
		private FileCleanFromStrings file;
		
		/**
		 * @return Zwraca plik, który jest przetwarzany.
		 */
		public FileCleanFromStrings getFile() {
			return file;
		}

		/**
		 * @param file  Plik, który jest przetwarzany.
		 */
		public void setFile(FileCleanFromStrings file) {
			this.file = file;
		}

		/**
		 * @return Zwraca akumulator zmiennych tekstowych.
		 */
		public FileStringAccumulator getAccumulator() {
			return accumulator;
		}

		/**
		 * @param accumulator  Akumulator zmiennych tekstowych.
		 */
		public void setAccumulator(FileStringAccumulator accumulator) {
			this.accumulator = accumulator;
		}
		
		/**
		 * Tworzy obiekt klasy CleanBibTexFile.
		 * @param accumulator Akumulator zmiennych tekstowych.
		 * @param file Plik, który jest przetwarzany.
		 */
		public CleanBibTexFile(FileStringAccumulator accumulator, FileCleanFromStrings file) {
			this.accumulator = accumulator;
			this.file = file;
		}

		/**
		 * Metoda zamieniaj¹ca zmienne tekstowe(Stringi) w pliku na odpowiadaj¹ce im napisy.
		 * @return Lista poprawnych, ³atwo interpretowalnych ci¹gów znaków tworz¹cych plik z podmienionymi zmiennymi tekstowymi.
		 * @see FileCleaner#cleanFile()
		 * @see FileStringAccumulator#getAccumulator()
		 */
		public ArrayList<String> swapStrings(){
			ArrayList<String> fileCleaned = file.cleanFile();
			HashMap<String, String> key = accumulator.getAccumulator();
			ArrayList<String> cleanBibTexFile = new ArrayList<String>();
			
			for(String line:fileCleaned) {
				//line += " ";
				int i=0;
				String lineSwapped = "";
				if(line.charAt(0)=='@' || line.charAt(0)=='}') {
					lineSwapped = line;
					i=line.length();
				}
				while(i<line.length()-1 && line.charAt(i) != '=') {
					lineSwapped += line.charAt(i);
					i++;
				}
				if(i<line.length()-1){
					lineSwapped += line.charAt(i);
					i++;
				}
				while(i<line.length()-1) {
					while(i<line.length()-1 && (line.charAt(i)== ' ' || line.charAt(i)== '	')) {
						lineSwapped += line.charAt(i);
						i++;
					}
					if(i<line.length()-1 && line.charAt(i) == '"') {
						i++;
						while(i<line.length()-1) {
						if(i<line.length()-1 && line.charAt(i)== '"' && line.charAt(i-1)!='\\') {
							//lineSwapped += line.charAt(i);
							i++;
							break;
						}
						lineSwapped += line.charAt(i);
						i++;
						
						}
					}
					else if(i<line.length()-1 && line.charAt(i) == '{') {
						//lineSwapped += line.charAt(i);
						i++;
						int bracket = 1;
						while(i<line.length()-1) {
							if(bracket==1 && line.charAt(i)=='}') {
								i++;
								break;
							}
							lineSwapped += line.charAt(i);
							if(line.charAt(i)=='{') bracket++;
							else if(line.charAt(i)=='}') bracket--;
							i++;
						}
					}
					else if(i<line.length()-1 && line.charAt(i) == '#') {
						i++;	
						while(i<line.length()-1 && (line.charAt(i)== ' ' || line.charAt(i)== '	')) i++;
					}
					else {
						String s= "";
						while(i<line.length()-1 && line.charAt(i)!= ' ' && line.charAt(i)!= '	') {
							s+=line.charAt(i);
							i++;
						}
						//System.out.println(s);
						if(key.containsKey(s)) {
							lineSwapped += key.get(s);
						}
						else {
							lineSwapped += s;
						}
					}
				}
				cleanBibTexFile.add(lineSwapped);
			}
			return cleanBibTexFile;
		}
		
}
