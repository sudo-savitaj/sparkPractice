package config

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

trait AppConfigComponent{
  val appConfigService: AppConfigService

  class AppConfigService{
    val conf = new SparkConf().setAppName("SparkPractice");
    val sparkContext = new SparkContext(conf);

    val sparkSession = SparkSession.builder()
    .master("local")
    .config("spark.sql.autoBroadcastJoinThreshold", -1)
    .config("spark.executor.memory", "500mb")
    .appName("Exercise1")
    .getOrCreate()

  }

}
