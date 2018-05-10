package win.likie.proxy.DynamicProxy;

import win.likie.proxy.RealSubject;
import win.likie.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class Test {

    public static void main(String[] args) {
        RealSubject realObject = new RealSubject();
        Subject proxy = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, new DynamicProxyHandler(realObject));
        proxy.buyMac();
    }
}
