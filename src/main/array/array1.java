package main.array;

/**
 * Created by Vanhelsing on 2018/3/25.
 */
public class array1 {
    public static void main(String[] args) {
        char[] charArr1={'a','b','c'};

        char[] charArr3=new char[3];
        charArr3[0]='1';
        charArr3[1]='2';
        charArr3[2]='3';

        char[] charArr2=new char[]{'图','解','j'};

        char[] charx=charArr2;
        charx[1]='x';

        System.out.println(charx);

    }
}
