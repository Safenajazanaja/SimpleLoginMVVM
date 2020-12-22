package com.example.simpleloginmvvm.data.datasource

import com.example.simpleloginmvvm.data.database.Users
import com.example.simpleloginmvvm.data.models.LoginRequest
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object DataSource {

    fun login(request:LoginRequest): Boolean {
        val result = transaction {
            addLogger(StdOutSqlLogger)

            Users.select {
                Users.username eq request.username
            }.andWhere { Users.password eq request.password }
                .count()
                .toInt()

        }

        if (result == 1) {
            return true
        } else {
            return false
        }
    }

}
