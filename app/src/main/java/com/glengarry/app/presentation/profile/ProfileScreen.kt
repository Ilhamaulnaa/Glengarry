package com.glengarry.app.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.domain.model.Resource
import com.glengarry.app.R
import com.glengarry.app.presentation.profile.component.CustomButtonProfile
import com.glengarry.app.presentation.profile.component.ProfileHeader
import com.glengarry.app.presentation.profile.domain.Profile
import com.glengarry.app.ui.dialog.BaseDialog
import com.glengarry.app.ui.dialog.BaseDialogButton
import com.glengarry.app.ui.theme.GlengarryTheme
import com.glengarry.app.ui.theme.poppinsFontFamily
import com.glengarry.app.ui.topbar.BaseTopAppBar
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navigateToLoginScreen: () -> Unit = {}
//    viewModel: ProfileViewModel = koinViewModel()
) {

//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    val user = uiState.user

    var profile by remember {
        mutableStateOf(Profile())
    }

    var profil = Profile(
        "",
        "Ilham Maulana",
        "ilhmaulnaa@gmail.com"
    )

    var showLogoutDialog by remember { mutableStateOf(false) }
    val hideShowDialog = { showLogoutDialog = false }

//    LaunchedEffect(key1 = user){
//        if (user is Resource.Success){
//            val data = user.data
//            profile = Profile(
//                photo = data.photoUrl,
//                name = data.displayName,
//                email = data.email
//            )
//        }
//    }

    val onLogout: () -> Unit = {
        navigateToLoginScreen()
    }

    if (showLogoutDialog){
        BaseDialog(
            message = "Are you sure you want to logout?" ,
            positiveButton = BaseDialogButton(
                title = "Yes",
                onClick = onLogout
            ),
            negativeButton = BaseDialogButton(
                title = "Cancel",
                onClick = hideShowDialog
            )
        )
    }

    Scaffold(
        topBar = {
            BaseTopAppBar(title = "Profile")
        },
        modifier = modifier
    ) { paddingValues ->

        Column (
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            ProfileHeader(
                profile = profil,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(58.dp))
            CustomButtonProfile(
                img = R.drawable.ic_privacy,
                text = "Privacy",
                onCLick = {},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            CustomButtonProfile(
                img = R.drawable.ic_refresh,
                text = "Purchase History",
                onCLick = {},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            CustomButtonProfile(
                img = R.drawable.ic_help,
                text = "Help & Support",
                onCLick = {},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            CustomButtonProfile(
                img = R.drawable.ic_person_add,
                text = "Invite a Friend",
                onCLick = {},
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(21.dp))
            CustomButtonProfile(
                img = R.drawable.ic_logout,
                text = "Logout",
                modifier = Modifier.padding(horizontal = 20.dp),
                onCLick = { showLogoutDialog = true },
            )
        }

    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ProfileScreenPreview() {
    GlengarryTheme {
        Surface {
            ProfileScreen()
        }
    }
}