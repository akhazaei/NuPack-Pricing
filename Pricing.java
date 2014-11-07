import java.math.*;
import java.text.*;
import java.util.*;

public class Pricing {
  public static final String AUTOMATIC_MARKUP = "0.05";
  public static final String WORKER_MARKUP = "0.012";
  public static final String FOOD_MARKUP = "0.13";
  public static final String ELECTRONICS_MARKUP = "0.02";
  public static final String PHARMA_MARKUP = "0.075";
  public static final String ZERO = "0.00";

  public static String getDollarFormat (String amount) {
    return "$" + amount;
  }

  public static String getBasePrice (String inputAmount){
    
    BigDecimal inputPrice = new BigDecimal(inputAmount);
    BigDecimal automaticMarkup = inputPrice.multiply(new BigDecimal(AUTOMATIC_MARKUP));
   
    inputPrice = inputPrice.add(automaticMarkup);
    inputPrice = inputPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

    return inputPrice.toString();
  }

  //Class member function to calculate price adjustments
  public static void priceMarkupCalculator (Project givenProject) {

    BigDecimal basePrice = new BigDecimal(givenProject.getBasePrice ());
    BigDecimal finalCost = new BigDecimal(ZERO);
    BigDecimal workerMarkup = new BigDecimal(ZERO);
    BigDecimal categoryMarkup = new BigDecimal(ZERO);
    
    BigDecimal workerMarkupRate = new BigDecimal(WORKER_MARKUP);
    workerMarkupRate = workerMarkupRate.multiply(new BigDecimal(givenProject.getNumWorkers()));

    workerMarkup = basePrice.multiply(workerMarkupRate);

    //Apply category markups  
    String prodCategory = givenProject.getCategory();
    if (prodCategory == "FOOD"){
      categoryMarkup = basePrice.multiply(new BigDecimal(FOOD_MARKUP));
    } else if (prodCategory == "ELECTRONICS") {
      categoryMarkup = basePrice.multiply(new BigDecimal(ELECTRONICS_MARKUP));
    } else if (prodCategory == "PHARMA") {
      categoryMarkup = basePrice.multiply(new BigDecimal(PHARMA_MARKUP));
    }

    finalCost = basePrice.add(workerMarkup);
    finalCost = finalCost.add(categoryMarkup);
    finalCost = finalCost.setScale(2, BigDecimal.ROUND_HALF_UP);

    givenProject.setMarkupCost(finalCost.toString());
    givenProject.setMarkupStatus(true);
  }
}