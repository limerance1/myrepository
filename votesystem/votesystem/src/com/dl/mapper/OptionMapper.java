package com.dl.mapper;

import com.dl.entity.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    //更新票数
    Integer updateVote(Integer id);
    //查看票数
    List<Option> findOption(Integer sid);
}
