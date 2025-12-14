package com.example.koltinbasics

fun MerchantDTO.toEntity() = MerchantEntity(id = this.id, name = this.business_name, isActive = this.active_status == 1)

fun MerchantEntity.toDomain() = Merchant(id = this.id, name = this.name, isEnabled = this.isActive)

fun Merchant.toUIState() = MerchantUIState(displayName = "merchant ${this.name} ", statusColor = if (this.isEnabled) "Green" else "red" )