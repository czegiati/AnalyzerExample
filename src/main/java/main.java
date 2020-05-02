import condition_example.ConditionAnalyzer;
import double_example.DoubleAnalyzer;
import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;
import hu.unideb.czty.analyzer.parsers.implementations.XMLParser;
import prefix_parser.Prefix;
import prefix_parser.PrefixParser;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        ConditionAnalyzer a=new ConditionAnalyzer(); System.out.println(new XMLParser().parseFromFile("xml.xml",a).getValue());

    }

    public static void readAnalyzerElement(AnalyzerElement ae){
        System.out.println("NAME = "+ae.getName());
        System.out.println(ae.getName() +" -> CONTENT = "+ae.getContent());
        System.out.println(ae.getName() +" -> ATTRIBUTES ="+ae.getAttributes());
        System.out.println(ae.getName() +" -> CHILDREN = "+ae.getSubElements().stream().map(o -> o.getName()).collect(Collectors.toList()));
        for(AnalyzerElement a: ae.getSubElements()){
            readAnalyzerElement(a);
        }


    }
}
