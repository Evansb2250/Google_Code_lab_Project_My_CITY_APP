package com.example.cityapp.navigation.routes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cityapp.R

sealed class Screen(open val route: String, @StringRes open val resourceId: Int) {
    object Login : Screen("Login", R.string.login)
    object SignUp : Screen("SignUp", R.string.SignUp)
    object HomeScreenLayout: Screen("HomeScreenLayout", R.string.HomeScreen)

    sealed class HomeScreenRoutes(
        override val route: String,
        @StringRes override val resourceId: Int,
        @DrawableRes val drawableRes: Int
    ) : Screen(route, resourceId) {
        object HomeScreenRoute : HomeScreenRoutes("HomeScreenRoute", R.string.HomeScreen, R.drawable.house_icon)

        object CatalogRoute: HomeScreenRoutes("CatalogRoute", resourceId = R.string.catalog, R.drawable.catalog_icon)

        object BookMarkRoute: HomeScreenRoutes(route = "BookMarkRoute", resourceId = R.string.bookMarkScreen, R.drawable.favorite_icon)

        object RestaurantRoute : HomeScreenRoutes("RestaurantRoute", R.string.Restaurant, R.drawable.knife_fork_icon)

        object CafeRoute : HomeScreenRoutes("CafeRoute", R.string.Cafe, R.drawable.coffee_icon)

        object ShoppingRoute : HomeScreenRoutes("ShoppingRoute", R.string.Shopping, R.drawable.bag_shoping_icon)

        object FitnessRoute : HomeScreenRoutes("FitnessRoute", R.string.Fitness, R.drawable.weight_icon)

        object ParksRoute : HomeScreenRoutes("ParksRoute", R.string.Parks, R.drawable.parks_icon)

        object AdventureRoute : HomeScreenRoutes("AdventureRoute", R.string.adventure, R.drawable.adventure_icon)

    }
}
