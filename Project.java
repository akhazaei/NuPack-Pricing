/* Author: Arash Khazaei
 * Description: The Project class can be utilized to save project information
 */ 
public class Project {
  public static final String FOOD = "FOOD";
  public static final String ELECTRONICS = "ELECTRONICS";
  public static final String PHARMA = "PHARMA";
  public static final String OTHER = "OTHER";


  private String basePrice;
  private String markupPrice;
  private String numWorkers; 
  private String category;
  private boolean markupStatus;

  /* Project Class Constructor
   * @param _basePrice - the input base price of the project
   * @param _numWorkers - the input number of workers 
   * @param -category - the input category
   */
  public Project (String _basePrice, String _numWorkers, String _category) {
    basePrice = _basePrice;
    numWorkers = _numWorkers;
    category = _category;
    markupStatus = false;
    markupPrice = "0.00";
  }

  /* Gets the base price of the project
   * @return - the base price of the project
   */
  public String getBasePrice (){
    return basePrice;
  }

  /* Gets the final marked-up price of the project
   * @return - the marked-up price of the project
   */
  public String getMarkupPrice() {
    return markupPrice;
  }

  /* Gets the number of the workers in the project
   * @return - the number of workers as a string
   */
  public String getNumWorkers () {
    return numWorkers;
  }

  /* Gets the category title of the project
   * @return - the category title of the project
   */
  public String getCategory() {
    return category;
  }

  /* determines whether all the markups are applied
   * @return - the markup status
   */
  public boolean areMarkupsApplied (){ 
    return markupStatus;
  }

  /* sets whether or not markups have all been set
   */
  public void setMarkupStatus (boolean status) {
    markupStatus = status;
  }
  
  /* Sets the base price of the project
   */
  public void setBasePrice (String value){
    basePrice = value;
  }

  /* Sets the final marked-up price of the project
   */
  public void setMarkupCost(String value){
    markupPrice = value;
  }

}
