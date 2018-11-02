package xmlmanager;

import entities.Dragon;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;

/**
 * Clase encargada de escribir y leer XML
 *
 * @author David Azofeifa Herrera
 */
public class Parse {

    /**
     * Toma la información de la oleada
     *
     * @param oleada, array de instancias dragon que representan oleada
     * @param ordenamiento, tipo de ordenamiento implementado sobre oleada
     */
    public static Document escribirXML(Dragon[] oleada, String ordenamiento) {
        Element oleadaElement = new Element("oleada");

        Document doc = new Document();
        doc.setRootElement(oleadaElement);

        int dragonId = 1;

        Element tipoOrdenamiento = new Element("ordenamiento");
        tipoOrdenamiento.addContent(new Text(ordenamiento));


        for (int i = 0; i < oleada.length; i++) {
            Element tempDragon = new Element("Dragon");
            tempDragon.setAttribute("dragonId", "" + dragonId);
            dragonId++;

            // TODO anadir padre
            Element nombre = new Element("nombre");
            nombre.addContent(oleada[i].getName());
            Element edad = new Element("edad");
            edad.addContent("" + oleada[i].getAge());
            Element velocidadRecarga = new Element("velocidadRecarga");
            velocidadRecarga.addContent("" + oleada[i].getReloadingTime());
            Element resistencia = new Element("resistencia");
            resistencia.addContent("" + oleada[i].getResistance());
            Element rank = new Element("rank");
            rank.addContent(oleada[i].getRank());

            tempDragon.addContent(nombre);
            tempDragon.addContent(edad);
            tempDragon.addContent(velocidadRecarga);
            tempDragon.addContent(resistencia);
            tempDragon.addContent(rank);

            oleadaElement.addContent(tempDragon);
        }

        oleadaElement.addContent(tipoOrdenamiento);

        return doc;
    }

    /**
     * Lee XML y crea array de instancias Dragon, a partir de la informacion que contiene
     *
     * @param doc
     * @return
     */
    public static Dragon[] leerXML(Document doc) {
        Dragon[] oleada;
        int numDragones = 0;

        for (Element tempElement : doc.getRootElement().getChildren("Dragon")) {
            numDragones++;
        }

        oleada = new Dragon[numDragones];

        int index = 0;
        for (Element tempElement : doc.getRootElement().getChildren("Dragon")) {
            String nombre = tempElement.getChildText("nombre");
            int edad = Integer.parseInt(tempElement.getChildText("edad"));
            int velocidadRecarga = Integer.parseInt(tempElement.getChildText("velocidadRecarga"));
            int resistencia = Integer.parseInt(tempElement.getChildText("resistencia"));
            String rank = tempElement.getChildText("rank");

            // TODO crear instancias con dragon factory
            oleada[index] = new Dragon(nombre, resistencia, rank);
            oleada[index].setAge(edad);
            oleada[index].setReloadingTime(velocidadRecarga);

            index++;
        }
        return oleada;
    }

    /**
     * Indica tipo de ordenamiendo expecificado en XML
     *
     * @param doc
     * @return
     */
    public static String leerTipoDeOrdenamiento(Document doc) {
        return doc.getRootElement().getChildText("ordenamiento");
    }
}
