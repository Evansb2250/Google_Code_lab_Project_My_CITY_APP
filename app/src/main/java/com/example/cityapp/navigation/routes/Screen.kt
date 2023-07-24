package com.example.cityapp.navigation.routes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cityapp.R

enum class ScreenArgs(arg:String){
    SEARCH_ID("searchID")
}


sealed class Screen(open val route: String, @StringRes open val resourceId: Int) {
    object Login : Screen("Login", R.string.login)
    object SignUp : Screen("SignUp", R.string.SignUp)
    object HomeScreenLayout: Screen("HomeScreenLayout", R.string.HomeScreen)

    sealed class HomeScreens(
        override val route: String,
        @StringRes override val resourceId: Int,
        @DrawableRes val drawableRes: Int
    ) : Screen(route, resourceId) {

        object HomeScreenRoute : HomeScreens("HomeScreenRoute", R.string.HomeScreen, R.drawable.house_icon)

        object CatalogRoute: HomeScreens("CatalogRoute", resourceId = R.string.catalog, R.drawable.catalog_icon)

        object BookMarkRoute: HomeScreens(route = "BookMarkRoute", resourceId = R.string.bookMarkScreen, R.drawable.favorite_icon)

        object ListViewRoute: HomeScreens(route = "ListViewScreen/{${ScreenArgs.SEARCH_ID.name}}", resourceId = R.string.bookMarkScreen, R.drawable.favorite_icon)

        object RestaurantRoute : HomeScreens("RestaurantRoute", R.string.Restaurant, R.drawable.knife_fork_icon)

        object CafeRoute : HomeScreens("CafeRoute", R.string.Cafe, R.drawable.coffee_icon)

        object ShoppingRoute : HomeScreens("ShoppingRoute", R.string.Shopping, R.drawable.bag_shoping_icon)

        object FitnessRoute : HomeScreens("FitnessRoute", R.string.Fitness, R.drawable.weight_icon)

        object ParksRoute : HomeScreens("ParksRoute", R.string.Parks, R.drawable.parks_icon)

        object AdventureRoute : HomeScreens("AdventureRoute", R.string.adventure, R.drawable.adventure_icon)

    }
}
