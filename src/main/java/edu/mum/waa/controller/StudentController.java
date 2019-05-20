package edu.mum.waa.controller;

import edu.mum.waa.entity.AttendDetail;
import edu.mum.waa.entity.UserEntity;
import edu.mum.waa.response.StudentReport;
import edu.mum.waa.service.AttendanceService;
import edu.mum.waa.service.BlockService;
import edu.mum.waa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private UserService userService;

    @Autowired
    private BlockService blockService;

    @Autowired
    private AttendanceService attendanceService;
    @GetMapping
    public String studentReport(Authentication authentication, Model model) {
        Integer studentId = Integer.parseInt(authentication.getName());
        UserEntity student = userService.findById(studentId);
        StudentReport studentReport = attendanceService.getAllAttendedOfStudent(student);
        model.addAttribute("blocks", student.getBlockList());
        model.addAttribute("report", studentReport);
        return "student";
    }

    @GetMapping(value = "/detail/{blockId}")
    public String reportDetail(@PathVariable("blockId") Integer blockId, Authentication authentication, Model model) {
        Integer studentId = Integer.parseInt(authentication.getName());
        StudentReport studentReport = attendanceService.getBlockReportOfStudent(blockId, studentId);
        List<AttendDetail> attendDetails = attendanceService.getAttendRecord(blockId, studentId);
        model.addAttribute("report", studentReport);
        model.addAttribute("attendDetails", attendDetails);
        return "studentdetail";
    }
}
