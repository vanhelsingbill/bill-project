package HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Vanhelsing on 2018/5/27.
 */
public class HttpClientStudyHeader {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();   //创建httpclient
        HttpGet httpGet=new HttpGet("http://www.tuicool.com");      //创建httpget实例
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
        CloseableHttpResponse response = httpClient.execute(httpGet);    //执行请求
        HttpEntity entity=response.getEntity();                         //获取网页内容
        //System.out.println("Content-Type:"+entity.getContentType().getValue()); //获取Content-Type
        //System.out.println("上海12345:" + EntityUtils.toString(entity,"utf-8"));//获取网页内容
        System.out.println("响应状态:" + response.getStatusLine().getStatusCode());//获取响应状态

        response.close();
        httpClient.close();

    }
}
