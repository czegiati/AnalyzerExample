package prefix_parser;

import hu.unideb.czty.analyzer.core.AbstractObject;
import hu.unideb.czty.analyzer.core.Analyzer;
import hu.unideb.czty.analyzer.parsers.interfaces.AnalyzerParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrefixParser implements AnalyzerParser
{
    @Override
    public AbstractObject parseFromFile(String input, Analyzer analyzer) {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(input) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return parseRoot(Prefix.read(content),analyzer);
    }

    @Override
    public AbstractObject parseFromString(String str, Analyzer analyzer) {
        return parseRoot(Prefix.read(str),analyzer);
    }
}
