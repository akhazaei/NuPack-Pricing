import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PricingTest extends TestCase {
  
  public void testGetBasePriceInput1 () {
    //Test if the correct base price was calculated with Input1
    String inputAmount = "1299.99";
    String expected = "1364.99";
    String actual = Pricing.getBasePrice (inputAmount);
    assertEquals (expected, actual);
  }
  
    public void testGetBasePriceInput2 () {
    //Test if the correct base price was calculated with Input2
    String inputAmount = "5432.00";
    String expected = "5703.60";
    String actual = Pricing.getBasePrice (inputAmount);
    assertEquals (expected, actual);
  }
    
  public void testGetBasePriceInput3 () {
    //Test if the correct base price was calculated with Input3
    String inputAmount = "12456.95";
    String expected = "13079.80";
    String actual = Pricing.getBasePrice (inputAmount);
    assertEquals (expected, actual);
  }
    
  public void testMarkupCalculatorCorrectInput1 () {
    //Testing the markup calculator with the given input1
    String expected = "1591.58";
    Project inputProject = new Project("1364.99", "3",Project.FOOD);
    Pricing.priceMarkupCalculator (inputProject);
    String actual = inputProject.getMarkupPrice();
    assertEquals (expected, actual);
  }
  
  public void testMarkupCalculatorCorrectInput2 () {
    //Testing the markup calculator with the given input2
    String expected = "6199.81";
    Project inputProject = new Project("5703.60", "1",Project.PHARMA);
    Pricing.priceMarkupCalculator (inputProject);
    String actual = inputProject.getMarkupPrice();
    assertEquals (expected, actual);
  }
  
  public void testMarkupCalculatorCorrectInput3 () {
    //Testing the markup calculator with the given input3
    String expected = "13707.63";
    Project inputProject = new Project("13079.80", "4",Project.OTHER);
    Pricing.priceMarkupCalculator (inputProject);
    String actual = inputProject.getMarkupPrice();
    assertEquals (expected, actual);
  }
  
  public void testMarkupCalculatorNormalInputs () {
    //Testing the markup calculator with a new input that undergo the normal conditions
    String expected = "12369.00";
    Project inputProject = new Project("10500", "4",Project.FOOD);
    Pricing.priceMarkupCalculator (inputProject);
    String actual = inputProject.getMarkupPrice();
    assertEquals (expected, actual);
  }
  
  public void testMarkupCalculatorNormalInputsElectronics () {
    //Testing the markup calculator with a new input that is in the electronics sector
    String expected = "1.12";
    Project inputProject = new Project("1.05", "4",Project.ELECTRONICS);
    Pricing.priceMarkupCalculator (inputProject);
    String actual = inputProject.getMarkupPrice();
    assertEquals (expected, actual);
  }
  
  public void testMarkupCalculatorBadProject () {
    //Testing the markup calculator with a bad project input
    Project badProject = null;
    int expected = -1;
    int actual = Pricing.priceMarkupCalculator(badProject);
    assertEquals (expected, actual);
  }
  
}
