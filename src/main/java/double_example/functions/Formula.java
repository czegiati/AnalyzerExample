package double_example.functions;

import double_example.AbstractDouble;
import double_example.DoubleNumber;
import double_example.restrictions.HaveChildren;
import hu.unideb.czty.analyzer.core.fields.Content;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.List;

@DoubleNumber(name="FORMULA")
@HaveChildren(names={"FVAR"})
public class Formula extends AbstractDouble {

    @Content
    String content;

    @Override
    public Double getValue() {

        //set expression
        ExpressionBuilder eb=new ExpressionBuilder(content);


        //set variable names in expression
        for(String s: getVarNames()){
            eb.variables(s);
        }
        Expression exp= eb.build();


        //set variable values in expression
        for(AbstractDouble ad: getSubObjects()){
            exp.setVariable(((FormulaVar)ad).getName(),((FormulaVar) ad).getValue());
        }


        return exp.evaluate();
    }


    private List<String> getVarNames(){
        List<String> namesList=new ArrayList<>();
        for(AbstractDouble ad:getSubObjects()){
            if(ad instanceof FormulaVar){
               namesList.add (((FormulaVar) ad).getName());
            }
        }
        return namesList;
    }
}
