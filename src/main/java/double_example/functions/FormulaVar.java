package double_example.functions;

import double_example.AbstractDouble;
import double_example.DoubleNumber;
import hu.unideb.czty.analyzer.core.fields.Content;
import hu.unideb.czty.analyzer.core.fields.GetAnalyzerElement;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;
@DoubleNumber(name="FVAR",max=1)
public class FormulaVar extends AbstractDouble {

    @Content
    String content;

    @GetAnalyzerElement
    AnalyzerElement element;

    @Override
    public Double getValue() {
        if(getSubObjects().size()==0)
        return Double.valueOf(content);
        else return getSubObjects().get(0).getValue();
    }

    public String getName(){
        return element.getAttributes().get("name");
    }
}
