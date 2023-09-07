
class  动物 {
    int i = 1;
    void cry() {
    }
    void showi() {
        System.out.println("父类中的i："+i);
    }
}
class 狗 extends 动物 {
    void cry() {
        System.out.println("汪汪.....");
        System.out.println("继承动物类i的值："+i);
    }
}
class 猫 extends 动物  {
    int i = 3;
    void cry() {
        System.out.println("喵喵.....");
        System.out.println("隐藏动物类i的值："+i);
        showi();
    }
}
public class Example {
    public static void main(String args[]) {
        动物 animal;
        animal = new 狗();
        animal.cry();
        animal = new 猫();
        animal.cry();
    }
}




