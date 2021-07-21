package com.naya.simulator.service

import com.naya.simulator.repository.DataRepository
import com.naya.simulator.service.kafka.Producer
import com.naya.simulator.util.Convertor
import org.apache.spark.storage.StorageLevel

class Simulator extends Thread {
  System.setProperty("hadoop.home.dir", "/")

  def start(ticket: String, delay: Int) = {

    val df = new DataRepository().getDataPriceStocks(ticket)
    df.persist(StorageLevel.MEMORY_AND_DISK)

    df.foreach(row => {
      new Producer()
        .sendMessageToKafka("stock-updates", Convertor.convertQuoteToJson(row))
      Thread.sleep(delay)
    })
  }
}
