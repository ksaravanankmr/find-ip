package com.example.findmyip.data.mapper

import com.example.findmyip.data.remote.dto.IpAddressDto
import com.example.findmyip.domain.model.IpAddress

fun IpAddressDto.toIpAddress(): IpAddress {
    return IpAddress(
        asn,
        city,
        continent_code,
        country,
        country_area,
        country_calling_code,
        country_capital,
        country_code,
        country_code_iso3,
        country_name,
        country_population,
        country_tld,
        currency,
        currency_name,
        in_eu,
        ip,
        languages,
        latitude,
        longitude,
        network,
        org,
        postal,
        region,
        region_code,
        timezone,
        utc_offset,
        version
    )
}