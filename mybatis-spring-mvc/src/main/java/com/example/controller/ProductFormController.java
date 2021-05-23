package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.example.model.Product;
import com.example.model.Review;
import com.example.model.User;
import com.example.controller.ProductForm;
import com.example.model.Category;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import com.example.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("product")
//@SessionAttributes("Category")
//@RequestMapping({"/product/newProduct.do","/product/editProduct.do/{pNum}"})
@RequestMapping({"/product/newProduct.do"})
public class ProductFormController implements ApplicationContextAware {
	
	
	private WebApplicationContext context;	
	private String uploadDir;
	private String imgDir;
	
	@Value("product/productRegister")
	private String formViewName;
	@Value("product/productDetail")
	private String successViewName;
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/productfile/");
		this.imgDir = context.getServletContext().getRealPath("/upload/");
	}
	
	//private static final String[] LANGUAGES = {"english", "japanese"};
	
	@Autowired
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
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
	
//	@Autowired
//	private AccountFormValidator validator;
//	public void setValidator(AccountFormValidator validator) {
//		this.validator = validator;
//	}
		
//	@ModelAttribute("categoryNames")
//	public List<String> referenceSearchCategoryList() {
//		List<String> categoryList = categoryService.getCategoryNameList();
//		return categoryList;
//	}
	
	@ModelAttribute("categories")
	public List<Category> referenceSearchCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		return categoryList;
	}
	
	@ModelAttribute("checkConditionList")
	public String[] referenceSearchMenuList() {
		return new String[] { "판매중", "판매중지" };
	}
	
	
	//@RequestMapping("/product/newProduct.do")
	@ModelAttribute("productForm")
	public ProductForm formBackingObject(HttpServletRequest request//,
			//@RequestParam("pNum") String pNum) 
			)throws Exception {		
//		if (pNum != null) {	// edit an existing account
//			return new ProductForm(productService.getProduct(pNum));
//		}
//		else
		{	// create a new account
			System.out.println("accessor method");
			return new ProductForm();
		}
	}
	
//	//@RequestMapping("/product/editProduct.do/{pNum}")
//	@ModelAttribute("productForm")
//	public ProductForm formBackingObject2(HttpServletRequest request,
//			@PathVariable("pNum") String pNum) 
//			throws Exception {		
//		//if (pNum != null) {	// edit an existing account
//			return new ProductForm(productService.getProduct(pNum));
////		}
////		else
////		{	// create a new account
////			return new ProductForm();
////		}
//	}
	
	@RequestMapping(method = RequestMethod.GET) // form 보여주기
	public String showProductForm(HttpSession session, Model model) {
		User seller = (User) session.getAttribute("user");
		
		model.addAttribute("seller", seller.getuNum());
		return "product/productRegister";
	}
	
