package projekt;
/**
 *
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Book (posiadaj�cy wymaganie na pole author). S� to pola wymagane i opcjonalne tego typu.
 *  @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Book1 extends CheckedRecord{
	
	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Book1(Record record) {
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
		required.add("publisher");
		required.add("year");
	}
	/**
	 * @see projekt.CheckedRecord#getOptional()
	 * Metoda dodaj�ca charakterystyczne dla typu pozycje do ArrayListy optional.
	 */
	@Override
	void getOptional() {
		optional.add("volume"); 
		optional.add("series");
		optional.add("address");
		optional.add("edition");
		optional.add("month"); 
		optional.add("note"); 
		optional.add("key");
	}

}
