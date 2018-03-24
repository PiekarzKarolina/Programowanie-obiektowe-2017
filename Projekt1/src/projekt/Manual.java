package projekt;

/**
 * W tej klasie przechowywane s¹ specyficzne dane dotycz¹ce osobnego typu jakim jest typ Article. S¹ to pola wymagane i opcjonalne tego typu.
 * @author Karolina Piekarz
 * @see CheckedRecord
 */
public class Manual extends CheckedRecord{
	/**
	 * @param record Obiekt dziedziczony z klasy nadrzêdnej. Jego dotycz¹ pola wymagane i opcjonalne.
	 * Konstruktor korzystaj¹cy z konstruktora klasy nadrzêdnej.
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
