package com.example.repository.session;

 

import java.util.HashMap;

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

import com.example.model.Team;

 

@Repository

public class MiniHomeSessionRepository {

	@Autowired

	private SqlSessionTemplate sqlSession;

 

	private final String namespace = "com.example.repository.mapper.MiniHomeMapper";

	

 

	

	public List<Schedule> selectSchedules(@Param("mentorSessionUnum")String mentorSessionUnum, @Param("teamSessionTnum") String teamSessionTnum) {

		Map<String, String> paramMap = new HashMap<>();

		

		paramMap.put("mentorSessionUnum", mentorSessionUnum);

		paramMap.put("teamSessionTnum", teamSessionTnum);

		return sqlSession.selectList(namespace + ".selectSchedules", paramMap);

		

		

	}

	

	public Schedule selectScheduleByPrimaryKey(String sNum) {

		return (Schedule)sqlSession.selectOne(namespace + ".selectScheduleByPrimaryKey", sNum);

		

	}

	

	public Integer insertSchedule(Schedule schedule) {

		int result = sqlSession.insert(namespace + ".insertSchedule", schedule);

		return result;

	}

	public Integer insertActivity(Activity activity){

		int result = sqlSession.insert(namespace + ".insertActivity", activity);

		return result;

	}

	

	public Activity selectActivityByPrimaryKey(String aNum){

		return (Activity)sqlSession.selectOne(namespace + ".selectActivityByPrimaryKey", aNum);

		

	}

	

	public List<Activity> selectActivitys(String teamSessionTnum){

		return sqlSession.selectList(namespace + ".selectActivitys", teamSessionTnum);

	}

	

	public Activity WriterCheckByAnumUnum(@Param("aNum")String aNum, @Param("userSessionUnum") String userSessionUnum){

		Map<String, String> paramMap = new HashMap<>();

		

		paramMap.put("userSessionUnum", userSessionUnum);

		paramMap.put("aNum", aNum);

		return (Activity)sqlSession.selectOne(namespace + ".WriterCheckByAnumUnum", paramMap);

	}

}

