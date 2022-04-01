package MultiThread;

public class ObjectB extends Thread implements Action{
    @Override
    public void printSomething(String string ) {
        System.out.println(string);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
