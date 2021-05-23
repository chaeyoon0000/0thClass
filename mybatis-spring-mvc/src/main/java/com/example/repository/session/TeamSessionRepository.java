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

import com.example.model.User;

import com.example.repository.mapper.TeamMapper;

 

@Repository

public class TeamSessionRepository {

	@Autowired

	private SqlSessionTemplate sqlSession;

 

	private final String namespace = "com.example.repository.mapper.TeamMapper";

	

	public List<Team> selectTeams() {

		return sqlSession.selectList(namespace + ".selectTeams");

	}

	public Team selectTeamByPrimaryKey(String tNum) {

		return (Team)sqlSession.selectOne(namespace + ".selectTeamByPrimaryKey", tNum);

	}

	public Integer insertTeam(Team team) {

		int result = sqlSession.insert(namespace + ".insertTeam", team);

		return result;

	}

	public User mentorNameByMentorNum(String uNum) {

		return (User)sqlSession.selectOne(namespace + ".mentorNameByMentorNum", uNum);

	}

	

	public Integer deleteTeam(String tNum) {

		int result = sqlSession.delete(namespace + ".deleteTeam", tNum);

		return result;

	}

	public Integer insertTeamRequestToApply(@Param("tNum")String tNum, @Param("uNum")String uNum) {

		Map<String, String> paramMap = new HashMap<>();

		System.out.println("Repository 팀 신청 직전 TNUM!" + tNum);

		paramMap.put("tNum", tNum);

		paramMap.put("uNum", uNum);

		

		int result = sqlSession.insert(namespace + ".insertTeamRequestToApply", paramMap);

		return result;

	}

	

	public Integer updateTeam(Team team) {

		int result = sqlSession.update(namespace + ".updateTeam", team);

		return result;

	}

	

 

	public Team applyCheckByTnumUnum(String tNum, String userSessionNum) {

		Map<String, String> paramMap = new HashMap<>();

		System.out.println("Repository 팀넘 체크 TNUM!" + tNum);

		paramMap.put("tNum", tNum);

		paramMap.put("userSessionNum", userSessionNum);

		return (Team)sqlSession.selectOne(namespace + ".applyCheckByTnumUnum", paramMap);

	}

	

	

	

	

	public Integer leaveTeam(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		Map<String, String> paramMap = new HashMap<>();

		System.out.println("Repository 팀 탈퇴 직전 TNUM!" + tNum);

		paramMap.put("tNum", tNum);

		paramMap.put("userSessionNum", userSessionNum);

		

		int result = sqlSession.delete(namespace + ".leaveTeam", paramMap);

		return result;

	}

	

	public List<Team> selectTeamByCondition(Map<String, Object> condition) {

		return sqlSession.selectList(namespace + ".selectTeamByCondition", condition);

	}

	public Team memberShipCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		Map<String, String> paramMap = new HashMap<>();

		System.out.println("Repository 팀넘 체크 TNUM!" + tNum);

		paramMap.put("tNum", tNum);

		paramMap.put("userSessionNum", userSessionNum);

		return (Team)sqlSession.selectOne(namespace + ".memberShipCheckByTnumUnum", paramMap);

		

	}

	public Team mentorCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum) {

		Map<String, String> paramMap = new HashMap<>();

		System.out.println("Repository 팀넘 체크 TNUM!" + tNum);

		paramMap.put("tNum", tNum);

		paramMap.put("userSessionNum", userSessionNum);

		return (Team)sqlSession.selectOne(namespace + ".mentorCheckByTnumUnum", paramMap);

	};

	

	public Team applyLimitCheck(String tNum) {

		return (Team)sqlSession.selectOne(namespace + ".applyLimitCheck", tNum);

	};

	

	public List<Team> applyList(String tNum) {

		return sqlSession.selectList(namespace + ".applyList", tNum);

	}

	public Integer insertMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNumMemberShip", tNumMemberShip);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.insert(namespace + ".insertMemberShip", paramMap);

		return result;

	}

 

	public Integer deleteApply(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNumMemberShip", tNumMemberShip);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.delete(namespace + ".deleteApply", paramMap);

		return result;

	}

	public List<Team> memberShipList(String tNum){

		return sqlSession.selectList(namespace + ".memberShipList", tNum);

	}

 

	public Integer deleteMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNumMemberShip", tNumMemberShip);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.delete(namespace + ".deleteMemberShip", paramMap);

		return result;

	}

	

	

	public List<Activity> activityList(String tNum){

		return sqlSession.selectList(namespace + ".activityList", tNum);

	}

 

	public Integer deleteActivity(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNumMemberShip", tNumMemberShip);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.delete(namespace + ".deleteActivity", paramMap);

		return result;

	}

	

	public List<Schedule> scheduleList(String tNum){

		return sqlSession.selectList(namespace + ".scheduleList", tNum);

	}

 

	public Integer deleteSchedule(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNumMemberShip", tNumMemberShip);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.delete(namespace + ".deleteSchedule", paramMap);

		return result;

	};

 

	public Integer updateTeamRecruit(String tNum) {

		int result = sqlSession.update(namespace + ".updateTeamRecruit", tNum);

		return result;

	}

	

	public Integer insertTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("pointC", pointC);

		paramMap.put("mentorNum", mentorNum);

 

		int result = sqlSession.update(namespace + ".insertTeamRegisterPoint", paramMap);

		return result;

	}

	public Integer insertTeamCompleteMemberPoint(@Param("pointC")String pointC, @Param("uNumMemberShip")String uNumMemberShip){

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("pointC", pointC);

		paramMap.put("uNumMemberShip", uNumMemberShip);

		

		int result = sqlSession.update(namespace + ".insertTeamCompleteMemberPoint", paramMap);

		return result;

	}

 

	public Integer insertTeamCompleteLeaderPoint(@Param("pointC1")String pointC1, @Param("mentorNum")String mentorNum){

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("pointC1", pointC1);

		paramMap.put("mentorNum", mentorNum);

		

		int result = sqlSession.update(namespace + ".insertTeamCompleteLeaderPoint", paramMap);

		return result;

	}

	

	public Integer deleteTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("pointC", pointC);

		paramMap.put("mentorNum", mentorNum);

		

		int result = sqlSession.update(namespace + ".deleteTeamRegisterPoint", paramMap);

		return result;

	}

	public List<Team> selectListTeams(){

		return sqlSession.selectList(namespace + ".selectListTeams");

	}

	public List<Team> selectListWishListTeams(String uNum){

		return sqlSession.selectList(namespace + ".selectListWishListTeams", uNum);

	}

	
	public Integer deleteWishlist(@Param("tNum")String tNum, @Param("uNum")String uNum) {
		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("tNum", tNum);

		paramMap.put("uNum", uNum);

		

		int result = sqlSession.update(namespace + ".deleteWishlist", paramMap);

		return result;
		
	}
}

