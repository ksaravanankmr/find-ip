package com.example.findmyip

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.findmyip.data.repository.IpRepositoryImpl
import com.example.findmyip.presentation.IpDetailsScreen
import com.example.findmyip.presentation.IpDetailsScreenViewModel
import com.example.findmyip.presentation.IpDetailsScreenViewModelFactory
import com.example.findmyip.ui.theme.FindMyIPTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindMyIpApp() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            val viewModel: IpDetailsScreenViewModel =
                viewModel(factory = IpDetailsScreenViewModelFactory(IpRepositoryImpl()))
            IpDetailsScreen(viewModel.state)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFindMyIpApp() {
    FindMyIPTheme {
        FindMyIpApp()
    }
}
