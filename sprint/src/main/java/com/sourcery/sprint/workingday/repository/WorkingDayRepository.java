package com.sourcery.sprint.workingday.repository;

import com.sourcery.sprint.workingday.model.WorkingDayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkingDayRepository {

    @Autowired
    private WorkingDayRepositoryMyBatis workingDayRepositoryMyBatis;

    public List<WorkingDayEntity> findWorkingDaysById(Long sprintId, Long memberId) {
        return workingDayRepositoryMyBatis.findWorkingDaysById(sprintId, memberId);
    }

    public void saveWorkingDay(WorkingDayEntity workingDayEntity) {
        workingDayRepositoryMyBatis.save(workingDayEntity);
    }
}
