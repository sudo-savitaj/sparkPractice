import config.AppConfigComponent

object AppComponentRegistery extends AppConfigComponent
with FilterComponent
{
  override val appConfigService: AppComponentRegistery.AppConfigService = new AppConfigService()
  override val filterService: AppComponentRegistery.FilterService = new FilterService(appConfigService.sparkContext)
}