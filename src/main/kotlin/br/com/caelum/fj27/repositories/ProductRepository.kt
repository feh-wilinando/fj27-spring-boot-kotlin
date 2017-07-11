package br.com.caelum.fj27.repositories

import br.com.caelum.fj27.domain.Product
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository

/**
 * Created by nando on 08/07/17.
 */
interface ProductRepository : CrudRepository<Product, ObjectId>