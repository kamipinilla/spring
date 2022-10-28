package com.example.gradlekotlin.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty

data class Bank(
    @field:Min(10) val id: Long,
    @field:NotEmpty val accountNumber: String,
    val trust: Double,
    val transactionFee: Int,
)