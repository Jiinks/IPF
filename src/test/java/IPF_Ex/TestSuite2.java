package IPF_Ex;

import IPF_Ex.helpers.PostObject;
import IPF_Ex.helpers.TestDataGenerator;

import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * TestSuite2
 */
public class TestSuite2 {

    private final static String baseUri = "https://jsonplaceholder.typicode.com";
    private int maxUserId = -1;
    private int maxPostId = -1;

    @BeforeClass
    public static void Setup() {
        baseURI = baseUri;
    }

    @Test(priority = 1)
    public void GetMaxUserId() {
        Response response = get("/posts");
        assertEquals(200, response.statusCode());

        PostObject[] posts = get("/posts").as(PostObject[].class);
        for (PostObject post : posts) {
            if (post.userId > maxUserId) {
                maxUserId = post.userId;
            }
        }

        assertTrue(maxUserId > -1);
    }

    @Test(priority = 2)
    public void GetMaxUserPostId() {
        Response response = get("/posts?userId={userId}", maxUserId);
        assertEquals(200, response.statusCode());

        PostObject[] posts = response.body().as(PostObject[].class);
        for (PostObject post : posts) {
            if (post.id > maxPostId) {
                maxPostId = post.id;
            }
        }

        assertTrue(maxPostId > -1);
        
    }

    @Test(priority = 2)
    public void CreateCommentForPost() {
        Response response = get("/comments");
        int actualSize = response.body().jsonPath().getList("").size();

        JsonObject json = new JsonObject();
        json.addProperty("postId", maxPostId);
        json.addProperty("name", TestDataGenerator.GetFirstName());
        json.addProperty("email", TestDataGenerator.GetEmail());
        json.addProperty("body", TestDataGenerator.GetRandomString());

        response = given().
            contentType("application/json").body(json.toString()).
            when().
            post("/comments");

        assertEquals(201, response.statusCode());
        assertEquals(actualSize + 1, response.jsonPath().get("id"));
    }
}