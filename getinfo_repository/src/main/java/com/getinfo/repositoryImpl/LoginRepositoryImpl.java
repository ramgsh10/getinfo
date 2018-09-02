package com.getinfo.repositoryImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.getinfo.model.SignUpModel;
import com.getinfo.repository.LoginRepository;

@Repository
public class LoginRepositoryImpl implements LoginRepository 
{
	@Autowired
	SessionFactory sf;
	@Override
	public int signUp(SignUpModel signUpData) {
		sf.getCurrentSession().saveOrUpdate(signUpData);
		return (int)signUpData.getUserId();
	}

}
