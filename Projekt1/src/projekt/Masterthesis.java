package projekt;

/**
 * W tej klasie przechowywane s¹ specyficzne dane dotycz¹ce osobnego typu jakim jest typ Masterthesis. S¹ to pola wymagane i opcjonalne tego typu.
  * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Masterthesis extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrzêdnej. Jego dotycz¹ pola wymagane i opcjonalne.
	 * Konstruktor korzystaj¹cy z konstruktora klasy nadrzêdnej.
	 * @see CheckedRecord
	 */
	public Masterthesis(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see CheckedRecord#getRequired()
	 * Metoda dodaj¹ca charakterystyczne dla typu pozycje do ArrayListy required.
	 */
	@Override
	void getRequired() {
		required.add("author");
		required.add("title");
		required.add("school");
		required.add("year");
	}
	/**
	 * @see projekt.CheckedRecord#getOptional()
	 * Metoda dodaj¹ca charakterystyczne dla typu pozycje do ArrayListy optional.
	 */
	@Override
	void getOptional() {
		optional.add("type"); 
		optional.add("address");
		optional.add("month");
		optional.add("note");
		optional.add("key");
	}

}
