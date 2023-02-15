package apps.monkpad.ovul8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import apps.monkpad.ovul8.models.SystemCalendar
import apps.monkpad.ovul8.models.SystemCalendarImpl
import apps.monkpad.ovul8.ui.components.HorizontalCalendarBlock
import apps.monkpad.ovul8.ui.components.OvulationWheel
import apps.monkpad.ovul8.ui.theme.Ovul8Theme


val LocalSystemCalendar = compositionLocalOf<SystemCalendar>{ SystemCalendarImpl() }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ovul8Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Ovul8Application()
                }
            }
        }
    }
}

@Composable
fun Ovul8Application(
    modifier: Modifier = Modifier
) {
    val width = LocalConfiguration.current.screenWidthDp
    Column {
        HorizontalCalendarBlock()
        OvulationWheel(
            modifier = modifier.size(width.dp)
        )
    }
}