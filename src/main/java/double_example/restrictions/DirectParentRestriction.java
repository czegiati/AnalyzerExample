package double_example.restrictions;

import hu.unideb.czty.analyzer.core.Analyzer;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;
import hu.unideb.czty.analyzer.restrictions.core.RestrictionHandler;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class DirectParentRestriction implements RestrictionHandler {
    @Override
    public boolean accept(AnalyzerElement element, Object o, Analyzer analyzer, Annotation annotation) {
        if(Arrays.asList(((DirectParent)annotation).names()).contains(element.getParent().getName()))
        return true;
        else return false;
    }
}
