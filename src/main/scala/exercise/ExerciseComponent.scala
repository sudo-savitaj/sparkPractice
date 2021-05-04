import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.countDistinct
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{StructField, StructType}

trait ExerciseComponent {
  val exerciseService: ExerciseService

  class ExerciseService(sparkSession: SparkSession) {
    val folderPath = "./src/main/scala/exercise/data/";
//   val schema = StructType([
//      StructField("member_srl", IntegerType(), True),
//    StructField("click_day", IntegerType(), True),
//    StructField("productid", IntegerType(), True)])
    val productRD = sparkSession.read.option("header","true").csv(folderPath + "products.csv")
    val salesRD = sparkSession.read.option("header","true").csv(folderPath + "sales.csv")
    val sellersRD = sparkSession.read.csv(folderPath + "sellers.csv")

    def perform() = {
      warmup1()
      warmup2()
    }

    //Find out how many orders, how many products and how many sellers are in the data.
    //How many products have been sold at least once? Which is the product contained in more orders?
    def warmup1() = {
      println("Number of orders: %d".format(salesRD.count()))
      println("Number of sellers: %d".format(sellersRD.count()))
      println("Number of products: %d".format(productRD.count()))

      salesRD.agg(countDistinct(col("product_id"))).show()
    }

    //How many distinct products have been sold in each day?
    def warmup2() = {
      salesRD.groupBy(col("date")).agg(countDistinct(col("product_id"))).show()
    }

  }

}