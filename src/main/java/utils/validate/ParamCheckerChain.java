package utils.validate;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

/**
 * @Author hezhensheng
 * @Date 2021/4/20
 * @Description
 */
public class ParamCheckerChain {
    private List<Pair<ParamChecker, ?>> paramCheckerChain;

    public ParamCheckerChain(List<Pair<ParamChecker, ?>> paramCheckerChain) {
        this.paramCheckerChain = paramCheckerChain;
    }

    public static ParamCheckerChain newCheckerChain() {
        return new ParamCheckerChain(new ArrayList<>());
    }

}
