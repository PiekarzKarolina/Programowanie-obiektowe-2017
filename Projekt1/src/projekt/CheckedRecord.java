package projekt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa abstrakcyjna odpowiedzialan za sprawdzenie czy rekord posiada odpowiednie pola.
 *  @author Karolina Piekarz
 */
public abstract class CheckedRecord {
		
	  /**
	 * Lista p�l wymaganych w rekordzie.
	 */
	protected ArrayList<String> required = new ArrayList<String>();
      /**
     * Abstrakcyjna metoda wype�niaj�ca list� required pozycjami.
     */
    abstract void getRequired();  

      /**
     * Lista p�l opcjonalnych w rekordzie.
     */
    protected ArrayList<String> optional = new ArrayList<String>();
      /**
     *  Abstrakcyjna metoda wype�niaj�ca list� optional pozycjami.
     */
    abstract void getOptional(); 
      
      /**
     * Przetwarzany rekord.
     */
    private Record record;

      /**
     * @return Zwraca przetwarzany rekord.
     */
    public Record getRecord() {
    	  return record;
      }
      
      /**
     * @param record Przetwarzany rekord.
     */
    public void setRecord(Record record) {
    	  this.record = record;
      }                         

      /**
       * Tworzy obiekt klasy CheckedRecord
     * @param record Przetwarzany rekord.
     */
    public CheckedRecord(Record record) {
		this.record = record;
	}

	/**
	 * Metoda sprawdzaj�ca czy wszystkie pola wymagane istniej� w rekordzie oraz usu�waj�ca wszytkie pola nie zawarte w li�cie p�l wymaganych oraz opcjonalnych.
	 * @see Record
	 */
	public void checkAndSet(){ 
    	  HashMap<String, String> fields = record.getFields();
    	  HashMap<String, String> fields2 = new HashMap<String, String>();
    	  try {
    	  if(required!=null) {
    		  for(String s: required) {
    			  if(fields.get(s)==null)  throw new NonExistentRequiredFieldsException();
    		  }
	    	  for(String s: required) {
	    		  fields2.put(s, fields.get(s));
	    	  }
    	  }
    	  }
    	  catch (NonExistentRequiredFieldsException e) {
    		  System.err.println("Record " + record.getType().toString() + " "+ record.getKey() + " does not have all required fields.");
    		  e.printStackTrace();
    		  System.exit(1);
    	  }
    	  for(String s: optional) {
    		  if(fields.get(s)!=null) fields2.put(s, fields.get(s));
    	  }
    	  record.setFields(fields2);
      }
      
      
}
