package double_example.restrictions;

import hu.unideb.czty.analyzer.core.Analyzer;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;
import hu.unideb.czty.analyzer.restrictions.core.RestrictionHandler;

import java.lang.annotation.Annotation;

public class MyRestrictionImpl implements RestrictionHandler {
    @Override
    public boolean accept(AnalyzerElement e, Object o, Analyzer a, Annotation an) {
        return true;
    }

    @Override
    public String getMessage(Annotation annotation) {
        return "My custom error message!";
    }
}
