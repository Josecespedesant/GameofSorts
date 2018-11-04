package xmlmanager;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

public class XMLTest {
	Parse parse=new Parse();
	
//	comprueba que la excepcion sea lanzada
	@Test (expected=FileNotFoundException.class)
	public void LeerXMLTest() throws JDOMException, IOException{
		Document doc=new Document();
		SAXBuilder builder = new SAXBuilder();
		doc=builder.build(new File("/GameofSorts/pruebaArchivo.xml"));
		Parse.leerXML(doc);
	}

}
