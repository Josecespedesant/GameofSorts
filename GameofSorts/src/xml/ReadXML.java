package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File xmlFIle = new File("test.xml");
		
		DocumentBuilderFactory documentbuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentbuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFIle);
		
		NodeList list = document.getElementsByTagName("info.dragon");
		
		for(int i = 0; i < list.getLength(); i++){
			Node node = list.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE){
				Element element = (Element) node;
				
				System.out.println(element.getAttribute("id"));
				System.out.println(element.getElementsByTagName("nombre").item(0).getTextContent());
				
				System.out.println(element.getElementsByTagName("Velocidad").item(0).getTextContent());


				System.out.println(element.getElementsByTagName("Edad").item(0).getTextContent());

				System.out.println(element.getElementsByTagName("Clase").item(0).getTextContent());

				

				System.out.println(element.getElementsByTagName("Padre").item(0).getTextContent());
			}
		}
		
	}
}
