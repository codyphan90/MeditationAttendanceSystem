package edu.mum.waa.controller;

import edu.mum.waa.entity.BlockEntity;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.response.StudentReport;
import edu.mum.waa.service.AttendanceService;
import edu.mum.waa.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AttendanceController {
    @Autowired
    private BlockService blockService;

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/faculty")
    public String facultyForm(Model model) {
        List<BlockEntity> blockEntities = blockService.getBlockList(9);
        model.addAttribute("blocks", blockEntities);
        return "facultyreport";
    }

    @GetMapping("/faculty/report/{blockId}")
    public String getReport(@PathVariable("blockId") Integer blockId, Model model) {
        List<StudentReport> studentReports = attendanceService.getReport(blockId);
        model.addAttribute("reports", studentReports);
        System.out.println("report = " + studentReports.toString());
        return "reporttable";
    }


}
