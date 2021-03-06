package pruebas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by CTN Developer on 13-07-2016.
 */
public class JsonReader {
    private String url;

    public JsonReader(){
    }

    public JsonReader(String url){
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static String readAll(Reader rd) throws IOException {
        String fake="";
        try {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        } finally{
            return fake;
        }
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }




    public String readJsonFromUrl2(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);

            return jsonText;
        } finally {
            is.close();
        }
    }

    //public static void main(String[] args) throws IOException, JSONException {
        //JSONObject json = readJsonFromUrl("http://www.jorgepartal.xyz/jsontest/getUser.php");
        //System.out.println(json);
        //System.out.println(json.toString());
        //System.out.println(json.get("id"));


        //String jsonText = readJsonFromUrl2("http://www.jorgepartal.xyz/jsontest/getUser.php");
        //System.out.println(jsonText);
        //JSONObject obj = new JSONObject(jsonText);
        //String in;
        //JSONObject reader = new JSONObject(in);




    //}




}
