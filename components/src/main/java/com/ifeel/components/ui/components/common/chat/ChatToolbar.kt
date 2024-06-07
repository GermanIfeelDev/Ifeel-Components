package com.ifeel.components.ui.components.common.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ifeel.components.R
import com.ifeel.components.ui.extension.crop
import com.ifeel.components.ui.theme.IfeelComponentsTheme
import com.ifeel.components.ui.theme.color_text_200
import com.ifeel.components.ui.theme.color_text_500
import com.ifeel.components.ui.theme.color_text_600
import com.ifeel.components.ui.theme.color_text_700
import com.ifeel.components.ui.theme.text.BodyTextStyle
import com.ifeel.components.ui.theme.text.ButtonTextStyle
import com.ifeel.components.ui.theme.text.CaptionTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatToolbar(
    name: String,
    status: String,
    imageUrl: String,
    toolbarActions: List<String>,
    onToolbarActionClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDropDownMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(
                        text = name,
                        style = BodyTextStyle.Body16SemiBold.toTextStyle(),
                        color = color_text_700,
                    )

                    Text(
                        text = status,
                        style = CaptionTextStyle.Caption12Regular.toTextStyle(),
                        color = color_text_500,
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { showDropDownMenu = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.toolbar_chat_options_ic),
                    contentDescription = "Localized description"
                )
            }

            MaterialTheme(shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(0.dp))) { //To remove roundedCorners
                DropdownMenu(
                    expanded = showDropDownMenu,
                    onDismissRequest = { showDropDownMenu = false },
                    modifier = Modifier
                        .background(Color.White)
                        .crop(vertical = 8.dp) //We cut the top and bottom of the menu because it has a internal padding @link{https://stackoverflow.com/questions/74238933/how-to-remove-dropdownmenus-default-vertical-padding-when-clicking-the-first-it}
                ) {
                    toolbarActions.forEach { toolbarAction ->
                        DropdownMenuItem(
                            onClick = {
                                showDropDownMenu = false
                                onToolbarActionClicked.invoke(toolbarAction)
                            },
                            contentPadding = PaddingValues(),
                            text = {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    TextButton(
                                        onClick = {
                                            onToolbarActionClicked.invoke(toolbarAction)
                                        },
                                        shape = RoundedCornerShape(0.dp),
                                        colors = ButtonDefaults.textButtonColors(
                                            containerColor = Color.White,
                                            contentColor = color_text_600
                                        ),
                                    ) {
                                        Text(
                                            text = toolbarAction,
                                            style = ButtonTextStyle.ButtonDefaultRegular.toTextStyle()
                                        )
                                    }
                                    Divider(color = color_text_200)
                                }
                            }
                        )
                    }
                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            scrolledContainerColor = Color.Unspecified,
            navigationIconContentColor = Color.Unspecified,
            titleContentColor = Color.Unspecified,
            actionIconContentColor = Color.Unspecified
        ),
        modifier = modifier.height(50.dp)
    )
}

@Preview
@Composable
fun ChatToolbarPreview() {
    IfeelComponentsTheme {
        ChatToolbar(
            name = "Paco",
            status = "Connected",
            imageUrl = "https://headshots-inc.com/wp-content/uploads/2022/04/website-photos-1-4.jpg",
            toolbarActions = listOf("Sign out", "Settings"),
            onToolbarActionClicked = { Log.e("XXX", it)},
        )
    }
}