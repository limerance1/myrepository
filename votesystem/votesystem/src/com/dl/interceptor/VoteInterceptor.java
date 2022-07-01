package com.dl.interceptor;

import com.dl.entity.Option;
import com.dl.entity.Subject;
import com.dl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteInterceptor implements HandlerInterceptor {
    @Autowired
    private SubjectService subjectService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer id=Integer.valueOf( request.getParameter("id"));
        Subject subject=subjectService.showDetail(id);
        Integer totals=subject.getTotalVotes();
        Integer totalo=0;
        for(Option option:subject.getOptions())
        {

            totalo+=option.getVote();
        }
        if(totalo!=totals)
        {
            Subject subject1=new Subject();
            subject1.setId(id);
            subject1.setTotalVotes(totalo);
            subjectService.updateVotes(subject1);
        }
        return true;
    }
}
