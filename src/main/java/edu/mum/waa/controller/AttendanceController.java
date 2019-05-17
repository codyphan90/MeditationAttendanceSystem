package edu.mum.waa.controller;

import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.response.StudentReport;
import edu.mum.waa.service.AttendanceService;
import edu.mum.waa.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
    private BlockService blockService;

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/faculty/block")
    public String facultyBlock(Authentication authentication, Model model) {
        Integer professorId = Integer.parseInt(authentication.getName());
        if (professorId == 1) {
            model.addAttribute("blocks", blockService.getAllBlock());
        } else {
            List<BlockEntity> blockEntities = blockService.getBlockList(professorId);
            model.addAttribute("blocks", blockEntities);

        }
        return "facultyblock";
    }

    @RequestMapping("/faculty/entry")
    public String facultyEntry(Authentication authentication, Model model) {
        List<String> entryList = Arrays.asList("Nov2018","Feb2019");
        model.addAttribute("entries", entryList);
        return "facultyentry";
    }

    @GetMapping("/faculty/block/{blockId}")
    public String getBlockReport(@PathVariable("blockId") Integer blockId, Model model) {
        List<StudentReport> studentReports = attendanceService.getBlockReport(blockId);
        model.addAttribute("reports", studentReports);
        System.out.println("report = " + studentReports.toString());
        return "reporttable";
    }

    @GetMapping("/faculty/entry/{entryId}")
    public String getEntryReport(@PathVariable("entryId") String entryId, Model model) {
        System.out.println("ENtryy....");
        List<StudentReport> studentReports = attendanceService.getEntryReport(entryId);
        model.addAttribute("reports", studentReports);
        System.out.println("report = " + studentReports.toString());
        return "reporttable";
    }


}
