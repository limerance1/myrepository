package com.dl.mapper;

import com.dl.entity.Option;
import com.dl.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper {
    //查看所有主题
    List<Subject> findAll();
    Subject findById(Integer id);
    //更新投票人数（一次更新一个）
    Integer updateVote(Integer id);
    //更新投票人数(同步option投票)
    Integer updateVotes(Subject sub);
    //更新人数
    Integer updateView(Integer id);
}
