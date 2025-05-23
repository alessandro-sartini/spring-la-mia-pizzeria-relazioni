package com.spring.java.pizzeria.spring_la_mia_pizzeria_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.java.pizzeria.spring_la_mia_pizzeria_crud.model.SpecialOffer;
import com.spring.java.pizzeria.spring_la_mia_pizzeria_crud.repo.OfferRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private OfferRepository repository;    


    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("offer")SpecialOffer formOffer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "offers/create";
        }
        repository.save(formOffer);

        return "redirect:/pizze";    
    }
    

}
