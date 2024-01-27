//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.cdv.pokemongo.ui.theme.PrimaryColor
//
//@Composable
//fun PokemonCard(
//    modifier: Modifier = Modifier,
//    color: Color = PrimaryColor,
//    imageUrl: String
//) {
//    Card(
//        modifier = modifier,
//        backgroundColor = color
//    ) {
//        Column {
//            PokemonImage(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clip(shape = RoundedCornerShape(10.dp)),
//                color = color,
//                url = imageUrl
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PokemonCardPreview() {
//    PokemonCard(
//        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/35.png"
//    )
//}