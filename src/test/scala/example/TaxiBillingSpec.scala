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

  test("23:00之后到第二天5点之前，起步距离以外每公里额外收取 1 元夜间行驶费") {
    assertEquals(calc(4D,"23:00"), 16.0D)
  }

  test("23:00之后到第二天5点之前，起步距离以外每公里额外收取 1 元夜间行驶费") {
    assertEquals(calc(0.5D,"23:00"), 13.0D)
  }
}
