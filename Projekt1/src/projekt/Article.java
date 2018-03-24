package projekt;

/**
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Manual. S� to pola wymagane i opcjonalne tego typu.
 *@author Karolina Piekarz
 * @see CheckedRecord
 */
public class Article extends CheckedRecord {

	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Article(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see CheckedRecord#getRequired()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy required.
	 */
	@Override
	public void getRequired() {
		required.add("author");
		required.add("title");
		required.add("journal");
		required.add("year");
	}

	/**
	 * @see projekt.CheckedRecord#getOptional()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy optional.
	 */
	@Override
	public void getOptional() {
		optional.add("volume"); 
		optional.add("number"); 
		optional.add("pages"); 
		optional.add("month"); 
		optional.add("note"); 
		optional.add("key");
	}

}
