package TaxCalculate;

/* This class has a method that reads the ItemDetails.xml which has all the information related to the items and
 parse that xml file into a document that can be iterated on each node.*/



import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLDataFile {
 
	File dataXmlFile;
	DocumentBuilderFactory documentBuilderFactory;
	DocumentBuilder documentBuilder;
	protected Document document;
	
  @BeforeTest
  public void beforeTest()throws ParserConfigurationException, SAXException, IOException {
	  
	  	dataXmlFile = new File(Paths.get("ItemDetails.xml").toAbsolutePath().toString());
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.parse(dataXmlFile);
				
  }

}
