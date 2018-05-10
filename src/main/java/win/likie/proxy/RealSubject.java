package win.likie.proxy;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class RealSubject implements Subject {
    @Override
    public void buyMac() {
        System.out.println("买MAC");
    }
}
