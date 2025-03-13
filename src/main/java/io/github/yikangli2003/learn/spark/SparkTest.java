package io.github.yikangli2003.learn.spark;

import static spark.Spark.*;

public class SparkTest {

    public static void main(String[] args) {
        // 设置服务器端口（默认是 4567）
        port(8080);

        // 根路径的 GET 请求
        get("/", (req, res) -> "Welcome to Spark Java!");

        // 带路径参数的 GET 请求
        get("/hello/:name", (req, res) -> {
            String name = req.params(":name");
            return "Hello, " + name + "!";
        });

        // POST 请求示例
        post("/greet", (req, res) -> {
            String name = req.queryParams("name");
            return "Greetings, " + name + "!";
        });

        // PUT 请求示例
        put("/update", (req, res) -> {
            String data = req.body();
            return "Updated with: " + data;
        });

        // DELETE 请求示例
        delete("/remove/:id", (req, res) -> {
            String id = req.params(":id");
            return "Removed item with ID: " + id;
        });

        // 异常处理示例
        exception(Exception.class, (e, req, res) -> {
            res.status(500);
            res.body("Internal Server Error: " + e.getMessage());
        });

        // 404 处理
        notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Custom 404 - Endpoint not found\"}";
        });
    }
}