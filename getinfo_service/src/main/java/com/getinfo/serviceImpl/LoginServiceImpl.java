package com.getinfo.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getinfo.model.SignUpModel;
import com.getinfo.repository.LoginRepository;
import com.getinfo.service.LoginService;

@Service
@Transactional()
public class LoginServiceImpl implements LoginService 
{
	@Autowired
	LoginRepository loginRepository;

	@Override
	public int signUp(SignUpModel signUpData) 
	{
		return loginRepository.signUp(signUpData);
	}

}
