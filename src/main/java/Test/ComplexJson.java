package main.java.Test;

import main.java.data.input;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import main.java.utils.Utils;

public class ComplexJson {
    String placeId;
    String baseURI ="https://rahulshettyacademy.com";

   JsonPath js = Utils.rawToJson(input.CoursePrice());

   @Test
    public void complexResponse(){
       SoftAssert sa = new SoftAssert();
       int numberOfCourses = js.getInt("courses.size()");
       sa.assertEquals(numberOfCourses,4);
       sa.assertEquals(js.getInt("dashboard.purchaseAmount"),1162);
       int total = js.getInt("dashboard.purchaseAmount");

       System.out.println(js.getString("courses[0].title"));
       int priceOfEachBook =0;
       int finalAmount=0;
       int RPACopies =0;
       for(int i=0;i<numberOfCourses;i++){
           int copies = js.getInt("courses["+i+"].copies");
           int price = js.getInt("courses["+i+"].price");
           if(js.getString("courses["+i+"].title").equals("RPA")){
               RPACopies = copies;
           }

           priceOfEachBook= copies * price;
           finalAmount= finalAmount+priceOfEachBook;


       }
       System.out.println("total:"+ total);
       System.out.println("finalAmount:"+ finalAmount);
       System.out.println("RPACopies:"+ RPACopies);
       Assert.assertEquals(finalAmount,total);






   }

}

