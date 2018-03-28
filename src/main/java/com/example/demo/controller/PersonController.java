package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class PersonController {
    @Resource
    PersonService personService;
    @RequestMapping("/list")
    public String list(Model model) {
        List<Person> persons=personService.getPersonList();
        model.addAttribute("persons", persons);
        return "/person/list";
    }
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Person person=personService.findPersonById(id);
        System.out.println(person);
        model.addAttribute("person", person);
        return "/person/update";
    }
    @RequestMapping("/toAdd")
    public  String toAdd(Model model){
        Person person =new Person();
        model.addAttribute("person", person);
        return "/person/update";
    }
    @RequestMapping("/edit")
    public String edit(Person person) {
        personService.save(person);
        return "redirect:/list";
    }
    @RequestMapping("delete")
    public String delete(Long id){
        personService.delete(id);
        return "redirect:/list";
    }

}
