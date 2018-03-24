package projekt;

/**
 *
 * Klasa tworz¹ca dla danego rekordu klasê dziedzicz¹c¹ z abstrakcyjnej klasy CheckedRecord, po to by mo¿na by³o sprawdziæ poprawnoœæ argumentów opcjonalnych i obowi¹zkowych.
 * @author Karolina Piekarz
 */
public class GetRecordType {
    /**
     * Metoda tworz¹ca now¹ klasê dziedzicz¹c¹ z abstrakcyjnej klasy CheckedRecord.
     * @param record Rekord, dla którego ma zostaæ stworzona klasa.
     * @return Nowa klasa dziedzicz¹ca z klasy CheckedRecord pozwalaj¹ca na przypisanie do rekordu pól obowi¹zkowych i opcjonalnych.
     * @throws NonExistentRecordTypeException Wyj¹tek gdy podany typ nie gadza siê z okreœlonymi.
     * @see CheckedRecord
     * @see Article
     * @see Book1
     * @see Book2
     * @see Inproceedings
     * @see Proceedings
     * @see Booklet
     * @see Inbook1
     * @see Inbook2
     * @see Inbook3
     * @see Inbook4
     * @see Incollection
     * @see Manual
     * @see Masterthesis
     * @see Phdthesis
     * @see Techreport
     * @see Misc
     * @see Unpublished
     * @see Conference 
     */
    public CheckedRecord getType(Record record) throws NonExistentRecordTypeException{  
    	 switch (record.getType()) {
         case ARTICLE : return new Article(record);
         case BOOK1 : return new Book1(record);
         case BOOK2 : return new Book2(record);
         case INPROCEEDINGS : return new Inproceedings(record);
         case PROCEEDINGS : return new Proceedings(record);
         case BOOKLET : return new Booklet(record);
         case INBOOK1 : return new Inbook1(record);
         case INBOOK2 : return new Inbook2(record);
         case INBOOK3 : return new Inbook3(record);
         case INBOOK4 : return new Inbook4(record);
         case INCOLLECTION : return new Incollection(record);
         case MANUAL : return new Manual(record);
         case MASTERTHESIS : return new Masterthesis(record);
         case PHDTHESIS : return new Phdthesis(record);
         case TECHREPORT : return new Techreport(record);
         case MISC : return new Misc(record);
         case UNPUBLISHED : return new Unpublished(record);
         case CONFERENCE : return new Conference(record); 
         default : throw new NonExistentRecordTypeException();
         } 
}  
}
