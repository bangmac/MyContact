package com.bmv.casestudycontact.controller;

import com.bmv.casestudycontact.model.Contact;
import com.bmv.casestudycontact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public ModelAndView showList(@PageableDefault(size =5) Pageable pageable){
        Page<Contact> contacts = contactService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
//        List<Contact> contacts = (List<Contact>) contactService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("contacts", contacts);
//        return modelAndView;
    }

//    public String list(Model model) {
//        model.addAttribute("contacts", contactService.findAll());
//        return "list";
//    }

    @GetMapping("/contact/search")
    public ModelAndView search(@RequestParam("term") Optional<String> term,@PageableDefault(size =5) Pageable pageable){
        Page<Contact> contacts;
        if(term.isPresent()){
            contacts = contactService.findAllByNameContaining(term.get(), pageable);
        } else {
            contacts = contactService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

//    public ModelAndView search(@RequestParam("term") Optional<String> term, @PageableDefault(size =5) Pageable pageable){
//        ModelAndView modelAndView = new ModelAndView("/list");
////        if (StringUtils.isEmpty(term)){
////            return modelAndView;
////        }
//        if (term == null){
//            return modelAndView;
//        }
//        modelAndView.addObject("contacts",contactService.findAllByNameContaining(term.get(), pageable));
//        return modelAndView;
//    }

//    public String search(@RequestParam("term") Optional<String> term,@PageableDefault(size =5) Pageable pageable, Model model) {
//        if (StringUtils.isEmpty(term)) {
//            return "redirect:/contact";
//        }
//
//        model.addAttribute("contacts", contactService.findAllByNameContaining(term.get(), pageable));
//        return "list";
//    }

    @GetMapping("/contact/add")
    public ModelAndView add(){
        Contact contact = new Contact();
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }
//    public String add(Model model) {
//        model.addAttribute("contact", new Contact());
//        return "form";
//    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }

    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.findById(id));
        return "form";
    }

    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/contact";
    }

}


//@Controller
//public class ContactController {
//    @Autowired
//    private ContactService contactService;
//
//    @GetMapping("/contact")
////    public ModelAndView showList(){
////        Iterable<Contact> contacts = contactService.findAll();
////        // lay du lieu tu database luu vao doi tuong contacts
////        // sau do tao mot doi tuong modelAndView moi chua duong dan
////        // den trang can hien thi du lieu /list
////        // cuoi cung them doi tuong contacts vao modelAndView vua tao
////        // va tra lai modelAndView
////        ModelAndView modelAndView = new ModelAndView("/list");
////        modelAndView.addObject("contact", contacts);
////        return modelAndView;
////    }
//    public String list(Model model){
//        model.addAttribute("contacts", contactService.findAll());
//        return "list";
//    }
//
//    @GetMapping("/contact/add")
////    public ModelAndView addNewContact(){
////        ModelAndView modelAndView = new ModelAndView("/form");
////        modelAndView.addObject("contact", new Contact());
////        return modelAndView;
////    }
//    public String add(Model model) {
//        model.addAttribute("contact", new Contact());
//        return "form";
//    }
//
//    @PostMapping("/contact/save")
//    public ModelAndView saveContact(@ModelAttribute("contact") Contact contact){
//        contactService.save(contact);
//        ModelAndView modelAndView = new ModelAndView("/list");
//        modelAndView.addObject("contact", new Contact());
//        modelAndView.addObject("message", "New Contact saved success");
//        return modelAndView;
//    }
//
//    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
//        if (result.hasErrors()) {
//            return "form";
//        }
//        contactService.save(contact);
//        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
//        return "redirect:/contact";
//    }
//
//    @GetMapping("/contact/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("contact", contactService.findById(id));
//        return "form";
//    }
//
//    @GetMapping("/contact/{id}/delete")
//    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
//        contactService.delete(id);
//        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
//        return "redirect:/contact";
//    }
//
//    @GetMapping("/contact/search")
//    public String search(@RequestParam("name") String name, Model model) {
//        if (StringUtils.isEmpty(name)) {
//            return "redirect:/contact";
//        }
//
//        model.addAttribute("contacts", contactService.search(name));
//        return "list";
//    }
//
//}
