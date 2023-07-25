package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (var c : source.toCharArray()) {
            var currentDelimiter = getDelimiterStartsWithChar(delimiters, c);
            if(currentDelimiter != null){
                if(source.substring(source.indexOf(c), source.indexOf(c) + currentDelimiter.length()).equals(currentDelimiter)){
                    if(!buffer.toString().isBlank())
                        result.add(buffer.toString());
                    buffer = new StringBuilder();
                }
            }else {
                buffer.append(c);
            }
        }
        if(!buffer.toString().isBlank())
            result.add(buffer.toString());
        return result;
        //throw new UnsupportedOperationException("You should implement this method.");
    }

    private String getDelimiterStartsWithChar(Collection<String> delimiters, char startChar){
        for (var delimiter: delimiters){
            if(delimiter.charAt(0) == startChar)
                return delimiter;
        }
        return null;
    }
}
