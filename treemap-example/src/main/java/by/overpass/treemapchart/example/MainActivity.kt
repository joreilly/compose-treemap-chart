package by.overpass.treemapchart.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import by.overpass.treemapchart.android.TreemapChart
import by.overpass.treemapchart.core.measure.squarified.SquarifiedMeasurer
import by.overpass.treemapchart.core.tree.tree
import by.overpass.treemapchart.example.ui.theme.ComposetreemapchartTheme

private val simpleTreeData = tree(10) {
    node(6) {
        node(4)
        node(2) {
            node(1)
            node(1)
        }
    }
    node(3) {
        node(2)
        node(1)
    }
    node(1)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposetreemapchartTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TreemapChart(
                        data = simpleTreeData,
                        evaluateItem = { it.toDouble() },
                        treemapChartMeasurer = remember { SquarifiedMeasurer() },
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                    ) { item ->
                        TreemapItem(item = item)
                    }
                }
            }
        }
    }
}

@Composable
fun TreemapItem(item: Int, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.border(1.dp, MaterialTheme.colors.onBackground),
    ) {
        Text(
            text = item.toString(),
            textAlign = TextAlign.Center,
        )
    }
}