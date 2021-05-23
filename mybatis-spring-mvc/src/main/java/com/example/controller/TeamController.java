package com.example.controller;

 

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.context.ApplicationContextAware;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.context.WebApplicationContext;

 

import com.example.model.Activity;

import com.example.model.Category;

import com.example.model.Schedule;

import com.example.model.Team;

import com.example.model.User;

import com.example.service.CategoryService;

 

import com.example.service.TeamService;

 

/*

 * 

 * 190606 팀 생성, 리스트, 디테일, 삭제, 수정, 탈퇴, 요청

 * 	리스트의 경우 페이지 목록 추가 필요, apply 테이블과 연관된 모집인원 수정 필요

 * 	삭제의 경우 멘토넘버와 비교 검사 필요, 후에 활동기록, 스케줄 추가

 * 	수정, 삭제의 경우 생성 직후 삭제, 수정 불가능. tNum을 불러와야하는데, tNum 제외하고 기본키를 대신해 쿼리문을 짤 수 있는가?

 * 		-생성시 생성 직후 디테일로 가는 controller를 한번 더 갔다가 다시 오는 걸로 구현?

 * 	팀 신청 시, a태그에 달 경우 씹힘. data-target 밑에 달아야할것가은데 이후에 수정. 또 팀 신청, 탈퇴 구분 위해 apply membership에 들어있는지 확인하고 멘토도 안 보이도록 수정.

 * 	검색의 종류 : 카테고리, 이름 검색, 내용 검색, 팀네임 검색

 * 	팀 수정 시 모집완료로 수정하면, 팀 모집인원도 수정하고, 멤버쉽으로 넘김

 * 

 * 	해야할 일: 등록(수정) 페이지에 모집완료-모집중 버튼 추가 및 AJAX, 검색-이름 검색, 내용 검색, 팀네임 검색

 * 				인원 차면 미니홈이 열리도록-버튼 표시, 팀섹션 추가

 * 	

 * 

 * 	팀세션이 필요?

 */

 

 

@Controller

public class TeamController implements ApplicationContextAware {

	

	private WebApplicationContext context;	

	

	@Override					// life-cycle callback method

	public void setApplicationContext(ApplicationContext appContext)

		throws BeansException {

		this.context = (WebApplicationContext) appContext;

	}

	

	@Autowired

	private TeamService teamService;

	public void setTeamService(TeamService teamService) {

		this.teamService = teamService;

	}

	

	@Autowired

	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {

		this.categoryService = categoryService;

	}

	

	@RequestMapping("/team/teamList.do")

	public String listTeams(Model model) {

//		List<Team> teamList = teamService.getTeamList();

		

		List<Team> teamList = teamService.selectListTeams();

		

		

		

		/* apply와 엮어서 질의문 작성 필요 */

		

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("teamList", teamList);

		model.addAttribute("categoryList", categoryList);

		return "team/teamList";

	}

	

	@RequestMapping("/team/teamDetail.do/{tNum}")

	public String selectByTeamNo(@PathVariable("tNum") String tNum, HttpSession session,  Model model) {

		

		/*모델 객체가 없어 임시로 team에 넣음*/

		Team team = teamService.selectTeam(tNum);

		Team ApplyLimitCheck = teamService.applyLimitCheck(tNum);

		

		model.addAttribute("ApplyDetailCheck", "true");

		if(ApplyLimitCheck == null) {

			model.addAttribute("ApplyDetailCheck", "false");

		}

		

		TeamSession teamSession = new TeamSession(team); //세션 저장

		System.out.println("팀세션 저장" + teamSession.getTeam().gettNum());

		

		

		

		

		//미니홈의 경우 결국 모델이 필요하지 않은지??
		User user = (User) session.getAttribute("user");
		String userSessionNum = user.getuNum(); //임시 유저 섹션

	

		//false일때 보이도록 true일때 보이지 않도록

		

		Team requestApplyCheckList = teamService.applyCheckByTnumUnum(tNum, userSessionNum); //apply 테이블 체크(신청, 탈퇴 구분)

		model.addAttribute("ApplyInclude", "true");

        if(requestApplyCheckList == null) {

        	model.addAttribute("ApplyInclude", "false");

        }

		

        Team requestMemberShipCheckList = teamService.memberShipCheckByTnumUnum(tNum, userSessionNum); //멤버쉽 테이블 체크(신청, 탈퇴 구분)

        model.addAttribute("MemberShipInclude", "true");

        if(requestMemberShipCheckList == null) {

        	model.addAttribute("MemberShipInclude", "false");

        }

        

        Team requestMentorCheckList = teamService.mentorCheckByTnumUnum(tNum, userSessionNum); //멘토 테이블 체크(신청, 탈퇴 구분, 삭제, 수정)

        model.addAttribute("MentorInclude", "true");

        if(requestMentorCheckList == null) {

        	model.addAttribute("MentorInclude", "false");

        }

        

        int teamFull = Integer.parseInt(team.getRecruit()); //모집완료 체크

        model.addAttribute("TeamFull", "true");

        if(teamFull == 0) {

        	model.addAttribute("TeamFull", "false");

        }

        model.addAttribute("ApplyLimitCheck", ApplyLimitCheck);

        model.addAttribute("teamSession", teamSession);

        model.addAttribute("userSessionNum", userSessionNum);

		model.addAttribute("team", team);

		return "team/teamDetail";

	}

	

