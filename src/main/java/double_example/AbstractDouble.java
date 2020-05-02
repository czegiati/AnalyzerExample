package double_example;

import hu.unideb.czty.analyzer.core.AbstractObject;
import hu.unideb.czty.analyzer.core.type.TypeBridge;

public abstract class AbstractDouble extends AbstractObject<Double,AbstractDouble> {

    @TypeBridge(name = "HIGHEST_NUMBER",analyzerClass = DoubleAnalyzer.class)
    public static AbstractDouble foo(AbstractDouble num1,AbstractDouble num2){
        if(num1.getValue()>num2.getValue()){
            return num1;
        }else
            return num2;
    }
}
