package com.devcods.mvvm_retrofit_kotlin.models

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("website")
	val website: String? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("company")
	val company: Company? = null
)

data class Address(

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("suite")
	val suite: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("zipcode")
	val zipcode: String? = null,

	@field:SerializedName("geo")
	val geo: Geo? = null
)

data class Geo(

	@field:SerializedName("lat")
	val lat: Double? = null,

	@field:SerializedName("lng")
	val lng: Double? = null
)

data class Company(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("catchPhrase")
	val catchPhrase: String? = null,

	@field:SerializedName("bs")
	val bs: String? = null
)
