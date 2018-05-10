package win.likie.factory;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class Test {

    public static void main(String[] args) {
        BaseFactory factory = new FactorA();
        factory.Manufacture().show();

        BaseFactory factory1 = new FactorB();
        factory1.Manufacture().show();
    }
}
