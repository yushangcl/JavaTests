//package win.likie.drools;
//
//
//import com.alibaba.dubbo.common.utils.CollectionUtils;
//import com.sprucetec.tms.fee.service.rule.RuleEngineService;
//import com.sprucetec.tms.fee.utils.RuleBaseFacatory;
//import org.drools.RuleBase;
//import org.drools.StatefulSession;
//import org.drools.compiler.PackageBuilder;
//import org.drools.spi.AgendaFilter;
//import org.springframework.stereotype.Service;
//
//import java.io.Reader;
//import java.io.StringReader;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by duyinqiang on 2016/12/12.
// * 规则接口实现类 .
// */
//@Service
//public class RuleEngineServiceImpl implements RuleEngineService {
//    private RuleBase ruleBase;
//
//    /**
//     * 初始化规则引擎.
//     *
//     * @param drlRuleDomains
//     */
//    public void initEngine(List<String> drlRuleDomains) {
//        // 设置时间格式
//        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
//        try {
//            synchronized (this) {
//                ruleBase = RuleBaseFacatory.getRuleBase();
//                // 从DB加载规则
//                PackageBuilder backageBuilder = this.getPackBuilderFromDrlDB(drlRuleDomains);
//                ruleBase.addPackages(backageBuilder.getPackages());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public <T> T executeRuleEngine(List<String> drlRuleDomains, T t) {
//        if (CollectionUtils.isEmpty(drlRuleDomains)) {
//            return t;
//        }
//        this.initEngine(drlRuleDomains);
//        if (null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {
//            return null;
//        }
//        StatefulSession statefulSession = ruleBase.newStatefulSession();
//        statefulSession.insert(t);
//        // fire
//        statefulSession.fireAllRules(new AgendaFilter() {
//            @Override
//            public boolean accept(org.drools.spi.Activation activation) {
//                return !activation.getRule().getName().contains("_test");
//            }
//        });
//        statefulSession.dispose();
//        return t;
//    }
//
//    /**
//     * 从Drl规则DB中读取规则
//     *
//     * @return
//     * @throws Exception
//     */
//    private PackageBuilder getPackBuilderFromDrlDB(List<String> drlRuleDomains) {
//        // 装载规则
//        List<Reader> readers = this.buildReadersFromDrlDB(drlRuleDomains);
//
//        // 装载PackageBuilder
//        try {
//            return this.buildPackageBuilder(readers);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 装载PackageBuilder
//     *
//     * @param readers
//     * @return
//     * @throws Exception
//     */
//    private PackageBuilder buildPackageBuilder(List<Reader> readers)
//            throws Exception {
//        if (null == readers || 0 == readers.size()) {
//            return null;
//        }
//        PackageBuilder backageBuilder = new PackageBuilder();
//        for (Reader r : readers) {
//            backageBuilder.addPackageFromDrl(r);
//        }
//        // 检查脚本是否有问题
//        if (backageBuilder.hasErrors()) {
//            throw new Exception(backageBuilder.getErrors().toString());
//        }
//        return backageBuilder;
//    }
//
//    /**
//     * 装载db中的规则到List<Reader>
//     *
//     * @return
//     */
//    private List<Reader> buildReadersFromDrlDB(List<String> drlRuleDomains) {
//        List<Reader> readers = new ArrayList<Reader>();
//        if (null == drlRuleDomains) {
//            return readers;
//        }
//        for (String ruleContext : drlRuleDomains) {
//            Reader br = new StringReader(ruleContext);
//            readers.add(br);
//        }
//        return readers;
//    }
//}