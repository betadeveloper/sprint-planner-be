package com.sourcery.sprint.workingday.repository;

import com.sourcery.sprint.workingday.model.WorkingDayEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface WorkingDayRepositoryMyBatis {

    @Insert("INSERT INTO working_day (day, sprint_id, member_id, task_key_value) " +
            "VALUES (#{day}, #{sprintId}, #{memberId}, #{taskKeyValue})")
    void save(@RequestBody WorkingDayEntity workingDayEntity);

    @Select("SELECT id, day, sprint_id AS sprintId, member_id AS memberId, task_key_value AS taskKeyValue" +
            " FROM working_day WHERE sprint_id=#{sprintId} AND member_id=#{memberId}")
    List<WorkingDayEntity> findWorkingDaysById(@Param("sprintId") Long sprintId, @Param("memberId") Long memberId);
}


