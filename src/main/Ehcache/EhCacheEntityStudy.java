package Ehcache;


/**
 * Created by Vanhelsing on 2018/6/24.
 * 实体存入Ehcache学习
 */
public class EhCacheEntityStudy {

    public static void main(String[] args){

        UserEntity userEntity=new UserEntity();
        userEntity.setAge(17);
        userEntity.setUserId("bill");
        userEntity.setUserName("billname");

        EhcacheUtil.getInstance().put("ehcacheGO","userEch",userEntity);
        System.out.println("use cacher");
        UserEntity userEntity1= (UserEntity) EhcacheUtil.getInstance().get("ehcacheGO","userEch");
        System.out.print("Age："+ userEntity1.getAge()+" Name:"+userEntity1.getUserName());



    }





}


