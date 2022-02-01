package data;

import io.restassured.path.json.JsonPath;

public class input {


    public static String AddPlace() {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";


    }

    public static String updatePlace(String placeId) {
        return "  {\n" +
                "        \"place_id\": \"" + placeId + "\",\n" +
                "        \"address\": \"70,Raj St MA ,USA\",\n" +
                "        \"key\": \"qaclick123\"\n" +
                "    }";
    }


    public static String CoursePrice() {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }

    public static String placeSchema(){
        return "{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
                "  \"$id\": \"https://rahulshettyacademy.com/maps/api/place/get/json.schema.json\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"location\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "              \"latitude\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"longitude\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "\n" +
                "      }\n" +
                "\n" +
                "    },\n" +
                "    \"accuracy\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"phone_number\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"website\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"language\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

}

