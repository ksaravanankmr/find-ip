package com.example.findmyip.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.findmyip.R
import com.example.findmyip.domain.model.IpAddress
import com.example.findmyip.domain.model.Resource
import com.example.findmyip.ui.components.CustomDivider

@Composable
fun IpDetailsScreen(uiState: IpDetailsScreenUiState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (uiState.ipAddress) {
            is Resource.Loading -> CircularProgressIndicator(modifier = Modifier.testTag("ProgressIndicator"))

            is Resource.Error -> {
                Text(uiState.ipAddress.message ?: stringResource(id = R.string.unknown_error))
            }

            is Resource.Success -> {
                uiState.ipAddress.data?.let {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Top
                    ) {

                        Text(
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Start,
                            text = stringResource(id = R.string.welcome_text),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(id = R.string.ip_address),
                                    style = MaterialTheme.typography.labelSmall
                                )
                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = it.ip,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            CustomDivider()

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.latitude_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = it.latitude.toString(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                CustomDivider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(2.dp)
                                        .width(1.dp)
                                )

                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.longitude_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = it.longitude.toString(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }

                            CustomDivider()

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.address_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = "${it.city}, ${it.region}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                CustomDivider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(2.dp)
                                        .width(1.dp)
                                )


                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.postal_code_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = it.postal,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }

                            CustomDivider()

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.time_zone_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = it.timezone,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                CustomDivider(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(2.dp)
                                        .width(1.dp)
                                )


                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.currency_text),
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = it.currency,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewIpDetailsScreen() {
    IpDetailsScreen(
        uiState = IpDetailsScreenUiState(
            Resource.Success(
                data = IpAddress(
                    ip = "2405:201:e039:d904:6df8:95c:d4e6:ed62",
                    network = "2405:201:e039::/48",
                    version = "IPv6",
                    city = "Chennai",
                    region = "Tamil Nadu",
                    region_code = "TN",
                    country = "IN",
                    country_name = "India",
                    country_code = "IN",
                    country_code_iso3 = "IND",
                    country_capital = "New Delhi",
                    country_tld = ".in",
                    continent_code = "AS",
                    in_eu = false,
                    postal = "600001",
                    latitude = 12.8996,
                    longitude = 80.2209,
                    timezone = "Asia/Kolkata", utc_offset = " + 0530",
                    country_calling_code = "+91",
                    currency = "INR",
                    currency_name = "Rupee",
                    languages = "en-IN,hi,bn,te,mr,ta,ur,gu,kn,ml,or,pa,as,bh,sat,ks,ne,sd,kok,doi,mni,sit,sa,fr,lus,inc",
                    country_area = 3287590.0,
                    country_population = 1352617328,
                    asn = "AS55836",
                    org = "Reliance Jio Infocomm Limited"
                )
            )
        )
    )
}