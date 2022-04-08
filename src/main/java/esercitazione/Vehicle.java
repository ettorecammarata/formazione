package esercitazione;

public abstract class Vehicle implements MyInterface{

    public void getStart () {
        System.out.println("avvio veicolo");
    }

    @Override
    public void method () {
        System.out.println("method Vehicle");
    }
}
