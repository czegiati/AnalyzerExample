package prefix_parser;


import hu.unideb.czty.analyzer.parsers.classes.AnalyzerElement;

import java.util.ArrayList;
import java.util.List;

public class Prefix {

    public static AnalyzerElement read(String str){
        if(isSyntaxErrorPresent(str)) throw new IllegalArgumentException("Syntax error in: "+str);
        return readElement(str, null);
    }

    private static AnalyzerElement readElement(String str,AnalyzerElement parent){
        AnalyzerElement root=new AnalyzerElement();     //create element
        if(parent!=null) root.setParent(parent);        //set parent, if the element has one
        int start=-1;
        int finish=-1;
        int open=0;
        int i=0;

        for(char c : str.toCharArray()){
            if(c=='('){
                if(open==0) start=i;
                open ++;
            }
            if(c==')'){
                if(open==1) finish=i;
                open --;
            }
            i++;
        }           //find opening and closing brackets

        root.setName(str.substring(0,start).trim());   //set element's name
        String inside=str.substring(start+1,finish);   //getting the string inside brackets
        int content=0;

        for(String s:splitUpWithCommas(inside)){       //separates with commas
            if(s.contains("(")){
                if(s.charAt(0)=='c' && s.charAt(1)==':'){
                    root.setContent(s.substring(2));
                    content++;
                } else root.getSubElements().add(readElement(s,root));
            }                   //create child element
            else if(s.contains("=")){          //attributes
                int eqIndex=s.indexOf("=");
                String attrName=s.substring(0,s.indexOf("="));
                String attrValue=s.substring(s.indexOf("=")+1);
                root.getAttributes().put(attrName.trim(),attrValue);
                //System.out.println(root.getName()+" "+root.getAttributes());
            }              //add attribute
            else if(content==0){
                if(s.charAt(0)=='c' && s.charAt(1)==':'){
                    root.setContent(s.substring(2));
                } else root.setContent(s);
                content++;
            }                   //add comment
            else throw new IllegalArgumentException("Syntax error when reading: "+s);

        }

        return root;
    }

    private static boolean isSyntaxErrorPresent(String str){
        int open = 0;
        int close= 0;
        char lastChar=' ';
        for(char c: str.toCharArray()){
            if(c=='('){
                open++;
            } else if(c==')'){
                close++;
            }
             //if(lastChar==')' &&( c!=')' && c!=',')) return true;
            if(c !=' ' && c !='\n' && c != '\t') lastChar=c;
        }
        return !((open==close)); // && str.length()-1==str.lastIndexOf(')'));
    }

    private static List<String> splitUpWithCommas(String str){
        List<String> list=new ArrayList<>();
        int open =0;
        int i=0;
        int startAt=0;
        for(char c: str.toCharArray()){
            if(c=='(') open++;
            if(c==')') {
                open--;
            }
            if(open==0){
                if(c==','){
                    list.add(str.substring(startAt,i));
                    startAt=i+1;
                }
                if(i+1==str.length()){
                    list.add(str.substring(startAt,i+1));
                }
            }
            i++;
        }
        return list;
    }


}
