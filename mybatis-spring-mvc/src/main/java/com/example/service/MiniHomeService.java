package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Activity;
import com.example.model.Comment;
import com.example.model.Review;
import com.example.model.Schedule;
import com.example.repository.mapper.MiniHomeMapperRepository;
import com.example.repository.mapper.ReviewMapperRepository;
// import com.example.repository.mapper.CommentMapperRepository2;
// import com.example.repository.session.CommentSessionRepository;

@Service
public class MiniHomeService {
	@Autowired
	private MiniHomeMapperRepository miniHomeRepository;

	public List<Schedule> getScheduleList(@Param("mentorSessionUnum")String mentorSessionUnum, @Param("teamSessionTnum") String teamSessionTnum) {
		// TODO Auto-generated method stub
		return miniHomeRepository.selectSchedules(mentorSessionUnum, teamSessionTnum);
	}

	public Schedule selectSchedule(String sNum) {
		// TODO Auto-generated method stub
		return miniHomeRepository.selectScheduleByPrimaryKey(sNum);
	}
	
	@Transactional
	public Integer insertSchedule(Schedule schedule) {
		return miniHomeRepository.insertSchedule(schedule);
	}
	@Transactional
	public Integer insertActivity(Activity activity) {
		return miniHomeRepository.insertActivity(activity);
	}

	public Activity selectActivity(String aNum) {
		// TODO Auto-generated method stub
		return miniHomeRepository.selectActivityByPrimaryKey(aNum);
	}

	public List<Activity> getActivityList(String teamSessionTnum) {
		return miniHomeRepository.selectActivitys(teamSessionTnum);
	}
	@Transactional
	public Integer deleteActivity(String aNum) {
		return miniHomeRepository.deleteActivity(aNum);
		
	}
	
	public Activity WriterCheckByAnumUnum(@Param("aNum")String aNum, @Param("userSessionUnum") String userSessionUnum) {
		return miniHomeRepository.WriterCheckByAnumUnum(aNum, userSessionUnum);
	}
}