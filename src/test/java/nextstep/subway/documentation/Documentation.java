package nextstep.subway.documentation;

import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ActiveProfiles;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(RestDocumentationExtension.class)
class Documentation {
	protected RequestSpecification spec;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		this.spec = new RequestSpecBuilder()
			.addFilter(documentationConfiguration(restDocumentation))
			.build();
	}
}
