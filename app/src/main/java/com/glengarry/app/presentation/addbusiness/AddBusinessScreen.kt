package com.glengarry.app.presentation.addbusiness

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.core.domain.model.Resource
import com.core.domain.model.ServiceType
import com.data.user.domain.model.RefreshTokenResult
import com.glengarry.app.ui.dropdown.DropdownTextFieldWithLabel
import com.glengarry.app.ui.text.BaseText
import com.glengarry.app.ui.theme.GlengarryTheme

import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState
import com.glengarry.app.R
import com.glengarry.app.presentation.addbusiness.component.BusinessImagePicker
import com.glengarry.app.ui.bottomnavigation.ButtonAttributes
import com.glengarry.app.ui.bottomnavigation.DetailBottomNavigation
import com.glengarry.app.ui.textfield.SmallTextFieldWithLabel
import com.glengarry.app.ui.textfield.SmalltextFieldWithLabelType
import com.glengarry.app.ui.topbar.DetailTopAppBar
import org.koin.androidx.compose.koinViewModel

enum class AddBusinessDialogState {
    NONE,
    ERROR_REFRESH_TOKEN,
    CONFIRMATION,
    CONFIRMATION_CLOSE,
    FAILED_CREATE_BUSINESS,
    SUCCESS_CREATE_BUSINESS
}
@ExperimentalMaterial3Api
@Composable
fun AddBusinessScreen(
    modifier: Modifier = Modifier,
    viewModel: AddBusinessViewModel = koinViewModel(),
    type: ServiceType = ServiceType.ALL,
    formData: FormState<TextFieldState> = FormState(emptyList()),
    onTypeChanged: (ServiceType) -> Unit = {}
) {

    val scrollState = rememberScrollState()

    val formState = remember { viewModel.formState }

    var category = formState.getState<TextFieldState>("category")
    var subCategory = formState.getState<TextFieldState>("subcategory")
    var location = formState.getState<TextFieldState>("location")

    var businessName = formState.getState<TextFieldState>("business-name")
    var businessEmail = formState.getState<TextFieldState>("business-email")
    var whatsappNumber = formState.getState<TextFieldState>("whatsapp-number")

    var businessDescription = formState.getState<TextFieldState>("business-description")
    var businessPrice = formState.getState<TextFieldState>("business-price")

    val userPreferences by viewModel.userPreference.collectAsStateWithLifecycle()
    val refreshToken by viewModel.refreshTokenResult.collectAsStateWithLifecycle()

    var primaryButtonTittle by remember {
        mutableStateOf("Market Now")
    }
    var secondaryButtonTittle by remember {
        mutableStateOf("Cancel")
    }

    var img: Any by remember { mutableStateOf("") }

    val imageLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            img = uri
        }
    }

