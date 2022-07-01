package com.dl.service;

import com.dl.entity.Subject;
import com.dl.mapper.OptionMapper;
import com.dl.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("SubjectService")
public class SubjectServiceImp implements SubjectService {
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public List<Subject> showAll() {
        return subjectMapper.findAll();
    }

    @Override
    public Subject showDetail(Integer id) {
        return  subjectMapper.findById(id);
    }

    @Override
    public Integer updateVote(Integer id,Integer sid) {
        try{
            optionMapper.updateVote(id);
          Integer res=subjectMapper.updateVote(sid);
            return res;
        }catch (Exception e)
        {
            throw  new RuntimeException();
        }


    }

    @Override
    public Integer updateView(Integer id) {
        return subjectMapper.updateView(id);
    }



    @Override
    public Integer updateVotes(Subject subject) {
        return subjectMapper.updateVotes(subject);
    }
}
