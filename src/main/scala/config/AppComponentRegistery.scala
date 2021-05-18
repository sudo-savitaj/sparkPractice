import config.AppConfigComponent
import sparkSQL.housePriceProblem.HousePriceComponent
import com.databricks.dbutils_v1.DBUtilsHolder.dbutils

object AppComponentRegistery extends AppConfigComponent
  with FilterComponent
  with ExerciseComponent
  with HousePriceComponent
{
  override val appConfigService: AppComponentRegistery.AppConfigService = new AppConfigService()
  private val dbURL = dbutils.secrets.get("key-vault-secrets","Db-Url")
  private val username = dbutils.secrets.get("key-vault-secrets","Db-User-Name")
  private val password = dbutils.secrets.get("key-vault-secrets","Db-Password")
  override val dataFrameReaderService: AppComponentRegistery.DataFrameReaderService = new DataFrameReaderService(appConfigService.sparkSession,dbURL,username,password)
  override val filterService: AppComponentRegistery.FilterService = new FilterService(appConfigService.sparkContext)
  override val exerciseService: AppComponentRegistery.ExerciseService = new ExerciseService(appConfigService.sparkSession)
  override val housePriceService: AppComponentRegistery.HousePriceService = new HousePriceService(appConfigService.sparkSession)
}