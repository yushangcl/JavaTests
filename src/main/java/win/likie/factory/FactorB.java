package win.likie.factory;

/**
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/5/10.
 */
public class FactorB extends BaseFactory {
    @Override
    BaseProduct Manufacture() {
        return new ProductB();
    }
}
