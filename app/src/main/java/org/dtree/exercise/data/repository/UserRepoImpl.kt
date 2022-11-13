package org.dtree.exercise.data.repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import org.dtree.exercise.data.local.Database
import org.dtree.exercise.data.local.entity.UserEntity
import org.dtree.exercise.data.remote.Api
import org.dtree.exercise.domain.model.UserModel
import org.dtree.exercise.domain.repository.UserRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepoImpl @Inject constructor (
    private val api: Api, db: Database
) : UserRepo {
    private val dao = db.userDao

    override suspend fun insert(users: List<UserEntity>) {
        dao.insert(users)
    }

    override fun query(query: String): Flow<List<UserEntity>> {
        return flow {
            val data = dao.query().first()
            val flow = if (data.isEmpty()) {
                try {
                    val remoteApi = api.getUsers()
                    dao.insert(remoteApi)
                    dao.query(query)
                } catch (e: Exception) {
                    dao.query(query)
                }
            } else dao.query(query)
            emitAll(flow)
        }
    }

}