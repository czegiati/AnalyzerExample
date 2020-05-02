package condition_example;

import hu.unideb.czty.analyzer.core.AbstractObject;
import hu.unideb.czty.analyzer.core.Analyzer;
import hu.unideb.czty.analyzer.exceptions.AnalyzerDetectorException;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ConditionAnalyzer implements Analyzer {

    private static  Map<String, Class<AbstractObject>> map=new HashMap<>();


    public ConditionAnalyzer() {
        try {
            detect("condition_example");
        } catch (AnalyzerDetectorException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Class<AbstractObject>> getAbstractClassMap() {
        return map;
    }

    @Override
    public boolean acceptAnnotationOn(Map annotation, Class<?> class0, AnalyzerElement element, Analyzer analyzer) {
        int min=(int)annotation.get("min");
        int max=(int)annotation.get("max");
        int num=element.getSubElements().size();
        return (num<=max && num>=min)||(num>=min && max==-1);
    }

    @Override
    public Class getAnnotationClass() {
        return Condition.class;
    }

    @Override
    public Class getAbstractClass() {
        return AbstractCondition.class;
    }
}
