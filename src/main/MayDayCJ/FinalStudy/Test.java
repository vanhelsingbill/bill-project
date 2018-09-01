package MayDayCJ.FinalStudy;

/**
 * Created by Vanhelsing on 2018/7/11.
 * 1) 被final修饰不可变的是变量的引用，而不是引用指向的内容，引用指向的内容是可以改变的
 */
public class Test {
    public static void main(String[] args){
        /*
        final FinalString fs=new FinalString("1");
        //fs.setStr("2");
        final FinalString fss=new FinalString("3");
        //fss=fs;
        System.out.println(fss.getStr());
        */

        final String[] strs0={"111","222"};
        final String[] strs1={"333","444"};
        //strs1=strs0;
        strs1[1]="555";
        System.out.println(strs1[1]);

    }
}
