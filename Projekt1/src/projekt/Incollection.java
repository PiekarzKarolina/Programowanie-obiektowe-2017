package projekt;

/**
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Incollection. S� to pola wymagane i opcjonalne tego typu.
  * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Incollection extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Incollection(Record record) {
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
		required.add("publisher");
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
		optional.add("type"); 
		optional.add("chapter"); 
		optional.add("pages"); 
		optional.add("address");
		optional.add("edition");
		optional.add("month");
		optional.add("note"); 
		optional.add("key");
	}

}
