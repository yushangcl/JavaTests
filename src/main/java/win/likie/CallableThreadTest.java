package win.likie;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huahui.wu.
 * Created on 2018/3/22.
 */
public class CallableThreadTest implements Callable {


    public static void main(String[] args) {
        CallableThreadTest callableThreadTest = new CallableThreadTest();
        FutureTask<Integer> task = new FutureTask<>(callableThreadTest);
        Thread thread = new Thread(task);
        thread.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable running");
        return 1;
    }
}