	@RequestMapping("/team/teamRequest.do/{tNum}")

	public String insertRequestApplyAndDetail(@PathVariable("tNum") String tNum, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		

		System.out.println("팀 신청 직전 TNUM!" + tNum);

		teamService.insertTeamRequestToApply(tNum, uNum);

		System.out.println("팀 신청 넣음!");

		
		teamService.deleteWishlist(tNum, uNum);
		System.out.println("팀 위시리스트 삭제!");

 

		Team team = teamService.selectTeam(tNum);

	

		Team applyLimitChecking = teamService.applyLimitCheck(tNum); //임시로 count를 t_limit에 넣음

		int counting = Integer.parseInt(applyLimitChecking.gettLimit());

		System.out.println("현재 인원 !" +  counting);

		

		if(counting == Integer.parseInt(team.gettLimit())) {

			System.out.println("팀 꽉 찼을때!");

			/*apply 삭제하고 멤버쉽에 옮기기 

			 * 

			 * apply를 멤버쉽에 옮기고 apply를 삭제

			 * 

			 * 

			 * */

			

			List<Team> applyList = teamService.applyList(tNum);

			for(int i = 0; i < counting; i++) {

				String tNumMemberShip = applyList.get(i).gettNum();				

				String uNumMemberShip = applyList.get(i).getMentor().getuNum();

				System.out.println("uNumMemberShip" + uNumMemberShip);

				teamService.insertMemberShip(tNumMemberShip, uNumMemberShip);

				teamService.deleteApply(tNumMemberShip, uNumMemberShip);

				

				User userPrice = teamService.mentorNameByMentorNum(uNumMemberShip);

				int pointA = Integer.parseInt(userPrice.getPoint());

				int pointB = pointA + 500;

				String pointC = String.valueOf(pointB);

				

				teamService.insertTeamCompleteMemberPoint(pointC, uNumMemberShip);

			}

			String mentorNum = team.getMentor().getuNum();

			User userPrice1 = teamService.mentorNameByMentorNum(mentorNum);

			int pointA1 = Integer.parseInt(userPrice1.getPoint());

			int pointB1 = pointA1 + 1000;

			String pointC1 = String.valueOf(pointB1);

			

			teamService.insertTeamCompleteLeaderPoint(pointC1, mentorNum);

			teamService.updateTeamRecruit(tNum);

			

		}

		

		

		

		Team requestApplyCheckList = teamService.applyCheckByTnumUnum(tNum, uNum); //apply 테이블 체크(신청, 탈퇴 구분)

		model.addAttribute("ApplyInclude", "true");

        if(requestApplyCheckList == null) {

        	model.addAttribute("ApplyInclude", "false");

        }

		

        Team requestMemberShipCheckList = teamService.memberShipCheckByTnumUnum(tNum, uNum); //멤버쉽 테이블 체크(신청, 탈퇴 구분)

        model.addAttribute("MemberShipInclude", "true");

        if(requestMemberShipCheckList == null) {

        	model.addAttribute("MemberShipInclude", "false");

        }

        

        Team requestMentorCheckList = teamService.mentorCheckByTnumUnum(tNum, uNum); //멘토 테이블 체크(신청, 탈퇴 구분, 삭제, 수정)

        model.addAttribute("MentorInclude", "true");

        if(requestMentorCheckList == null) {

        	model.addAttribute("MentorInclude", "false");

        }

        

        int teamFull = Integer.parseInt(team.getRecruit()); //모집완료 체크

        model.addAttribute("TeamFull", "true");

        if(teamFull == 0) {

        	model.addAttribute("TeamFull", "false");

        }

 

        

        

        

        

//		model.addAttribute("result", result);

		model.addAttribute("team", team);

		return "team/teamDetail";

 

		

	}

	

