package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Slf4j
@Controller
public class IndexController {
    @Autowired
    private ProductDAO productDAO;



    @GetMapping("/")
    public ModelAndView index(@RequestParam(required = false) Integer id) {


        ModelAndView response = new ModelAndView("index");

        Product product = productDAO.findById(id);

        response.addObject("message", "Goodbye World!");
        response.addObject("productKey", product);

        log.debug("Debug level");
        log.info("Info level");
        log.warn("Warn level");
        log.error("Error level");

        System.out.println("This is kinda forbidden at all times");

        return response;
    }

    @GetMapping("/index/{id}")
    public ModelAndView indexPathVar(@PathVariable Integer id) {

        // if the id paramether is not present on the URL then the incoming id will be null
        ModelAndView response = new ModelAndView("index");

        Product product = productDAO.findById(id);
        response.addObject("productKey", product);


        response.addObject("message", "Hello World!");

        return response;
    }

    @GetMapping("/another-page")
    public ModelAndView canBeAnyFunctionNameYouWant() {
        ModelAndView response = new ModelAndView("another-page");
        return response;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String search) {

        ModelAndView response = new ModelAndView("search");

        log.debug("The user searched for the term: " + search);
        response.addObject("search", search);

        List<Product> products = productDAO.findByName(search);
        response.addObject("products", products);

        return response;
    }

}