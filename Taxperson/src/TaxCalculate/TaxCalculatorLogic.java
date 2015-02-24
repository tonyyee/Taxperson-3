package TaxCalculate;

/*
 This class has the logic to calculate the tax as below:
 1. The test class calls the method in this class with item code as a parameter.
 2. The ItemDetails.xml file is iterated though each node to get the item details (i.e. item cost and item type - necessity or luxury)
 3. Depending upin the item type, the tax is calculated and returned to the test class for assertions.
 */

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class TaxCalculatorLogic extends XMLDataFile{

	NodeList nodeList; 
	
	public Double calculateItemCostAfterTax(String enteredItemCode) 
	{	
		
		//Retrieve all the nodes from ItemDetails.xml and store it in nodeList.
		nodeList = document.getElementsByTagName("item");
				
		//Iterate through the nodeList to get the node whoch matched the item code.
		for(int index=0;index<nodeList.getLength();index++)
		{
		Node node=nodeList.item(index);
		String codeNum = ((Element) node).getAttribute("code");
		
		//Compare each node for the item code.
		if(enteredItemCode.equalsIgnoreCase(codeNum))
			{
			//If comparison is true, get the itemType and cost before taxes of that item from the node.
			String taxType = ((Element) node).getElementsByTagName("itemType").item(0).getTextContent();
			Double costBeforeTax = Double.parseDouble(((Element) node).getElementsByTagName("itemCost").item(0).getTextContent());
			
			Double costAfterTax= 0.0;
			
			//Compare if the item is a luxury 'L' or a necessity 'N' and calculate tax accordingly.
			if(taxType.equals("N"))
				{
				costAfterTax = (costBeforeTax*0.01)+costBeforeTax;
				System.out.println("Item Id is: "+codeNum);
				System.out.println("Item name is: "+((Element) node).getElementsByTagName("itemName").item(0).getTextContent());
				System.out.println("Item is a necessity item.");
				System.out.println("Item cost before tax (in cents): "+costBeforeTax);
				System.out.println("Item cost after tax (in cents): "+costAfterTax);
				return costAfterTax;
				}
				else if(taxType.equals("L"))
				{
				costAfterTax = (costBeforeTax*0.09)+costBeforeTax;
				System.out.println("Item Id is: "+codeNum);
				System.out.println("Item name is: "+((Element) node).getElementsByTagName("itemName").item(0).getTextContent());
				System.out.println("Item is a luxury item.");
				System.out.println("Item cost before tax (in cents): "+costBeforeTax);
				System.out.println("Item cost after tax (in cents): "+costAfterTax);
				return costAfterTax;
				}
				
			}
		
		}
		//If there is no match with any of the items in the ItemDetails.xml, return 0.0 to the test method
		return 0.0;
	}

}
	
	

	
	

