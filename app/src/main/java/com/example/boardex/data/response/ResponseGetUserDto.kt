package com.example.boardex.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseGetUserDto (
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("username")
    val username: String,
    @SerialName("email")
    val email: String,  // 추가된 필드
    @SerialName("address")
    val address: AddressDto,  // AddressDto에 대한 클래스도 정의해야 합니다.
    @SerialName("phone")
    val phone: String,  // 추가된 필드
    @SerialName("website")
    val website: String,  // 추가된 필드
    @SerialName("company")
    val company: CompanyDto,  // CompanyDto에 대한 클래스도 정의해야 합니다.
){
    @Serializable
    data class AddressDto(
        @SerialName("street")
        val street: String,
        @SerialName("suite")
        val suite:String,
        @SerialName("city")
        val city:String,
        @SerialName("zipcode")
        val zipcode:String,
        @SerialName("geo")
        val geo:GeoDto,
    )

    @Serializable
    data class GeoDto(
        @SerialName("lat")
        val lat:String,
        @SerialName("lng")
        val lng:String,
    )

    @Serializable
    data class CompanyDto(
        @SerialName("name")
        val name:String,
        @SerialName("catchPhrase")
        val catchPhrase:String,
        @SerialName("bs")
        val bs:String,
    )
}