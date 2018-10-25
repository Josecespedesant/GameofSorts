//
//package xml;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//
//import entities.Dragon;
//import entities.DragonFactory;
//import entities.DragonFactoryMethod;
//import linkedlist.SimpleLinkedList;
//
//public class WaveXML {
//	
//	private String XMLArchivo="DragonWave.xml";
//	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;
//	private String XMLFile="DragonWave.xml";
//	static SimpleLinkedList<Dragon> dragonsArray;
//	private Dragon[] dragones;
//	static LinkedList<Dragon> linkedList;
//	
//	public WaveXML(int waveSize) throws ParserConfigurationException, TransformerException{
//		dragones = new Dragon[waveSize];
//		linkedList = new LinkedList();
//		DragonFactoryMethod factory = new DragonFactory();
//		int y=0;
//		int x=0;
////		for(int i=0;i<waveSize;i++) {
////			if(i<1) {
////				dragones[i]=factory.createDragon(1, 3, "Comandant", null, 3,1400,400);
////				d = dragones[i];
////				dragones[i].setX(1400);
////				dragones[i].setY(400);
////			}else if(i>=1 && i<5) {
////				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1500, 320+y);
////				dragones[i].setX(1500);
////				dragones[i].setY(320+y);
////				y+=50;
////				
////			}else if(i>=5 && i<10) {
////				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1600+x, 0+y);
////				dragones[i].setX(1600+x);
////				dragones[i].setY(y);
////				y+=100;
////				if(x>=6)
////					x=100;
////			}else if(i>=10 && i<12) {
////				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1700, -350+y);
////				dragones[i].setX(1700);
////				dragones[i].setY(-350+y);
////				y+=100;
////			}else if(i>=12 && i<14) {
////				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1800, -600+y);
////				dragones[i].setX(1800);
////				dragones[i].setY(-600+y);
////				y+=200;
////			}else if(i>=14 && i<17) {
////				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1900, -1050+y);
////				dragones[i].setX(1900);
////				dragones[i].setY(-1050+y);
////				y+=150;
////			}else if(i>=17 && i<20) {
////				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,2000, -1600+y);
////				dragones[i].setX(2000);
////				dragones[i].setY(-1600+y);
////				y+=250;
////			}
//		
//		for(int i=0;i<waveSize;i++) {
//			if(i<1) {
//				dragones[i]=factory.createDragon(3, "Comandant", 3);
//				d = dragones[i];
//				dragones[i].setReloadingTime(1);
//				dragones[i].setFather(null);
//				dragones[i].setX(1400);
//				dragones[i].setY(400);
//			}else if(i>=1 && i<5) {
//				dragones[i]=factory.createDragon(2, "Captain",3);
//				dragones[i].setReloadingTime(2);
//				dragones[i].setFather(d);
//				dragones[i].setX(1500);
//				dragones[i].setY(320+y);
//				y+=50;
//				
//			}else if(i>=5 && i<10) {
//				dragones[i]=factory.createDragon(1, "Infantry",3);
//				dragones[i].setReloadingTime(3);
//				dragones[i].setFather(d);
//				dragones[i].setX(1600+x);
//				dragones[i].setY(y);
//				y+=100;
//				if(x>=6)
//					x=100;
//			}else if(i>=10 && i<12) {
//				dragones[i]=factory.createDragon(1, "Infantry",3);
//				dragones[i].setReloadingTime(3);
//				dragones[i].setFather(d);
//				dragones[i].setX(1700);
//				dragones[i].setY(-350+y);
//				y+=100;
//			}else if(i>=12 && i<14) {
//				dragones[i]=factory.createDragon(2, "Captain",3);
//				dragones[i].setReloadingTime(2);
//				dragones[i].setFather(d);
//				dragones[i].setX(1800);
//				dragones[i].setY(-600+y);
//				y+=200;
//			}else if(i>=14 && i<17) {
//				dragones[i]=factory.createDragon(1, "Infantry",3);
//				dragones[i].setReloadingTime(3);
//				dragones[i].setFather(d);
//				dragones[i].setX(1900);
//				dragones[i].setY(-1050+y);
//				y+=150;
//			}else if(i>=17 && i<20) {
//				dragones[i]=factory.createDragon(2, "Captain",3);
//				dragones[i].setReloadingTime(2);
//				dragones[i].setFather(d);
//				dragones[i].setX(2000);
//				dragones[i].setY(-1600+y);
//				y+=250;
//			}
//		}
//
//			
//		
//		dragonsArray = new SimpleLinkedList<>();
//		
//		
//		for(Dragon dragon : this.dragones) {
//			linkedList.add(dragon);
//		}
//		
//		for(Dragon dragon : this.dragones) {
//			dragonsArray.addLast(dragon);
//		}
//
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document doc = db.newDocument();
//		
//		
////	     Aqui se ha serializado la oleada con su contenido
//		Element oleadaSerializada = this.serializarOleada(doc);
//		Assert.assertNotNull(oleadaSerializada);
//		
//		doc.appendChild(oleadaSerializada);
////		++++++++++++++++++++++++++++++++++
////		instanciarXML(doc);
////		----------------------------------
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//		File archivoDestino = new File(this.XMLArchivo);
//		StreamResult result = new StreamResult(archivoDestino);
//		transformer.transform(source, result);
//		
//		File archivo = new File(this.XMLArchivo);
//		Assert.assertTrue(archivo.exists());
//	}
//	
//	public Element serializarOleada(Document doc) {
//		Element elementoOleada = doc.createElement("Oleada");
//		elementoOleada.setAttribute("nombre", "WAVE");
//		Element elementoDragones = doc.createElement("Dragones");
////		Element elementoPadre = doc.createElement("Padre");
////		elementoDragones.appendChild(elementoPadre);
//		elementoOleada.appendChild(elementoDragones);
////		for(int i=0;i<dragones.length;i++) {
//		for (Dragon dragon : this.dragones) { 
//			elementoDragones.appendChild(dragon.serializarDragon(doc));
//			
//		}
//		return elementoOleada;
//	}
//	
//	public static LinkedList getLista() {
//		return linkedList;
//	}
//	
//	public static SimpleLinkedList<Dragon> getdragonsArray() {
//		return dragonsArray;
//	}
//	
////	Instancia los dragones apartir de un xml
//	public static Dragon instanciarXML(Node elementoDragon) {
//		
//		Dragon nuevoDragon = new Dragon(Integer.parseInt(((Element) elementoDragon).getAttribute("Resistencia")),((Element) elementoDragon).getAttribute("Rango"),Integer.parseInt(((Element) elementoDragon).getAttribute("Velocidad")));
//		return nuevoDragon;
//	}
//		
////	Instancia los dragones apartir de un xml
//	public Dragon instanciarXML(Document doc) {
//		
//		Dragon dragon;
//		dragon = instanciarXML(serializarOleada(doc));
//		
//		return dragon;
//		
//	}
//}

 package xml;


 


 import java.io.File;


 import java.util.ArrayList;


 import java.util.LinkedList;


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


 import org.w3c.dom.Node;


 


 import entities.Dragon;


 import entities.DragonFactory;


 import entities.DragonFactoryMethod;


 import linkedlist.SimpleLinkedList;


 


 public class WaveXML {


 	


 	private String XMLArchivo="DragonWave.xml";


 	Dragon d, d2, d3, d4, d5, d6, d7, d8, d9, d10;


 	private String XMLFile="DragonWave.xml";


 	static SimpleLinkedList<Dragon> dragonsArray;


 	private Dragon[] dragones;


 	static LinkedList<Dragon> linkedList;


 	


 	public WaveXML(int waveSize) throws ParserConfigurationException, TransformerException{


 		dragones = new Dragon[waveSize];


 		linkedList = new LinkedList();


 		DragonFactoryMethod factory = new DragonFactory();


 		int y=0;


 		int x=0;


 //		for(int i=0;i<waveSize;i++) {


 //			if(i<1) {


 //				dragones[i]=factory.createDragon(1, 3, "Comandant", null, 3,1400,400);


 //				d = dragones[i];


 //				dragones[i].setX(1400);


 //				dragones[i].setY(400);


 //			}else if(i>=1 && i<5) {


 //				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1500, 320+y);


 //				dragones[i].setX(1500);


 //				dragones[i].setY(320+y);


 //				y+=50;


 //				


 //			}else if(i>=5 && i<10) {


 //				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1600+x, 0+y);


 //				dragones[i].setX(1600+x);


 //				dragones[i].setY(y);


 //				y+=100;


 //				if(x>=6)


 //					x=100;


 //			}else if(i>=10 && i<12) {


 //				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1700, -350+y);


 //				dragones[i].setX(1700);


 //				dragones[i].setY(-350+y);


 //				y+=100;


 //			}else if(i>=12 && i<14) {


 //				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,1800, -600+y);


 //				dragones[i].setX(1800);


 //				dragones[i].setY(-600+y);


 //				y+=200;


 //			}else if(i>=14 && i<17) {


 //				dragones[i]=factory.createDragon(3, 1, "Infantry", d,3,1900, -1050+y);


 //				dragones[i].setX(1900);


 //				dragones[i].setY(-1050+y);


 //				y+=150;


 //			}else if(i>=17 && i<20) {


 //				dragones[i]=factory.createDragon(2, 2, "Captain", d,3,2000, -1600+y);


 //				dragones[i].setX(2000);


 //				dragones[i].setY(-1600+y);


 //				y+=250;


 //			}


 		


 		for(int i=0;i<waveSize;i++) {


 			if(i<1) {


 				dragones[i]=factory.createDragon(3, "Comandant", 3);


 				d = dragones[i];


 				dragones[i].setReloadingTime(1);


 				dragones[i].setFather(null);


 				dragones[i].setX(1400);


 				dragones[i].setY(400);


 			}else if(i>=1 && i<5) {


 				dragones[i]=factory.createDragon(2, "Captain",3);


 				dragones[i].setReloadingTime(2);


 				dragones[i].setFather(d);


 				dragones[i].setX(1500);


 				dragones[i].setY(320+y);


 				y+=50;


 				


 			}else if(i>=5 && i<10) {


 				dragones[i]=factory.createDragon(1, "Infantry",3);


 				dragones[i].setReloadingTime(3);


 				dragones[i].setFather(d);


 				dragones[i].setX(1600+x);


 				dragones[i].setY(y);


 				y+=100;


 				if(x>=6)


 					x=100;


 			}else if(i>=10 && i<12) {


 				dragones[i]=factory.createDragon(1, "Infantry",3);


 				dragones[i].setReloadingTime(3);


 				dragones[i].setFather(d);


 				dragones[i].setX(1700);


 				dragones[i].setY(-350+y);


 				y+=100;


 			}else if(i>=12 && i<14) {


 				dragones[i]=factory.createDragon(2, "Captain",3);


 				dragones[i].setReloadingTime(2);


 				dragones[i].setFather(d);


 				dragones[i].setX(1800);


 				dragones[i].setY(-600+y);


 				y+=200;


 			}else if(i>=14 && i<17) {


 				dragones[i]=factory.createDragon(1, "Infantry",3);


 				dragones[i].setReloadingTime(3);


 				dragones[i].setFather(d);


 				dragones[i].setX(1900);


 				dragones[i].setY(-1050+y);


 				y+=150;


 			}else if(i>=17 && i<20) {


 				dragones[i]=factory.createDragon(2, "Captain",3);


 				dragones[i].setReloadingTime(2);


 				dragones[i].setFather(d);


 				dragones[i].setX(2000);


 				dragones[i].setY(-1600+y);


 				y+=250;


 			}


 		}


 


 			


 		


 		dragonsArray = new SimpleLinkedList<>();


 		


 		


 		for(Dragon dragon : this.dragones) {


 			linkedList.add(dragon);


 		}


 		


 		for(Dragon dragon : this.dragones) {


 			dragonsArray.addLast(dragon);


 		}


 


 		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();


 		DocumentBuilder db = dbf.newDocumentBuilder();


 		Document doc = db.newDocument();


 		


 		


 //	     Aqui se ha serializado la oleada con su contenido


 		Element oleadaSerializada = this.serializarOleada(doc);


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


 	


 	public Element serializarOleada(Document doc) {


 		Element elementoOleada = doc.createElement("Oleada");


 		elementoOleada.setAttribute("nombre", "WAVE");


 		Element elementoDragones = doc.createElement("Dragones");


 //		Element elementoPadre = doc.createElement("Padre");


 //		elementoDragones.appendChild(elementoPadre);


 		elementoOleada.appendChild(elementoDragones);


 //		for(int i=0;i<dragones.length;i++) {


 		for (Dragon dragon : this.dragones) { 


 			elementoDragones.appendChild(dragon.serializarDragon(doc));


 			


 		}


 		return elementoOleada;


 	}


 	


 	public static LinkedList getLista() {


 		return linkedList;


 	}


 	


 	public static SimpleLinkedList<Dragon> getdragonsArray() {


 		return dragonsArray;


 	}


 	


 //	Instancia los dragones apartir de un xml


 	public static Dragon instanciarXML(Node elementoDragon) {


 		


		Dragon nuevoDragon = new Dragon(Integer.parseInt(((Element) elementoDragon).getAttribute("Resistencia")),((Element) elementoDragon).getAttribute("Rango"),Integer.parseInt(((Element) elementoDragon).getAttribute("Velocidad"))); 


		return nuevoDragon; 
	} 

//	Instancia los dragones apartir de un xml 
	public Dragon instanciarXML(Document doc) { 	
		Dragon dragon; 
		dragon = instanciarXML(serializarOleada(doc)); 
		return dragon; 
	} 

} 
