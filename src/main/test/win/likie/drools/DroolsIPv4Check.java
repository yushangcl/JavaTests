package win.likie.drools;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.conf.MultithreadEvaluationOption;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatelessKnowledgeSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by huahui.wu on 2017/7/24.
 */
public class DroolsIPv4Check {
    @Test
    public void testRules() {
        // 构建KieServices
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        // 获取kmodule.xml中配置中名称为ksession-rule的session，默认为有状态的。
        KieSession kSession = kieContainer.newKieSession("ksession-rule");
        Product product = new Product();
        product.setType(Product.DIAMOND);

        List<Product> products = new ArrayList<>();
        products.add(product);

        kSession.insert(product);
        int count = kSession.fireAllRules();
        System.out.println("命中了" + count + "条规则！");
        System.out.println("商品" +product.getType() + "的商品折扣为" + product.getDiscount() + "%。");

    }

    @Test
    public void testRuls1() {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com.rules.rules.drl",DroolsIPv4Check.class), ResourceType.DRL);
        Collection<KnowledgePackage> kpackage =	kbuilder.getKnowledgePackages();

        KieBaseConfiguration kbConf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
        kbConf.setProperty("org.drools.sequential", "true");
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(kbConf);
        kbase.addKnowledgePackages(kpackage);//将KnowledgePackage集合添加到KnowledgeBase当中

        StatelessKnowledgeSession statelessKSession=kbase.newStatelessKnowledgeSession();
        ArrayList list=new ArrayList();
        list.add(new Object());
        list.add(new Object());
        statelessKSession.execute(list);
    }

    @Test
    public void testRules2() {
        KieServices ks = KieServices.Factory.get();
        KieBaseConfiguration kieBaseConf = ks.newKieBaseConfiguration();
        kieBaseConf.setOption(MultithreadEvaluationOption.YES);
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieBase kieBase = kieContainer.newKieBase(kieBaseConf);
    }

}
