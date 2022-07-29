package specs;

import config.AppConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {
    public static final RequestSpecification REQ_SPEQ =
            new RequestSpecBuilder()
                    .setBaseUri(AppConfig.ApiUrl)
                    .setBasePath("/api")
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
}
