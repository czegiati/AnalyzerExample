package condition_example.functions;

import condition_example.AbstractCondition;
import condition_example.Condition;

@Condition(name="OR",min=2)
public class OR extends AbstractCondition {
    @Override
    public Boolean getValue() {
        for(AbstractCondition c:getSubObjects()){
            if(c.getValue()==true) return true;
        }
        return false;
    }


}
