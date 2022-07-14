package com.example.trendingprojects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.trendingprojects.viewmodel.TrendingProjectListingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectVerticalCard(
    project: Project,
    viewModel: TrendingProjectListingViewModel
) {

    var imgVector by remember { mutableStateOf(Icons.Outlined.FavoriteBorder) }
    if (project.isFavorite) imgVector = Icons.Filled.Favorite
    else imgVector = Icons.Outlined.FavoriteBorder

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8)),
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = project.price,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis, maxLines = 1,
                )
                IconButton(onClick = {
                    viewModel.updateProject(project.projectId, !project.isFavorite)
                }) {
                    Icon(
                        imageVector = imgVector,
                        contentDescription = "Favorite",
                        tint = Color.Red
                    )
                }
            }
//            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = project.title,
                color = Color.Black,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = project.location,
                overflow = TextOverflow.Ellipsis, maxLines = 1,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp)
            ) {
                Column(modifier = Modifier.weight(0.6f)) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = project.seller,
                        color = Color.Black,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis, maxLines = 1,
                    )
                    Text(text = "Seller", color = Color.Gray)
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedButton(
                        modifier = Modifier
                            .padding(all = 2.dp)
                            .fillMaxHeight(),
                        onClick = { },
                        contentPadding = PaddingValues(4.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Text(text = "View Phone", fontSize = 12.sp)
                    }
                    OutlinedButton(
                        modifier = Modifier.fillMaxHeight(),
                        onClick = { },
                        contentPadding = PaddingValues(2.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(id = R.drawable.whatsapp),
                            contentDescription = "Whatsapp Button"
                        )
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxHeight(),
                        contentPadding = PaddingValues(2.dp),
                        shape = CutCornerShape(4.dp)
                    ) {
                        Icon(imageVector = Icons.Outlined.Call, contentDescription = "Call Button")
                    }
                }
            }
        }
    }
}