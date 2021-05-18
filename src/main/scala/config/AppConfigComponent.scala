package config

import org.apache.spark.sql.SparkSession

trait AppConfigComponent{
  val appConfigService: AppConfigService

  class AppConfigService{
    val sparkSession = SparkSession.builder()
    .appName("SparkPractice")
    .getOrCreate()
    val sparkContext = sparkSession.sparkContext

  }

}
