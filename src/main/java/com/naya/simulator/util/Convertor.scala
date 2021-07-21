package com.naya.simulator.util

import com.naya.simulator.util.Time.getCurrentTimeQuote
import org.apache.spark.sql.Row

object Convertor {

  def convertQuoteToJson(row: Row): String = {
    val msg = new StringBuilder("{")
    msg.append("\"stockTicker\":")
    msg.append("\"" + row.get(6) + "\",")
    msg.append("\"date\":")
    msg.append("\"" + getCurrentTimeQuote() + "\",")
    msg.append("\"openPrice\":")
    msg.append("" + row.get(1) + ",")
    msg.append("\"highPrice\":")
    msg.append("" + row.get(2) + ",")
    msg.append("\"lowPrice\":")
    msg.append("" + row.get(3) + ",")
    msg.append("\"closePrice\":")
    msg.append("" + row.get(4) + ",")
    msg.append("\"volume\":")
    msg.append("" + row.get(5) + "")
    msg.append("}")
    msg.toString()
  }
}
