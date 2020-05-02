package double_example.functions;


import double_example.AbstractDouble;
import double_example.DoubleNumber;
import hu.unideb.czty.analyzer.core.fields.Content;

@DoubleNumber(name = "CONST",max = 0)
public class Const extends AbstractDouble {

    @Content
    String content;

    @Override
    public Double getValue() {
        return Double.valueOf(content);
    }
}
