package main.java.Test;

import main.java.data.input;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import main.java.utils.Utils;
import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class testing{
    String placeId;
    String baseURI ="https://rahulshettyacademy.com";

    File schema = new File(System.getProperty("user.dir")+"/src/main/java/data/schema.json");
   // File update = new File(System.getProperty("user.dir")+"/src/main/java/data/update.json");
    String baseDir = System.getProperty("user.dir");
    String addPlaceJson = System.getProperty("user.dir")+"/src/main/java/data/addPlace.json";



    @Test(enabled = false)
    public void test1(){
        Response resp = get("https://www.boredapi.com/api/activity");
        int status = resp.getStatusCode();
        Assert.assertEquals(status,200);

    }

    @Test(enabled = false)
    public void test2(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json")
                .header("Connection","keep-alive");

        JSONObject json = new JSONObject();

        json.put("userId",1);
        json.put("id",8);
        json.put("title","raj");
        json.put("completed",false);

        request.body(json.toJSONString());
       Response resp=  request.post("https://jsonplaceholder.typicode.com/todos");
       int status = resp.getStatusCode();
       Assert.assertEquals(status,200);


    }
    @Test()
    public void addPlace() throws IOException {
        SessionFilter sf = new SessionFilter();
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json")
                .queryParam("key","qaclick123")
               // .body(input.AddPlace());
                .body(Utils.jsonToString(addPlaceJson));

        Response resp = request.filter(sf)
                .post(baseURI+"/maps/api/place/add/json");
       resp.then().body("scope",equalTo("APP"));

        int status = resp.getStatusCode();
        String server = resp.header("server");
        Assert.assertEquals(status,200);

        String response = resp.asString();
        System.out.println("response:"+ response);
        JsonPath js = Utils.rawToJson(response);
        placeId = js.getString("place_id");
        String address = js.getString("address");
        System.out.println(placeId);
        System.out.println(server);
        System.out.println(address);



    }
    @Test(dependsOnMethods = {"addPlace"})
    public void updatePlace(){

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json")
                .queryParam("key","qaclick123")
                .body(input.updatePlace(placeId));

        System.out.println(input.updatePlace(placeId));
        Response resp = request.put(baseURI+"/maps/api/place/update/json");
        int status = resp.getStatusCode();
        Assert.assertEquals(status,404);

        String response = resp.asString();
        JsonPath js = Utils.rawToJson(response);
        String msg = js.getString("msg");
        System.out.println(msg);



    }

    @Test(dependsOnMethods = {"updatePlace"})
    public void getPlace(){
        RequestSpecification request = RestAssured.given();
        request.queryParam("key","qaclick123")
                .queryParam("place_id",placeId);
        Response resp = request.get(baseURI+"/maps/api/place/get/json");
        //resp.then().body(matchesJsonSchema(input.placeSchema()));
        resp.then().body(matchesJsonSchema(schema));
        int status = resp.getStatusCode();
        Assert.assertEquals(status,200);

        String response = resp.asString();
        JsonPath js = Utils.rawToJson(response);
        String address = js.getString("address");
        System.out.println(address);
        System.out.println(schema);


    }

//    @DataProvider(name="placeData")
//    public Object[][] getData(){
//
//        return new Object[][] {{1,2},{3,4}};
//    }

}

