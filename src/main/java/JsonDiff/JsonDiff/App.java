package JsonDiff.JsonDiff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Parsing.JsonDiffParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonMappingException, JsonProcessingException
    {
        
        JsonDiffParser s1 = new JsonDiffParser();
        s1.diff();
    }
}
