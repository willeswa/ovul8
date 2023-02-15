package apps.monkpad.ovul8.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import apps.monkpad.ovul8.LocalSystemCalendar
import apps.monkpad.ovul8.models.Profile
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@OptIn(ExperimentalTextApi::class)
@Composable
fun OvulationWheel(
    modifier: Modifier = Modifier,
    profile: Profile = Profile(firstDateOfLastCycle = "10/01/2023"),
){

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier) {
        val calendarDay = LocalSystemCalendar.current
        val textMeasurer = rememberTextMeasurer()

      Canvas(modifier = modifier.fillMaxSize()){
          val circleRadius = 0.8f * size.minDimension/2
          val wheelRepetition = profile.cycleLength

          repeat(wheelRepetition){cycleDay ->
              val adjustedCycleDay = cycleDay + 1
              val cycleDayIsCurrentCalendarDay = profile.getElapsedSinceLastPeriodDayOne(calendarDay.getTodayDate()) == adjustedCycleDay
              val initialDegree = -(PI/2)
              val step = (2*PI)/wheelRepetition.toFloat()
              val degree = initialDegree + adjustedCycleDay * step
              val x = center.x + cos(degree) * circleRadius
              val y = center.y + sin(degree) * circleRadius

              drawText(
                  textMeasurer = textMeasurer,
                  topLeft = Offset(x.toFloat(), y.toFloat()),
                  text = "$adjustedCycleDay",
                  style = if (cycleDayIsCurrentCalendarDay){
                      TextStyle(
                          color = Color.Black
                      )
                  } else {
                      TextStyle(
                          color = Color.Black.copy(alpha = 0.1f)
                      )
                  })
          }

      }

    }
}