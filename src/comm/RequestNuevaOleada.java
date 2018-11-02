package comm;

import entities.Dragon;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import xmlmanager.Conversion;
import xmlmanager.Parse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Consigue oleada creada por el serviddor
 *
 * @author David Azofeifa H.
 */
public class RequestNuevaOleada {

    private final String obtenerOleadaUrl = "http://192.168.100.4:8080/Generar";

    /**
     * Envia al servidor numero de dragones deseados en nueva oleada, devuelva oleada creada.
     *
     * @param numDragones
     * @return
     * @throws IOException
     */
    public Dragon[] getNuevaOleada(int numDragones) throws IOException {
        Dragon[] nuevaOleada = new Dragon[0];

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(obtenerOleadaUrl);

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("NumDragones", "" + numDragones));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        System.out.println("Se realizo pedido de nueva oleada con " + numDragones + " dragones.");

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                InputStreamReader inputStreamReader = new InputStreamReader(instream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String bufferedStrChunk = null;
                while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                    stringBuilder.append(bufferedStrChunk);
                }
                PrintWriter out = new PrintWriter("nuevaOleada.xml");
                out.println(stringBuilder.toString());
                out.close();
            }
            try {
                Document doc = Conversion.getXMLFromDisk("nuevaOleada.xml");
                nuevaOleada = Parse.leerXML(doc);
            } catch (JDOMException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nueva oleada recibida con " + nuevaOleada.length + "dragones");
        return nuevaOleada;
    }

    public static void main(String[] args) throws IOException, JDOMException {
        RequestNuevaOleada test = new RequestNuevaOleada();
        Dragon[] oleada = test.getNuevaOleada(4);
        for (Dragon dragon: oleada) {
            System.out.println(dragon.getName());
        }
    }
}
