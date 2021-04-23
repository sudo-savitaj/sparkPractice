import org.apache.spark.{ SparkContext}

trait FilterComponent{
  val filterService : FilterService

  class FilterService(conf: SparkContext){
    def filter() {
      val filePath = "./src/main/scala/filtering/E0.csv";
      val logRDD = conf.textFile(filePath)

      logRDD.take(10).foreach(println)

      val filterRDD = logRDD.filter(item => item.contains("E0"))
      filterRDD.take(10).foreach(println)
      println(filterRDD.count())

    }
  }

}