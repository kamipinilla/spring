package com.example.gradlekotlin.controller

import com.example.gradlekotlin.exception.CustomException
import com.example.gradlekotlin.model.Bank
import com.example.gradlekotlin.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {
    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

//    @ExceptionHandler(Exception::class)
//    fun handleException(e: Exception): ResponseEntity<String> {
//        e.printStackTrace()
//        return ResponseEntity(e.message, HttpStatus.INTERNAL_SERVER_ERROR)
//    }

    @GetMapping
    fun getBanks(): Collection<Bank> {
        return service.getBanks()
    }

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank {
        return service.getBank(accountNumber)
    }

    @PostMapping
    fun addBank(@Valid @RequestBody bank: Bank) {
        service.addBank(bank)
    }
}