package com.example.gradlekotlin.service

import com.example.gradlekotlin.datasource.BankDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest {
    private val dataSource: BankDataSource = mockk()
    private val bankService = BankService(dataSource)

    @Test
    fun `should call datasource to retrieve banks`() {
        val banks = bankService.getBanks()

        verify(exactly = 1) { dataSource.retrieveBanks() }
    }
}