package com.m.instagramuicompose.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

data class ImageWithText(
    val image: Painter,
    val text: String
)

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "ialiforoozan",
            modifier = Modifier
                .padding(10.dp)
        )

    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    name: String
) {

    val constraints = ConstraintSet {
        val iconBack = createRefFor("iconBack")
        val name = createRefFor("name")
        val iconNotification = createRefFor("iconNotification")
        val iconMenu = createRefFor("iconMenu")

        constrain(iconBack) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(name) {
            top.linkTo(parent.top)
            start.linkTo(iconBack.end)
            end.linkTo(iconNotification.start)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }

        constrain(iconNotification) {
            top.linkTo(parent.top)
            end.linkTo(iconMenu.start)
            bottom.linkTo(parent.bottom)
        }

        constrain(iconMenu) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }

    }

    ConstraintLayout(constraintSet = constraints, modifier = modifier.fillMaxWidth()) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(24.dp)
                .layoutId("iconBack")
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier.layoutId("name"),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Icon(
            painter = painterResource(id = com.m.instagramuicompose.R.drawable.ic_bell),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(24.dp)
                .layoutId("iconNotification")
        )
        Icon(
            painter = painterResource(id = com.m.instagramuicompose.R.drawable.ic_dotmenu),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(20.dp)
                .layoutId("iconMenu")
        )
    }
}
