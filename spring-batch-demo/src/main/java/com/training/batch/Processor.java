package com.training.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.training.model.User;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class Processor implements ItemProcessor<User, User> {
	
	
    private static final Map<String, String> DEPT_NAMES =
            new HashMap<>();

    public Processor() {
        DEPT_NAMES.put("001", "Technology");
        DEPT_NAMES.put("002", "Operations");
        DEPT_NAMES.put("003", "Accounts");
    }

    @Override
    public User process(User user) throws Exception { //1	Peter	001	12000

    	log.info("Processing.....");
    	 String deptCode = user.getDept();
    	 log.info(deptCode);
        String dept = DEPT_NAMES.get(deptCode);
        user.setName(user.getName().toUpperCase());
        user.setDept(dept);
        user.setTime(LocalDateTime.now());
        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
        return user;
    }
}
