package RestFulBooker;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class MultipleBookingsWithRequestSpec {
    @Test
    public void createBooking1()
    {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .body("{\r\n" +
                        "    \"firstname\" : \"Amod\",\r\n" +
                        "    \"lastname\" : \"Mahajan\",\r\n" +
                        "    \"totalprice\" : 15,\r\n" +
                        "    \"depositpaid\" : false,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2021-01-01\",\r\n" +
                        "        \"checkout\" : \"2021-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Lunch\"\r\n" +
                        "}")
                .contentType(ContentType.JSON)
                // Hit the request and get the response
                .post()
                // Validate the response
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void updateBooking()
    {
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/1")
                .header("Content-Type","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body("{\r\n" +
                        "    \"firstname\" : \"Amod\",\r\n" +
                        "    \"lastname\" : \"Mahajan\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .when()
                .put()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }

}

