package projekt;
/**
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Conference. S� to pola wymagane i opcjonalne tego typu.
 * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Conference extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Conference(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see CheckedRecord#getRequired()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy required.
	 */
	@Override
	void getRequired() {
		required.add("author"); 
		required.add("title"); 
		required.add("booktitle"); 
		required.add("year");
	}
	/**
	 * @see projekt.CheckedRecord#getOptional()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy optional.
	 */
	@Override
	void getOptional() {
		optional.add("editor");
		optional.add("volume");
		optional.add("number"); 
		optional.add("series"); 
		optional.add("pages");
		optional.add("month"); 
		optional.add("organization"); 
		optional.add("publisher"); 
		optional.add("note"); 
		optional.add("key");
	}

}