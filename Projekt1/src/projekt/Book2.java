package projekt;
/**
 * W tej klasie przechowywane s¹ specyficzne dane dotycz¹ce osobnego typu jakim jest typ Book (posiadaj¹cy wymaganie napole editor). S¹ to pola wymagane i opcjonalne tego typu.
  * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Book2 extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrzêdnej. Jego dotycz¹ pola wymagane i opcjonalne.
	 * Konstruktor korzystaj¹cy z konstruktora klasy nadrzêdnej.
	 * @see CheckedRecord
	 */
	public Book2(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see CheckedRecord#getRequired()
	 * Metoda dodaj¹ca charakterystyczne dla typu pozycje do ArrayListy required.
	 */
	@Override
	void getRequired() {
		required.add("editor");  
		required.add("title"); 
		required.add("publisher");
		required.add("year");
	}
	/**
	 * @see projekt.CheckedRecord#getOptional()
	 * Metoda dodaj¹ca charakterystyczne dla typu pozycje do ArrayListy optional.
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