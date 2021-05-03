package Parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;


public class JsonDiffParser {
	
	public void diff() throws JsonMappingException, JsonProcessingException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		String s1 = "{\n"
				+ "    \"firstName\": \"John\",\n"
				+ "    \"lastName\": \"Smith\",\n"
				+ "    \"age\": 25,\n"
				+ "    \"address\": {\n"
				+ "        \"streetAddress\": \"21 2nd Street\",\n"
				+ "        \"city\": \"New York\",\n"
				+ "        \"state\": \"NY\",\n"
				+ "        \"postalCode\": 10021\n"
				+ "    },\n"
				+ "    \"phoneNumbers\": [\n"
				+ "        {\n"
				+ "            \"type\": \"home\",\n"
				+ "            \"number\": \"212 555-1234\"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"type\": \"fax\",\n"
				+ "            \"number\": \"646 555-4567\" \n"
				+ "        }\n"
				+ "    ] \n"
				+ "}";
		
		String s2 = "{\n"
				+ "    \"firstName\": \"John123\",\n"
				+ "    \"lastName\": \"Smith\",\n"
				+ "    \"age\": 25,\n"
				+ "    \"address\": {\n"
				+ "        \"streetAddress\": \"21 2nd Street\",\n"
				+ "        \"city\": \"New York\",\n"
				+ "        \"state\": \"NY\",\n"
				+ "        \"postalCode\": 10021\n"
				+ "    },\n"
				+ "    \"phoneNumbers\": [\n"
				+ "        {\n"
				+ "            \"type\": \"home\"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"type\": \"fax123\",\n"
				+ "            \"number\": \"646-4567\" \n"
				+ "        }\n"
				+ "    ] \n"
				+ "}";
		
		JsonNode beforeNode = mapper.readTree(s1);
		JsonNode afterNode = mapper.readTree(s2);
		JsonNode patch = JsonDiff.asJson(beforeNode, afterNode);
		String diffs = patch.toString().replace("[","").replace("]","").replaceAll("},", "}},");
		//System.out.println(diffs);
		String[] res = diffs.split("},");
		for(String s : res)
			System.out.println(s);
		
	}

}
