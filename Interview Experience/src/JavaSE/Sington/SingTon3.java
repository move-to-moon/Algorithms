package JavaSE.Sington;



public class SingTon3 {
    private SingTon3(){}
    
    private static SingTon3 Instance;
    
    public static SingTon3 getInstance(){
        if (Instance == null){
            synchronized (SingTon3.class){
                if (Instance == null) Instance = new SingTon3();
            }
        }

        return Instance;
    }
}
