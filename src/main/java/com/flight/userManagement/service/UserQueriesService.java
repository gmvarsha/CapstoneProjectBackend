package com.flight.userManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.userManagement.DTO.QueryRequest;
import com.flight.userManagement.model.UserQuery;
import com.flight.userManagement.repository.UserQueryRepository;

@Service
public class UserQueriesService {

	@Autowired
	private UserQueryRepository userQueryRepository;

	public String saveQuery(QueryRequest queryRequest) throws Exception {
		UserQuery query = new UserQuery();
		query.setUserQueries(queryRequest.getQuery());
		query.setUserId(queryRequest.getUserId());
		query.setCreatedAt(LocalDateTime.now());
		try {
			userQueryRepository.save(query);
		} catch (Exception e) {
			throw new Exception("Save Query Failed", e);
		}
		return "Query sent successfully! You Will get response within 24hrs";
	}

	public List<Map<String, Object>> getAllQueries() {
		return userQueryRepository.getAllQueries();
	}

	public List<Map<String, Object>> getQueriesByUserId(Long userId) {
		List<Map<String, Object>> userQueries = userQueryRepository.getQueriesByUserId(userId);
		if (!userQueries.isEmpty()) {
			return userQueries;
		} else {
			return null;
		}
	}
}
