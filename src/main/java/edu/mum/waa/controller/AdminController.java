package edu.mum.waa.controller;

import edu.mum.waa.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    FileService fileService;

    @GetMapping("/process")
    public String processFile() {
        return "process";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("mediation-file") MultipartFile file, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", fileService.processFile(file));
        return "redirect:/admin/process";
    }
}
