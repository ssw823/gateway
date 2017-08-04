package example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Map;

public class DtHttpRequest {

    Map<String,String> headers;
    String host;
    String port;
    String protocol;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }



    public DtHttpRequest(Map<String, String> headers, String protocol, String host, String port) {
        this.headers = headers;
        this.host = host+":";
        this.port = port+"/";
        this.protocol = protocol+"://";
    }

    private void writeHeaders(URLConnection connection){
        for(Map.Entry<String,String> e:headers.entrySet()){
            connection.setRequestProperty(e.getKey(),e.getValue());
        }
    }

    public String sendGet(String url, Map<String,String> param) throws Exception {
        String stringParam="";
        if(param!=null){
            for(Map.Entry<String,String> e:param.entrySet()){
                stringParam+=(e.getKey()+"="+e.getValue()+"&");
            }
        }
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString =this.protocol+this.host+this.port+ url + "?" + stringParam;
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();

            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("contentType", "UTF-8");
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            connection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            writeHeaders(connection);
            connection.setDoInput(true);//发送get请求时使用
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("inmyhttprequest" + e.toString());
            e.printStackTrace();
            throw e;
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    public String sendPost(String url, Map<String,String> param) throws Exception {
        String stringParam="";
        if(param!=null){
            for(Map.Entry<String,String> e:param.entrySet()){
                stringParam+=(e.getKey()+"="+e.getValue()+"&");
            }
            stringParam=stringParam.substring(0,stringParam.length()-1);
        }


        PrintWriter out = null;
        BufferedReader in = null;
        OutputStreamWriter outputStreamWriter = null;
        String result = "";
        try {
            URL realUrl = new URL(this.protocol+this.host+this.port+ url );

            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestProperty("Accept-Language", Locale.getDefault().toString());
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            writeHeaders(conn);
            conn.setDoOutput(true);//发送post请求时使用


            outputStreamWriter = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            outputStreamWriter.write(stringParam);

            // out.print(param);
            outputStreamWriter.flush();
            // out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            // e.printStackTrace();
            throw e;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}