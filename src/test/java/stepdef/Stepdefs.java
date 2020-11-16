package stepdef;

import common.Utility;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import static io.restassured.RestAssured.given;



/**
 * Contains Step Definitions
 */

public class Stepdefs {

    @Given("^I execute GET operation to retrieve Manufacturer Brand information for the below (.+)$")
    public void i_execute_get_operation_to_retrieve_manufacturer_brand_information_for_the_below(String locale) {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .queryParams("locale", locale)
                        .queryParam("wa_key", Utility.getProp("AccessKey")).
                when()
                        .get(Utility.getProp("BaseURL") + "/v1/car-types/manufacturer").
                then()
                        .statusCode(200)
                        .extract().response();

        try {
            JSONAssert.assertEquals(response.asString(), Utility.getJSONObj("Brands", locale).toString(), JSONCompareMode.NON_EXTENSIBLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Given("^I execute GET operation to retrieve Model information for the below (.+) and (.+)$")
    public void i_execute_get_operation_to_retrieve_model_information_for_the_below(String locale,String brand) {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .queryParams("locale", locale)
                        .queryParams("manufacturer", Utility.getBrandID(brand))
                        .queryParam("wa_key", Utility.getProp("AccessKey")).
                when()
                        .get(Utility.getProp("BaseURL") + "/v1/car-types/main-types").
                then()
                        .statusCode(200)
                        .extract().response();

        try {
            JSONAssert.assertEquals(response.asString(), Utility.getJSONObj("Models", brand).toString(), JSONCompareMode.NON_EXTENSIBLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
