package br.com.caelum.fj27.controller

import br.com.caelum.fj27.domain.BookType
import br.com.caelum.fj27.domain.Product
import br.com.caelum.fj27.form.ProductForm
import br.com.caelum.fj27.repositories.ProductRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import javax.validation.Valid

/**
 * Created by nando on 08/07/17.
 */
@Controller
@RequestMapping("/products")
class ProductsController(val repository: ProductRepository) {


    @GetMapping("/form","/id/{id}")
    fun form(form: ProductForm, @PathVariable("id",required = false) id:ObjectId?): ModelAndView {

        if (id != null)
            form.inflate(repository.findOne(id))

        val view = ModelAndView("products/form")

        view.addObject("booksType", BookType.values())

        return view
    }

    @PostMapping
    fun save(@Valid form:ProductForm, result:BindingResult, redirect: RedirectAttributes): ModelAndView{

        if (result.hasErrors()) {
            result.allErrors.forEach { error ->
                println(error.defaultMessage)
            }
            return form(form, null)
        }

        val product = form.toProduct()

        println(product)

        repository.save(product)

        redirect.addFlashAttribute("msg", "Product saved successfully!")

        return ModelAndView("redirect:/products")
    }

    @GetMapping
    fun list(): ModelAndView {
        val view = ModelAndView("products/list")

        view.addObject("products", repository.findAll())

        return view
    }

}