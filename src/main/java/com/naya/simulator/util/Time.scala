package com.naya.simulator.util

import java.text.SimpleDateFormat
import java.util.Calendar

object Time {

  def getCurrentTimeQuote(): String = {
    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      .format(Calendar.getInstance().getTime)
  }
}
