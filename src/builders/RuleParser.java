package builders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RuleParser {
    public static Integer getParamCount(String templateString){
          String[] words = templateString.split("<");
          return words.length;
    }
}
