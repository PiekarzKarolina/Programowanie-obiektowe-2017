package projekt;
/**
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Proceedings. S� to pola wymagane i opcjonalne tego typu.
 * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Proceedings extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Proceedings(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see CheckedRecord#getRequired()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy required.
	 */
	@Override
	void getRequired() {
		required.add("title"); 
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
		optional.add("address");
		optional.add("month"); 
		optional.add("organization"); 
		optional.add("publisher"); 
		optional.add("note"); 
		optional.add("key");
	}

}
