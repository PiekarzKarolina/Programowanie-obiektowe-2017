package projekt;

/**
 * 
 * Korzysta ze wszystkich potrzebnych klas, na podstawie nazwy pliku tworzy baz� rekord�w.
 * @author Karolina Piekarz
 */
public class BaseGenerator {
		/**
		 * Nazwa pliku, kt�ry ma zostac odczytany.
		 */
		private String fileName;
		
		/**
		 * @return Zwraca nazw� pliku.
		 */
		public String getFileName() {
			return fileName;
		}

		/**
		 * @param fileName Nazwa pliku, kt�ry ma zosta� przetworzony.
		 */
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		/**
		 * Tworzy obiekt klasy BaseGenerator.
		 * @param fileName Nazwa pliku, kt�ry ma zosta� przetworzony.
		 */
		public BaseGenerator(String fileName) {
			this.fileName = fileName;
		}

		/**
		 * Parsuje plik, tworz�c z niego prawid�ow� baz� rekord�w.
		 * @return Przetworzona baza rekord�w, ka�dy rekord jest sprawdzony pod k�tem poprawno�ci.
		 * @see FileRead
		 * @see FileCleaner
		 * @see FileCleanFromStrings
		 * @see FileStringAccumulator
		 * @see CleanBibTexFile
		 * @see Parser#parse()
		 * @see Base
		 * @see GetRecordType#getType(Record)
		 * @see CheckedRecord
		 */
		public Base generate(){
			FileRead file = new FileRead(fileName);
			FileCleaner file2 = new FileCleaner(file);
			FileCleanFromStrings file3 = new FileCleanFromStrings(file2);
			FileStringAccumulator file4 = new FileStringAccumulator(file2);
			CleanBibTexFile file5 = new CleanBibTexFile(file4 ,file3);
			Parser file6 = new Parser(file5);
			Base base = file6.parse();
			try {
			for(Record record : base.getBase().values()) {
				GetRecordType file7 = new GetRecordType();
				CheckedRecord file8 = file7.getType(record);
				file8.getRequired();
				file8.getOptional();
				file8.checkAndSet();
			}
			}
			catch(NonExistentRecordTypeException e) {
				System.err.println("That record type does not exist.");
				e.printStackTrace();
				System.exit(1);
			}
			return base;
		}
}
