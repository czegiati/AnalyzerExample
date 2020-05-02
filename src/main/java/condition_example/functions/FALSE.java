package condition_example.functions;

import condition_example.AbstractCondition;
import condition_example.Condition;

@Condition(name="FALSE",max=0)
public class FALSE extends AbstractCondition {
    @Override
    public Boolean getValue() {
        return false;
    }
}
