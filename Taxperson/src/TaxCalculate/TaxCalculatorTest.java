
package TaxCalculate;

/*This is a test class. This class has methods to assert that the tax calculated for various items from 
 ItemDetails.xml is as expected or not depending upon its type. */



import org.testng.Assert;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.*;
import org.xml.sax.SAXException;

@Test
public class TaxCalculatorTest extends TaxCalculatorLogic{
	
	Double itemCostAfterTax;
	
//This method tests that tax for item 0001 which is a necessity item is calculated on 1%.
public void testNecessaryItemCorrectTax() throws ParserConfigurationException, SAXException, IOException
	{
		itemCostAfterTax = calculateItemCostAfterTax("0001");
		Assert.assertTrue(itemCostAfterTax ==352.49 ,"The tax calculated is wrong for the necessity item ");
	}


//This method tests that tax for item 0001 which is a necessity item is not calculated on 1%.
public void testNecessaryItemWrongTax() throws ParserConfigurationException, SAXException, IOException
{
	itemCostAfterTax = calculateItemCostAfterTax("0001");
	Assert.assertTrue(itemCostAfterTax ==35 ,"The tax calculated is wrong for the necessity item ");
}


//This method tests that tax for item 0003 which is a luxury item is calculated on 9%.
public void testLuxuryItemCorrectTax() throws ParserConfigurationException, SAXException, IOException
	{
	itemCostAfterTax =	calculateItemCostAfterTax("0003");
	Assert.assertTrue(itemCostAfterTax == 27250.0 ,"The tax calculated is wrong for the luxury item ");
	}

//This method tests that tax for item 0003 which is a luxury item is not calculated on 9%.
public void testLuxuryItemWrongTax() throws ParserConfigurationException, SAXException, IOException
{
itemCostAfterTax =	calculateItemCostAfterTax("0003");
Assert.assertTrue(itemCostAfterTax == 352.49 ,"The tax calculated is wrong for the luxury item ");
}


//This method tests that item was not found in the data file.
public void itemNotFound() throws ParserConfigurationException, SAXException, IOException
	{
	itemCostAfterTax = calculateItemCostAfterTax("0004");
	Assert.assertTrue(itemCostAfterTax != 0.0, "The item is invalid.");
	}
			
//This method tests that item valid but the cost of item is zero.
public void itemValidWrongTax() throws ParserConfigurationException, SAXException, IOException
{
itemCostAfterTax = calculateItemCostAfterTax("0002");
Assert.assertTrue(itemCostAfterTax != 0.0, "The item is valid but tax not calculated correctly.");
}


}
