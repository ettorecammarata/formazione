package esercitazione;

public class FourWheels extends Vehicle implements MyInterface{

    public void getStart () {
        System.out.println("avvio quattro ruote");
    }

    @Override
    public void method() {
        System.out.println("fW");
    }
}
