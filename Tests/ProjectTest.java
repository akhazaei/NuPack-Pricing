import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ProjectTest extends TestCase {
  
  
  public void testSettingBase() {
    //Simple test to see if the final price can be modified
    Project testProject = new Project ("100.00", "5", Project.FOOD);
    
    String actual = "100.00";
    testProject.setBasePrice(actual);
    String expected = testProject.getBasePrice();
    assertEquals (expected, actual);
    
  }
  
  public void testSettingFinalPrice() {
    //Simple test to see if the final price can be modified
    Project testProject = new Project ("100.00", "5", Project.FOOD);

    String actual = "150.00";
    testProject.setMarkupCost(actual);
    String expected = testProject.getMarkupPrice();
    assertEquals (expected, actual);
    
  }
  
 
}
