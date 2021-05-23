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

import com.example.model.Team;

import com.example.model.User;

 

public interface TeamMapper {

	

//	@Select("SELECT r_num, title, content, r_date, image, rate, item, id AS writer, kind, cat_title AS r_cat " +

//	   	    "FROM review, category, user_t " +

//			"WHERE r_num = #{r_num} AND review.r_cat = category.cat_num AND user_t.u_num = review.u_num")

//	Team selectTeamByPrimaryKey(String t_num);

//	

//	@Select("SELECT TEAM.T_NUM, T_NAME, T_START, T_LIMIT, CAT_TITLE AS "category.catTitle", " +

//			"T_CONTENT, T_END, RECRUIT, T_TERM, PRICE, TEAM.U_NUM, NAME " +

//			"FROM TEAM, CATEGORY, USER_T " +

//			"WHERE TEAM.CAT_NUM = CATEGORY.CAT_NUM AND TEAM.U_NUM = USER_T.U_NUM AND T_NUM = #{t_num}")

	Team selectTeamByPrimaryKey(String t_num);

	

	

	

	List<Team> selectTeams();

 

 

 

	Integer insertTeam(Team team);

 

 

 

	User mentorNameByMentorNum(String uNum);

 

 

 

	Integer deleteTeam(String tNum);

 

 

 

	Integer insertTeamRequestToApply(@Param("tNum")String tNum, @Param("uNum")String uNum);

 

 

 

	Integer updateTeam(Team team);

 

 

 

	Integer leaveTeam(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum);

 

 

 

	Team applyCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum);

 

 

 

	List<Team> selectTeamByCondition(Map<String, Object> condition);

 

 

 

	Team memberShipCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum);

 

 

 

	Team mentorCheckByTnumUnum(@Param("tNum")String tNum, @Param("userSessionNum")String userSessionNum);

 

 

 

	Team applyLimitCheck(String tNum);

 

 

 

	List<Team> applyList(String tNum);

 

 

 

	Integer insertMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip);

 

 

 

	Integer deleteApply(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip);

 

	

	List<Team> memberShipList(String tNum);

 

 

	Integer deleteMemberShip(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip);

 

 

	List<Activity> activityList(String tNum);

 

	Integer deleteActivity(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip);

 

 

 

	List<Schedule> scheduleList(String tNum);

 

	Integer deleteSchedule(@Param("tNumMemberShip")String tNumMemberShip, @Param("uNumMemberShip")String uNumMemberShip);

 

 

 

	Integer updateTeamRecruit(String tNum);

 

 

 

	Integer insertTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum);

 

 

 

	Integer insertTeamCompleteMemberPoint(@Param("pointC")String pointC, @Param("uNumMemberShip")String uNumMemberShip);

 

 

 

	Integer insertTeamCompleteLeaderPoint(@Param("pointC1")String pointC1, @Param("mentorNum")String mentorNum);

 

 

 

	Integer deleteTeamRegisterPoint(@Param("pointC")String pointC, @Param("mentorNum")String mentorNum);

 

	List<Team> selectListTeams();

 

 

 

	List<Team> selectListWishListTeams(String uNum);







	Integer deleteWishlist(@Param("tNum")String tNum, @Param("uNum")String uNum);


}