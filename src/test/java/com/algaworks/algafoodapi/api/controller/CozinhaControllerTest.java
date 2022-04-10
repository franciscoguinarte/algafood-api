package com.algaworks.algafoodapi.api.controller;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CozinhaControllerTest {

    @Test
    @Order(1)
    void listarCozinhaTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                    .get("/cozinhas")
                .then()
                    .assertThat().statusCode(200);
    }

    @Test
    @Order(2)
    void buscarCozinhaTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                    .get("/cozinhas/1")
                .then()
                    .assertThat().statusCode(200);
    }
    @Test
    @Order(3)
    void buscarCozinhaTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/cozinhas/1")
                .then()
                    .assertThat()
                        .body("id",is(1))
                        .body("nome",is("Tailandesa"));
    }

    @Test
    @Order(4)
    void cadastrarCozinhaTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\" : \"Italiana\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                    .post("/cozinhas")
                .then()
                    .assertThat().statusCode(201);
    }
    @Test
    @Order(5)
    void cadastrarCozinhaTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\" : \"Italiana\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                    .post("/cozinhas")
                .then()
                    .assertThat()
                        .body("id",is(4))
                        .body("nome",is("Italiana"));
    }

    @Test
    @Order(6)
    void modificarCozinhaTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\" : \"Italiana\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                    .put("/cozinhas/1")
                .then()
                    .assertThat().statusCode(200);
    }
    @Order(7)
    @Test
    void modificarCozinhaTesteResponseBody() {
        baseURI = "http://localhost";
        port = 8080;
        given()
                .body("{\n" +
                        "    \"nome\" : \"Italiana\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when()
                .put("/cozinhas/1")
                .then()
                .body("id",is(1))
                .body("nome",is("Italiana"));
    }

    @Order(8)
    @Test
    void excluirCozinhaTesteStatusCode() {
        baseURI = "http://localhost";
        port = 8080;
        given()

                .contentType(ContentType.JSON)
                .when()
                .delete("/cozinhas/3")
                .then()
                .statusCode(204);
    }

}