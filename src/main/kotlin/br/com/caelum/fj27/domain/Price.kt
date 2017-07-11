package br.com.caelum.fj27.domain

import java.math.BigDecimal
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull

/**
 * Created by nando on 09/07/17.
 */
data class Price (
            @NotNull
             var bookType: BookType? = null,

             @DecimalMin("10.0")
             @NotNull
             var value:BigDecimal? = null)