package double_example.restrictions;

import hu.unideb.czty.analyzer.core.Analyzer;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;
import hu.unideb.czty.analyzer.restrictions.core.RestrictionHandler;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

public class HaveChildrenRestriction implements RestrictionHandler {
    @Override
    public boolean accept(AnalyzerElement element, Object o, Analyzer analyzer, Annotation annotation) {
        List<String> namesList= Arrays.asList(((HaveChildren) annotation).names());
        for(AnalyzerElement ae:element.getSubElements()){
            if(!namesList.contains(ae.getName()))
                return false;
        }
        return true;
    }
}
