package sparkSQL.DataFrameReader

import org.apache.spark.sql.{DataFrame,SparkSession}
import java.util.Properties

trait DataFrameReaderComponent {
  val dataFrameReaderService: DataFrameReaderService;

  class DataFrameReaderService(sparkSession: SparkSession, dbUrl: String, jdbcUsername: String, jdbcPassword: String) {
    val connectionProperties = new Properties()
    val driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver"


    private def setup() = {
      connectionProperties.put("user", s"${jdbcUsername}")
      connectionProperties.put("password", s"${jdbcPassword}")
      connectionProperties.setProperty("driver",  s"${driverClass}")
    }

     def get(table:String):DataFrame = {
       setup()
       System.out.println("dbUrl:"+dbUrl)
       System.out.println("table:"+table)
       System.out.println("connectionProperties:"+connectionProperties)
       System.out.println("sparkSession:"+sparkSession)
      sparkSession.read.jdbc(dbUrl, table, connectionProperties)
    }
  }

}

