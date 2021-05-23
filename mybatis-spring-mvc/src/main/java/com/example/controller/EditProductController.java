package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;

@Controller
@RequestMapping({"/product/editProduct.do/{pNum}"})
public class EditProductController implements ApplicationContextAware {
	
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Value("product/productRegister")
	private String formViewName;
	@Value("product/productDetail")
	private String successViewName;
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
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
	
	@ModelAttribute("categories")
	public List<Category> referenceSearchCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		return categoryList;
	}
	
	@ModelAttribute("checkConditionList")
	public String[] referenceSearchMenuList() {
		return new String[] { "판매중", "판매중지" };
	}
	
	@ModelAttribute("productForm")
	public ProductForm formBackingObject(@PathVariable("pNum") String pNum) throws Exception {		
//		if (pNum != null) {	// edit an existing account
		System.out.println("accessor method");
		return new ProductForm(productService.getProduct(pNum));
//		}
//		else
//		{	// create a new account
			
//			return new ProductForm();
//		}
	}
	
//	@RequestMapping(value="/product/editProduct.do/{pNum}", method = RequestMethod.GET) // form 보여주기
	@RequestMapping(method = RequestMethod.GET) // form 보여주기
	public String showExistingProductForm(HttpServletRequest request, @PathVariable("pNum") String pNum, Model model) {
		System.out.println("editProduct.do");
		System.out.println("get일 때");
		
//		Product product = productService.getProduct(pNum);
//		ProductForm productForm = new ProductForm(product);
//		model.addAttribute("productForm", productService.getProduct(pNum));
	//	model.addAttribute("seller", "609");//세션 대신
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST) // form 제출하고 나서 신청인지 수정인지
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@RequestParam("image_old") String image_old,
			@ModelAttribute("productForm") ProductForm productForm,
			BindingResult result, Model model, SessionStatus status) throws Exception {
		
//		validator.validate(productForm, result);
		System.out.println("에러 검증 전");
		//if (result.hasErrors()) return formViewName;
		System.out.println("에러 없음");
		
		MultipartFile image = productForm.getImage(); System.out.println(image.getOriginalFilename());
		String uploadedPath = image.getOriginalFilename();
		
		Product product = productForm.getProduct();
		System.out.println(image_old);
		if(!image_old.equals(uploadedPath)) {
			uploadFile(image);
			product.setImage(uploadedPath);
			System.out.println("첫번째 이미지 처리");
		}
		System.out.println(product.getImage());
		int rslt = productService.updateProduct(product);
		model.addAttribute("product", product);
		
		status.setComplete();
		return successViewName;  
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
