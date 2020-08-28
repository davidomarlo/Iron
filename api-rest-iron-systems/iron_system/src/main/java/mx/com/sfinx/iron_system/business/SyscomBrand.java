package mx.com.sfinx.iron_system.business;

import mx.com.sfinx.iron_system.domain.SessionToken;
import mx.com.sfinx.iron_system.domain.response.ResponseBrand;
import mx.com.sfinx.iron_system.utils.DataUtilities;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Class that handles all the logic in Syscom process
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
@Service
public class SyscomBrand {

    private static final Logger log = LoggerFactory.getLogger(SyscomBrand.class);

    private static SessionToken tokenSyscom = new SessionToken();

    public ResponseBrand getBrandSinmarca() {

        ResponseBrand responseBrand = new ResponseBrand();
        String result = null;

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://developers.syscom.mx/api/v1/marcas/sinmarca");


            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("Authorization", "Bearer "+SessionToken.getInstance().getAccess_Token());

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                InputStream stream= entity.getContent();
                String str= DataUtilities.convertStreamToString(stream);
                log.info(str);
            }

            responseBrand.setStatus(200);
            responseBrand.setMessage("OK");
            responseBrand.setDescription("Se obtuvo marca sinmarca");

            return responseBrand;

        } catch (Exception e1) {
            log.error("Error: {}", e1.getMessage());

            e1.printStackTrace();

            responseBrand.setStatus(500);
            responseBrand.setMessage("Fail");
            responseBrand.setDescription("Error al obtener marcas sinmarca");

            return responseBrand;
        }

    }
    public ResponseBrand getBrandTrescx() {

        ResponseBrand responseBrand = new ResponseBrand();
        String result = null;

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://developers.syscom.mx/api/v1/marcas/3cx");


            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("Authorization", "Bearer "+SessionToken.getInstance().getAccess_Token());

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                InputStream stream= entity.getContent();
                String str= DataUtilities.convertStreamToString(stream);
                log.info(str);
            }

            responseBrand.setStatus(200);
            responseBrand.setMessage("OK");
            responseBrand.setDescription("Se obtuvo marca 3cx");

            return responseBrand;

        } catch (Exception e1) {
            log.error("Error: {}", e1.getMessage());

            e1.printStackTrace();

            responseBrand.setStatus(500);
            responseBrand.setMessage("Fail");
            responseBrand.setDescription("Error al obtener marca 3cx");

            return responseBrand;
        }

    }
    public ResponseBrand getBrandProds() {

        ResponseBrand responseBrand = new ResponseBrand();
        String result = null;

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("https://developers.syscom.mx/api/v1/marcas/productos/2548");
          //  HttpGet httpGet = new HttpGet("https://developers.syscom.mx/api/v1/marcas/"+SessionToken.getInstance().getBrand_name()+"/3cx");



            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("Authorization", "Bearer "+SessionToken.getInstance().getAccess_Token());

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            if(entity!=null){
                InputStream stream= entity.getContent();
                String str= DataUtilities.convertStreamToString(stream);
                log.info(str);
            }

            responseBrand.setStatus(200);
            responseBrand.setMessage("OK");
            responseBrand.setDescription("Se obtuvo marca 3cx");

            return responseBrand;

        } catch (Exception e1) {
            log.error("Error: {}", e1.getMessage());

            e1.printStackTrace();

            responseBrand.setStatus(500);
            responseBrand.setMessage("Fail");
            responseBrand.setDescription("Error al obtener marca 3cx");

            return responseBrand;
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


