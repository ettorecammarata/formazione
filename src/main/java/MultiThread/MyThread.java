package MultiThread;

public class MyThread {
    public static void main(String[] args) {
        Integer a = 0 ;
        Integer b = 0 ;

        int i = 0 ;
        while (i < 20) {
        Thread mytA = new Thread(()-> {
                System.out.println("thread A");
        });

        Thread mytB = new Thread(()-> {
                System.err.println("thread B");
        });
        mytA.start();
        mytB.start();
            i++;
        }
    }
}
