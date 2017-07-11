package br.com.caelum.fj27.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

/**
 * Created by nando on 08/07/17.
 */
@Document
data class Product (
        @Id
        var id:ObjectId? = null,
        var title:String = "",
        var description:String = "",
        var  prices: Array<Price> = arrayOf(),
        var releaseDate: LocalDate = LocalDate.now(),
        var numberOfPages:Long = 0

){
    constructor(title:String, description:String, prices:Array<Price>, releaseDate: LocalDate, numberOfPages:Long) : this(){
        this.title = title
        this.description = description
        this.numberOfPages = numberOfPages
        this.releaseDate = releaseDate
        this.prices = prices
    }

    override fun toString(): String {
        return "Product:{id='$id', title='$title', description='$description', numberOfPages=$numberOfPages}"
    }

    override fun equals(other: Any?): Boolean {

        if (other == null) return false
        if (other !is Product) return false

        return  other.title.equals(title) &&
                other.releaseDate.equals(releaseDate) &&
                other.numberOfPages.equals(numberOfPages)
    }

    override fun hashCode(): Int {
        return title.hashCode() + releaseDate.hashCode() + numberOfPages.hashCode()
    }
}
