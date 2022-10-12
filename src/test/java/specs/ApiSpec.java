package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiSpec {
    public static final RequestSpecification REQ_SPEQ =
            new RequestSpecBuilder()
                    .setBaseUri("")
                    .setBasePath("/api")
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
}