//    val buttonLoading by viewModel.buttonLoading.collectAsStateWithLifecycle(initialValue = false)
    var addBusinessDialogState by remember { mutableStateOf(AddBusinessDialogState.NONE) }

    val launchGallery: () -> Unit = {
        imageLauncher.launch("image/*")
    }

    val primaryButton by remember(key1 = primaryButtonTittle){
        mutableStateOf(ButtonAttributes(
            title = primaryButtonTittle,
            onClick = {}
        ))
    }
    val secondaryButton by remember(key1 = secondaryButtonTittle) {
        mutableStateOf(ButtonAttributes(
            title = secondaryButtonTittle,
            onClick = {}
        ))
    }

    val categories = listOf(
        "Fashion",
        "Electronic",
        "Book",
        "Sport"
    )

    val fashionSubCategory = listOf(
        "Hoodie",
        "T-shirt",
        "Jacket",
        "Sweater",
        "Shoes",
        "Pants"
    )
    val electronicSubCategory = listOf(
        "Handphone",
        "Laptop",
        "Ipad",
        "Tablet",
        "TV",
        "Earphone",
        "Speaker",
        "Mouse"
    )
    val bookSubCategory = listOf(
        "Fiksi",
        "non-FIksi"
    )
    val sportSubCategory = listOf(
        "Ball",
        "Racket",
        "T-shirt",
        "Shoes"
    )
    val locations = listOf(
        "Surabaya",
        "Bandung",
        "Jakarta",
        "Medan",
        "Semarang",
        "Makassar",
        "Lainnya",
    )

    LaunchedEffect(key1 = Unit){
        viewModel.getUserPreference()
    }

    LaunchedEffect(key1 = userPreferences){
        if (userPreferences.refreshToken.isNotEmpty() && refreshToken !is Resource.Error){
            viewModel.getRefreshToken(userPreferences.refreshToken)
        }
    }

    LaunchedEffect(key1 = refreshToken){
        if (refreshToken is Resource.Success){
            viewModel.updateAccessToken(accessToken = (refreshToken as Resource.Success<RefreshTokenResult>).data.accessToken)
            addBusinessDialogState = AddBusinessDialogState.NONE
        }
        if (refreshToken is Resource.Error){
            addBusinessDialogState = AddBusinessDialogState.ERROR_REFRESH_TOKEN
        }
    }

    val onCategoryCanged: (Int) -> Unit = {
        category.change(categories[it])
        val newType = when(category.value){
            categories[0] -> ServiceType.FASHION
            categories[1] -> ServiceType.ELECTRONIC
            categories[2] -> ServiceType.BOOK
            else -> ServiceType.SPORT
        }
        onTypeChanged(newType)
    }

    val subCategories by remember(key1 = category.value) {
        val categoryValue = when (category.value){
            categories[1] -> fashionSubCategory
            categories[2] -> electronicSubCategory
            categories[3] -> bookSubCategory
            categories[4] -> sportSubCategory
            else -> emptyList()
        }
        mutableStateOf(categoryValue)
    }

    Scaffold(
        topBar = {
            DetailTopAppBar(
                title = "Add Business",
                onNavigationClick = { addBusinessDialogState = AddBusinessDialogState.CONFIRMATION_CLOSE }
            )
        },
        bottomBar = {
            DetailBottomNavigation(
                primaryButton = primaryButton,
                secondaryButton = secondaryButton,
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(20.dp)
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            BasicInformationSectionForm(
                type = type,
                categories = categories,
                selectedCategory = category.value,
                categoryErrorMessage = category.errorMessage,
                onCategorySelected = onCategoryCanged ,
                categoryError = category.hasError,
                subCategories = subCategories,
                selectedSubCategory = subCategory.value,
                subCategoryErrorMessage = subCategory.errorMessage,
                onSubCategorySelected = { subCategory.change(subCategories[it]) },
                subCategoryError = subCategory.hasError,
                locations = locations,
                selectedLocation = location.value,
                onLocationSelected = { location.change(locations[it])},
                locationErrorMessage = location.errorMessage,
                locationError = location.hasError,
            )
            BusinessProfile(
                businessName = businessName.value,
                businessEmail = businessEmail.value,
                whatsappNumber = whatsappNumber.value,
                image = img,
                onImageClick = launchGallery,
                onBusinessNameChanged = { businessName.change(it) },
                onBusinessEmailChanged = { businessEmail.change(it) },
                onWhatsappNumberChanged = { whatsappNumber.change(it) },
                businessNameError = businessName.hasError,
                businessEmailError = businessEmail.hasError,
                whatsappNumberError = whatsappNumber.hasError,
                businessNameErrorMessage = businessName.errorMessage,
                businessEmailErrorMessage = businessName.errorMessage,
                whatsappNumberErrorMessage = whatsappNumber.errorMessage,
            )
            BusinessDetail(
                businessDescription = businessDescription.value,
                businessPrice = businessPrice.value,
                onBusinessDescriptionChanged = { businessDescription.change(it) },
                onBusinessPriceChanged = { businessPrice.change(it) },
                businessDescriptionError = businessDescription.hasError,
                businessPriceError = businessPrice.hasError,
                businessDescriptionMessage = businessDescription.errorMessage,
                businessPriceErrorMessage = businessPrice.errorMessage,
            )
        }
    }

}

