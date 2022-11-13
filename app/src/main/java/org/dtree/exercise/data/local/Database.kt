package org.dtree.exercise.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import org.dtree.exercise.data.local.dao.UserDao
import org.dtree.exercise.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract val userDao: UserDao

}