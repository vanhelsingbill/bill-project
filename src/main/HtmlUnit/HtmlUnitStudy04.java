package HtmlUnit;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;


/**
 * Created by Vanhelsing on 2018/6/24.
 * 模拟按钮点击
 */
public class HtmlUnitStudy04 {
    public static void main(String[] args)  {
        WebClient webClient=new WebClient(BrowserVersion.CHROME);                //实例化web客户端
        webClient.getOptions().setJavaScriptEnabled(true);
        HtmlPage page = null;       //解析获取页面
        try {
            page = webClient.getPage("http://blog.java1234.com/index.html");
            HtmlForm myform = page.getFormByName("myform");     //获取form表单
            HtmlTextInput inputText = myform.getInputByName("q");   //获取搜索文本框
            HtmlSubmitInput submitButton = myform.getInputByName("submitButton");   //获取提交按钮
            inputText.setValueAttribute("htmlunit");            //模拟输入文本框值
            HtmlPage resultPage = submitButton.click();
            System.out.println("搜索结果网页html："+resultPage.asXml()); //获取html
            System.out.println("========================================================");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close();      //关闭客户端，释放内存
        }

    }

}
