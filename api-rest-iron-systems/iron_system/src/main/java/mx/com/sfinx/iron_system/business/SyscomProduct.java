package mx.com.sfinx.iron_system.business;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.com.sfinx.iron_system.domain.SessionToken;
import mx.com.sfinx.iron_system.domain.response.ResponseProd;
import mx.com.sfinx.iron_system.domain.response.ResponseToken;
import mx.com.sfinx.iron_system.utils.DataUtilities;
import mx.com.sfinx.iron_system.utils.XlsUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles all the logic in Syscom process
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
@Service
public class SyscomProduct {

    private static final Logger log = LoggerFactory.getLogger(SyscomProduct.class);

    private static SessionToken tokenSyscom = new SessionToken();

    public ResponseProd getProduct() {

        ResponseProd responseProd = new ResponseProd();
        String result = null;

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://developers.syscom.mx/api/v1/productos/72036");


            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("Authorization", "Bearer "+SessionToken.getInstance().getAccess_Token());

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if(entity!=null){
//                InputStream stream= entity.getContent();
//                String str= DataUtilities.convertStreamToString(stream);
//                log.info(str);


                if(entity!=null){
//                InputStream stream= entity.getContent();
//                String str= DataUtilities.convertStreamToString(stream);
//                log.info(str);

                }

                InputStream instream = entity.getContent();

                result = DataUtilities.convertStreamToString(instream);

                Gson g = new Gson();

                tokenSyscom = g.fromJson(result, SessionToken.class);

                SessionToken.getInstance().setProducto_id(tokenSyscom.getProducto_id());
                // now you have the string representation of the HTML request
                System.out.println("ID: " + tokenSyscom.getProducto_id());
                System.out.println("Referencia interna: " + tokenSyscom.getModelo());
                System.out.println("Nombre: " + tokenSyscom.getTitulo());
                System.out.println("precio_lista: " + tokenSyscom.getPrecio_lista());
                System.out.println("categ_id: " + tokenSyscom.getMarca());
                instream.close();

                // now you have the string representation of the HTML request


            }



            responseProd.setStatus(200);
            responseProd.setMessage("OK");
            responseProd.setDescription("Se obtuvo producto");

            return responseProd;

        } catch (Exception e1) {
            log.error("Error: {}", e1.getMessage());

            e1.printStackTrace();

            responseProd.setStatus(500);
            responseProd.setMessage("Fail");
            responseProd.setDescription("Error al obtener token");

            return responseProd;


    }

    }
}
//    private static String convertStreamToString(InputStream is) {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//
//        String line = null;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb.toString();
//    }


