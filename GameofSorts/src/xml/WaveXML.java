package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entities.Dragon;
import entities.DragonFactory;
import entities.DragonFactoryMethod;
import linkedlist.SimpleLinkedList;

public class WaveXML {
	
	private String XMLArchivo="DragonWave.xml";
	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;
	private String XMLFile="DragonWave.xml";
	static SimpleLinkedList<Dragon> dragonsArray;
	Dragon[] dragones;
	
	
	public WaveXML(int waveSize) throws ParserConfigurationException, TransformerException{
		dragones = new Dragon[waveSize];
		DragonFactoryMethod factory = new DragonFactory();
		int y=0;
		int x=0;
		for(int i=0;i<waveSize;i++) {
			if(i<1) {
				dragones[i]=factory.createDragon(1, 3, "Comandant", null, 3,1400,400);
			}else if(i>=1 && i<5) {
				
				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1500, 320+y);
				y+=50;
				
			}else if(i>=5 && i<10) {
				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1600+x, 0+y);
				y+=100;
				if(x>=6)
					x=100;
			}else if(i>=10 && i<12) {
				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1700, -350+y);
				y+=100;
			}else if(i>=12 && i<14) {
				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1800, -600+y);
				y+=200;
			}else if(i>=14 && i<17) {
				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1900, -1050+y);
				y+=150;
			}else if(i>=17 && i<20) {
				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,2000, -1600+y);
				y+=250;
			}
		}
			
		
		dragonsArray = new SimpleLinkedList<>();
		
		for(Dragon dragon : this.dragones) {
			dragonsArray.addLast(dragon);
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		
//	     Aqui se ha serializado la oleada con su contenido
		Element oleadaSerializada = this.serializar(doc);
		Assert.assertNotNull(oleadaSerializada);
		
		doc.appendChild(oleadaSerializada);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivoDestino = new File(this.XMLArchivo);
		StreamResult result = new StreamResult(archivoDestino);
		transformer.transform(source, result);
		
		File archivo = new File(this.XMLArchivo);
		Assert.assertTrue(archivo.exists());
	}
	
//	serializa lo que hay en el array llamado dragones
	public Element serializar(Document doc) {
		Element elementoOleada = doc.createElement("Oleada");
		elementoOleada.setAttribute("nombre", "WAVE");
		Element elementoDragones = doc.createElement("Dragones");
		elementoOleada.appendChild(elementoDragones);
		for (Dragon dragon : this.dragones) { //aqui se especifica el array a serializar
			elementoDragones.appendChild(dragon.serializar(doc));
		}
		return elementoOleada;
	}
	
	public static SimpleLinkedList<Dragon> getdragonsArray() {
		return dragonsArray;
	}
	
	
}
