/* Author: Arash Khazaei
 * Description: The SalesRepTools class contains functionality that can be used by sales representatives
 */ 
public class SalesRepTools {

  /* Calculates an estimate based on the inputs a representative would enter
   * @param inputPrice - the user input for the initial price of the product
   * @param inputTeamSize - the user input for the number of people required
   * @param inputCategory - the user input for the category of the product
   * @return - The calculated dollar cost of the estimated costs
   */
 public static String getEstimate (String inputPrice, String inputTeamSize, String inputCategory) {
  String [] parsedInputs = InputParsing.extractInputs(inputPrice,inputTeamSize, inputCategory);
  
  String basePrice = Pricing.getBasePrice(parsedInputs[InputParsing.DOLLAR_AMOUNT]);
  String numWorkers = parsedInputs[InputParsing.WORKER_AMOUNT];
  String projectCategory = parsedInputs[InputParsing.CATEGORY];

  Project potentialProject = new Project(basePrice, numWorkers, projectCategory);
  
  Pricing.priceMarkupCalculator(potentialProject);

  return Pricing.getDollarFormat(potentialProject.getMarkupPrice());
 }
 
}