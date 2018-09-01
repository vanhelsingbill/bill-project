package HtmlUnit;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;


/**
 * Created by Vanhelsing on 2018/6/24.
 */
public class HtmlUnitStudy {
    public static void main(String[] args) throws InterruptedException {
        WebClient webClient=new WebClient();                //实例化web客户端

        HtmlPage page = null;       //解析获取页面
        try {
            page = webClient.getPage("https://pan.baidu.com/share/home?uk=305605848#category/type=0");
            Thread.sleep(10000);
            System.out.println("网页html："+page.asXml()); //获取html
            System.out.println("========================================================");
            //System.out.println("网页文本："+page.asText());  //获取文本
            //System.out.println("========================================================");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();      //关闭客户端，释放内存
        }

    }

}
