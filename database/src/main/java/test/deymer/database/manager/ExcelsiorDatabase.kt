package test.deymer.database.manager

import androidx.room.Database
import androidx.room.RoomDatabase
import test.deymer.database.constants.DatabaseConstants.DATABASE_VERSION
import test.deymer.database.dao.SongDao
import test.deymer.database.entities.SongEntity

@Database(entities = [SongEntity::class], version = DATABASE_VERSION)
abstract class ExcelsiorDatabase: RoomDatabase() {

    abstract fun getSongDao(): SongDao
}