package com.dl.controller;

import com.dl.entity.Subject;
import com.dl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VoteController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/show.do")
    @ResponseBody
    public List<Subject> show(ModelMap map)
    {
        return subjectService.showAll();
    }
    @RequestMapping("/showdetail.do")
    @ResponseBody
    public Subject showDetail(Integer id)
    {
        subjectService.updateView(id);
        return subjectService.showDetail(id);
    }
    @RequestMapping("/update.do")
    public  String update(Integer id,Integer sid)
    {
        try{
            subjectService.updateVote(id,sid);
            return "redirect:/index.jsp";
        }catch (Exception e)
        {
            return "redirect:/error.jsp";
        }
    }
}
