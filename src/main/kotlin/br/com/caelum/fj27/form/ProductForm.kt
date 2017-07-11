package br.com.caelum.fj27.form

import br.com.caelum.fj27.domain.Price
import br.com.caelum.fj27.domain.Product
import org.bson.types.ObjectId
import org.hibernate.validator.constraints.NotBlank
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
 * Created by nando on 09/07/17.
 */
class ProductForm {

    var id: ObjectId? = null

    @NotBlank
    var title: String = ""

    @NotBlank
    var description: String = ""

    @Min(30)
    var numberOfPages: Long = 0


    @Valid
    var prices: Array<Price> = arrayOf()

    @NotNull
    var releaseDate: LocalDate = LocalDate.now()

    fun  inflate(product: Product?) {

        if (product != null){
            id = product.id
            title = product.title
            description = product.description
            numberOfPages = product.numberOfPages
            releaseDate = product.releaseDate
            prices = product.prices
        }
    }

    fun toProduct(): Product {
        if (id != null)
            return Product(id!!, title, description, prices, releaseDate, numberOfPages)
        else
            return Product(title, description, prices, releaseDate, numberOfPages)
    }

}