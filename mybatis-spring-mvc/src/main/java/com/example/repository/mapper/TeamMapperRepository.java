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

import com.example.model.Team;

import com.example.model.User;

 

@Repository

public class TeamMapperRepository {

	@Autowired

	private SqlSessionTemplate sqlSession;

	

	public List<Team> selectTeams() {

		System.out.println("Repository 부분 " + sqlSession.getMapper(TeamMapper.class).selectTeams().get(0).gettName());

		return sqlSession.getMapper(TeamMapper.class).selectTeams();

	}

 

	public Team selectTeamByPrimaryKey(String t_num) {

		// TODO Auto-generated method stub

		return sqlSession.getMapper(TeamMapper.class).selectTeamByPrimaryKey(t_num);

	}

 

	public Integer insertTeam(Team team) {

		Integer result = sqlSession.getMapper(TeamMapper.class).insertTeam(team);

		return result;

	}

 

	public User mentorNameByMentorNum(String uNum) {

		// TODO Auto-generated method stub

		return sqlSession.getMapper(TeamMapper.class).mentorNameByMentorNum(uNum);

	}

 

	public Integer deleteTeam(String tNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteTeam(tNum);

		return result;

	}

 

	public Integer insertTeamRequestToApply(@Param("tNum")String tNum, @Param("uNum")String uNum) {

		System.out.println("MapperRepository 팀 신청 직전 TNUM!" + tNum);

		Integer result = sqlSession.getMapper(TeamMapper.class).insertTeamRequestToApply(tNum, uNum);

		return result;

	}

 

	public Integer updateTeam(Team team) {

		Integer result = sqlSession.getMapper(TeamMapper.class).updateTeam(team);

		return result;

	}

 

 

 

	public Integer leaveTeam(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).leaveTeam(tNum, userSessionNum);

		return result;

	}

 

	public Team applyCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return sqlSession.getMapper(TeamMapper.class).applyCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public List<Team> selectTeamByCondition(Map<String, Object> condition) {

		return sqlSession.getMapper(TeamMapper.class).selectTeamByCondition(condition);

	}

 

	public Team memberShipCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return sqlSession.getMapper(TeamMapper.class).memberShipCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public Team mentorCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		return sqlSession.getMapper(TeamMapper.class).mentorCheckByTnumUnum(tNum, userSessionNum);

	}

 

	public Team applyLimitCheck(String tNum) {

		return sqlSession.getMapper(TeamMapper.class).applyLimitCheck(tNum);

	}

 

	public List<Team> applyList(String tNum) {

		return sqlSession.getMapper(TeamMapper.class).applyList(tNum);

	}

 

	public Integer insertMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).insertMemberShip(tNumMemberShip, uNumMemberShip);

		return result;

	}

 

	public Integer deleteApply(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteApply(tNumMemberShip, uNumMemberShip);

		return result;

	}

 

	public List<Team> memberShipList(String tNum) {

		return sqlSession.getMapper(TeamMapper.class).memberShipList(tNum);

	}

 

	public Integer deleteMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteMemberShip(tNumMemberShip, uNumMemberShip);

		return result;

	}

 

	public List<Activity> activityList(String tNum) {

		return sqlSession.getMapper(TeamMapper.class).activityList(tNum);

	}

 

	public Integer deleteActivity(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteActivity(tNumMemberShip, uNumMemberShip);

		return result;

	}

 

	public List<Schedule> scheduleList(String tNum) {

		return sqlSession.getMapper(TeamMapper.class).scheduleList(tNum);

	}

 

	public Integer deleteSchedule(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteSchedule(tNumMemberShip, uNumMemberShip);

		return result;

	}

 

	public Integer updateTeamRecruit(String tNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).updateTeamRecruit(tNum);

		return result;

	}

 

	public Integer insertTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).insertTeamRegisterPoint(pointC, mentorNum);

		return result;

	}

 

	public Integer insertTeamCompleteMemberPoint(@Param("pointC")String pointC, @Param("uNumMemberShip")String uNumMemberShip) {

		Integer result = sqlSession.getMapper(TeamMapper.class).insertTeamCompleteMemberPoint(pointC, uNumMemberShip);

		return result;

	}

 

	public Integer insertTeamCompleteLeaderPoint(@Param("pointC1")String pointC1, @Param("mentorNum")String mentorNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).insertTeamCompleteLeaderPoint(pointC1, mentorNum);

		return result;

	}

 

	public Integer deleteTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		Integer result = sqlSession.getMapper(TeamMapper.class).deleteTeamRegisterPoint(pointC, mentorNum);

		return result;

	}

 

	public List<Team> selectListTeams() {

		return sqlSession.getMapper(TeamMapper.class).selectListTeams();

	}

 

	public List<Team> selectListWishListTeams(String uNum) {

		return sqlSession.getMapper(TeamMapper.class).selectListWishListTeams(uNum);

	}



	public Integer deleteWishlist(@Param("tNum")String tNum, @Param("uNum")String uNum) {
		Integer result = sqlSession.getMapper(TeamMapper.class).deleteWishlist(tNum, uNum);

		return result;
	}

 

	

}