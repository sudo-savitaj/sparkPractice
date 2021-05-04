import config.AppConfigComponent

object AppComponentRegistery extends AppConfigComponent
with FilterComponent
with ExerciseComponent
{
  override val appConfigService: AppComponentRegistery.AppConfigService = new AppConfigService()
  override val filterService: AppComponentRegistery.FilterService = new FilterService(appConfigService.sparkContext)
  override val exerciseService: AppComponentRegistery.ExerciseService = new ExerciseService(appConfigService.sparkSession)
}