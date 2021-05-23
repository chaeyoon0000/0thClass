package com.example.controller;

 

import java.util.List;

import javax.servlet.http.HttpSession;

import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

 

import org.springframework.beans.BeansException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.context.ApplicationContextAware;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.context.WebApplicationContext;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartHttpServletRequest;

 

import com.example.model.Activity;

import com.example.model.Category;

import com.example.model.Comment;

import com.example.model.Review;

import com.example.model.Schedule;

import com.example.model.Team;

import com.example.model.User;

import com.example.service.CategoryService;

import com.example.service.MiniHomeService;

import com.example.service.ReviewService;

import com.example.service.TeamService;

 

/*

 * 190615

 * 	달력 빈 부분 선택했을 때, 멘토라면 alert?으로 스케줄과 활동기록 선택. 수강생이면 활동기록으로 바로 넘어가도록?

 * 	

 * 	스케줄 리스트를 불러오려면 스트링형을 모델로 둬야함 그런데 db에 넣으려면 date형이 필요한데 커맨드에서 date형으로 바꿔봤자 스케줄모델에선 스트링이라  db에 넣는건 결국 스트링형임

 * 	db에서 삽입할때 to_char같은걸로  가능?

 *

 * 

 * 

 */

 

 

@Controller

public class MiniHomeController implements ApplicationContextAware {

	

	private WebApplicationContext context;	

	private String uploadDir;

	

	@Override					// life-cycle callback method

	public void setApplicationContext(ApplicationContext appContext)

		throws BeansException {

		this.context = (WebApplicationContext) appContext;

		this.uploadDir = context.getServletContext().getRealPath("/upload/");

	}

	

	@Autowired

	private MiniHomeService miniHomeService;

	public void setMiniHomeervice(MiniHomeService miniHomeService) {

		this.miniHomeService = miniHomeService;

	}

	

	@Autowired

	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {

		this.categoryService = categoryService;

	}

	

	@Autowired

	private TeamService teamService;

	public void setTeamService(TeamService teamService) {

		this.teamService = teamService;

	}

	

	

	

	@RequestMapping("/miniHome/miniHome.do/{tNum}")

	public String listActivitySchedules(

//			@ModelAttribute("teamSession") TeamSession teamSession, 
			HttpSession session,
			@PathVariable("tNum") String tNum,

				Model model){

		/* 후에 model 옆에 @PathVariable 섹션 추가 */

		
		User user = (User) session.getAttribute("user");
		String mentorSessionUnum = user.getuNum(); //임시 스케줄용 멘토섹션

		String teamSessionTnum = tNum;

//		String teamSessionTnum = teamSession.getTeam().gettNum();

		

		List<Schedule> scheduleList = miniHomeService.getScheduleList(mentorSessionUnum, teamSessionTnum);

		List<Category> categoryList = categoryService.getCategoryList();

		

		Team teamMentor = teamService.selectTeam(teamSessionTnum);

		

		

//		String scheduleTname = scheduleList.get(0).getTeam().gettName();

//		String scheduleMentorName = scheduleList.get(0).getMentor().getName();

		

		String scheduleTname = teamMentor.gettName();

		String scheduleMentorName = teamMentor.getMentor().getName();

	

		

		

		List<Activity> activityList = miniHomeService.getActivityList(teamSessionTnum);

//		Activity activityList1 = activityList.get(0);

		

		/* 임시 섹션  */

		User mentor = teamService.mentorNameByMentorNum(mentorSessionUnum);

		Team team = teamService.selectTeam(teamSessionTnum);

		model.addAttribute("mentor", mentor);

		model.addAttribute("team", team);

		

		model.addAttribute("scheduleTname", scheduleTname);

		model.addAttribute("scheduleMentorName", scheduleMentorName);

		

//		model.addAttribute("activityList1", activityList1);

		model.addAttribute("activityList", activityList);

		model.addAttribute("scheduleList", scheduleList);

		model.addAttribute("categoryList", categoryList);

		return "miniHome/miniHome";

	}

 

	

	@RequestMapping("/miniHome/scheduleDetail.do/{sNum}")

	public String selectByScheduleNo(@PathVariable("sNum") String sNum, 
			HttpSession session,
			Model model) {

		Schedule schedule = miniHomeService.selectSchedule(sNum);

		/* 멘토 섹션 검사 필요*/
		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();
 

		System.out.println("팀번호 불러오기 오류 " + schedule.getTeam().gettNum());

		Team team = teamService.selectTeam(schedule.getTeam().gettNum());

		model.addAttribute("team", team);

		

		

		

		model.addAttribute("schedule", schedule);

		return "miniHome/scheduleDetail";

	}

