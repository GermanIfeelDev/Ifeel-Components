package com.ifeel.components.ui.components.common.chat

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.style.TextAlign
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

/**
 * Displays a unified toolbar for chat screens with user information and actions.
 *
 * This component provides a flexible toolbar that can display user name, optional status,
 * and avatar with a dropdown menu for actions. The toolbar adapts to different chat contexts
 * by making status and avatar optional parameters.
 *
 * [Design](https://www.figma.com/design/URRpzc3xSS8h94F0i9VRiW/DS_iFeel-Library-DRAFT?node-id=808-65&p=f&t=moYy82ifJSDSkF9O-0)
 *
 * @param name The name of the user displayed in the toolbar (required).
 * @param toolbarActions A list of action strings to display in the toolbar dropdown menu.
 * @param onToolbarActionClicked Lambda function invoked when a toolbar action is clicked.
 * @param modifier Modifier for this layout. Defaults to Modifier.
 * @param status Optional status text displayed below the user name. If null, status is not shown.
 * @param avatarUrl Optional URL of the user's avatar image displayed in a circular shape.
 *                  If null or fails to load, shows the default avatar.
 * @param defaultAvatarResId Drawable resource ID for the default avatar when avatarUrl is null
 *                          or fails to load. Defaults to R.drawable.toolbar_default_ic.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatToolbar(
    name: String,
    toolbarActions: List<String>,
    onToolbarActionClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    status: String? = null,
    avatarUrl: String? = null,
    @DrawableRes defaultAvatarResId: Int = R.drawable.toolbar_default_ic,
) {
    var showDropDownMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
            ) {
                AsyncImage(
                    model = avatarUrl,
                    contentDescription = null,
                    error = painterResource(defaultAvatarResId),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.padding(start = 12.dp),
                ) {
                    Text(
                        text = name,
                        style = BodyTextStyle.Body16SemiBold.toTextStyle(),
                        color = color_text_700,
                    )

                    status?.let {
                        Text(
                            text = it,
                            style = BodyTextStyle.Body14Regular.toTextStyle(),
                            color = color_text_500,
                        )
                    }
                }
            }
        }, actions = {
            IconButton(onClick = { showDropDownMenu = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.toolbar_chat_options_ic),
                    contentDescription = "Localized description",
                    tint = Color.Unspecified
                )
            }

            MaterialTheme(shapes = MaterialTheme.shapes.copy(extraSmall = RoundedCornerShape(0.dp))) {
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
                                onToolbarActionClicked(toolbarAction)
                            },
                            contentPadding = PaddingValues(),
                            text = {
                                Column(
                                    modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start
                                ) {
                                    TextButton(
                                        onClick = {
                                            showDropDownMenu = false
                                            onToolbarActionClicked(toolbarAction)
                                        },
                                        shape = RoundedCornerShape(0.dp),
                                        colors = ButtonDefaults.textButtonColors(
                                            containerColor = Color.White,
                                            contentColor = color_text_600
                                        ),
                                    ) {
                                        Text(
                                            text = toolbarAction,
                                            style = ButtonTextStyle.ButtonDefaultRegular.toTextStyle(),
                                            textAlign = TextAlign.Start,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    }
                                    HorizontalDivider(color = color_text_200)
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
        modifier = modifier.height(54.dp)
    )
}

@Preview
@Composable
private fun ChatToolbarPreview() {
    IfeelComponentsTheme {
        Column {
            ChatToolbar(
                name = "Paco",
                status = "Connected",
                toolbarActions = listOf("Sign out", "Settings"),
                onToolbarActionClicked = { Log.e("XXX", it) },
            )

            ChatToolbar(
                name = "Your therapist",
                toolbarActions = listOf("Sign out", "Settings"),
                onToolbarActionClicked = { Log.e("XXX", it) },
            )
        }
    }
}