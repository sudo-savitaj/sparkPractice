import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.countDistinct
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.functions.avg

trait ExerciseComponent {
  val exerciseService: ExerciseService

  class ExerciseService(sparkSession: SparkSession) {
    lazy val folderPath = "./src/main/scala/exercise/data/";

    lazy val productDF = sparkSession.read.option("header", "true").csv(folderPath + "products.csv")
    lazy val salesDF = sparkSession.read.option("header", "true").csv(folderPath + "sales.csv")
    lazy val sellersDF = sparkSession.read.csv(folderPath + "sellers.csv")

    def perform() = {
      //      warmup1()
      //      warmup2()
      excerise1()


    }

    //Find out how many orders, how many products and how many sellers are in the data.
    //How many products have been sold at least once? Which is the product contained in more orders?
    def warmup1() = {
      println("Number of orders: %d".format(salesDF.count()))
      println("Number of sellers: %d".format(sellersDF.count()))
      println("Number of products: %d".format(productDF.count()))

      salesDF.agg(countDistinct(col("product_id"))).show()
    }

    //How many distinct products have been sold in each day?
    def warmup2() = {
      salesDF.groupBy(col("date")).agg(countDistinct(col("product_id"))).show()
    }

    //What is the average revenue of the orders
    def excerise1(): Unit = {
      salesDF.join(productDF, Seq("product_id"), "inner").agg(avg(col("num_pieces_sold")*col("price"))).show();
    }

    def exercise2(): Unit ={

    }

  }

}