	/* 임시  */

	@RequestMapping("/miniHome/activityDetail.do/{aNum}")

	public String selectByActivityNo(@PathVariable("aNum") String aNum, 
			HttpSession session,
						Model model) {
		User user = (User) session.getAttribute("user");
		String userSessionUnum = user.getuNum(); //임시 섹션

		Activity activity = miniHomeService.selectActivity(aNum);

		String teamSessionTnum = activity.getTeam().gettNum();

		

		Activity deleteWriterCheckList = miniHomeService.WriterCheckByAnumUnum(aNum, userSessionUnum); //멘토 테이블 체크(신청, 탈퇴 구분, 삭제, 수정)

        model.addAttribute("WriterInclude", "true");

        if(deleteWriterCheckList == null) {

        	model.addAttribute("WriterInclude", "false");

        }

		

//		List<Schedule> scheduleList = miniHomeService.getScheduleList(mentorSessionUnum, teamSessionTnum);

//		List<Category> categoryList = categoryService.getCategoryList();

//		model.addAttribute("scheduleList", scheduleList);

//		model.addAttribute("categoryList", categoryList);

        model.addAttribute("teamSessionTnum", teamSessionTnum);

        model.addAttribute("activity", activity);

		return "miniHome/activityDetail";

	}

	

	

	

	@RequestMapping("/miniHome/newActivitySchedule.do/{tNum}")

	public String newActivitySchedule(
			HttpSession session,
			@PathVariable("tNum") String tNum,

//			@ModelAttribute("teamSession") TeamSession teamSession, 

			Model model) {

		User user = (User) session.getAttribute("user");
		
		String mentorSessionUnum = user.getuNum();//임시 스케줄용 멘토섹션

		String teamSessionTnum = tNum;

		

		/* 임시 섹션  */

		User mentor = teamService.mentorNameByMentorNum(mentorSessionUnum);

		

		System.out.println("팀번호 불러오기 오류 ~~~" + teamSessionTnum);

		Team team = teamService.selectTeam(teamSessionTnum);

		model.addAttribute("mentor", mentor);

		model.addAttribute("team", team);

 

		

		List<Schedule> scheduleList = miniHomeService.getScheduleList(mentorSessionUnum, teamSessionTnum);

		List<Category> categoryList = categoryService.getCategoryList();

		model.addAttribute("scheduleList", scheduleList);

		model.addAttribute("categoryList", categoryList);

		return "miniHome/miniHomeRegister";

	}

	@RequestMapping(value = "/miniHome/insertNewActivitySchedule.do/{tNum}", method = RequestMethod.POST)

	public String insertNewActivitySchedule(@PathVariable("tNum") String tNum,
			HttpSession session,
//			@ModelAttribute("teamSession") TeamSession teamSession, 

					ScheduleCommand scheduleCommand, Model model) {

//		String mentorSessionUnum = "909"; //임시 스케줄용 멘토섹션

//		String teamSessionTnum = "410";

		User user = (User) session.getAttribute("user");
		String uNum = user.getuNum();

		User mentorNameByMentorNum = teamService.mentorNameByMentorNum(scheduleCommand.getuNum());

		Team teamNameByTnum = teamService.selectTeam(tNum);

		

 

		Schedule schedule = new Schedule();

		User user1 = new User();

		Team team1 = new Team();

		

		user1.setuNum(scheduleCommand.getuNum());

		user1.setName(mentorNameByMentorNum.getName());

		

		team1.settNum(scheduleCommand.gettNum());

		team1.settName(teamNameByTnum.gettName());

		

		schedule.setTitle(scheduleCommand.getTitle());

		

		 // Date 타입 컬럼 --> java.sql.Date --> java.util.Date --> String

 

		

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		String dateTime = dateFormat.format(scheduleCommand.getSchDate());

		System.out.println("db넣기 전 시간 "+ dateTime);

 

//		scheduleCommand.getSchDate()

		

//		schedule.setSchDate(scheduleCommand.getSchDate());

		schedule.setSchDate(dateTime);

		schedule.setSchAddr(scheduleCommand.getSchAddr());

		schedule.setSchContent(scheduleCommand.getSchContent());

		schedule.setMentor(user1);

		schedule.setTeam(team1);

		

		int result = miniHomeService.insertSchedule(schedule);

		

		model.addAttribute("result", result);

		model.addAttribute("schedule", schedule);

		

		

		return "miniHome/scheduleDetail";

	}

