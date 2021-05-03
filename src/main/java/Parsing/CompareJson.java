package Parsing;

import java.util.ArrayList;
import java.util.List;

import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

public class CompareJson {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		String s1 = "{\n" + "    \"firstName\": \"John\",\n" + "    \"lastName\": \"Smith\",\n" + "    \"age\": 25,\n"
//				+ "    \"address\": {\n" + "        \"streetAddress\": \"21 2nd Street\",\n"
//				+ "        \"city\": \"New York\",\n" + "        \"state\": \"NY\",\n"
//				+ "        \"postalCode\": 10021\n" + "    },\n" + "    \"phoneNumbers\": [\n" + "        {\n"
//				+ "            \"type\": \"home\",\n" + "            \"number\": \"2125551234\"\n" + "        },\n"
//				+ "        {\n" + "            \"type\": \"fax\",\n" + "            \"number\": \"646 555-4567\" \n"
//				+ "        }\n" + "    ] \n" + "}";
//
//		String s2 = "{\n" + "    \"firstName\": \"John\",\n" + "    \"lastName\": \"Smith\",\n" + "    \"age\": 25,\n"
//				+ "    \"address\": {\n" + "        \"streetAddress\": \"21 2nd Street\",\n"
//				+ "        \"city\": \"New York\",\n" + "        \"state\": \"NY\",\n"
//				+ "        \"postalCode\": 10021\n" + "    },\n" + "    \"phoneNumbers\": [\n" + "        {\n"
//				+ "            \"type\": \"home1\",\n" + "            \"number\": \"21255512341\"\n" + "        },\n"
//				+ "        {\n" + "            \"type\": \"fax123\",\n" + "            \"number\": \"646 555-4567\" \n"
//				+ "        }\n" + "    ] \n" + "}";

		String s1 = "{\n" + "  \"requestHeader\": {\n" + "    \"tenantID\": 1234\n" + "  },\n"
				+ "  \"TemplateConfiguration\": {\n" + "    \"branchName\": \"Regal\",\n"
				+ "    \"folderName\": \"QA_Auto_2PM\",\n" + "    \"isDefault\": true,\n"
				+ "    \"urlExpressionID\": 0,\n" + "    \"latestVersion\": \"RBENT-001\",\n" + "    \"versions\": [\n"
				+ "      \"RBENT-001\",\n" + "      \"RBENT-002\"\n" + "    ],\n" + "    \"criteria\": [\n"
				+ "      {\n" + "        \"version\": \"RBENT-001\",\n" + "        \"filters\": [\n" + "          {\n"
				+ "            \"name\": \"Location\",\n" + "            \"values\": [\n"
				+ "              \"California\",\n" + "              \"Hyderabad\",\n" + "              \"Chicago\",\n"
				+ "              \"New York City\"\n" + "            ],\n" + "            \"operator\": \"Equal\",\n"
				+ "            \"logical\": \"And\"\n" + "          },\n" + "          {\n"
				+ "            \"name\": \"Speciality\",\n" + "            \"values\": [\n"
				+ "              \"Pediatricians\",\n" + "              \"General Surgeon\"\n" + "            ],\n"
				+ "            \"operator\": \"Equal\",\n" + "            \"logical\": \"And\"\n" + "          }\n"
				+ "        ]\n" + "      },\n" + "      {\n" + "        \"version\": \"RBENT-002\",\n"
				+ "        \"filters\": [\n" + "          {\n" + "            \"name\": \"Location\",\n"
				+ "            \"values\": [\n" + "              \"California\",\n" + "              \"Hyderabad\"\n"
				+ "            ],\n" + "            \"operator\": \"Equal\",\n" + "            \"logical\": \"And\"\n"
				+ "          }\n" + "        ]\n" + "      }\n" + "    ]\n" + "  }\n" + "}";
		String s2 = "{\n" + "  \"requestHeader\": {\n" + "    \"tenantID\": 1234\n" + "  },\n"
				+ "  \"TemplateConfiguration\": {\n" + "    \"branchName\": \"Regal\",\n"
				+ "    \"folderName\": \"QA_Auto\",\n" + "    \"isDefault\": false,\n" + "    \"urlExpressionID\": 0,\n"
				+ "    \"latestVersion\": \"RBENT-001\",\n" + "    \"versions\": [\n" + "      \"RBENT-001\"\n"
				+ "    ],\n" + "    \"criteria\": [\n" + "      {\n" + "        \"version\": \"RBENT-001\",\n"
				+ "        \"filters\": [\n" + "          {\n" + "            \"name\": \"Location\",\n"
				+ "            \"values\": [\n" + "              \"California\",\n" + "              \"Hyderabad\",\n"
				+ "              \"Chicago\",\n" + "              \"New York City\"\n" + "            ],\n"
				+ "            \"operator\": \"Equal\",\n" + "            \"logical\": \"And\"\n" + "          },\n"
				+ "          {\n" + "            \"name\": \"Speciality\",\n" + "            \"values\": [\n"
				+ "              \"Pediatricians\",\n" + "              \"General Surgeon\"\n" + "            ],\n"
				+ "            \"operator\": \"Equal\",\n" + "            \"logical\": \"And\"\n" + "          }\n"
				+ "        ]\n" + "      },\n" + "      {\n" + "        \"version\": \"RBENT-002\",\n"
				+ "        \"filters\": [\n" + "          {\n" + "            \"name\": \"Location\",\n"
				+ "            \"values\": [\n" + "              \"California\",\n" + "              \"Hyderabad\"\n"
				+ "            ]\n" + "          }\n" + "        ]\n" + "      }\n" + "    ]\n" + "  }\n" + "}";

		JSONCompareResult result = JSONCompare.compareJSON(s1, s2, JSONCompareMode.STRICT);
		if (result.toString().length() <= 0)
			System.out.println("No Change");
		else {
			String[] res = result.toString().split(";");
//			for (String s4 : res)
//				System.out.print(s4);
			List<List<String>> output = new ArrayList<List<String>>();
			for (String s : res) {
				List<String> temp = new ArrayList<String>();
				String[] temparr = new String[2];
				if (s.contains("got:"))
					temparr = s.split("Expected:");
				else {
					if (s.contains("Expected:"))
						temparr = s.split("Expected:");
					else
						temparr = s.split("Expected");
				}

				temp.add("Field: " + temparr[0].trim());
				if (temparr[1].contains("got:"))
					temparr = temparr[1].trim().split("got:");
				else
					temparr = temparr[1].trim().split("but");
				temp.add("Expected: " + temparr[0].trim());
				if (temparr[0].trim().matches("-?\\d+")) {
					temp.add("DataType: Integer");
				} else {
					if (temparr[0].trim().equals("true") || temparr[0].trim().equals("false"))
						temp.add("DataType: Boolean");
					else
						temp.add("DataType: String");
				}

				output.add(temp);

			}

			for (List<String> out : output)
				System.out.println(out);
		}

	}

}
