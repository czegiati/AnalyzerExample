package condition_example;

import condition_example.functions.FALSE;
import condition_example.functions.TRUE;
import double_example.AbstractDouble;
import double_example.DoubleAnalyzer;
import hu.unideb.czty.analyzer.core.AbstractObject;
import hu.unideb.czty.analyzer.core.attributes.AttributeParam;
import hu.unideb.czty.analyzer.core.attributes.Interceptor;
import hu.unideb.czty.analyzer.core.type.TypeBridge;
import hu.unideb.czty.analyzer.restrictions.AttributeValues;


public abstract class AbstractCondition extends AbstractObject<Boolean,AbstractCondition> {

    public static String type;

    @AttributeValues(name="type", values={"EQ","GT","LT","GE","LE"})
    @TypeBridge(name="COMPARE",analyzerClass = DoubleAnalyzer.class)
    public static AbstractCondition compare(AbstractDouble num1,AbstractDouble num2){
        switch (type){
            case "EQ": return toAbstractForm(num1.getValue().equals( num2.getValue()));
            case "GT": return toAbstractForm(num1.getValue()    >   num2.getValue());
            case "LT": return toAbstractForm(num1.getValue()    <   num2.getValue());
            case "GE": return toAbstractForm(num1.getValue()    >=  num2.getValue());
            default: return toAbstractForm(num1.getValue()    <=  num2.getValue());

        }
    }

    @Interceptor("COMPARE")
    public static void init(@AttributeParam("type")String t){
        type=t;
    }

    private static AbstractCondition toAbstractForm(Boolean b){
        if(b) return new TRUE();
        else return new FALSE();
    }
}
