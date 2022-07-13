package com.example.trendingprojects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trendingprojects.data.Project

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectHorizontalCard(project: Project) {
    ElevatedCard(
        modifier = Modifier
//            .height(350.dp)
            .width(300.dp)
            .padding(all = 6.dp),
        containerColor = Color.White
    ) {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8)),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                text = project.title,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                text = "mktd by ${project.seller}",
                overflow = TextOverflow.Ellipsis, maxLines = 1,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = project.size,
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis, maxLines = 1,
                )
                Text(
                    text = project.location,
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis, maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                text = project.price,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis, maxLines = 1,
            )
        }
    }
}