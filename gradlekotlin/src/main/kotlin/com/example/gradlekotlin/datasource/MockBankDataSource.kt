package com.example.gradlekotlin.datasource

import com.example.gradlekotlin.exception.CustomException
import com.example.gradlekotlin.model.Bank
import org.springframework.stereotype.Repository

@Repository("mock")
class MockBankDataSource : BankDataSource {
    private val banks = mutableListOf(
        Bank(1, "abcdef", 10.0, 20),
        Bank(2, "ghijkl", 30.0, 15),
    )

    override fun retrieveBanks(): Collection<Bank> {
        return banks
    }

    override fun retrieveBank(accountNumber: String): Bank {
        return banks.firstOrNull() { it.accountNumber == accountNumber } ?: throw CustomException("Bank with account number $accountNumber not found")
    }

    override fun createBank(bank: Bank) {
        if (banks.any { it.id == bank.id }) {
            throw CustomException("Bank with id ${bank.id} already exists")
        }

        banks.add(bank)
    }
}