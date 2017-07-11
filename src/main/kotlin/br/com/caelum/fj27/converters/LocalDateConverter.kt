package br.com.caelum.fj27.converters

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by nando on 09/07/17.
 */
class LocalDateConverter{

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    @Component
    inner class FromLocalDate: Converter<String, LocalDate> {

        override fun convert(value: String?): LocalDate {

            if (value != null)
                return LocalDate.parse(value, formatter)

            throw IllegalArgumentException("String can't be null to converter")

        }
    }

    @Component
    inner class ToLocalDate: Converter<LocalDate, String> {
        override fun convert(date: LocalDate?): String {
            if (date != null)
                return date.format(formatter)

            throw IllegalArgumentException("LocalDate can't be null to converter")
        }
    }

}