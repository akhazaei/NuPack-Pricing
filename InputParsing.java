public class InputParsing {
 public static final int DOLLAR_AMOUNT = 0;
 public static final int WORKER_AMOUNT = 1;
 public static final int CATEGORY = 2;
 
 private static String extractCategory (String categoryInput) {
  String temp = categoryInput.toLowerCase();
  if (categoryInput == "food")
   return Project.FOOD;
  if(categoryInput == "drugs" || categoryInput == "pharmaceutical")
   return Project.PHARMA;
  if (categoryInput == "electronics")
   return Project.ELECTRONICS;
  return  Project.OTHER;
 }

 private static String extractNumWorkers (String inputWorkers){
  String temp = inputWorkers.toLowerCase().replace("people","");
  temp = temp.replace("person","");
  temp = temp.trim();
  return temp;
 }

 private static String extractDollarAmount (String inputAmount){
  String temp = inputAmount.replace("$","");
  return temp;
 }

 public static String [] extractInputs (String inputAmount, String inputTeamSize, String inputCategory) {
  String [] finalOutput = new String[3];
  finalOutput[DOLLAR_AMOUNT] = extractDollarAmount(inputAmount);
  finalOutput[WORKER_AMOUNT] = extractNumWorkers(inputTeamSize);
  finalOutput[CATEGORY] = extractCategory(inputCategory);

  return finalOutput;
   }
}