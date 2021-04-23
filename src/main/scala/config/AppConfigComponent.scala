package config

import org.apache.spark.{SparkConf, SparkContext}

trait AppConfigComponent{
  val appConfigService: AppConfigService

  class AppConfigService{
    val conf = new SparkConf().setAppName("SparkPractice");
    val sparkContext = new SparkContext(conf);
  }

}
