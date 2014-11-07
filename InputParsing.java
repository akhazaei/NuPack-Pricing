public class InputParsing {
 public static final int DOLLAR_AMOUNT = 0;
 public static final int WORKER_AMOUNT = 1;
 public static final int CATEGORY = 2;
 
 /* Extracts the correct category from a given input
  * @param categoryInput - the user input of the category
  * @return - One of either four options: "FOOD", "PHARMA", "ELECTRONICS", "OTHER"
  */
 public static String extractCategory (String categoryInput) {
  String formattedCategory = categoryInput.toLowerCase();
  if (formattedCategory == "food")
   return Project.FOOD;
  if(formattedCategory == "drugs" || formattedCategory == "pharmaceutical")
   return Project.PHARMA;
  if (formattedCategory == "electronics")
   return Project.ELECTRONICS;
  return  Project.OTHER;
 }

 
 /* Extracts the correct number of workers from a given input
  * @param inputWorkers - the user input of the number of workers
  * @return - a string representation of a single integer
  */
 public static String extractNumWorkers (String inputWorkers){
  String formattedWorker = inputWorkers.toLowerCase().replace("people","");
  formattedWorker = formattedWorker.replace("person","");
  formattedWorker = formattedWorker.trim();
  
  //Throws an exception if a valid integer was not inputted
  int numWorkers;
  try {
    numWorkers = Integer.parseInt(formattedWorker);
  }
  catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Number of Workers cannot be : " + inputWorkers);
  }
  
  if (numWorkers < 0){
    throw new IllegalArgumentException("Number of Workers cannot be : " + inputWorkers);
  }
  
  return formattedWorker;
 }

 /* Extracts the correct dollar amount of a given userinput
  * @param inputAmount - the user input of the initial dollar amount
  * @return - a string representation of the dollar amount
  */
 public static String extractDollarAmount (String inputAmount){
  String formattedAmount = inputAmount.replace("$","");
  
  //Throws an exception if a valid double was not inputted
  double moneyAmount;
  try {
    moneyAmount = Float.parseFloat(formattedAmount);
  }
  catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Initial amount cannot be : " + inputAmount);
  }
  
  if (moneyAmount < 0){
    throw new IllegalArgumentException("Initial amount cannot be : " + inputAmount);
  }
  
  return formattedAmount;
 }

 /* Extracts all the inputs given by the user
  * @param inputWorkers - the user input of the initial dollar amount
  * @param inputTeamSize - the user input of the number of workers
  * @param inputCategory - the user input of the category
  * @return - an array containing all the formatted user inputs
  */
 public static String [] extractInputs (String inputAmount, String inputTeamSize, String inputCategory) {
  String [] finalOutput = new String[3];
  finalOutput[DOLLAR_AMOUNT] = extractDollarAmount(inputAmount);
  finalOutput[WORKER_AMOUNT] = extractNumWorkers(inputTeamSize);
  finalOutput[CATEGORY] = extractCategory(inputCategory);

  return finalOutput;
   }
}