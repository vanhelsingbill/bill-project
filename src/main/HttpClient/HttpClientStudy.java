package HttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Vanhelsing on 2018/5/27.
 */
public class HttpClientStudy {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();   //创建httpclient
        //HttpGet httpGet=new HttpGet("http://www.sh12345.gov.cn/r/cms/www/shline12345/appeal_public.html");      //创建httpget实例
        HttpGet httpGet=new HttpGet("http://www.tuicool.com");      //创建httpget实例
        CloseableHttpResponse response = httpClient.execute(httpGet);                                           //执行请求
        HttpEntity entity=response.getEntity();                                                                 //获取网页内容
        System.out.println("上海12345:" + EntityUtils.toString(entity,"utf-8"));
        response.close();
        httpClient.close();

    }
}
