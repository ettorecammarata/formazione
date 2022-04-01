package MultiThread;

public class ObjectA extends Thread implements Action {
    @Override
    public void printSomething(String string ) {
        System.out.println(string);
    }
}
