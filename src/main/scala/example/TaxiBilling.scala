package example

import java.time.LocalTime
import scala.language.postfixOps

trait TaxiBilling {

  // distance 距离，Double 是双精度的浮点数，language 语言, postfix 后缀, Ops 操作符, Billing 计费, package 包， trait 特性
  def calc(distance: Double, startTime: String = "22:00"): Double =
    if (distance <= 3.0D) 13D
    else {
      val overRage = Math.ceil(distance - 3.0D)
      val startLocalTime = LocalTime.parse(startTime)
      if (isNightRate(startLocalTime)) {
        13D + overRage * 3.0D
      } else {
        13D + overRage * 2.0D
      }
    }

  private def isNightRate(t: LocalTime): Boolean = {
    val start = LocalTime.of(23, 0)
    val end   = LocalTime.of(5, 0)
    !t.isBefore(start) || t.isBefore(end)
  }
}
