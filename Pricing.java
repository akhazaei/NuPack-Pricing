import java.math.*;

/* Author: Arash Khazaei
 * Description: The Pricing class contains member data and member function that pertain to financial analysis
 */ 
public class Pricing {
  public static final String AUTOMATIC_MARKUP = "0.05";
  public static final String WORKER_MARKUP = "0.012";
  public static final String FOOD_MARKUP = "0.13";
  public static final String ELECTRONICS_MARKUP = "0.02";
  public static final String PHARMA_MARKUP = "0.075";
  public static final String ZERO = "0.00";
  public static final int SUCCESS_MARKUP = 0;
  public static final int FAIL_MARKUP = -1;

  /* Returns the dollar amount with dollar format modification
   * @param amount - the dollar amount without a '$' sign
   * @retun - the amount with a '$'
   */
  public static String getDollarFormat (String amount) {
    return "$" + amount;
  }

  /* Returns calculated base price given an initial amount
   * Base price is determined by the input amount with the 5% automatic markup
   * @param inputAmount - the dollar amount prior to the initial markup
   * @retun - the calculated base price
   */
  public static String getBasePrice (String inputAmount){
    
    BigDecimal inputPrice = new BigDecimal(inputAmount);
    BigDecimal automaticMarkup = inputPrice.multiply(new BigDecimal(AUTOMATIC_MARKUP));
   
    inputPrice = inputPrice.add(automaticMarkup);
    inputPrice = inputPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

    return inputPrice.toString();
  }

  /* Calculates all the necissary markups of a given Project
   * It calculates the Worker Markups and Category Markups if applicable
   * @param givenProject - the input project that needs to have markups applied to! 
   * @return - either FAIL_MARKUP meaning no markups were applied or SUCCESS_MARKUP meaning markups applied
   */
  public static int priceMarkupCalculator (Project givenProject) {
    if (givenProject == null)
      return FAIL_MARKUP;
    if (givenProject.areMarkupsApplied() == true)
      return FAIL_MARKUP;
    
    BigDecimal basePrice = new BigDecimal(givenProject.getBasePrice ());
    BigDecimal finalCost = new BigDecimal(ZERO);
    BigDecimal workerMarkup = new BigDecimal(ZERO);
    BigDecimal categoryMarkup = new BigDecimal(ZERO);
    
    //Calculate worker markups
    BigDecimal workerMarkupRate = new BigDecimal(WORKER_MARKUP);
    workerMarkupRate = workerMarkupRate.multiply(new BigDecimal(givenProject.getNumWorkers()));

    workerMarkup = basePrice.multiply(workerMarkupRate);

    //Calculate category markups  
    String prodCategory = givenProject.getCategory();
    if (prodCategory == "FOOD"){
      categoryMarkup = basePrice.multiply(new BigDecimal(FOOD_MARKUP));
    } else if (prodCategory == "ELECTRONICS") {
      categoryMarkup = basePrice.multiply(new BigDecimal(ELECTRONICS_MARKUP));
    } else if (prodCategory == "PHARMA") {
      categoryMarkup = basePrice.multiply(new BigDecimal(PHARMA_MARKUP));
    }

    //Cacluate total markup cost
    finalCost = basePrice.add(workerMarkup);
    finalCost = finalCost.add(categoryMarkup);
    finalCost = finalCost.setScale(2, BigDecimal.ROUND_HALF_UP);

    givenProject.setMarkupCost(finalCost.toString());
    givenProject.setMarkupStatus(true);
    
    return SUCCESS_MARKUP;
  }
}