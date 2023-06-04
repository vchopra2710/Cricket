package com.app.compose.cricket.ui.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.appwidget.updateAll
import com.app.compose.cricket.usecase.GetCricketScoreUseCase
import com.app.compose.cricket.usecase.GetCurrentMatchUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SelectedMatchReceiver @Inject constructor() : GlanceAppWidgetReceiver() {

    private val coroutineScope = MainScope()

    @Inject
    lateinit var getCurrentMatchUseCase: GetCurrentMatchUseCase

    override val glanceAppWidget: GlanceAppWidget
        get() = SelectedMatchWidget

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        updateWidget(context = context)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        updateWidget(context = context)
    }

    private fun updateWidget(context: Context) {
        coroutineScope.launch(Dispatchers.IO) {
            val glanceId = GlanceAppWidgetManager(context)
                .getGlanceIds(SelectedMatchWidget::class.java)
                .firstOrNull()
                ?: return@launch

            updateAppWidgetState(
                context = context,
                definition = SelectedMatchStateDefinition,
                glanceId = glanceId
            ) {
                getCurrentMatchUseCase()
            }
            SelectedMatchWidget.updateAll(context)
        }
    }
}