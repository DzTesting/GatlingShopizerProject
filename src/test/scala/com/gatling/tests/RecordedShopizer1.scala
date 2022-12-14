package com.gatling.tests

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.Shopizer.scnShopizer
import scala.concurrent.duration._


class RecordedShopizer1 extends Simulation {

  //val nbUsers = Integer.getInteger("users",50)
  //val myRamp = java.lang.Long.getLong("ramp",50)


  setUp(scnShopizer.inject(
    rampUsers(50).during(100)
  )).protocols(httpProtocol)

}
