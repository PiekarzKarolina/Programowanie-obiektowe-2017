package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * Klasa czytaj�ca plik, dzi�ki metodzie readFile() zamienia go na list� ci�g�w znak�w.
 * @author Karolina Piekarz
 */
public class FileRead {
		/**
		 * Nazwa pliku, kt�ry jest wczytywany.
		 */
		private String fileName;

		/**
		 * @return Zwraca nazw� pliku.
		 */
		public String getFileName() {
			return fileName;
		}

		/**
		 * @param fileName Nazwa pliku.
		 */
		public void setFilePath(String fileName) {
			this.fileName = fileName;		
		}
		/**
		 * Tworzy obiekt klasy FileRead
		 * @param fileName Nazwa pliku, kt�ry ma zosta� przetworzony.
		 */
		public FileRead (String fileName){
			this.fileName = fileName;
		}

		/**
		 * Metoda czytaj�ca dane z pliku. Zapisywane s� one do ArrayListy.
		 * @return Lista ci�g�w znak�w tworz�cych plik.
		 */
		public ArrayList<String> readFile() {
			ArrayList<String> FileContent = new ArrayList<String>();
			try {
	            BufferedReader br = new BufferedReader(new FileReader(fileName));
	            String line = br.readLine();
	            while (line!= null) {
	                FileContent.add(line);
	                line = br.readLine();
	            }
	            br.close();
	        } catch (Exception e) {
	            System.err.println("Wystapil blad przy wczytywaniu danych");
	            e.printStackTrace();
	            System.exit(1);
	        }
			return FileContent;
		}
}

