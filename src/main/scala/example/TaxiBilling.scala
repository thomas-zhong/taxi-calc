package example

import scala.language.postfixOps

trait TaxiBilling {

  // distance 距离，Double 是双精度的浮点数，language 语言, postfix 后缀, Ops 操作符, Billing 计费, package 包， trait 特性
  def calc(distance: Double): Double =
    if (distance <= 3.0D) 13D
    else {
      val overRage = Math.ceil(distance - 3.0D)
      13D + overRage * 2.0D
    }
}
