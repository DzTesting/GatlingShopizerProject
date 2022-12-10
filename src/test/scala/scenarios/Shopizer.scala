package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Shopizer {

    def scnShopizer: ScenarioBuilder = {
      scenario("Choosing Table and Chairs")
        .exec(flushHttpCache)
        .exec(flushCookieJar)
        .exitBlockOnFail(
          group("Home Page") {
            exec(api.ShopizerTables.home())
              .exec(api.ShopizerTables.ping())
              .exec(api.ShopizerTables.boxes())
              .exec(api.ShopizerTables.fitured())
              .exec(api.ShopizerTables.category())
              .exec(api.ShopizerTables.store())
              .exec(api.ShopizerTables.pages())
//              .exec { session =>
//                println(session("productId").as[String])
//                session}
               .foreach("${productId}", "id"){
                repeat(2){
                exec(api.ShopizerTables.price())}}
               .pause(MinThinkTime,MaxThinkTime)
          }
            .group("Tables page"){
              exec(api.ShopizerTables.tables())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.products())
                .exec(api.ShopizerTables.category())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.price())
                .exec(api.ShopizerTables.category50())
                .exec(api.ShopizerTables.manufacturers())
                .exec(api.ShopizerTables.variants())
                .pause(MinThinkTime, MaxThinkTime)
            }
            .group("Open table") {
              exec(api.ShopizerTables.olivetable())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.products1())
                .exec(api.ShopizerTables.reviews())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.category())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.price())
                .pause(MinThinkTime, MaxThinkTime)
            }
            .group ("Add table to cart") {
            exec(api.ShopizerTables.cart())
              .exec(api.ShopizerTables.addtable())
              .pause(MinThinkTime, MaxThinkTime)
            }
            .randomSwitch(
              15d-> group("Cart table"){
                exec(api.ShopizerTables.cartview())
                  .exec(api.ShopizerTables.ping())
                  .exec(api.ShopizerTables.boxes())
                  .exec(api.ShopizerTables.cartdef())
                  .exec(api.ShopizerTables.pages())
                  .exec(api.ShopizerTables.store())
                  .exec(api.ShopizerTables.category())
                  .pause(MinThinkTime, MaxThinkTime)}
                .group("Proceed to Checkout table") {
                  exec(api.ShopizerTables.checkout())
                    .exec(api.ShopizerTables.ping())
                    .exec(api.ShopizerTables.boxes())
                    .exec(api.ShopizerTables.cartdef())
                    .exec(api.ShopizerTables.zones())
                    .exec(api.ShopizerTables.country())
                    .exec(api.ShopizerTables.zones())
                    .exec(api.ShopizerTables.config())
                    .exec(api.ShopizerTables.total())
//                    .exec(api.shopizertables.shipping())
                    .exec(api.ShopizerTables.store())
                    .exec(api.ShopizerTables.pages())
                    .exec(api.ShopizerTables.category())
                    .exec(api.ShopizerTables.googleapis())
                    .pause(MinThinkTime, MaxThinkTime)},
               50d-> group("Chairs") {
              exec(api.ShopizerTables.chairs())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.products51())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.category())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.price52())
                .exec(api.ShopizerTables.price50())
                .exec(api.ShopizerTables.price51())
                .exec(api.ShopizerTables.category51())
                .exec(api.ShopizerTables.manufacturers())
                .exec(api.ShopizerTables.variants())
                .exec(api.ShopizerTables.pages())
                .pause(MinThinkTime, MaxThinkTime)
            }
            .group("Choose random chair") {
              exec(api.ShopizerTables.choosechair())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.reviews50())
                .exec(api.ShopizerTables.products50())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.category())
                .exec(api.ShopizerTables.price50())
                .exec(api.ShopizerTables.pages())
                .pause(MinThinkTime, MaxThinkTime)
            }
            .group("Add chair to cart") {
              exec(api.ShopizerTables.addchair())
                 .exec(api.ShopizerTables.carten())
                 .exec(api.ShopizerTables.pages())
                .pause(MinThinkTime, MaxThinkTime)}
            .randomSwitch(
            30d-> group("Cart Chair") {
              exec(api.ShopizerTables.cartview())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.cartdef1())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.cartdef1())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.category())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.pages())
                .pause(MinThinkTime, MaxThinkTime)
            }
            .group("Proceed to checkout chair") {
              exec(api.ShopizerTables.checkout())
                .exec(api.ShopizerTables.ping())
                .exec(api.ShopizerTables.country())
                .exec(api.ShopizerTables.cartdef2())
                .exec(api.ShopizerTables.boxes())
                .exec(api.ShopizerTables.zones())
                .exec(api.ShopizerTables.zones())
                .exec(api.ShopizerTables.config())
                .exec(api.ShopizerTables.total1())
//                .exec(api.shopizertables.shipping())
                .exec(api.ShopizerTables.store())
                .exec(api.ShopizerTables.pages())
                .exec(api.ShopizerTables.category())
            }
            )   
      )
        )
    }

}
