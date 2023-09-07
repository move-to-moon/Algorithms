package JavaSE.Sington;

//懒汉式(这种在多线程的情况下是不安全的)
public class SingTon1 {
    private static SingTon1 Instance = null;

    private SingTon1(){

    }

    public static SingTon1 singTon1(){
        if (Instance == null) Instance= new SingTon1();
        return Instance;
    }
}
