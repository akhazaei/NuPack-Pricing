public class SalesRepTools {

 public static String getEstimate (String inputPrice, String inputTeamSize, String inputCategory) {
  String [] parsedInputs = InputParsing.extractInputs(inputPrice,inputTeamSize, inputCategory);
  
  String basePrice = Pricing.getBasePrice(parsedInputs[InputParsing.DOLLAR_AMOUNT]);
  String numWorkers = parsedInputs[InputParsing.WORKER_AMOUNT];
  String projectCategory = parsedInputs[InputParsing.CATEGORY];

  Project potentialProject = new Project(basePrice, numWorkers, projectCategory);
  
  Pricing.priceMarkupCalculator(potentialProject);

  return Pricing.getDollarFormat(potentialProject.getMarkupPrice());
 }


 public static void main(String [ ] args){
  System.out.println (getEstimate("$1299.99","3 people", "food"));
  System.out.println (getEstimate("$5432.00","1 person", "drugs"));
  System.out.println (getEstimate("$12456.95","4 people", "books"));
 }

}