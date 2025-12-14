package com.example.koltinbasics



data class MerchantDTO(val id : String, val business_name: String, val active_status: Int )

data class MerchantEntity(val id: String, val name: String, val isActive: Boolean)

data class Merchant(val id: String, val name: String, val isEnabled: Boolean)

data class MerchantUIState(val displayName: String, val statusColor: String)
