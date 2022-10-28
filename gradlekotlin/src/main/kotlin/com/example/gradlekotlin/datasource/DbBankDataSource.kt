package com.example.gradlekotlin.datasource

import com.example.gradlekotlin.entity.BankEntity
import com.example.gradlekotlin.exception.CustomException
import com.example.gradlekotlin.repository.BankRepository
import com.example.gradlekotlin.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.Exception

fun entityToBank(entity: BankEntity): Bank {
    return Bank(
        id = entity.id,
        accountNumber = entity.accountNumber,
        trust = entity.trust,
        transactionFee = entity.transactionFee,
    )
}

fun bankToEntity(bank: Bank): BankEntity {
    return BankEntity(
        id = bank.id,
        accountNumber = bank.accountNumber,
        trust = bank.trust,
        transactionFee = bank.transactionFee,
    )
}

@Repository("db")
class DbBankDataSource @Autowired constructor(
    private val bankRepository: BankRepository
) : BankDataSource {
    override fun retrieveBanks(): Collection<Bank> {
        return bankRepository.findAll().map(::entityToBank)
    }

    override fun retrieveBank(accountNumber: String): Bank {
        val bank = bankRepository.findByAccountNumber(accountNumber)
        if (bank != null) {
            return entityToBank(bank)
        } else {
            throw CustomException("Bank with account number $accountNumber not found")
        }
    }

    override fun createBank(bank: Bank) {
        val bankEntity = bankToEntity(bank)
        bankRepository.save(bankEntity)
    }
}