package ru.skillbranch.devintensive.models

import java.util.*

class User(
    val id :String,
    var firstName :String?,
    var lastName :String?,
    var avatar :String?,
    var rating :Int = 0,
    var respect :Int = 0,
    val lastVisit :Date? = null,
    val isOnline :Boolean = false
) {

    constructor(id:String, firstName:String?, lastName:String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)

    constructor(id:String) : this(id, "default-name", "default-lastname")

    init {
        println("It's alive!!!" +
                "\n${if(lastName === "default-lastname") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"}\n")
    }

    companion object Factory{
        private var lastId :Int = -1
        fun makeUser(fullName :String?) : User{
            lastId++

            val parts :List<String>? = fullName?.trim()?.split(" ")


            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)

            return User(id= "$lastId", firstName = firstName, lastName = lastName)
        }
    }

}


