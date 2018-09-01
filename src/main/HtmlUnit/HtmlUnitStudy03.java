package HtmlUnit;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.List;


/**
 * Created by Vanhelsing on 2018/6/24.
 */
public class HtmlUnitStudy03 {
    public static void main(String[] args)  {
        WebClient webClient=new WebClient(BrowserVersion.CHROME,"118.190.95.26",9001);   //实例化web客户端，模拟chrome浏览器且使用代理
        webClient.getOptions().setCssEnabled(false);        //取消css支持
        webClient.getOptions().setJavaScriptEnabled(false); //取消js支持
        HtmlPage page = null;       //解析获取页面
        try {
            page = webClient.getPage("http://www.java1234.com");
            DomElement domElement = page.getElementById("navMenu");     //获取指定id的dom元素
            System.out.println("网页html："+domElement.asXml()); //获取html
            System.out.println("========================================================");
            DomNodeList<DomElement> aList = page.getElementsByTagName("a"); //获取tag是a的所有dom元素
            for(int i=0;i<aList.size();i++){
                DomElement a=aList.get(i);
                System.out.println("a标签："+a.asXml());  //获取html
            }
            System.out.println("========================================================");
            //通过xpath获取id='navMenu'的div下ul下的所有li元素
            List<HtmlListItem> liList = page.getByXPath("//div[@id='navMenu']/ul/li");
            System.out.println("li标签："+liList.get(1).asXml());  //获取html
            List<HtmlSpan> spanList =  page.getByXPath("//div[@id='navMenu']/ul/li[1]/a/span");
            System.out.println("span标签："+spanList.get(0).asXml());  //获取html


            // System.out.println("网页文本："+domElement.asText());  //获取文本
            System.out.println("========================================================");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();      //关闭客户端，释放内存
        }

    }

}
