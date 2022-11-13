package org.dtree.exercise.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.dtree.exercise.domain.model.UserModel

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("_id") val id: String,
    @SerializedName("NAME") val name: String,
    @SerializedName("SURNAME") val surname: String,
    @SerializedName("AGE") val age: Int,
    @SerializedName("CITY") val city: String,
){
    fun toUserModel() = UserModel(id, name, surname, age, city)
}
