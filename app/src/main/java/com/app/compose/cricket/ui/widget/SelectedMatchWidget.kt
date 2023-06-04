package com.app.compose.cricket.ui.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import com.app.compose.cricket.domain.model.currentmatches.Data

object SelectedMatchWidget : GlanceAppWidget() {
    override val sizeMode: SizeMode
        get() = super.sizeMode

    override suspend fun provideGlance(
        context: Context,
        id: GlanceId,
    ) {
        provideContent {
            val cricketMatch = currentState<CurrentMatch?>()
            Content(
                cricketMatch = (cricketMatch?.data ?: listOf()).filter { !it.matchEnded }
            )
        }
    }

    @Composable
    private fun Content(cricketMatch: List<Data>) = Column(
        modifier = GlanceModifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.4f))
    ) {
        cricketMatch.zipWithNext { match1, match2 ->
            Row(modifier = GlanceModifier.fillMaxWidth()) {
                CurrentMatchView(data = match1)
                Spacer(modifier = GlanceModifier.width(8.dp))
                CurrentMatchView(data = match2)
            }

            Spacer(modifier = GlanceModifier.height(8.dp))
        }
    }

    @Composable
    private fun CurrentMatchView(data: Data) = Column(
        modifier = GlanceModifier
            .width(160.dp)
            .cornerRadius(10.dp)
            .padding(8.dp)
            .background(Color.Black)
    ) {
        val sortedScoreList = data.score.sortedBy { it.inning }
        val teamInfoList = data.teamInfo.sortedBy { it.name }

        teamInfoList.forEach { teamInfo ->
            val filteredScoreList = sortedScoreList.filter {
                it.inning.contains(teamInfo.name)
            }

            val score = filteredScoreList.joinToString(separator = ",\n") { score ->
                "${score.run}-${score.wicket} (${score.over})"
            }

            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = teamInfo.shortname,
                    maxLines = 1,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = ColorProvider(Color.White),
                        fontSize = 12.sp,
                    )
                )

                Spacer(modifier = GlanceModifier.defaultWeight())

                Text(
                    text = score,
                    maxLines = 1,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        color = ColorProvider(Color.White),
                        fontSize = 12.sp,
                    )
                )
            }
        }

        Text(
            text = data.matchType.uppercase(),
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = ColorProvider(Color.White),
                fontSize = 12.sp,
            )
        )
    }
}