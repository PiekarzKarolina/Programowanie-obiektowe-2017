package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * 
 * Klasa czytaj¹ca plik, dziêki metodzie readFile() zamienia go na listê ci¹gów znaków.
 * @author Karolina Piekarz
 */
public class FileRead {
		/**
		 * Nazwa pliku, który jest wczytywany.
		 */
		private String fileName;

		/**
		 * @return Zwraca nazwê pliku.
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
		 * @param fileName Nazwa pliku, który ma zostaæ przetworzony.
		 */
		public FileRead (String fileName){
			this.fileName = fileName;
		}

		/**
		 * Metoda czytaj¹ca dane z pliku. Zapisywane s¹ one do ArrayListy.
		 * @return Lista ci¹gów znaków tworz¹cych plik.
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

