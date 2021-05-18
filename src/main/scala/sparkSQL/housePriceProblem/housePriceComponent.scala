package sparkSQL.housePriceProblem

import org.apache.spark.sql.SparkSession
import sparkSQL.DataFrameReader.DataFrameReaderComponent

trait HousePriceComponent extends DataFrameReaderComponent {
  val housePriceService: HousePriceService;
  val housePrice = "housePrice"

  class HousePriceService(conf: SparkSession) {
    def print() {
      val housePriceDF = dataFrameReaderService.get(housePrice)
      housePriceDF.show()
    }
  }

}
