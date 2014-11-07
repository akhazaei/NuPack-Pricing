import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class InputParsingTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testExtractNormalInputs() {
    String amount = "$100.00";
    String numWorkers = "14 people";
    String category = "magazines";
    String [] expected = {"100.00","14","OTHER"};
    String [] actual = InputParsing.extractInputs (amount, numWorkers, category);
    assertArrayEquals(expected, actual);
  }
  
  public void testExtractInputsWithErrorInAmount () {
  
  }
  
  public void testExtractInputsWithErrorInCategory () {
    
  }
  
  
 // public void testExtractInputsWith
  
 /* public void testExtractWorkers() {
    //
    //
  }*/
  
}
