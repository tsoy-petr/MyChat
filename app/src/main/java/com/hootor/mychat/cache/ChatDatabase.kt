package com.hootor.mychat.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hootor.mychat.cache.friends.FriendsDao
import com.hootor.mychat.domain.friends.FriendEntity
import kotlin.coroutines.CoroutineContext

@Database(entities = [FriendEntity::class], version = 2, exportSchema = false)
abstract class ChatDatabase :RoomDatabase() {

    abstract val friendsDao: FriendsDao

    companion object{

        @Volatile
        private var INSTANCE: ChatDatabase? = null

        fun getInstance(context: Context): ChatDatabase {

            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatDatabase::class.java,
                    "chat_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
            }

            return instance
        }
    }

}