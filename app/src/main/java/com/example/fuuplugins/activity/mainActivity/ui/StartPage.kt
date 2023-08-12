package com.example.fuuplugins.activity.mainActivity.ui


import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.palette.graphics.Palette
import com.example.fuuplugins.R
import dev.jeziellago.compose.markdowntext.MarkdownText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask
import kotlin.random.Random


@Composable
fun StartPage(
    onclick:()->Unit
) {
    val scope = rememberCoroutineScope()
    DisposableEffect(Unit){
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                scope.launch {
                    onclick.invoke()
                }
            }
        }
        timer.schedule(task, 5000, 5000)
        onDispose {
            task.cancel()
        }
    }
    Markdown(){
        onclick.invoke()
    }
}

@Composable
fun ImagesOnly(

){
    Box (
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(x = (-10).dp, y = (-10).dp)
                .align(Alignment.BottomEnd),
            containerColor = Color(Palette.from(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.img)).generate().getMutedColor(Color(217, 217, 238).toArgb())),
            contentColor = Color(Palette.from(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.img)).generate().getMutedColor(Color(217, 217, 238).toArgb()))
        ) {
            Image(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
        }
    }
}

@Composable
@Preview
fun ImageOnlyPreview(){
    ImagesOnly()
}

@Composable
fun Markdown(
    markdownContent : String = """  
	# <u>Sample<u>
	## Markdown  
	* [Link](https://example.com)
  
	    ![Image](https://picx.zhimg.com/80/v2-34a2b85cc01eb4991cb4154b8b5a3dac_720w.webp?source=1940ef5c)  
	
    <a href="https://www.google.com/">Google</a>  
    # Sample  
	## Markdown  
	* [Link](https://example.com)
  
	    ![Image](https://picx.zhimg.com/80/v2-34a2b85cc01eb4991cb4154b8b5a3dac_720w.webp?source=1940ef5c)  
	
    <a href="https://www.google.com/">Google</a>  
    # Sample  
    ## Markdown  
    * [Link](https://example.com)
    
        ![Image](https://picx.zhimg.com/80/v2-34a2b85cc01eb4991cb4154b8b5a3dac_720w.webp?source=1940ef5c)  
    
    <a href="https://www.google.com/">Google</a>  
""".trimIndent(),
    onclick: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ){
            MarkdownText(
                modifier = Modifier
                    .fillMaxSize(),
                markdown = markdownContent
            )
        }
        ExtendedFloatingActionButton(
            onClick = onclick,
            modifier = Modifier
                .offset(x = (-10).dp, y = (-20).dp)
                .align(Alignment.BottomEnd),
            icon = {
                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
            },
            text = {
                Text(text = "跳过")
            }
        )
    }

}

@Composable
@Preview
fun MarkDownPreview(){
    Markdown(){

    }
}


@Composable
@Preview
fun Loading(){
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val remote by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 720f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            imageVector = Icons.Filled.Refresh,
            contentDescription = null,
            modifier = Modifier
                .rotate(remote)
                .size(50.dp, 50.dp)
                .align(Alignment.Center)
        )
        FloatingActionButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .offset(x = (-10).dp, y = (-10).dp)
                .align(Alignment.BottomEnd),
        ) {
            Image(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
        }
    }

}
enum class StartPageShowType{
    MarkDown,
    ImageOnly,
    Loading
}



private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

fun randomColor() = Color(Random.nextInt(0,255),Random.nextInt(0,255),Random.nextInt(0,255))