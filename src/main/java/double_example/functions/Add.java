package double_example.functions;

import double_example.AbstractDouble;
import double_example.DoubleNumber;

@DoubleNumber(name = "ADD",min=2)
public class Add extends AbstractDouble {

    @Override
    public Double getValue() {
        double d=0.0;
        for(AbstractDouble ad:getSubObjects()){
            d+=ad.getValue();
        }
        return d;
    }
}
