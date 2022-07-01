package com.dl.service;

import com.dl.entity.Option;
import com.dl.entity.Subject;

import java.util.List;

public interface SubjectService {
    //查看所有的
    List<Subject> showAll();
    //查看某一个id的主题
    Subject showDetail(Integer id);
    //更新主题总投票数
    Integer updateVote(Integer id,Integer sid);
    //更新主题人数
    Integer updateView(Integer id);

    //同步更新
    Integer updateVotes(Subject subject);
}
