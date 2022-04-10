package com.algaworks.algafoodapi.api.controller;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestauranteControllerTest {

    @Test
    @Order(1)
    void listarRestaurantesTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                    .get("/restaurantes")
                .then()
                    .assertThat().statusCode(200);
    }

    @Test
    @Order(2)
    void buscarRestauranteTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                    .get("/restaurantes/1")
                .then()
                    .assertThat().statusCode(200);
    }
    @Test
    @Order(3)
    void buscarRestauranteTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/restaurantes/1")
                .then()
                    .assertThat()
                        .body("id",is(1))
                        .body("nome",is("Tailandia Comidinhas"))
                        .body("taxaFrete",is(123.41F))
                        .body("cozinha.id",is(1))
                        .body("cozinha.nome",is("Italiana"));
    }

    @Test
    @Order(4)
    void cadastrarRestauranteTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\": \"Comida Tajash Comidinhas\",\n" +
                        "    \"taxaFrete\": 123.41,\n" +
                        "    \"cozinha\": {\n" +
                        "        \"id\": 1\n" +
                        "    }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                    .post("/cozinhas")
                .then()
                    .assertThat().statusCode(201);
    }

    @Test
    @Order(5)
    void cadastrarRestauranteTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\": \"Comida Tajash Comidinhas\",\n" +
                        "    \"taxaFrete\": 123.41,\n" +
                        "    \"cozinha\": {\n" +
                        "        \"id\": 1\n" +
                        "    }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                    .post("/restaurantes")
                .then()
                    .assertThat()
                        .body("id",is(3))
                        .body("nome",is("Comida Tajash Comidinhas"))
                        .body("taxaFrete", is(123.41F))
                        .body("cozinha.id",is(1))
                        .body("cozinha.nome",is("Italiana"));

    }

    @Test
    @Order(6)
    void modificarRestauranteTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\": \"Comida Tajash Comidinhas\",\n" +
                        "    \"taxaFrete\": 123.41,\n" +
                        "    \"cozinha\": {\n" +
                        "        \"id\": 1\n" +
                        "    }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .put("/restaurantes/1")
                .then()
                .assertThat()
                .statusCode(200);

    }
    @Order(7)
    @Test
    void modificarRestauranteTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\": \"Comida Tajash Comidinhas\",\n" +
                        "    \"taxaFrete\": 123.41,\n" +
                        "    \"cozinha\": {\n" +
                        "        \"id\": 1\n" +
                        "    }\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .put("/restaurantes/1")
                .then()
                .assertThat()
                .body("taxaFrete", is(123.41F))
                .body("cozinha.id",is(1));


    }
//
//    @Order(8)
//    @Test
//    void excluirCozinhaTesteStatusCode() {
//        baseURI = "http://localhost";
//        port = 8080;
//        given()
//
//                .contentType(ContentType.JSON)
//                .when()
//                .delete("/cozinhas/3")
//                .then()
//                .statusCode(204);
//    }

}