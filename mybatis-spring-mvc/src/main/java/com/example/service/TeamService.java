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

import com.example.model.Team;

import com.example.model.User;

import com.example.repository.mapper.ReviewMapperRepository;

// import com.example.repository.mapper.CommentMapperRepository2;

// import com.example.repository.session.CommentSessionRepository;

import com.example.repository.mapper.TeamMapperRepository;

 

@Service

public class TeamService {

	@Autowired

	private TeamMapperRepository teamRepository;

 

	public List<Team> getTeamList() {

		return teamRepository.selectTeams();

	}

 

	public Team selectTeam(String t_num) {

		// TODO Auto-generated method stub

		return teamRepository.selectTeamByPrimaryKey(t_num);

	}

 

 

	@Transactional

	public Integer insertTeam(Team team) {

		return teamRepository.insertTeam(team);

	}

 

	public User mentorNameByMentorNum(String uNum) {

		// TODO Auto-generated method stub

		return teamRepository.mentorNameByMentorNum(uNum);

	}

	

	@Transactional

	public Integer insertTeamRequestToApply(@Param("tNum")String tNum, @Param("uNum")String uNum) {

		System.out.println("서비스 팀 신청 직전 TNUM!" + tNum);

		return teamRepository.insertTeamRequestToApply(tNum, uNum);

	}

	

	

	

	

	

	

	@Transactional

	public Integer deleteTeam(String tNum) {

		return teamRepository.deleteTeam(tNum);

	}

	

	@Transactional

	public Integer updateTeam(Team team) {

		return teamRepository.updateTeam(team);

	}

 

	

	@Transactional

	public Integer leaveTeam(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return teamRepository.leaveTeam(tNum, userSessionNum);

		

	}

 

	public Team applyCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return teamRepository.applyCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public List<Team> searchTeamByCategory(String category) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("category", category);

		return teamRepository.selectTeamByCondition(map);

	}

 

	public Team memberShipCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return teamRepository.memberShipCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public Team mentorCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		// TODO Auto-generated method stub

		return teamRepository.mentorCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public Team applyLimitCheck(String tNum) {

		return teamRepository.applyLimitCheck(tNum);

	}

 

	public List<Team> applyList(String tNum) {

		return teamRepository.applyList(tNum);

	}

	@Transactional

	public Integer insertMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.insertMemberShip(tNumMemberShip, uNumMemberShip);

		

	}

	@Transactional

	public Integer deleteApply(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.deleteApply(tNumMemberShip, uNumMemberShip);

		

	}

 

	public List<Team> memberShipList(String tNum) {

		return teamRepository.memberShipList(tNum);

	}

	

	@Transactional

	public Integer deleteMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.deleteMemberShip(tNumMemberShip, uNumMemberShip);

		

	}

 

	public List<Activity> activityList(String tNum) {

		return teamRepository.activityList(tNum);

	}

	@Transactional

	public Integer deleteActivity(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.deleteActivity(tNumMemberShip, uNumMemberShip);

	}

 

	public List<Schedule> scheduleList(String tNum) {

		return teamRepository.scheduleList(tNum);

	}

	@Transactional

	public Integer deleteSchedule(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.deleteSchedule(tNumMemberShip, uNumMemberShip);

		

	}

	

	@Transactional

	public Integer updateTeamRecruit(String tNum) {

		return teamRepository.updateTeamRecruit(tNum);

		

	}

	@Transactional

	public Integer insertTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		return teamRepository.insertTeamRegisterPoint(pointC, mentorNum);

	}

	@Transactional

	public Integer insertTeamCompleteMemberPoint(@Param("pointC")String pointC, @Param("uNumMemberShip")String uNumMemberShip) {

		return teamRepository.insertTeamCompleteMemberPoint(pointC, uNumMemberShip);

		

	}

	@Transactional

	public Integer insertTeamCompleteLeaderPoint(@Param("pointC1")String pointC1, @Param("mentorNum")String mentorNum) {

		return teamRepository.insertTeamCompleteLeaderPoint(pointC1, mentorNum);

		

	}

	

	@Transactional

	public Integer deleteTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		return teamRepository.deleteTeamRegisterPoint(pointC, mentorNum);

		

	}

 

	public List<Team> selectListTeams() {

		return teamRepository.selectListTeams();

	}

 

	public List<Team> selectListWishListTeams(String uNum) {

		return teamRepository.selectListWishListTeams(uNum);

	}


	@Transactional
	public Integer deleteWishlist(@Param("tNum")String tNum, @Param("uNum")String uNum) {
		return teamRepository.deleteWishlist(tNum, uNum);
		
	}

 

 

}