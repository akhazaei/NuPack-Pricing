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

  public Project (String _basePrice, String _numWorkers, String _category) {
    basePrice = _basePrice;
    numWorkers = _numWorkers;
    category = _category;
    markupStatus = false;
    markupPrice = "0.00";
  }

  
  public String getBasePrice (){
    return basePrice;
  }

  public String getMarkupPrice() {
    return markupPrice;
  }

  public String getNumWorkers () {
    return numWorkers;
  }

  public String getCategory() {
    return category;
  }

  public boolean areMarkupsApplied (){ 
    return markupStatus;
  }

  public void setMarkupStatus (boolean status) {
    markupStatus = status;
  }
  
  public void setBasePrice (String value){
    basePrice = value;
  }

  public void setMarkupCost(String value){
    markupPrice = value;
  }

}