	@RequestMapping("/team/newTeam.do")

	public String newReview(HttpSession session, Model model) {

		List<Category> categoryList = categoryService.getCategoryList();
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
		
		
		model.addAttribute("categoryList", categoryList);

		model.addAttribute("uNum", uNum);//세션 대신

		return "team/teamRegister";

	}

 

	@RequestMapping(value = "/team/insertNewTeam.do", method = RequestMethod.POST)

	public String insertNewTeam(HttpSession session, TeamCommand teamCommand, Model model) {

		System.out.println("/team/insertNewTeam.do 시작");

	

		Category catTitlebyCatNum = categoryService.catTitleByCatNum(teamCommand.getCatNum());
		
		System.out.println("insertNewTeam의 직전 오류");
		User mentorNameByMentorNum = teamService.mentorNameByMentorNum(teamCommand.getuNum());

		System.out.println("insertNewTeam의 오류" + mentorNameByMentorNum.getuNum());
		String mentorNum = mentorNameByMentorNum.getuNum();

		Team team = new Team();

		Category category1 = new Category();

		User user1 = new User();

		category1.setCatTitle(catTitlebyCatNum.getCatTitle());

		category1.setCatNum(teamCommand.getCatNum());

		user1.setuNum(teamCommand.getuNum());

		user1.setName(mentorNameByMentorNum.getName());

		

		team.settName(teamCommand.gettName());

		team.setCategory(category1);

		team.settStart(teamCommand.gettStart());

		team.settEnd(teamCommand.gettEnd());

		team.settLimit(teamCommand.gettLimit());

		team.settTerm(teamCommand.gettTerm());

		team.setRecruit("0");

		team.settContent(teamCommand.gettContent());

		team.setPrice(teamCommand.getPrice());

		team.setMentor(user1);

		int result = teamService.insertTeam(team);

 

		int pointA = Integer.parseInt(mentorNameByMentorNum.getPoint());

		int pointB = pointA + 50;

		String pointC = String.valueOf(pointB);

		teamService.insertTeamRegisterPoint(pointC, mentorNum);

		

		

		System.out.println("삽입 후 tNUM은?? " + team.gettNum());

		

		

		model.addAttribute("result", result);

		model.addAttribute("team", team);

		return "team/teamDetail";

	}

	

	@RequestMapping(value = "/team/editTeam.do/{tNum}", method = RequestMethod.GET)
	public String editTeam(@PathVariable("tNum")String tNum, HttpSession session, Model model) {

		Team team = teamService.selectTeam(tNum);
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("team", team);

		model.addAttribute("categoryList", categoryList);

		model.addAttribute("uNum", uNum);//세션 대신

		return "team/teamRegister";

	}

	

	@RequestMapping("/team/insertEditTeam.do/{tNum}")
	public String insertEditTeam(@PathVariable("tNum")String tNum, 
				TeamCommand teamCommand, Model model) {
		
		
		System.out.println("setting team");
		

		Category catTitlebyCatNum = categoryService.catTitleByCatNum(teamCommand.getCatNum());

		User mentorNameByMentorNum = teamService.mentorNameByMentorNum(teamCommand.getuNum());
		

		Team team = new Team();

		Category category1 = new Category();

		User user1 = new User();

		category1.setCatTitle(catTitlebyCatNum.getCatTitle());

		category1.setCatNum(teamCommand.getCatNum());

		user1.setuNum(teamCommand.getuNum());

		user1.setName(mentorNameByMentorNum.getName());

		

		team.settNum(tNum);

		team.settName(teamCommand.gettName());

		team.setCategory(category1);

		team.settStart(teamCommand.gettStart());

		team.settEnd(teamCommand.gettEnd());

		team.settLimit(teamCommand.gettLimit());

		team.settTerm(teamCommand.gettTerm());

		team.setRecruit("0");

		team.settContent(teamCommand.gettContent());

		team.setPrice(teamCommand.getPrice());

		team.setMentor(user1);	

		
		System.out.println("controller.....");
		int result = teamService.updateTeam(team);

		model.addAttribute("result", result);

		model.addAttribute("team", team);

		return "team/teamDetail";

	}

	

