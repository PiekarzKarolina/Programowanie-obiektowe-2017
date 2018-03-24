package projekt;

/**
 *
 * Klasa tworz�ca dla danego rekordu klas� dziedzicz�c� z abstrakcyjnej klasy CheckedRecord, po to by mo�na by�o sprawdzi� poprawno�� argument�w opcjonalnych i obowi�zkowych.
 * @author Karolina Piekarz
 */
public class GetRecordType {
    /**
     * Metoda tworz�ca now� klas� dziedzicz�c� z abstrakcyjnej klasy CheckedRecord.
     * @param record Rekord, dla kt�rego ma zosta� stworzona klasa.
     * @return Nowa klasa dziedzicz�ca z klasy CheckedRecord pozwalaj�ca na przypisanie do rekordu p�l obowi�zkowych i opcjonalnych.
     * @throws NonExistentRecordTypeException Wyj�tek gdy podany typ nie gadza si� z okre�lonymi.
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
