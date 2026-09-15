package com.example.author_mvvm

import android.R
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Author_UI(viewModel: Posts_ViewModel = viewModel() ) {

    val post by viewModel.posts.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row() {
                        Text(
                            "Posts",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.width(12.dp))

                        Text("100",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFF7B1FA2),
                            modifier = Modifier.clip(RoundedCornerShape(60.dp))
                                .background(color = Color(0xFFEDE7F6),
                                )
                                .padding(vertical = 2.dp, horizontal = 6.dp)
                        )

                        Row(modifier = Modifier.fillMaxWidth().padding(end = 12.dp),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically) {

                            Icon(painter = painterResource(R.drawable.ic_dialog_email), contentDescription = "")

                            Spacer(Modifier.width(12.dp))

                            Icon(painter = painterResource(R.drawable.ic_menu_edit), contentDescription = "",
                                modifier = Modifier.size(20.dp))
                        }

                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    IconWithText(
                        icon = painterResource(R.drawable.ic_menu_add),
                        text = "Posts"
                    )

                    IconWithText(
                         icon = painterResource(R.drawable.ic_menu_day),
                        text = "Categories"
                    )

                    IconWithText(
                        icon = painterResource(R.drawable.ic_menu_call),
                        text = "Bookmarks"
                    )

                    IconWithText(
                        icon = painterResource(R.drawable.ic_menu_edit),
                        text = "Profile"
                    )
                }
            }
        }

    )
    { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)
            .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            R.drawable.ic_menu_search
                        ),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                },
                label = {Text("Search posts or authors...",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(2.dp))

            Row(modifier = Modifier
            ) {

                Row(modifier = Modifier
                    .clip(RoundedCornerShape(60.dp))
                    .background(Color(0xFF6A1B9A))
                    .padding(horizontal = 8.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                    Icon(
                        painter = painterResource(R.drawable.ic_menu_my_calendar),
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        "All Posts (100)",
                        fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(Modifier.width(6.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(post) { post ->
                        Rowdata(post)
                        Spacer(Modifier.width(8.dp))
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(
                    "SHOWING 7 CURATED ENTRIES",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )

                Row(modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier
                        .size(5.dp)
                        .background(color = Color.Blue,
                            shape = CircleShape
                        )
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "live stream",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            LazyColumn(modifier = Modifier
                .fillMaxSize(),
               ) {
                items(post){ post ->
                    CardView(post)
                }

            }
        }

    }
}

@Composable
fun IconWithText(
    icon: Painter,
    text: String
) {
    Column(modifier = Modifier.padding(), horizontalAlignment = Alignment.CenterHorizontally) {

        Icon(
            painter = icon,
            contentDescription = text,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}

@Composable
fun CardView(post: Posts) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(modifier = Modifier.fillMaxSize().padding(start = 12.dp, end = 12.dp, bottom = 6.dp, top = 6.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Row(modifier = Modifier
                    .clip(RoundedCornerShape(60.dp))
                    .background(color = Color(0xFFEDE7F6))
                    .padding(horizontal = 8.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.ic_menu_camera),
                        tint = Color(0xFF7B1FA2),
                        contentDescription = "",
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        "User ${post.userID}",
                        fontSize = 12.sp,
                        color = Color(0xFF7B1FA2),
                        modifier = Modifier.clip(RoundedCornerShape(60.dp))
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "#${post.id}",
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.clip(RoundedCornerShape(60.dp))
                        .background(color = Color(0xFFEDE7F6))
                        .padding(horizontal = 8.dp, vertical = 3.dp)

                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(painter = painterResource(R.drawable.ic_menu_my_calendar), contentDescription = "",
                    modifier = Modifier.size(20.dp))

                Text("2 min read",
                    fontSize = 12.sp,
                    color = Color.DarkGray
                )
            }

            Column(modifier = Modifier.fillMaxWidth().padding(start =16.dp, end = 16.dp, top = 2.dp)) {

                Text("${post.title}",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text("${post.body}",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                IconsView(
                    icon = painterResource(R.drawable.ic_menu_edit),
                    text = "24"
                )

                Spacer(Modifier.width(30.dp))

                IconsView(
                    icon = painterResource(R.drawable.ic_menu_add),
                    text = "6"
                )

                 Row(modifier = Modifier.fillMaxWidth(),
                     horizontalArrangement = Arrangement.End,
                     verticalAlignment = Alignment.CenterVertically) {

                     Icon(painter = painterResource(R.drawable.ic_menu_day), contentDescription = "",
                         modifier = Modifier.size(20.dp))

                     Icon(painter = painterResource(R.drawable.ic_btn_speak_now), contentDescription = "",
                         modifier = Modifier.size(20.dp))
                 }
            }

        }
    }

}

@Composable
fun Rowdata(post: Posts) {
    Row(modifier = Modifier
        .clip(RoundedCornerShape(60.dp))
        .background(color = Color(0xFFEDE7F6))
        .padding(horizontal = 8.dp, vertical = 3.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center) {

        RowView(
            icon = painterResource(R.drawable.ic_menu_camera),
            text = "User ${post.id}"
        )
        Spacer(Modifier.width(6.dp))
    }

}

@Composable
fun RowView(
    icon: Painter,
    text: String
){
    Icon(
        painter = icon,
        contentDescription = text,
        modifier = Modifier.size(20.dp),
        tint = Color(0xFF7B1FA2)

    )

    Spacer(Modifier.width(4.dp))

    Text(
        text = text,
        fontSize = 14.sp,
        color = Color(0xFF7B1FA2)
    )
}

@Composable
fun IconsView(
    icon : Painter,
    text : String
){
    Icon(
        painter = icon,
        contentDescription = text,
        modifier = Modifier.size(20.dp)
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = text,
        fontSize = 14.sp
    )
}

@Preview
@Composable
fun preview(){
    Author_UI()
}