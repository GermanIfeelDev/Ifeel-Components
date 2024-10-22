package com.ifeel.components.ui.components.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size

/**
 * A composable function that displays an SVG image asynchronously from a given URL. It uses a painter
 * to handle the image loading and supports optional color filtering.
 *
 * @param url The URL of the SVG image to be loaded.
 * @param modifier The modifier to be applied to the Image composable.
 * @param colorFilter An optional ColorFilter to apply to the image.
 */
@Composable
internal fun AsyncImageSvg(
    url: String,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(url)
            .size(Size.ORIGINAL)
            .build()
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        colorFilter = colorFilter
    )
}

@Preview
@Composable
fun SvgImageUrlPreview() {
    AsyncImageSvg(
        url = "https://ifeel-media.s3.eu-west-2.amazonaws.com/carousel/relax.svg",
        modifier = Modifier.size(30.dp),
        colorFilter = ColorFilter.tint(Color.White)
    )
}