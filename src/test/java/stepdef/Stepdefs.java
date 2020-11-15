package stepdef;

import common.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import java.util.List;
import java.util.Map;

/**
 * Contains Step Definitions
 */

public class Stepdefs {


    @Given("I execute GET operation to retrieve Manufacturer Brand information for the below locale")
    public void i_execute_get_operation_to_retrieve_manufacturer_brand_information_for_the_below_locale(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> value : table) {
            System.out.println(value.get("Locale"));
            given()
                    .contentType(ContentType.JSON)
                    .queryParams("locale", value.get("Locale"))
                    .queryParam("wa_key", Utility.getProp("AccessKey")).
            when()
                    .get(Utility.getProp("BaseURL")+"/v1/car-types/manufacturer").
            then()
                    .statusCode(200)
                    .assertThat().body("totalPageCount", equalTo(1));

        }

    }

}
