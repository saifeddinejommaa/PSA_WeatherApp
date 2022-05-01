package com.jommaa.psa_weatherapp.data.db.dao

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.ExpectFailure
import com.jommaa.datacomponent.db.dao.TownDao
import com.jommaa.psa_weatherapp.db.AppDatabase
import com.jommaa.psa_weatherapp.domain.entities.Town
import kotlinx.coroutines.test.runBlockingTest
import com.google.common.truth.Truth.assertThat
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class TownDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var appDatabase: AppDatabase
    private lateinit var townDao: TownDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        townDao = appDatabase.TownDao()
    }

    @After
    fun teardown() {
        appDatabase.close()
    }

    @Test
    fun insertTown() = runBlockingTest {
        val town = Town("Chicago", 33.44, -94.04, 1)
        townDao.insert(town)
        val towns = townDao.getAll().value
        assertThat(town).isIn(towns)
    }

}