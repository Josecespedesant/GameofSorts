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
import org.jdom2.output.XMLOutputter;
import xmlmanager.Conversion;
import xmlmanager.Parse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Encargada de pedirle al servidor que ordene una oleada con un método diferente de ordenamiento.
 *
 * @author David Azofeifa H.
 */
public class RequestNuevoOrdenamiento {

    private final String obtenerOleadaUrl = "http://localhost:8080/Ordenamiento";

    /**
     * Envia al servidor oleada y tipo de ordenamiento que se quiera aplicar, devuelve oleada ordenada.
     *
     * @param oleadaPorOdenar
     * @param tipoOrdenamiento
     * @return
     * @throws IOException
     */
    public Dragon[] getNuevoOrdenamiento(Dragon[] oleadaPorOdenar, String tipoOrdenamiento) throws IOException {
        Dragon[] oleadaOrdenada = new Dragon[0];

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(obtenerOleadaUrl);

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);

        Document doc = Parse.escribirXML(oleadaPorOdenar, tipoOrdenamiento);
        String oleadaxml = new XMLOutputter().outputString(doc);

        params.add(new BasicNameValuePair("oleada",
                "" + oleadaxml));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

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
                PrintWriter out = new PrintWriter("oleadaOrdenada.xml");
                out.println(stringBuilder.toString());
                out.close();
            }
            try {
                Document docOleadaOrdenada = Conversion.getXMLFromDisk("oleadaOrdenada.xml");
                oleadaOrdenada = Parse.leerXML(docOleadaOrdenada);
            } catch (JDOMException e) {
                e.printStackTrace();
            }
        }
        return oleadaOrdenada;
    }

}
