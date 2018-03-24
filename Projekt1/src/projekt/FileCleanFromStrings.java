package projekt;

import java.util.ArrayList;

/**
 * Klasa oczyszczaj¹ca plik z komentarzy. Pozostaj¹ tylko prawid³owo zadeklarowane rekordy(z dowln¹ zawratoœci¹).
 * @author Karolina Piekarz
 */
public class FileCleanFromStrings {
		/**
		 * Wczytany plik.
		 */
		private FileCleaner file;

		/**
		 * @return Zwraca wczytany plik.
		 */
		public FileCleaner getFile() {
			return file;
		}

		/**
		 * @param file Wczytany plik.
		 */
		public void setFile(FileCleaner file) {
			this.file = file;
		}

		/**
		 * Tworzy obiekt klasy FileCleanFromStrings.
		 * @param file  Wczytany plik.
		 */
		public FileCleanFromStrings(FileCleaner file) {
			this.file = file;
		}
		
		/**
		 * Oczyszcza plik z komentarzy zostawiaj¹c tylko poprawnie zadeklarowane rekordy(@ oraz poprawna nazwa typu).
		 * @return Lista poprawnych, ³atwo interpretowalnych ci¹gów zanków tworz¹cych plik, bez zadeklarowanych Stringów.
		 * @see FileCleaner#cleanFile()
		 */
		public ArrayList<String> cleanFile() {
			ArrayList<String> fileCleaned = file.cleanFile();	
			ArrayList<String> fileWithoutStrings = new ArrayList<String>();
			
			int Brackets = 0;
			
			for(String line:fileCleaned) {
				String copyLine = "";
				for(int i=0; i<line.length(); i++) {
					if(line.charAt(i)=='@') {
						if(line.length()-i>5  &&(line.startsWith("MISC{", i+1) || line.startsWith("misc{", i+1))) {
							Brackets++;
							i+=6;
							copyLine += "@MISC{";
						}
						if(line.length()-i>5  && (line.startsWith("BOOK{", i+1) || line.startsWith("book{", i+1))) {
							Brackets++;
							i+=6;
							copyLine += "@BOOK{";
						}
						if(line.length()-i>7  && (line.startsWith("MANUAL{", i+1) || line.startsWith("manual{", i+1))) {
							Brackets++;
							i+=8;
							copyLine += "@MANUAL{";
						}
						if(line.length()-i>7  && (line.startsWith("INBOOK{", i+1) || line.startsWith("inbook{", i+1))) {
							Brackets++;
							i+=8;
							copyLine += "@INBOOK{";
						}
						if(line.length()-i>8  && (line.startsWith("ARTICLE{", i+1) || line.startsWith("article{", i+1))) {
							Brackets++;
							i+=9;
							copyLine += "@ARTICLE{";
						}
						if(line.length()-i>8  && (line.startsWith("BOOKLET{", i+1) || line.startsWith("booklet{", i+1))) {
							Brackets++;
							i+=9;
							copyLine += "@BOOKLET{";
						}
						if(line.length()-i>10  && (line.startsWith("PHDTHESIS{", i+1) || line.startsWith("phdthesis{", i+1))) {
							Brackets++;
							i+=11;
							copyLine += "@PHDTHESIS{";
						}
						if(line.length()-i>11  && (line.startsWith("TECHREPORT{", i+1) || line.startsWith("techreport{", i+1))) {
							Brackets++;
							i+=12;
							copyLine += "@TECHREPORT{";
						}
						if(line.length()-i>12  && (line.startsWith("UNPUBLISHED{", i+1) || line.startsWith("unpublished{", i+1))) {
							Brackets++;
							i+=13;
							copyLine += "@UNPUBLISHED{";
						}
						if(line.length()-i>13  && (line.startsWith("INCOLLECTION{", i+1) || line.startsWith("incollection{", i+1))) {
							Brackets++;
							i+=14;
							copyLine += "@INCOLLECTION{";
						}
						if(line.length()-i>13  && (line.startsWith("MASTERTHESIS{", i+1) || line.startsWith("masterthesis{", i+1))) {
							Brackets++;
							i+=14;
							copyLine += "@MASTERTHESIS{";
						}
						if(line.length()-i>14  && (line.startsWith("INPROCEEDINGS{", i+1) || line.startsWith("inproceedings{", i+1))) {
							Brackets++;
							i+=15;
							copyLine += "@INPROCEEDINGS{";
						}
						if(line.length()-i>12  && (line.startsWith("PROCEEDINGS{", i+1) || line.startsWith("proceedings{", i+1))) {
							Brackets++;
							i+=13;
							copyLine += "@PROCEEDINGS{";
						}
						if(line.length()-i>11  && (line.startsWith("CONFERENCE{", i+1) || line.startsWith("conference{", i+1))) {
							Brackets++;
							i+=12;
							copyLine += "@CONFERENCE{";
						}
					}
					if(Brackets!=0 && i<line.length()) {
						if(line.charAt(i)=='{') {
							Brackets++;
						}
						else if(line.charAt(i)=='}') {
							Brackets--;
						}
						copyLine += line.charAt(i);
					}	
				}
				if(copyLine != "") {
					fileWithoutStrings.add(copyLine);
				}	
			}
			return fileWithoutStrings;
			
			
		}
}
