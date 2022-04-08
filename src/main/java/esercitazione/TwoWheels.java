package esercitazione;

public class TwoWheels extends Vehicle implements MyInterface{

    public void getStart () {
        System.out.println("avvio due ruote");
    }

    @Override
    public void method() {
        System.out.println("tW");
    }
}
