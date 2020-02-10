package twitter4j

import org.scalatest.FunSuite

object FakeTwStatusGenTest extends FunSuite {
  test("Return prepared json with coordinates") {
    assertResult("""{"type": "Point", "coordinates": [44.55, 33.22]}""")(FakeTwStatusGen.genCoordinates(44.55, 33.22))
  }
  test("Return prepared json with place") {
    assert(FakeTwStatusGen.genPlace("rr", "ruru").contains(""""country_code": "rr""""))
    assert(FakeTwStatusGen.genPlace("rr", "ruru").contains(""""country": "ruru"""))
  }
}
