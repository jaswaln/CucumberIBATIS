package ApiTestAutomation;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * Created by Neeraj on 04-05-2019.
 */
public class ApiRestAssuredTest {
    @Test
    public void GetWeatherDetails()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weatherfull/city";
        RequestSpecification httpRequest=RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/Pune");

        String responseBody =response.getContentType();
        int responseCode=response.getStatusCode();
        System.out.println("Status Code: "+responseCode);
        System.out.println("Response content is : "+responseBody);
    }
}
