package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.gatling.core.structure._
import io.gatling.http.Predef._

object ShopizerTables {

  def home(): ChainBuilder = {
    exec(
      http("Home Page")
        .get("http://localhost/")
    )
  }

  def ping(): ChainBuilder = {
    exec(
      http("ping")
        .get("http://localhost:8080/actuator/health/ping")
        .headers(def_headers)
        .check(jsonPath("$.status").is("UP"))

    )
  }

  def boxes(): ChainBuilder = {
    exec(
      http(requestName = "boxes")
        .get("http://localhost:80/api/v1/content/boxes/headerMessage/")
        .headers(def_headers)
        .queryParam("lang", "en")
    )
  }

  def store(): ChainBuilder = {
    exec(
      http("store")
        .get("http://localhost:8080/api/v1/store/DEFAULT")
        .headers(def_headers)
    )
  }

  def fitured(): ChainBuilder = {
    exec(
      http(requestName = "fitured")
        .get("http://localhost:8080/api/v1/products/group/FEATURED_ITEM")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
        .check(jsonPath("$.products[*].id").findAll.saveAs("productId"))
    )
  }

  def category(): ChainBuilder = {
    exec(
      http("category")
        .get("http://localhost:8080/api/v1/category/")
        .headers(def_headers)
        .queryParam("count", "20")
        .queryParam("page", "0")
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }


  def pages(): ChainBuilder = {
    exec(
      http(requestName = "pages")
        .get("http://localhost:8080/api/v1/content/pages")
        .headers(def_headers)
        .queryParam("page", "0")
        .queryParam("count", "20")
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

  def tables(): ChainBuilder = {
    exec(
      http("tables main")
        .get("http://localhost/category/tables")

    )
  }

  def products(): ChainBuilder = {
    exec(
      http(requestName = "products")
        .get("http://localhost:8080/api/v1/products/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
        .queryParam("page", "0")
        .queryParam("count", "15")
        .queryParam("category", "50")
    )
  }

  def price(): ChainBuilder = {
    exec(
      http("price")
        .post("http://localhost:8080/api/v1/product/${id}/price/")
        .headers(def_headers)
        .body(StringBody(
          """{
      "options": []
  } """)).asJson

    )
  }

  def category50(): ChainBuilder = {
    exec(
      http(requestName = "category50")
        .get("http://localhost:8080/api/v1/category/50")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

  def manufacturers(): ChainBuilder = {
    exec(
      http(requestName = "manufacturers")
        .get("http://localhost:8080/api/v1/category/50/manufacturers/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

  def variants(): ChainBuilder = {
    exec(
      http(requestName = "variants")
        .get("http://localhost:80/api/v1/category/50/variants/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

  def olivetable(): ChainBuilder = {
    exec(
      http("olivetable")
        .get("http://localhost/product/olive-table")
        .headers(def_headers)

    )
  }

  def products1(): ChainBuilder = {
    exec(
      http("products1")
        .get("http://localhost:8080/api/v1/products/1")
        .headers(def_headers)
        .queryParam("lang", "en")
        .queryParam("store", "DEFAULT")

    )
  }

  def reviews(): ChainBuilder = {
    exec(
      http("reviews")
        .get("http://localhost:8080/api/v1/products/1/reviews")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
    )
  }

  def addtable(): ChainBuilder = {
    exec(
      http("addtable")
        .get("http://localhost:8080/api/v1/cart/${cartId}")
        .headers(def_headers)
        .queryParam("lang", "en")

    )
  }
  
  def cart(): ChainBuilder = {
    exec(
      http("cart")
        .post("http://localhost:8080/api/v1/cart/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .body(StringBody( """{
      "attributes": [],
      "product": "table1",
      "quantity": 1
  } """)).asJson
        .check(jsonPath("$.code").saveAs("cartId"))
    )
  }

  def cartview(): ChainBuilder = {
    exec(
      http("cartview")
        .get("http://localhost/cart")
        .headers(def_headers)

    )
  }

  def cartdef(): ChainBuilder = {
    exec(
      http("cartdef")
        .get("http://localhost:80/api/v1/${cartId}")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
    )
  }

  def checkout(): ChainBuilder = {
    exec(
      http("checkout")
        .get("http://localhost/checkout")
        .headers(def_headers)

    )
  }

  def zones(): ChainBuilder = {
    exec(
      http("zones")
        .get("http://localhost:8080/api/v1/zones/")
        .headers(def_headers)
        .queryParam("code", "")

    )
  }

  def country(): ChainBuilder = {
    exec(
      http("country")
        .get("http://localhost:8080/api/v1/shipping/country")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }

  def config(): ChainBuilder = {
    exec(
      http("config")
        .get("http://localhost:8080/api/v1/config/")
        .headers(def_headers)
    )
  }

  def total(): ChainBuilder = {
    exec(
      http("total")
        .get("http://localhost:8080/api/v1/cart/${cartId}")
        .headers(def_headers)
    )
  }

  def shipping(): ChainBuilder = {
    exec(
      http("shipping")
        .post("http://localhost:8080/api/v1/cart/${cartId}/shipping")
        .headers(def_headers)
        .body(StringBody(
          """{} """)).asJson

    )
  }

  def googleapis(): ChainBuilder = {
    exec(
      http(requestName = "maps.googleapis")
        .get("https://maps.googleapis.com/maps/api/mapsjs/gen_204")
        .headers(def_headers)
        .queryParam("csp_test", "true")
    )
  }

  def chairs(): ChainBuilder = {
    exec(
      http("chairs")
        .get("http://localhost/category/chairs")
    )
  }

  def products51(): ChainBuilder = {
    exec(
      http(requestName = "products51")
        .get("http://localhost:8080/api/v1/products/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
        .queryParam("page", "0")
        .queryParam("count", "15")
        .queryParam("category", "51")
        .check(jsonPath("$.products[*].id").findRandom.saveAs("randomchair"))
    )
  }

  def price51(): ChainBuilder = {
    exec(
      http("price51")
        .post(s"http://localhost:8080/api/v1/product/51/price/")
        .headers(def_headers)
        .body(StringBody(
          """{
      "options": []
  } """)).asJson

    )
  }

  def price50(): ChainBuilder = {
    exec(
      http("price50")
        .post(s"http://localhost:8080/api/v1/product/50/price/")
        .headers(def_headers)
        .body(StringBody(
          """{
      "options": []
  } """)).asJson

    )
  }

  def price52(): ChainBuilder = {
    exec(
      http("price52")
        .post(s"http://localhost:8080/api/v1/product/52/price/")
        .headers(def_headers)
        .body(StringBody(
          """{
      "options": []
  } """)).asJson

    )
  }

  def category51(): ChainBuilder = {
    exec(
      http(requestName = "category51")
        .get("http://localhost:8080/api/v1/category/51")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .queryParam("lang", "en")
    )
  }
  def choosechair(): ChainBuilder = {
    exec(
    http("choose chair")
        .get("http://localhost/category/chairs")
      .headers(def_headers)
    )
}

  def reviews50(): ChainBuilder = {
    exec(
      http("review50")
        .get("http://localhost:8080/api/v1/products/50/reviews")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")

    )
  }

  def products50(): ChainBuilder = {
    exec(
      http("products50")
        .get("http://localhost:8080/api/v1/products/${randomchair}")
        .headers(def_headers)
        .queryParam("lang", "en")
        .queryParam("store", "DEFAULT")
    )
  }

  def addchair(): ChainBuilder = {
    exec(
      http("add chair")
        .post("http://localhost:8080/api/v1/cart/")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
        .body(StringBody(
          """{
      "attributes": [],
      "product": "chair1",
      "quantity": 1
  } """)).asJson

    )
  }

  def carten(): ChainBuilder = {
    exec(
      http("carten")
        .get("http://localhost:8080/api/v1/cart/${cartId}")
        .headers(def_headers)
        .queryParam("lang", "en")
    )
  }

  def cartdef1(): ChainBuilder = {
    exec(
      http("cartdef1")
        .get("http://localhost:8080/api/v1/cart/${cartId}")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
    )
  }

  def cartdef2(): ChainBuilder = {
    exec(
      http("cartdef1")
        .get("http://localhost:8080/api/v1/cart/${cartId}")
        .headers(def_headers)
        .queryParam("store", "DEFAULT")
    )
  }

  def total1(): ChainBuilder = {
    exec(
      http("total1")
        .get("http://localhost:8080/api/v1/cart/${cartId}/total/")
        .headers(def_headers)
    )
  }


}
