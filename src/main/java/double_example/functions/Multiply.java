package double_example.functions;

import double_example.AbstractDouble;
import double_example.DoubleNumber;

@DoubleNumber(name = "MUL",min=2)
public class Multiply extends AbstractDouble {


    @Override
    public Double getValue() {
        double d=1.0;
        for(AbstractDouble ad:getSubObjects()){
            d*=ad.getValue();
        }
        return d;
    }
}
