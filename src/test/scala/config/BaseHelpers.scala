package config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol._


object BaseHelpers {

  val httpProtocol: HttpProtocolBuilder = http
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36")

  val def_headers: Map[String, String] = Map(
    "Accept"-> "application/json, text/plain, */*",
    "Accept-Encoding" -> "gzip, deflate, br"
    )

  val MinThinkTime = System.getProperty("MinThinkTime","2").toInt
  val MaxThinkTime = System.getProperty("MaxThinkTime","5").toInt

}