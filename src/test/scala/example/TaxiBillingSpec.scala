package example

class TaxiBillingSpec extends munit.FunSuite with TaxiBilling {

  test("0.5km 应该收起步价 13元") {
    assertEquals(calc(0.5D), 13.0D)
  }

  test("4km 应该收起步价 15元") {
    assertEquals(calc(4D), 15.0D)
  }

  test("4.3km 应该收起步价 17元") {
    assertEquals(calc(4.3D), 17.0D)
  }

}