@Composable
fun BasicInformationSectionForm(
    modifier: Modifier = Modifier,
    type: ServiceType = ServiceType.ALL,
    selectedCategory: String = "",
    categoryErrorMessage: String = "",
    selectedSubCategory: String = "",
    subCategoryErrorMessage: String = "",
    locationErrorMessage: String = "",
    categoryError: Boolean = false,
    subCategoryError: Boolean = false,
    selectedLocation: String = "",
    locationError: Boolean = false,
    categories: List<String> = emptyList(),
    subCategories: List<String> = emptyList(),
    locations: List<String> = emptyList(),
    onCategorySelected: (Int) -> Unit = {},
    onSubCategorySelected: (Int) -> Unit = {},
    onLocationSelected: (Int) -> Unit = {},
) {
    val isLocationFormVisible by remember(key1 = type) {
        mutableStateOf(type == ServiceType.ALL)
    }
    val spacerHeight by remember(key1 = isLocationFormVisible) {
        mutableStateOf(if (isLocationFormVisible) 8.dp else 20.dp)
    }

    Column(
        modifier = modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        BaseText(
            text = "Basic Information",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        DropdownTextFieldWithLabel(
            label = "Category",
            placeholder = "Select One",
            selectedOption = selectedCategory,
            onSelected = onCategorySelected,
            options = categories,
            isError = categoryError,
            supportingText = categoryErrorMessage
        )
        Spacer(modifier = Modifier.height(4.dp))
        DropdownTextFieldWithLabel(
            label = "Subcategory",
            placeholder = "Select One",
            selectedOption = selectedSubCategory,
            onSelected = onSubCategorySelected,
            options = subCategories,
            isError = subCategoryError,
            supportingText = subCategoryErrorMessage
        )
        Spacer(modifier = Modifier.height(spacerHeight))
        AnimatedVisibility(visible = isLocationFormVisible) {
            DropdownTextFieldWithLabel(
                label = "Location",
                placeholder = "Select One",
                selectedOption = selectedLocation,
                onSelected = onLocationSelected,
                options = locations,
                isError = locationError,
                supportingText = locationErrorMessage
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun BusinessProfile(
    modifier: Modifier = Modifier,
    businessName: String = "",
    businessEmail: String = "",
    whatsappNumber: String = "",
    businessNameErrorMessage: String = "",
    businessEmailErrorMessage: String = "",
    whatsappNumberErrorMessage: String = "",
    businessNameError: Boolean = false,
    businessEmailError: Boolean = false,
    whatsappNumberError: Boolean = false,
    image: Any = R.drawable.img_add_business,
    onImageClick: () -> Unit = {},
    onBusinessNameChanged: (String) -> Unit = {},
    onBusinessEmailChanged: (String) -> Unit = {},
    onWhatsappNumberChanged: (String) -> Unit = {}
) {
    
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        
        BaseText(
            text = "Business Profile",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Row(modifier = Modifier) {
            BusinessImagePicker(img = image, onEditAddBusinessClick = onImageClick)
            Spacer(modifier = Modifier.width(8.dp))
            SmallTextFieldWithLabel(
                label = "Business Name",
                value = businessName,
                onValueChanged = onBusinessNameChanged,
                maxLength = 32,
                placeholder = "Input Name Here",
                isError = businessNameError,
                supportingText = businessNameErrorMessage
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        SmallTextFieldWithLabel(
            label = "Business Email",
            value = businessEmail,
            onValueChanged = onBusinessEmailChanged,
            placeholder = "Input Email here",
            isError = businessEmailError,
            supportingText = businessEmailErrorMessage,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        SmallTextFieldWithLabel(
            label = "Whatsapp Number Phone",
            value = whatsappNumber,
            onValueChanged = onWhatsappNumberChanged,
            prefixText = "+62",
            placeholder = "855787869",
            isError = whatsappNumberError,
            supportingText = whatsappNumberErrorMessage,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun BusinessDetail(
    modifier: Modifier = Modifier,
    businessPrice: String = "",
    businessDescription: String = "",
    businessPriceErrorMessage: String = "",
    businessDescriptionMessage: String = "",
    businessPriceError: Boolean = false,
    businessDescriptionError: Boolean = false,
    onBusinessPriceChanged: (String) -> Unit = {},
    onBusinessDescriptionChanged: (String) -> Unit = {}
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {
        BaseText(
            text = "Business Detail",
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        SmallTextFieldWithLabel(
            type = SmalltextFieldWithLabelType.OUTLINED,
            label = "Description",
            value = businessDescription,
            onValueChanged = onBusinessDescriptionChanged,
            placeholder = "Describe your business here (e.g.\n" +
                "- 1x Feed @seputarkampus\n" +
                "- 1x IG Story @seputarkampus\n" +
                "- 1x IG Story @magangupdate\n" +
                "- 1x Twit @seputarkampus)",
            isError = businessDescriptionError,
            maxLength = 1000,
            singleLine = false,
            minlines = 7,
            supportingText = businessDescriptionMessage,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        SmallTextFieldWithLabel(
            type = SmalltextFieldWithLabelType.OUTLINED,
            label = "Price",
            value = businessPrice,
            onValueChanged = onBusinessPriceChanged,
            placeholder = "Input Price Here",
            isError = businessPriceError,
            minlines = 1,
            supportingText = businessPriceErrorMessage,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            )
        )
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun AddBusinessScreenPreview() {
    GlengarryTheme {
        Surface {
            BusinessDetail(modifier = Modifier.padding(16.dp))
        }
    }
}
