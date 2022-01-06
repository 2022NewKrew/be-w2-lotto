import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        // matches "GET /hello/foo" and "GET /hello/bar"
// request.params(":name") is 'foo' or 'bar'
        get("/hello", (request, response) -> {
            return "Hello: " + request.queryParams("name");
        });
    }
}