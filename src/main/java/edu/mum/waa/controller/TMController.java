package edu.mum.waa.controller;
import edu.mum.waa.entity.TM;
import edu.mum.waa.service.StudentService;
import edu.mum.waa.service.TMService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static java.util.function.Predicate.isEqual;

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
    public String saveTmCheckForm(@Valid @ModelAttribute("tm") TM tm, BindingResult result, Model model,SessionStatus status){
        TM tm2= (TM)model.asMap().get("tm2");
        if(result.hasErrors()){
            return "tmchekform";
        }

        if(tm2!=null) {

            tm.setId(tm2.getId());// to maintain the id for update
            status.setComplete();
        }
        String message="";
        try {
            List<TM>studentTms=tmService.findAllTmChecksOfStudent(tm.getStudent().getStudentId());

            TM duplicateTm=null;
            TM updateTm=null;
            TM notAllowedTm=null;

            for(TM recent:studentTms){
                if (recent.getCheckedDate().isEqual(tm.getCheckedDate())) {
                    if (recent.getId()== tm.getId()){
                        break;

                    } else {
                        duplicateTm = recent;
                        message += "duplicate record exist";
                        break;
                    }
                }
                else if (recent.getCheckedDate().getMonthValue() - tm.getCheckedDate().getMonthValue() < 1 &&recent.getId()!=tm.getId()) {

                    notAllowedTm = recent;
                    message+= "You cann't make a tm check more than once within a month \n"+
                            "your  recent tm check is done on "+notAllowedTm.getCheckedDate();
                    break;
                }
            }
            if (duplicateTm!=null || notAllowedTm!=null){
                model.addAttribute("message",message);
                return "tmchekform";
            }

            else {
                tmService.saveTmCheck(tm);
            }

        } catch (RuntimeException exc){
            //message+=exc.getMessage();
            message+="Student with ID of "+ tm.getStudent().getStudentId()+ "doesn't exist";
            model.addAttribute("message",message);
            return "tmchekform";
        }
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

        System.out.println(theId);
        tmService.deleteTmCheck(theId);
        return "redirect:/tmchecking";
    }



}
