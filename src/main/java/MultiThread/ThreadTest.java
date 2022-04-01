package MultiThread;

public class ThreadTest {
    public static void main(String[] args) {
        ObjectA a = new ObjectA() ;
        ObjectB b = new ObjectB() ;

//        a.start();
//        b.start();

        a.run();
        b.run();
        a.printSomething(" sono il thread A");
        b.printSomething(" sono il thread B");



    }
}
