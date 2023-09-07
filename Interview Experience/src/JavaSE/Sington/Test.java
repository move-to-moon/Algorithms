package JavaSE.Sington;

public class Test {
    public static void main(String[] args) {
        SingTon2 singTon1 = SingTon2.getInstance();
        SingTon2 singTon2 = SingTon2.getInstance();
        System.out.println(singTon1);
        System.out.println(singTon2);
    }
}
