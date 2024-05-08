package com.ifeel.components.ui.components.generic.checkbox

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ifeel.components.R
import com.ifeel.components.ui.components.generic.textfield.ToogleIcon
import com.ifeel.components.ui.theme.IfeelComponentsTheme

@Composable
fun Checkbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    ToogleIcon(
        activeIcon = ImageVector.vectorResource(id = R.drawable.checked_checkbox_ic),
        inactiveIcon = ImageVector.vectorResource(id = R.drawable.unchecked_checkbox_ic),
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier
    )
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
private fun CheckboxPreview() {
    var checked by rememberSaveable { mutableStateOf(false) }

    IfeelComponentsTheme {
        Checkbox(checked = checked, onCheckedChange = { checked =  it }, Modifier.padding(10.dp))
    }
}

