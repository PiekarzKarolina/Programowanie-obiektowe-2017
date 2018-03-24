package projekt;

/**
 * W tej klasie przechowywane s� specyficzne dane dotycz�ce osobnego typu jakim jest typ Article. S� to pola wymagane i opcjonalne tego typu.
 * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Manual extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrz�dnej. Jego dotycz� pola wymagane i opcjonalne.
	 * Konstruktor korzystaj�cy z konstruktora klasy nadrz�dnej.
	 * @see CheckedRecord
	 */
	public Manual(Record record) {
		super(record);
		// TODO Auto-generated constructor stub
	}

	@Override
	void getRequired() {
		required.add("title");
	}

	@Override
	void getOptional() {
		optional.add("author"); 
		optional.add("organization"); 
		optional.add("address");
		optional.add("edition"); 
		optional.add("month"); 
		optional.add("year"); 
		optional.add("note"); 
		optional.add("key");
	}

}
