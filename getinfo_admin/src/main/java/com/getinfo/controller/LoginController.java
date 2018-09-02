package com.getinfo.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.getinfo.model.SignInModel;
import com.getinfo.model.SignUpModel;
import com.getinfo.service.LoginService;
import com.getinfo.util.ImageUploadUtils;

@Controller
public class LoginController 
{
	@Autowired
	LoginService loginService;
	
	@RequestMapping("welcome")
	public String welcome(ModelMap model)
	{
		model.addAttribute("loginData", new SignInModel());
		model.addAttribute("signUpData", new SignUpModel());
		return "home";
	}
	
	@RequestMapping(value="signIn",method=RequestMethod.POST)
	public String signIn(@ModelAttribute SignInModel loginData,BindingResult binding)
	{
		return "userhome";
	}
	
	@RequestMapping(value="signUp",method=RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("signup") SignUpModel signUpData,BindingResult binding,@RequestParam MultipartFile file,HttpServletRequest re)
	{
		HttpSession s=re.getSession();
		String convertimage=ImageUploadUtils.getImage(file);
		signUpData.setFile(convertimage);
		int result=loginService.signUp(signUpData);
		ModelAndView mav=new ModelAndView("userhome");
		
		byte[] encodeBase64=Base64.getEncoder().encode(signUpData.getFile().getBytes());
		String base64Encoded = new String(encodeBase64);
		
		s.setAttribute("pic",base64Encoded );
		
		System.out.println("................................................................"+result);
		return mav;
	}
	
	@RequestMapping(value="viewdetail")
	public ModelAndView viewDetail(ModelAndView model)
	{
		return model;
	}

}
