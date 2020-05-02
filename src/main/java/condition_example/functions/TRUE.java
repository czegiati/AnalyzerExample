package condition_example.functions;

import condition_example.AbstractCondition;
import condition_example.Condition;

@Condition(name="TRUE", max=0)
public class TRUE extends AbstractCondition {
    @Override
    public Boolean getValue() {
        return true;
    }
}
