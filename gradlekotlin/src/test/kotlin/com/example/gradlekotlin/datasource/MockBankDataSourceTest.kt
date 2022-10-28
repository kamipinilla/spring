package com.example.gradlekotlin.datasource

import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {
    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide some mock data`() {
        // given
        val banks = mockDataSource.retrieveBanks()
        assert(banks.all { it.accountNumber.isNotBlank() })
    }
}