package win.likie.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object realObject;

    DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理扩展逻辑
        System.out.println("proxy do");

        return method.invoke(realObject, args);
    }
}
