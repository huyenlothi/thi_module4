package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.city.ICityService;
import com.example.demo.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("country")
    Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView getAll(){
        ModelAndView modelAndView= new ModelAndView("list");
        Iterable<City> city= cityService.findAll();
        modelAndView.addObject("city",city);
        return modelAndView;
    }
    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("details");
        City city = cityService.findById(id).get();
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCity(@ModelAttribute City city){
        ModelAndView modelAndView= new ModelAndView("create");
        cityService.save(city);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
}