	@RequestMapping("/team/deleteTeam.do/{tNum}")

	public String deleteTeam(@PathVariable("tNum") String tNum, HttpSession session, Model model) {

		

		/* 멤버쉽, apply, 활동기록, 스케줄 삭제 필요 */

		

		//apply 삭제

		List<Team> applyList = teamService.applyList(tNum);

		for(int i = 0; i < applyList.size(); i++) {

			String tNumMemberShip = applyList.get(i).gettNum();				

			String uNumMemberShip = applyList.get(i).getMentor().getuNum();

			teamService.deleteApply(tNumMemberShip, uNumMemberShip);

		}

		System.out.println("apply삭제 완료");

		//멤버쉽 삭제

		List<Team> memberShipList = teamService.memberShipList(tNum);

		for(int i = 0; i < memberShipList.size(); i++) {

			String tNumMemberShip = memberShipList.get(i).gettNum();				

			String uNumMemberShip = memberShipList.get(i).getMentor().getuNum();

			teamService.deleteMemberShip(tNumMemberShip, uNumMemberShip);

		}

		System.out.println("멤버쉽 삭제 완료");

		//활동기록 삭제

		List<Activity> activityList = teamService.activityList(tNum);

		for(int i = 0; i < activityList.size(); i++) {

			String tNumMemberShip = activityList.get(i).getTeam().gettNum();				

			String uNumMemberShip = activityList.get(i).getUser().getuNum();

			teamService.deleteActivity(tNumMemberShip, uNumMemberShip);

		}

		System.out.println("활동기록 삭제 완료");

		//스케줄 삭제

		List<Schedule> scheduleList = teamService.scheduleList(tNum);

		for(int i = 0; i < scheduleList.size(); i++) {

			String tNumMemberShip = scheduleList.get(i).getTeam().gettNum();				

			String uNumMemberShip = scheduleList.get(i).getMentor().getuNum();

			teamService.deleteSchedule(tNumMemberShip, uNumMemberShip);

		}

		System.out.println("스케줄 삭제 완료");

 

		

		

		

		

		Team team = teamService.selectTeam(tNum);

		String mentorNum = team.getMentor().getuNum();

		

//		User userPrice = teamService.mentorNameByMentorNum(mentorNum);
//
//		
//
//		int pointA = Integer.parseInt(userPrice.getPoint());
//
//		int pointB = pointA + 50;
//
//		String pointC = String.valueOf(pointB);

		

		

//		teamService.deleteTeamRegisterPoint(pointC, mentorNum);

		

//		System.out.println("포인트 차감 완료");

		

		

		teamService.deleteTeam(tNum);

		System.out.println("팀 삭제 완료");

		List<Team> teamList = teamService.selectListTeams();

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("teamList", teamList);

		model.addAttribute("categoryList", categoryList);

		return "team/teamList";

	}

	

	@RequestMapping("/team/leaveTeam.do/{tNum}")

	public String leaveMemberTeam(@PathVariable("tNum") String tNum, HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		String userSessionNum = user.getuNum(); //임시 유저 섹션

		teamService.leaveTeam(tNum, userSessionNum);

		System.out.println("팀 탈퇴 완료");

		List<Team> teamList = teamService.getTeamList();

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("teamList", teamList);

		model.addAttribute("categoryList", categoryList);

		return "team/teamList";

	}

 

	@RequestMapping("/team/searchByCondition")

	public String searchByCategory(@RequestParam("category") String category, Model model) {

		List<Team> teamList;

		if(!category.equals("Category")) {

			teamList = teamService.searchTeamByCategory(category);

			model.addAttribute("category", category);

		}

		else

			teamList = teamService.getTeamList();

	

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("categoryList", categoryList);

		model.addAttribute("teamList", teamList);

		return "team/teamList";

	}

 

}