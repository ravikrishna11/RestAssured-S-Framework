package equifax.training.util;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Util {

	@SuppressWarnings("unchecked")
	public static JSONObject req(Object[] Key, Object[] Value) {

		JSONObject req = new JSONObject();
		for (int i = 0; i < Key.length; i++) {
			req.put(Key[i], Value[i]);
		}
		return req;
	}

	public static Response Res(JSONObject request, String serviceURL, int StatusCode) {

		Response response = null;
		baseURI = "http://localhost:8080/";
		response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Content-Type", "application/JSON").body(request.toJSONString()).when().post(serviceURL).then()
				.statusCode(StatusCode).log().all().contentType(ContentType.JSON).extract().response();
		return response;
	}

	@SuppressWarnings("unchecked")
	public static Response POSTRes(Object[] Key, Object[] Value, String serviceURL, int StatusCode) {

		Response response = null;
		baseURI = "http://localhost:8080/";
		RestAssured.defaultParser = Parser.JSON;

		JSONObject req = new JSONObject();
		for (int i = 0; i < Key.length; i++) {
			req.put(Key[i], Value[i]);
		}

		response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Content-Type", "application/JSON").body(req.toJSONString()).when().post(serviceURL).then()
				.statusCode(StatusCode).log().all().contentType(ContentType.JSON).extract().response();
		return response;
	}

	public static Response GETRes(String QueryP, int QueryV, String serviceURL, int StatusCode) {

		Response response = null;
		baseURI = "http://localhost:8080/";
		RestAssured.defaultParser = Parser.JSON;
		JSONObject req = new JSONObject();

		response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Content-Type", "application/JSON").body(req.toJSONString()).queryParam(QueryP, QueryV).when()
				.get(serviceURL).then().statusCode(StatusCode).log().all().contentType(ContentType.JSON).extract()
				.response();
		return response;
	}

	public static Response DELETERes(String QueryP, int QueryV, String serviceURL, int StatusCode) {

		Response response = null;
		baseURI = "http://localhost:8080/";
		RestAssured.defaultParser = Parser.JSON;
		JSONObject req = new JSONObject();

		response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Content-Type", "application/JSON").body(req.toJSONString()).queryParam(QueryP, QueryV).when()
				.delete(serviceURL).then().statusCode(StatusCode).log().all().contentType(ContentType.JSON).extract()
				.response();
		return response;
	}
}