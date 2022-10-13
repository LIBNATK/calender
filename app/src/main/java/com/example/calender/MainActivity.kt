package com.example.calender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.dp
import com.example.calender.ui.theme.CalenderTheme
import java.util.Calendar
//import androidx.compose.material.icons.filled.
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderTheme {
                CalenderApp()


            }
        }
    }
}
@Composable
fun CalenderApp() {
    Scaffold(
        topBar = {
            CalenderAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            //items(dates) {
                //dateItem(date = it)
            }
        }
    }


@Composable
fun CalenderAppBar() {
    TODO("Not yet implemented")
}
@Composable
fun dateItem(date: date,
             quqntityOptions: List<Pair<Int, Int>>,
             modifier: Modifier = Modifier) {
    var expanded by androidx.compose.runtime.remember {
        androidx.compose.runtime.mutableStateOf(
            false
        )
    }
    androidx.compose.material.Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = androidx.compose.animation.core.spring(
                        dampingRatio = androidx.compose.animation.core.Spring.DampingRatioMediumBouncy,
                        stiffness = androidx.compose.animation.core.Spring.StiffnessLow
                    )
                )
        ) {
            androidx.compose.foundation.layout.Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                androidx.compose.foundation.layout.Spacer(Modifier.weight(1f))
                dateItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )


            }
            if (expanded) {
                HostelDays(date.days)
            }
        }
    }
}
data class date(
    @StringRes val days: Int
)
@Composable
private fun dateItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = ImageVector,
            modifier=Modifier,

            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description),
        )
    }
}

fun Icon(imageVector: , modifier: Modifier.Companion, tint: Color, contentDescription: String) {

}

@Composable
fun calenderAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}
@Composable
fun HostelDays(@StringRes hosteldays: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.dates),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(hosteldays),
            style = MaterialTheme.typography.body1
        )
    }
}
@Preview
@Composable
fun WoofDarkThemePreview() {
    CalenderTheme(darkTheme = true) {
        CalenderApp()
    }
}

