package com.example.simpleloginmvvm.data.database

import org.jetbrains.exposed.sql.Table

object Users : Table("user") {

    val user_id = integer("user_id").autoIncrement()
    val username = varchar("username", 50)
    val password = varchar("password", 10)
    val name = varchar("name", 50)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(user_id, name = "user_id")

}
