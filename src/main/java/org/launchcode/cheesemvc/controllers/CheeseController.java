package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by candice on 5/18/17.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path: /cheese

    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title","My Cheese!");
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName){
        cheeses.add(cheeseName);
        return "redirect:";
    }
}
