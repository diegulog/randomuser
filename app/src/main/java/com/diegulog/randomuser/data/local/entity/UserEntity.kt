package com.diegulog.randomuser.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.diegulog.randomuser.data.DomainTranslatable
import com.diegulog.randomuser.domain.entity.Dob
import com.diegulog.randomuser.domain.entity.Id
import com.diegulog.randomuser.domain.entity.Location
import com.diegulog.randomuser.domain.entity.Login
import com.diegulog.randomuser.domain.entity.Name
import com.diegulog.randomuser.domain.entity.Picture
import com.diegulog.randomuser.domain.entity.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val email: String,
    val nat: String,
    val gender: String,
    val phone: String,
    @Embedded
    val dob: Dob,
    @Embedded
    val name: Name,
    @Embedded
    val location: Location,
    @Embedded
    val id: Id,
    @Embedded
    val login: Login,
    val cell: String,
    @Embedded
    val picture: Picture
): DomainTranslatable<User> {
    override fun toDomain(): User {
        return User(
            nat = nat,
            gender = gender,
            phone = phone,
            dob = dob,
            name = name,
            location = location,
            id = id,
            login = login,
            cell = cell,
            email = email,
            picture = picture
        )
    }

    companion object {
        fun fromDomain(user: User): UserEntity {
            return UserEntity(
                email = user.email,
                nat = user.nat,
                gender = user.gender,
                phone = user.phone,
                dob = user.dob,
                name = user.name,
                location = user.location,
                id = user.id,
                login = user.login,
                cell = user.cell,
                picture = user.picture
            )
        }
    }

}