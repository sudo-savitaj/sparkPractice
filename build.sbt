name := "SparkPractice"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.4.5",
  "org.apache.spark" % "spark-sql_2.11" % "2.4.5",
  "com.microsoft.sqlserver" % "mssql-jdbc" % "9.2.1.jre8",
  "com.databricks" % "dbutils-api_2.11" % "0.0.4"
)

