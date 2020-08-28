package mx.com.sfinx.iron_system.business;

import com.google.gson.Gson;
import mx.com.sfinx.iron_system.domain.SessionToken;
import mx.com.sfinx.iron_system.domain.response.ResponseToken;
import mx.com.sfinx.iron_system.utils.DataUtilities;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class SyscomToken {

    private static final Logger log = LoggerFactory.getLogger(SyscomToken.class);

    private static String clientId = "k5Z4qq4ZhfpvLsLHgujEnZTN3qOFr1rY";
    private static String clientSecret = "DHd4TtC4Rje1PLJdoqapW4qcrdNHqTjTuIu8CcvE";
    private static SessionToken tokenSyscom = new SessionToken();


    public ResponseToken getTokenSyscom() {

        ResponseToken responseToken = new ResponseToken();
        String result = null;

        try {

            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://developers.syscom.mx/oauth/token");

            // Request parameters and other properties.
            List<NameValuePair> params = new ArrayList<NameValuePair>(3);
            params.add(new BasicNameValuePair("client_id", clientId));
            params.add(new BasicNameValuePair("client_secret", clientSecret));
            params.add(new BasicNameValuePair("grant_type", "client_credentials"));

            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");

            //Execute and get the response.
            HttpResponse response = httpclient.execute(httppost);

            HttpEntity entity = response.getEntity();

            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();

                result = DataUtilities.convertStreamToString(instream);

                Gson g = new Gson();

                tokenSyscom = g.fromJson(result, SessionToken.class);
                SessionToken.getInstance().setAccess_Token(tokenSyscom.getAccess_Token());

                // now you have the string representation of the HTML request
                System.out.println("RESPONSE: " + tokenSyscom.getExpiresIn());
                System.out.println("RESPONSE: " + tokenSyscom.getAccess_Token());
                instream.close();

                if (response.getStatusLine().getStatusCode() == 200) {

                    responseToken.setStatus(200);
                    responseToken.setMessage("OK");
                    responseToken.setDescription("Se obtuvo token");

                }
            } else {
                responseToken.setStatus(200);
                responseToken.setMessage("Fail");
                responseToken.setDescription("Error al obtener token");

            }
            return responseToken;

        } catch (Exception e1) {
            log.error("Error: {}", e1.getMessage());
            e1.printStackTrace();

            responseToken.setStatus(500);
            responseToken.setMessage("Fail");
            responseToken.setDescription("Error al obtener token");

            return responseToken;
        }
    }



}