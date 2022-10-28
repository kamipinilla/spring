package com.example.gradlekotlin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BankEntity(
    @Id @GeneratedValue var id: Long,
    var accountNumber: String,
    var trust: Double,
    var transactionFee: Int,
)