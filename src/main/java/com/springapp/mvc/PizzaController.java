package com.springapp.mvc;

import com.springapp.dao.PizzaDAO;
import com.springapp.domain.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PizzaController {

    @Autowired
    private PizzaDAO pizzaDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
        List<Pizza> pizzas = pizzaDAO.getAll();
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("pizzaList", pizzas);
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("pizza") Pizza pizza) {
        pizzaDAO.save(pizza);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") long id) {
        pizzaDAO.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        Pizza pizza = pizzaDAO.getPizzaById(id);
        model.addAttribute("editPizza", pizza);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String edit(@ModelAttribute("editPizza") Pizza pizza) {
        pizzaDAO.update(pizza);
        return "redirect:/";
    }
}