	private void uploadFile(MultipartFile filePath) {

		System.out.println("업로드 한 파일: "

				+ filePath.getOriginalFilename());

		File file = new File(this.uploadDir + filePath.getOriginalFilename());

		try {

			filePath.transferTo(file);

		} catch (IllegalStateException | IOException e) {

			e.printStackTrace();

		}

	}

	

	

	@RequestMapping(value = "/miniHome/insertNewActivity.do/{tNum}", method = RequestMethod.POST)

	public String insertNewActivity(@PathVariable("tNum") String tNum,
			HttpSession session,
			ActivityCommand activityCommand, Model model) {

//		String mentorSessionUnum = "909"; //임시 스케줄용 멘토섹션

//		String teamSessionTnum = "410";

 

		User mentorNameByMentorNum = teamService.mentorNameByMentorNum(activityCommand.getuNum());

		Team teamNameByTnum = teamService.selectTeam(tNum);

		

//		private String title;

//		private String aContent;

//		private String image;

//		private String actAddress;

//		private Date actDate;

//		private String uNum;

//		private String tNum;

//		

		Activity activity = new Activity();

		User user1 = new User();

		Team team1 = new Team();

		

		user1.setuNum(activityCommand.getuNum());

		user1.setName(mentorNameByMentorNum.getName());

		

		team1.settNum(activityCommand.gettNum());

		team1.settName(teamNameByTnum.gettName());

		

		activity.setTitle(activityCommand.getTitle());

		activity.setaContent(activityCommand.getaContent());

		

		System.out.println("이미지 삽입???"+activityCommand.getImage()); 

		MultipartFile image = activityCommand.getImage(); 

		System.out.println(image.getOriginalFilename());

		uploadFile(image);

		String uploadedPath = image.getOriginalFilename();

		activity.setImage(uploadedPath);

 

		System.out.println("주소값"+activityCommand.getActAddress()); 

		activity.setActAddress(activityCommand.getActAddress());

		

		 // Date 타입 컬럼 --> java.sql.Date --> java.util.Date --> String

 

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		String dateTime = dateFormat.format(activityCommand.getActDate());

		System.out.println("db넣기 전 시간 "+ dateTime);

		

		activity.setActDate(dateTime);

		

		activity.setUser(user1);

		activity.setTeam(team1);

		

		int result = miniHomeService.insertActivity(activity);

		

		model.addAttribute("result", result);

		model.addAttribute("activity", activity);

		

		

		return "miniHome/activityDetail";

	}

	@RequestMapping("/miniHome/deleteActivity.do/{aNum}")

	public String deleteTeam(@PathVariable("aNum") String aNum, HttpSession session, Model model) {

		
		User user = (User) session.getAttribute("user");
		String mentorSessionUnum = user.getuNum(); //임시 스케줄용 멘토섹션

		

		Activity activity = miniHomeService.selectActivity(aNum);

		String teamSessionTnum = activity.getTeam().gettNum();

//		String teamSessionTnum = teamSession.getTeam().gettNum();

		

		miniHomeService.deleteActivity(aNum);

		

		

		

		List<Schedule> scheduleList = miniHomeService.getScheduleList(mentorSessionUnum, teamSessionTnum);

		List<Category> categoryList = categoryService.getCategoryList();

		

		String scheduleTname = scheduleList.get(0).getTeam().gettName();

		String scheduleMentorName = scheduleList.get(0).getMentor().getName();

		

		System.out.println("모임 네임" + scheduleList.get(0).getTitle());

		System.out.println("리스트 날짜 형식" + scheduleList.get(0).getSchDate());

		
		//System.out.println("activityList size = " + activityList.size());
		List<Activity> activityList = miniHomeService.getActivityList(teamSessionTnum);
		System.out.println("activityList size = " + activityList.size());
		
		//System.out.println("활동기록 사진???" + activityList.get(0).getImage());

		

		//Activity activityList1 = activityList.get(0);

		

		/* 임시 섹션  */

		User mentor = teamService.mentorNameByMentorNum(mentorSessionUnum);

		Team team = teamService.selectTeam(teamSessionTnum);

		model.addAttribute("mentor", mentor);

		model.addAttribute("team", team);

		

		model.addAttribute("scheduleTname", scheduleTname);

		model.addAttribute("scheduleMentorName", scheduleMentorName);

		

		//model.addAttribute("activityList1", activityList1);

		model.addAttribute("activityList", activityList);

		model.addAttribute("scheduleList", scheduleList);

		model.addAttribute("categoryList", categoryList);

		return "miniHome/miniHome";

	}

	

 

}