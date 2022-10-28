package com.example.gradlekotlin.repository

import com.example.gradlekotlin.entity.BankEntity
import org.springframework.data.repository.CrudRepository

interface BankRepository : CrudRepository<BankEntity, Long> {
    fun findByAccountNumber(accountNumber: String): BankEntity?
}