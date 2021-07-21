package com.naya.simulator.repository

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.col

class DataRepository() {
  var ss = SparkSession.builder()
    .appName("test")
    .master("local[*]")
    .getOrCreate()

  def getDataPriceStocks(ticket: String): DataFrame = {
    ss.read
      .option("header", true)
      .csv("data/*.txt")
      .toDF("date", "open", "high", "low", "close", "volume", "ticket")
      .filter(col("ticket") === ticket)
  }
}
