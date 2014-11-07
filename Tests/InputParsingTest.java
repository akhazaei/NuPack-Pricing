import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class InputParsingTest extends TestCase {
  

  public void testExtractInput1 () {
    //Test with the given input1
    String amount = "$100.00";
    String numWorkers = "14 people";
    String category = "magazines";
    String [] expected = {"100.00","14","OTHER"};
    String [] actual = InputParsing.extractInputs (amount, numWorkers, category);
    assertArrayEquals(expected, actual);
  }
  
  public void testExtractInput2 () {
    //Test with the given input2
    String amount = "$100.00";
    String numWorkers = "14 people";
    String category = "magazines";
    String [] expected = {"100.00","14","OTHER"};
    String [] actual = InputParsing.extractInputs (amount, numWorkers, category);
    assertArrayEquals(expected, actual);
  }
  
  public void testExtractInput3 () {
    //Test with the given input3
    String amount = "$100.00";
    String numWorkers = "14 people";
    String category = "magazines";
    String [] expected = {"100.00","14","OTHER"};
    String [] actual = InputParsing.extractInputs (amount, numWorkers, category);
    assertArrayEquals(expected, actual);
  }
  
  public void testExtractNormalInputs() {
    //Test with normal correct inputs 
    String amount = "$100.00";
    String numWorkers = "14 people";
    String category = "magazines";
    String [] expected = {"100.00","14","OTHER"};
    String [] actual = InputParsing.extractInputs (amount, numWorkers, category);
    assertArrayEquals(expected, actual);
  }
  
    public void testExtractCategoryOther () {
    //Test to see if OTHER category is returned
    String category = "pencils";
    String expected = "OTHER";
    String actual = InputParsing.extractCategory (category);
    assertEquals(expected, actual);
  }
  
  public void testExtractDollarAmountWithNegativeAmount () {
    //Test with negative input dollar amount
    String amount = "$-100.00";
    String actual;
    try {
        actual = InputParsing.extractDollarAmount (amount);
        fail( "Missing exception" );
    } catch( IllegalArgumentException e ) {
      assertEquals( "Initial amount cannot be : "+amount, e.getMessage() ); 
    }
  }
  
  public void testExtractDollarAmountWithIllegalAmount () {
    //Test with an illegal input dollar amount
    String amount = "$-1ARASH0.00";
    String actual;
    try {
        actual = InputParsing.extractDollarAmount (amount);
        fail( "Missing exception" );
    } catch( IllegalArgumentException e ) {
      assertEquals( "Initial amount cannot be : "+amount, e.getMessage() ); 
    }
  }
  
 
  public void testExtractNumWorkersWithNegativeWorkers () {
    //Test with negative amount of workers
    String numWorkers = "-5 people";
    String actual;
    try {
        actual = InputParsing.extractNumWorkers (numWorkers);
        fail( "Missing exception" );
    } catch( IllegalArgumentException e ) {
      assertEquals("Number of Workers cannot be : " + numWorkers, e.getMessage() ); 
    }
  }
   
  public void testExtractNumWorkersWithIllegaleNumWorkers () {
    //Test with illegal amount of workers
    String numWorkers = "2ARASH4 people";
    String actual;
    try {
      actual = InputParsing.extractNumWorkers (numWorkers);
      fail( "Missing exception" );
    } catch( IllegalArgumentException e ) {
      assertEquals("Number of Workers cannot be : " + numWorkers, e.getMessage() ); 
    }
  }
  
}
