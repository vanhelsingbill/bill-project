package HttpClient;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vanhelsing on 2018/6/10.
 * 获取图片
 */
public class HttpClientStudyPicture {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();   //创建httpclient
        //HttpGet httpGet=new HttpGet("http://www.java1234.com/uploads/allimg/180606/1-1P606231355549.jpg");      //创建httpget实例
        HttpGet httpGet=new HttpGet("http://i2.ygimg.cn/pics/shop/cms/home/2018/06/06/84820180606T113152.jpg");      //创建httpget实例
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
        CloseableHttpResponse response = httpClient.execute(httpGet);    //执行请求
        HttpEntity entity=response.getEntity();                         //获取网页内容

        //下载图片
        if(entity !=null){
            System.out.println("Content-Type:"+entity.getContentType().getValue()); //获取Content-Type
            InputStream inputStream = entity.getContent();
            FileUtils.copyToFile(inputStream,new File("c://java1.jpg"));

        }


        //System.out.println("上海12345:" + EntityUtils.toString(entity,"utf-8"));//获取网页内容
        System.out.println("响应状态:" + response.getStatusLine().getStatusCode());//获取响应状态

        response.close();
        httpClient.close();

    }
}
