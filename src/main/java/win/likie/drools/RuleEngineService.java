package win.likie.drools;

import java.util.List;

/**
 * Created by huahui.wu on 2017/7/25.
 */
public interface RuleEngineService {

    public <T> T executeRuleEngine(List<String> drlRuleDomains, T t);
}
