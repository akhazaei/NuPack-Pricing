import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class SalesRepToolsTest extends TestCase {
  
  
  public void testInput1() {
    //Testing the given Input1 Conditions
    String expected = "$1591.58";
    String actual = SalesRepTools.getEstimate("$1299.99","3 people", "food");
    assertEquals (expected, actual);
  }
  
  public void testInput2() {
    //Testing the given Input2 Conditions
    String expected = "$6199.81";
    String actual = SalesRepTools.getEstimate("$5432.00","1 person", "drugs");
    assertEquals (expected, actual);
  }
    
  public void testInput3() {
    //Testing the given Input3 Conditions
    String expected = "$13707.63";
    String actual = SalesRepTools.getEstimate("$12456.95","4 people", "books");
    assertEquals (expected, actual);
  }
  
   public void testInputZeroDollars() {
    //Testing the given Zero Dollar Conditions
    String expected = "$0.00";
    String actual = SalesRepTools.getEstimate("$0.00","4 people", "electronics");
    assertEquals (expected, actual);
  }
   
  public void testInputZeroWorkers() {
    //Testing the Input1 conditions with Zero Workers
    String expected = "$1542.44";
    String actual = SalesRepTools.getEstimate("$1299.99","0 people", "food");
    assertEquals (expected, actual);
  }
   
  public void testInputWithPharmaceuticals() {
    //Testing the given Input2 Conditions with the category pharmaceutical instead of drugs
    String expected = "$6199.81";
    String actual = SalesRepTools.getEstimate("$5432.00","1 person", "pharmaceutical");
    assertEquals (expected, actual);
  }
  
  public void testInputWithLargeDollarAmount () {
   //Testing the input with a dollar figure
    String expected = "$113400.00";
    String actual = SalesRepTools.getEstimate("$100000.00","5 people", "electronics");
    assertEquals (expected, actual);
  }
  

    
}
