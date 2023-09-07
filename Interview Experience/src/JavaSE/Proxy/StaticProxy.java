package JavaSE.Proxy;


interface ClothFactory{

    void produceCloth();

}



class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory ;
    }

    @Override
    public void produceCloth() {

    }
}



public class StaticProxy {

}


