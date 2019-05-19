package edu.mum.waa.controller;



import edu.mum.waa.entity.TM;
import edu.mum.waa.service.StudentService;
import edu.mum.waa.service.TMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@SessionAttributes("tm2")
@Controller
public class TMController {
    @Autowired
    StudentService studentService;
    @Autowired
    TMService tmService;

    @GetMapping("/tmchecking")
    public String listOfTmChecked(Model model){
        List<TM>  tms= tmService.getAllTmsChecked();
        model.addAttribute("tms",tms);


        return "listtmchecked";
    }

    @GetMapping("/tmcheck")
    public String displayTmCheckForm(Model theModel){
          TM tm=new TM();
          theModel.addAttribute("tm",tm);
        return "tmchekform";
    }
    @PostMapping("savetmcheck")
    public String saveTmCheckForm(@ModelAttribute("tm") TM tm, Model model, SessionStatus status){



       TM tm2= (TM)model.asMap().get("tm2");
       if(tm2!=null) {
           System.out.println(tm2.getId());
           tm.setId(tm2.getId());
           status.setComplete();
       }

        tmService.saveTmCheck(tm);
        //System.out.println(tm2.getId());
        return "redirect:/tmchecking";
    }

    @GetMapping("/tmformforupdate")
    public String showTmFormForUpdate(@RequestParam("id") int theId, Model model){

        //get the TM-check record from database
       TM tmCheck= tmService.getTmCheckById(theId);
       //int id=(int)tmCheck.getId();
       model.addAttribute("tm2",tmCheck);
      model.addAttribute("tm",tmCheck);
        return "/tmchekform";
    }
    @GetMapping("/delete")
    public String deleteTmCheck(@RequestParam("id") int theId){

        tmService.deleteTmCheck(theId);
        return "redirect:/tmchecking";
    }

}
