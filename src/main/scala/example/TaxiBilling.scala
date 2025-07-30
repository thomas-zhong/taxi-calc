package example

import java.time.LocalTime
import scala.language.postfixOps

trait TaxiBilling {
  // 起步距离
  val BASE_DISTANCE = 3.0D
  // 起步距离费率
  val BASE_FARE = 13D
  // 超过起步距离之外每公里费率
  val OVERAGE_RATE = 2.0D
  // 夜间附加费
  val OVERNIGHT_SURCHARGE = 1.0D
  // 夜间区间起点
  val NIGHT_START = LocalTime.of(23, 0)
  // 夜间区间终点
  val NIGHT_END = LocalTime.of(5, 0)

  // distance 距离，Double 是双精度的浮点数，language 语言, postfix 后缀, Ops 操作符, Billing 计费, package 包， trait 特性
  def calc(distance: Double, startTime: String = "22:00"): Double = {
    if (distance <= BASE_DISTANCE) BASE_FARE
    else {
      val overRage = Math.ceil(distance - BASE_DISTANCE)
      val startLocalTime = LocalTime.parse(startTime)
      if (isNightRate(startLocalTime)) {
        BASE_FARE + overRage * (OVERAGE_RATE + OVERNIGHT_SURCHARGE)
      } else {
        BASE_FARE + overRage * OVERAGE_RATE
      }
    }
  }

  //camel case
  private def isNightRate(t: LocalTime): Boolean = {
    !t.isBefore(NIGHT_START) || t.isBefore(NIGHT_END)
  }
}
