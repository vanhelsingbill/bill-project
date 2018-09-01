package Jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Vanhelsing on 2018/6/10.
 */
public class JsoupStudy01 {
    public static void main(String[] args) throws Exception{

        CloseableHttpClient httpClient = HttpClients.createDefault();   //创建httpclient
        HttpGet httpGet=new HttpGet("http://www.yougou.com/topics/152836382866.shtml");      //创建httpget实例
        CloseableHttpResponse response = httpClient.execute(httpGet);                                           //执行请求
        HttpEntity entity=response.getEntity();                                                                 //获取网页内容
        //System.out.println("网页内容:" + EntityUtils.toString(entity,"utf-8"));
        String content=EntityUtils.toString(entity,"utf-8");

        Document doc = Jsoup.parse(content);                    //解析网页，得到文档对象

/*
        Elements elementsByTag = doc.getElementsByTag("title"); //获取tag是title的所有dom元素
        Element element = elementsByTag.get(0);
        String title = element.text();                          //返回元素的文本
        System.out.println("网页标题："+title);
        Element elementById = doc.getElementById("site_nav_top");//获取指定id的dom元素

        String navTop=elementById.text();

        System.out.println("网站口号："+navTop);

        Elements itemElements = doc.getElementsByClass("post_item");   //根据样式名称查询dom
        System.out.println("=============输出post_item================");
        for(Element e:itemElements){
            System.out.println(e.html());
            System.out.println("----------------------------");
        }

        Elements hrefElements = doc.getElementsByAttribute("href");//根据属性名称获取dom
        System.out.println("=============输出href================");
        for(Element e:hrefElements){
            System.out.println(e.toString());
            System.out.println("----------------------------");
        }


        Elements attributeValueElements = doc.getElementsByAttributeValue("class", "titlelnk");//根据属性名称及其值获取dom
        System.out.println("=============输出attributeValue对应的dom================");
        for(Element e:attributeValueElements){
            System.out.println("link:"+e.toString());
            System.out.println("标题:"+e.text());
            System.out.println("----------------------------------------------------------");
        }
*/
        /*************************************************二、选择器语法************************************************

        //id用"#"前缀,class用"."前缀,标签无需前缀
        Elements linkElements = doc.select("#post_list .post_item .post_item_body h3 a");  //通过选择器获取所有博客标题链接的dom
        System.out.println("=============输出通过选择器获取的 dom================");
        for(Element e:linkElements){
            System.out.println("link:"+e.toString());
            System.out.println("标题:"+e.text());
            System.out.println("----------------------------------------------------------");
        }


        Elements aElements = doc.select("a[href]");//查找带有href属性的a标签
        System.out.println("=============查找带有href属性的a标签 dom================");
        for(Element e:aElements){
            System.out.println("link:"+e.toString());
            System.out.println("----------------------------------------------------------");
        }


        Elements imgElements = doc.select("img[src$=.jpg]");    //查找扩展名为.png的图片DOM节点
        System.out.println("=============查找扩展名为.png的图片DOM节点================");
        for(Element e:imgElements){
            System.out.println("图片:"+e.toString());
            System.out.println("----------------------------------------------------------");
        }
         */


        //Elements titileElements = doc.select(".cnt .nptt a");       //通过选择器获取商品的名称及链接
        //Elements priceElements = doc.select(".cnt .price_sc del");  //通过选择器获取商品的原价

        Elements yougouElements = doc.select("li .cnt");  //通过选择器获取商品的名称、链接及原价

        for(Element e:yougouElements){

            String title=e.select(".nptt a").attr("title").toString().toLowerCase();

            if(title.contains("adidas") || title.contains("nike"))
                System.out.println("商品信息："+e.select(".nptt a").attr("title")+" 原价："+e.select(".price_sc del").text()+" 链接："+e.select(".nptt a").attr("href"));  //获取dom的属性
        }

//        for(int i=0;i<titileElements.size();i++){
//            System.out.println("商品信息："+titileElements.next().attr("title")+" 原价："+priceElements.next().text()+" 链接："+titileElements.next().attr("href"));
//        }

        response.close();
        httpClient.close();
    }
}
