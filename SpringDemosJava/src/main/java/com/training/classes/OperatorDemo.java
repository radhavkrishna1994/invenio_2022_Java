package com.training.classes;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.interfaces.Operator;

public class OperatorDemo {
	
	@Autowired
	private Operator operator;

	public int getResult(int x, int y)
	{
		return operator.operate(x, y);
	}

}
