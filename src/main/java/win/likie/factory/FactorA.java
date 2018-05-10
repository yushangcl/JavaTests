package win.likie.factory;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class FactorA extends BaseFactory {
    @Override
    BaseProduct Manufacture() {
        return new ProductA();
    }
}
