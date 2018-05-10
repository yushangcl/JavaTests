package win.likie;

/**
 * @author huahui.wu.
 * Created on 2018/3/22.
 */
public class RecordExample2 {

    public static void main(String[] args) {
        final RecordExample2 e = new RecordExample2();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A");
                }

            }
        };


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("B");
                }

            }
        };


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println("Runn");
            }
        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("D");
                }
            }
        };
        Thread thread4 = new Thread(runnable, "new C");
        String name = Thread.currentThread().getName();
        System.out.println(name);

        thread1.start();
        thread2.start();

    }

    int a = 0;
    boolean flag = false;

    /**
     * A线程执行
     */
    public void writer() {
        a = 1;                  // 1
        flag = true;            // 2
    }

    /**
     * B线程执行
     */
    public void read() {
        if (flag) {                  // 3
            int i = a + a;          // 4
        }
    }



}
