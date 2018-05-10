package win.likie.proxy;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class Proxy implements Subject {
    @Override
    public void buyMac() {
        RealSubject realSubject = new RealSubject();
        realSubject.buyMac();
        warpMac();
    }

    private void warpMac() {
        System.out.println("其他处理");
    }
}