//	@RequestMapping(value="/product/editProduct.do/{pNum}", method = RequestMethod.GET) // form 보여주기
//	public String showExistingProductForm(HttpServletRequest request, @PathVariable("pNum") String pNum, Model model) {
//		System.out.println("editProduct.do");
//		System.out.println("get일 때");
//		model.addAttribute("productForm", productService.getProduct(pNum));
//	//	model.addAttribute("seller", "609");//세션 대신
//		return formViewName;
//	}
	
	@RequestMapping(method = RequestMethod.POST) // form 제출하고 나서 신청인지 수정인지
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("productForm") ProductForm productForm,
			BindingResult result, Model model, SessionStatus status) throws Exception {
		
			Product product = productForm.getProduct();
			if (productForm.isNewProduct()) {
				User seller = (User) session.getAttribute("user");
				System.out.println("새 product일 때");
				userService.addPoint(seller.getuNum(), 500);
				seller.setPoint(seller.getPoint()+500);
				
				session.setAttribute("user", seller);
				
				
				MultipartFile image = productForm.getImage();
				uploadimg(image);
				String uploadedPath = image.getOriginalFilename();
				product.setImage(uploadedPath);
				System.out.println("첫번째 이미지 처리");
				
				MultipartFile filePath = productForm.getFilePath();
				uploadFile(filePath);
				String uploadedPath2 = filePath.getOriginalFilename();
				product.setFilePath(uploadedPath2);
				System.out.println("두번째 파일 처리");
				
				System.out.println(product.getCate().getCatNum());
				String catTitle = categoryService.selectCategoryByPrimaryKey(product.getCate().getCatNum());
				System.out.println(catTitle);
				
				Category category = new Category();
				category.setCatNum(product.getCate().getCatNum());
				category.setCatTitle(catTitle);
				product.setCate(category);
				
				System.out.println(product.getCate().getCatNum());
				System.out.println(product.getCate().getCatTitle());
				
				
				product.setSeller(seller);
				
				productService.insertProduct(product);
				model.addAttribute("product", product);
				
				System.out.println("insert문 실행");
				System.out.println("pNum=" + product.getpNum());
			}
//			else {
//				int rslt = productService.updateProduct(product);
//			}
		//}
		//catch (DataIntegrityViolationException ex) {
		//	result.rejectValue("account.username", "USER_ID_ALREADY_EXISTS",
		//			"User ID already exists: choose a different ID.");
		//	return formViewName; 
		//}
		
//		UserSession userSession = new UserSession(
//			petStore.getAccount(accountForm.getAccount().getUsername()));
//		PagedListHolder<Product> myList = new PagedListHolder<Product>(
//			petStore.getProductListByCategory(accountForm.getAccount().getFavouriteCategoryId()));
//		myList.setPageSize(4);
//		userSession.setMyList(myList);
//		session.setAttribute("userSession", userSession);
	//	model.addAttribute("productForm", product);
		status.setComplete();
		return successViewName;  
	}
	
	/*@RequestMapping("/product/searchProduct.do")
	public String searchProduct(HttpServletRequest request,
			@RequestParam("category") String category,
			@RequestParam(value="keyword", required=false) String keyword,
			//@RequestParam(value="page", required=false) String page, 
			Model model) throws Exception {
		System.out.println("ProductFormController에... searchProduct()");
		if (keyword != null) { System.out.println("ProductFormController에... searchProduct()   keyword!= null");
			if (!StringUtils.hasLength(keyword)) { System.out.println("ProductFormController에... searchProduct() keyword != null, haslength");
				model.addAttribute("error", "Please enter a keyword to search for, then press the search button.");
				return "product/productList";
				//return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
			}
			PagedListHolder<Product> productList;
			
			if(!category.equals("Category")) { System.out.println("ProductFormController에... searchProduct() category.equals(\"Category\") != false");
				productList = new PagedListHolder<Product>(productService.searchProductListByCatAndKey(category, keyword));
				model.addAttribute("category", category);
			}
			else { System.out.println("ProductFormController에... searchProduct() category.equals(\"Category\") == false");
				productList = new PagedListHolder<Product>(productService.searchProductListByKeyword(keyword));
			}
			System.out.println("ProductFormController에... productList추가");
			productList.setPageSize(9);
			model.addAttribute("productList", productList.getPageList());
			
			//request.getSession().setAttribute("SearchProductController_productList", productList);
		}
//		else {
//			@SuppressWarnings("unchecked")
//			PagedListHolder<Product> productList = (PagedListHolder<Product>)request.getSession().getAttribute("SearchProductController_productList");
//			if (productList == null) {
//				model.addAttribute("error", "Your session has timed out. Please start over again.");
//				return "product/productList";
//				//return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
//			}
//			if ("next".equals(page)) {
//				productList.nextPage();
//			}
//			else if ("previous".equals(page)) {
//				productList.previousPage();
//			}
//		}
		return "product/productList";
	}
	
	@RequestMapping("/product/searchProductBySaleCondition.do")
	public String searchBySaleCondition(@RequestParam("prop") String prop, Model model) {
		List<Product> productList = productService.searchProductBySaleCondition(prop);
		model.addAttribute("productList", productList);
		return "product/productList";
	}*/
	
	private void uploadimg(MultipartFile filePath) {
		System.out.println("업로드 한 파일: "
				+ filePath.getOriginalFilename());
		File file = new File(this.imgDir + filePath.getOriginalFilename());
		try {
			filePath.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
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