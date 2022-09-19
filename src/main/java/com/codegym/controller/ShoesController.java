package com.codegym.controller;

import com.codegym.model.Shoes;
import com.codegym.model.ShoesForm;
import com.codegym.service.ShoesService;
import com.codegym.service.IShoesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/shoes")
public class ShoesController {
    private final IShoesService shoesService = new ShoesService();

    @GetMapping("")
    public String index(Model model) {
        List<Shoes> shoesList = shoesService.findAll();
        model.addAttribute("shoes", shoesList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("shoe", new Shoes());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Shoes shoes) {
//        shoes.setId((Long)(Math.random() * 10000));
        shoesService.save(shoes);
        return "redirect:/shoes";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("shoe", shoesService.findById(Integer.valueOf(id)));
        return "/edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("shoe", shoesService.findById(Integer.valueOf(id)));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Shoes shoes, RedirectAttributes redirect) {
        shoesService.remove(Integer.valueOf(Math.toIntExact(shoes.getId())));
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/shoes";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("shoe", shoesService.findById(Integer.valueOf(id)));
        return "/view";
    }

    @PostMapping("/update")
    public String update(Shoes shoes) {
        shoesService.update(Math.toIntExact(shoes.getId()), shoes);
        return "redirect:/shoes";
    }
    @Value("D:\\image\\")
    private  String fileUpload;
    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute ShoesForm shoesForm) {
        MultipartFile multipartFile = shoesForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(shoesForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Shoes shoes = new Shoes((Integer) shoesForm.getId(), shoesForm.getName(),
                shoesForm.getPrice(), fileName);
        shoesService.save(shoes);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customerForm", shoesForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

}