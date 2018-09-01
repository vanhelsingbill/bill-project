package Ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by Vanhelsing on 2018/6/14.
 */
public class EhCacheStudy {
    public static void main(String[] args){

        // 根据ehcache.xml配置文件创建Cache管理器
        CacheManager cacheManager=CacheManager.create("./src/main/resources/ehcache.xml");
        Cache cache=cacheManager.getCache("a");                 // 获取ehcache.xml配置文件中的指定Cache
        Element element=new Element("bill","Good luck!");       // 实例化一个元素
        cache.put(element);                                     // 把一个元素添加到Cache中

        Element element1=cache.get("bill");                     // 根据Key获取缓存元素
        System.out.println(element);
        System.out.println(element1.getObjectValue());

        cache.flush();                      // 刷新缓存
        cacheManager.shutdown();            // 关闭缓存管理器

    }

}
