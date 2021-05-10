package com.example.repository.mapper;

 

import java.util.List;

import java.util.Map;

 

import org.apache.ibatis.annotations.Param;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

 

import com.example.model.Activity;

import com.example.model.Comment;

import com.example.model.Review;

import com.example.model.Schedule;

 

@Repository

public class MiniHomeMapperRepository {

	@Autowired

	private SqlSessionTemplate sqlSession;

 

	public List<Schedule> selectSchedules(@Param("mentorSessionUnum")String mentorSessionUnum, @Param("teamSessionTnum") String teamSessionTnum) {

		// TODO Auto-generated method stub

		return sqlSession.getMapper(MiniHomeMapper.class).selectSchedules(mentorSessionUnum, teamSessionTnum);

	}

 

	public Schedule selectScheduleByPrimaryKey(String sNum) {

		return sqlSession.getMapper(MiniHomeMapper.class).selectScheduleByPrimaryKey(sNum);

	}

 

	public Integer insertSchedule(Schedule schedule) {

		Integer result = sqlSession.getMapper(MiniHomeMapper.class).insertSchedule(schedule);

		return result;

	}

 

	public Integer insertActivity(Activity activity) {

		Integer result = sqlSession.getMapper(MiniHomeMapper.class).insertActivity(activity);

		return result;

	}

 

	public Activity selectActivityByPrimaryKey(String aNum) {

		return sqlSession.getMapper(MiniHomeMapper.class).selectActivityByPrimaryKey(aNum);

	}

 

	public List<Activity> selectActivitys(String teamSessionTnum) {

		return sqlSession.getMapper(MiniHomeMapper.class).selectActivitys(teamSessionTnum);

	}

 

	public Integer deleteActivity(String aNum) {

		Integer result = sqlSession.getMapper(MiniHomeMapper.class).deleteActivity(aNum);

		return result;

	}

 

	public Activity WriterCheckByAnumUnum(@Param("aNum")String aNum, @Param("userSessionUnum") String userSessionUnum) {

		return sqlSession.getMapper(MiniHomeMapper.class).WriterCheckByAnumUnum(aNum, userSessionUnum);

	}

}