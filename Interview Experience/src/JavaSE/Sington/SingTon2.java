package JavaSE.Sington;

import org.junit.Test;

//饿汉式
public class SingTon2 {

    private static final SingTon2 getInstance = new SingTon2();

    private SingTon2(){

    }

    public static SingTon2 getInstance(){
        return  getInstance;
    }



}
