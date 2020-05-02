package condition_example.functions;

import condition_example.AbstractCondition;
import condition_example.Condition;

@Condition(name = "AND",min=2)
public class AND extends AbstractCondition {
    @Override
    public Boolean getValue() {
        for(AbstractCondition c: getSubObjects()){
            if(c.getValue()==false) return false;
        }
        return true;
    }
}
