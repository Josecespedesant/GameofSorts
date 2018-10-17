package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	public static String XMLpath = "test.xml";
	public static void main(String[] args) throws TransformerException, ParserConfigurationException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		
	DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	
	Document document = documentBuilder.newDocument();
	//root element 
	Element root = document.createElement("info.dragon");
	document.appendChild(root);
	
	//dragon element
	Element dragon = document.createElement("Dragon");
	root.appendChild(dragon);
	
	//Name element
	Element name = document.createElement("nombre");
	name.appendChild(document.createTextNode("Allan Brito Delgado"));
	dragon.appendChild(name);
	
	//velocidad element
	Element velocidadrecarga = document.createElement("Velocidad");
	velocidadrecarga.appendChild(document.createTextNode("4"));
	dragon.appendChild(velocidadrecarga);
	

	Element edad = document.createElement("Edad");
	edad.appendChild(document.createTextNode("1000"));
	dragon.appendChild(edad);
	

	Element clase = document.createElement("Clase");
	clase.appendChild(document.createTextNode("Comandante"));
	dragon.appendChild(clase);
	
	Element padre = document.createElement("Padre");
	padre.appendChild(document.createTextNode("null"));
	dragon.appendChild(padre);

	TransformerFactory transFactory = TransformerFactory.newInstance();
	
	Transformer trans = transFactory.newTransformer();
	DOMSource dom = new DOMSource(document);
	StreamResult streamResult = new StreamResult(new File(XMLpath));
	
	trans.transform(dom, streamResult);
	
	}

}
