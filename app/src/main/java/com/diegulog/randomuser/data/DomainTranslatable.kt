package com.diegulog.randomuser.data

interface DomainTranslatable<out T> {
     fun toDomain(): T
}