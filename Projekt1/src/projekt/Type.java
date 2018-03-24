package projekt;


/**
 * 
 * Typ wyliczeniowy posiadaj¹cy jako wartoœci mo¿liwe typy rekordów w bazie.
 * @author Karolina Piekarz
 */
public enum Type {
		ARTICLE, 
		BOOK,
		BOOK1,
		BOOK2,
		INPROCEEDINGS, 
		PROCEEDINGS,
		BOOKLET, 
		INBOOK, 
		INBOOK1,
		INBOOK2,
		INBOOK3,
		INBOOK4,
		INCOLLECTION, 
		MANUAL, 
		MASTERTHESIS, 
		PHDTHESIS, 
		TECHREPORT, 
		MISC, 
		UNPUBLISHED,
		CONFERENCE;

	/** 
	 * @see java.lang.Enum#toString()
	 * Metoda zwracaj¹ca dla danej wartoœci typu odpowiadaj¹cy mu napis String.
	 */
	public String toString(){
        switch (name()) {
        case "ARTICLE" : return "Article";
        case "BOOK" : return "Book";
        case "BOOK1" : return "Book";
        case "BOOK2" : return "Book";
        case "INPROCEEDINGS" : return "Inproceedings";
        case "PROCEEDINGS" : return "Proceedings";
        case "BOOKLET" : return "Booklet";
        case "INBOOK" : return "Inbook";
        case "INBOOK1" : return "Inbook";
        case "INBOOK2" : return "Inbook";
        case "INBOOK3" : return "Inbook";
        case "INBOOK4" : return "Inbook";
        case "INCOLLECTION" : return "Incollection";
        case "MANUAL" : return "Manual";
        case "MASTERTHESIS" : return "Masterthesis";
        case "PHDTHESIS" : return "PhdThesis";
        case "TECHREPORT" : return "Techreport";
        case "MISC" : return "Misc";
        case "UNPUBLISHED" : return "Unpublished";
        case "CONFERENCE" : return "Conference"; 
        default : return "Error.";
        }
    }
}
