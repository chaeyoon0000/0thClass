package com.example.repository.mapper;

 

import java.util.List;

import java.util.Map;

 

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

 

import com.example.model.Activity;

import com.example.model.Comment;

import com.example.model.Review;

import com.example.model.Schedule;

 

public interface MiniHomeMapper {

 

	List<Schedule> selectSchedules(@Param("mentorSessionUnum")String mentorSessionUnum, @Param("teamSessionTnum") String teamSessionTnum);

 

	Schedule selectScheduleByPrimaryKey(String sNum);

 

	Integer insertSchedule(Schedule schedule);

 

	Integer insertActivity(Activity activity);

 

	Activity selectActivityByPrimaryKey(String aNum);

 

	List<Activity> selectActivitys(String teamSessionTnum);

 

	Integer deleteActivity(String aNum);

 

	Activity WriterCheckByAnumUnum(@Param("aNum")String aNum, @Param("userSessionUnum") String userSessionUnum);

}

