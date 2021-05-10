package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.model.Category;
import com.example.model.Comment;
import com.example.model.Review;
import com.example.model.User;
import com.example.service.CategoryService;
import com.example.service.ReviewService;
import com.example.service.UserService;

@Controller
public class ReviewController implements ApplicationContextAware {
	
	private static final int countPerPage = 10;
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
	@Autowired
	private ReviewService reviewService;
	public void setReviewervice(ReviewService reveiwService) {
		this.reviewService = reveiwService;
	}
	
	@Autowired
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/review/reviewList.do")
	public String listReviews(HttpSession session, @RequestParam("page") String pageStr, Model model) {//리뷰 목록
		
		if(session.getAttribute("user") == null)
			return "user/login";

		int page = Integer.parseInt(pageStr);
		List<Review> totalReviewList = reviewService.getReviewList();
		int start = page;
		int countPage = countPerPage;
		List<Review> pagedReviewList = new ArrayList<Review>();
		
		for(Review r : totalReviewList) {
			if(start == 1) {
				pagedReviewList.add(r);
				countPage--;
				if(countPage == 0)
					break;
			}
			else {
				countPage--;
				if(countPage == 0) {
					countPage = countPerPage;
					start--;
				}	
			}
		}
		
		int totalPage = totalReviewList.size() / countPerPage;
		
		if(totalReviewList.size() % countPerPage > 0)
			totalPage++;
		
		List<Category> categoryList = categoryService.getCategoryList();
		List<Review> noticeList = reviewService.getReviewList();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("reviewList", pagedReviewList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		return "review/reviewList";
	}
	
	@RequestMapping("/review/reviewDetail.do/{r_num}")
	public String selectByReviewNo(@RequestParam("page") String page, @PathVariable("r_num") String r_num, Model model) {//리뷰 보기
		Review review = reviewService.selectReview(r_num);
		List<Comment> commentList = reviewService.getCommentsByrNum(r_num);
		model.addAttribute("review", review);
		model.addAttribute("page", page);
		model.addAttribute("commentList", commentList);
		System.out.println("Review controller ok");
		return "review/reviewDetail";
	}
	
	@RequestMapping("/review/insertNewComment.do/{rNum}")
	public String insertNewComment(HttpSession session, @PathVariable("rNum") String r_num, Comment comment, Model model) {
		
		comment.setcDate(Calendar.getInstance().getTime());
		comment.setrNum(r_num);
		reviewService.insertComment(comment);
		userService.addPoint(comment.getuNum(), 50);
		
		User user = (User) session.getAttribute("user");
		user.setPoint(user.getPoint()+50);
		
		session.setAttribute("user", user);
		
		List<Comment> commentList = reviewService.getCommentsByrNum(r_num);
		Review review = reviewService.selectReview(r_num);
		model.addAttribute("review", review);
		model.addAttribute("commentList", commentList);
		return "review/reviewDetail";
	}
	
	@RequestMapping("/review/deleteComment.do/{rNum}")
	public String deleteComment(@PathVariable("rNum") String rNum, @RequestParam("cNum") String cNum, Model model) {
		
		reviewService.deleteComment(cNum);

		List<Comment> commentList = reviewService.getCommentsByrNum(rNum);
		Review review = reviewService.selectReview(rNum);
		model.addAttribute("review", review);
		model.addAttribute("commentList", commentList);
		return "review/reviewDetail";
	}
	
	@RequestMapping("/review/newReview.do")
	public String newReview(Model model) {//리뷰 작성 화면으로 가기
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "review/reviewRegister";
	}
	
	@RequestMapping("/review/newNotice.do")
	public String newNotice(Model model) {//공지 작성 화면으로 가기
		return "review/noticeRegister";
	}
	
	@RequestMapping(value = "/review/insertNewReview.do", method = RequestMethod.POST)
	public String insertNewReview(HttpSession session, ReviewCommand reviewCommand, Model model) {//새로운 리뷰 등록
		reviewCommand.setrDate(Calendar.getInstance().getTime());
		MultipartFile image = reviewCommand.getImage();
		uploadFile(image);
		String uploadedPath = image.getOriginalFilename();
		Review review = new Review();
		review.setImage(uploadedPath);
		review.setTitle(reviewCommand.getTitle());
		review.setContent(reviewCommand.getContent());
		review.setWriteDate(reviewCommand.getrDate());
		review.setRate(reviewCommand.getRate());
		review.setItem(reviewCommand.getItem());
		User writer = new User();
		writer.setuNum(reviewCommand.getWriter());
		review.setWriter(writer);
		review.setKind(reviewCommand.getKind());
		Category myCategory = new Category();
		myCategory = categoryService.getCatTitleByCatNum(reviewCommand.getrCat());
		review.setCategory(myCategory);
		reviewService.insertReview(review);
		userService.addPoint(review.getWriter().getuNum(), 300);
		
		User user = (User) session.getAttribute("user");
		user.setPoint(user.getPoint()+300);
		
		session.setAttribute("user", user);

		model.addAttribute("review", review);
		model.addAttribute("noComment", "y");

		return "review/reviewDetail";
	}
	
	@RequestMapping(value = "/review/insertNewNotice.do", method = RequestMethod.POST)
	public String insertNewNotice(HttpSession session, ReviewCommand reviewCommand, Model model) {//새로운 리뷰 등록
		reviewCommand.setrDate(Calendar.getInstance().getTime());
		Review review = new Review();
		review.setImage("admin");
		review.setTitle(reviewCommand.getTitle());
		review.setContent(reviewCommand.getContent());
		review.setWriteDate(reviewCommand.getrDate());
		review.setRate("0");
		review.setItem("admin");
		User writer = new User();
		writer.setuNum("9");
		review.setWriter(writer);
		review.setKind("N");
		Category myCategory = new Category();
		myCategory.setCatTitle("admin");
		myCategory.setCatNum("1");
		review.setCategory(myCategory);
		reviewService.insertNotice(review);
		
		model.addAttribute("notice", review);
		model.addAttribute("noComment", "y");

		return "review/noticeDetail";
	}
	
	@RequestMapping(value = "/review/editReview.do/{r_num}")
	public String editReview(@PathVariable("r_num") String r_num, Model model) {//기존 리뷰 불러와서 폼에 뿌림
		Review review = reviewService.selectReview(r_num);
		List<Category> categoryList = categoryService.getCategoryList();
		
		model.addAttribute("review", review);
		model.addAttribute("categoryList", categoryList);
		return "review/reviewRegister";
	}
	
	@RequestMapping("/review/insertEditReview.do/{r_num}")
	public String insertEditReview(@PathVariable("r_num") String r_num, ReviewCommand reviewCommand, Model model) {//수정된 리뷰 다시 업로드
		Review review = new Review();
		MultipartFile image;
		String uploadedPath;
		if(reviewCommand.getImage() != null) {
			image = reviewCommand.getImage();
			uploadFile(image);
			uploadedPath = image.getOriginalFilename();
			review.setImage(uploadedPath);
		} else {
			review.setImage(reviewCommand.getImagePath());
		}
		review.setNum(r_num);
		review.setTitle(reviewCommand.getTitle());
		review.setContent(reviewCommand.getContent());
		review.setWriteDate(reviewCommand.getrDate());
		review.setRate(reviewCommand.getRate());
		review.setItem(reviewCommand.getItem());
		User writer = new User();
		writer.setuNum(reviewCommand.getWriter());
		review.setWriter(writer);
		review.setKind(reviewCommand.getKind());
		Category myCategory = new Category();
		myCategory = categoryService.getCatTitleByCatNum(reviewCommand.getrCat());
		review.setCategory(myCategory);
		reviewService.updateReview(review);
		model.addAttribute("review", review);
		model.addAttribute("noComment", "y");
		return "review/reviewDetail";
	}
	
	@RequestMapping("/review/deleteReview.do/{rNum}")
	public String deleteReview(@PathVariable("rNum") String rNum, Model model) {
		reviewService.deleteCommentByrNum(rNum);
		reviewService.deleteReview(rNum);
		List<Review> totalReviewList = reviewService.getReviewList();
		List<Category> categoryList = categoryService.getCategoryList();
		
		int page = 1;
		int start = page;
		int countPage = countPerPage;
		List<Review> pagedReviewList = new ArrayList<Review>();
		
		for(Review r : totalReviewList) {
			if(start == 1) {
				pagedReviewList.add(r);
				countPage--;
				if(countPage == 0)
					break;
			}
			else {
				countPage--;
				if(countPage == 0) {
					countPage = countPerPage;
					start--;
				}	
			}
		}
		
		int totalPage = totalReviewList.size() / countPerPage;
		
		if(totalReviewList.size() % countPerPage > 0)
			totalPage++;
		
		List<Review> noticeList = reviewService.getReviewList();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("reviewList", pagedReviewList);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("page", page);
		model.addAttribute("categoryList", categoryList);
		return "review/reviewList";
	}
	
	@RequestMapping("/review/searchByCondition")
	public String searchByCategory(@RequestParam("category") String category, @RequestParam("sort") String kind, Model model) {
		List<Review> reveiwList;
		if(!kind.equals("D") && !category.equals("Category")) {
			reveiwList = reviewService.searchReviewByCategory(kind, category);
			model.addAttribute("sort", kind);
			model.addAttribute("category", category);
		}
		else if(!kind.equals("D")) {
			reveiwList = reviewService.searchReviewByKind(kind);
			model.addAttribute("sort", kind);
		}
		else if(!category.equals("Category")) {
			reveiwList = reviewService.searchReviewByCategory(category);
			model.addAttribute("category", category);
		}
		else
			reveiwList = reviewService.getReviewList();
		List<Review> noticeList = reviewService.getReviewList();
		model.addAttribute("noticeList", noticeList);
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("reviewList", reveiwList);
		return "review/reviewList";
	}
	
	@RequestMapping("/review/searchByKeyword")
	public String searchByKeyword(@RequestParam("select") String select, @RequestParam("keyword") String keyword, Model model) {
		List<Review> reveiwList = reviewService.searchReviewByKeyword(select, keyword);
		List<Category> categoryList = categoryService.getCategoryList();
		List<Review> noticeList = reviewService.getReviewList();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("reviewList", reveiwList);
		return "review/reviewList";
	}
	
	@RequestMapping("/reveiw/searchReview.do/{userId}")
	public String searchByUserId(@PathVariable("u_num") String u_num, Model model) {
		List<Review> reveiwList = reviewService.searchReviewByUserId(u_num);
		List<Review> noticeList = reviewService.getReviewList();
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("reviewList", reveiwList);
		return "review/reviewList";
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
}
