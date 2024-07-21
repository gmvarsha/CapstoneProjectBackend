package com.example.userManagement.repository;

import com.example.userManagement.model.User;
import com.example.userManagement.model.UserQuery;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {

	@Query(value = "SELECT uq.user_query_id AS userQueryId, u.id as userId,uq.user_queries as userQueries, u.first_name as firstName,u.last_name as lastName, u.email AS email " +
            "FROM user_query uq " +
            "JOIN users u ON uq.user_id = u.id", nativeQuery = true)
List<Map<String, Object>> getAllQueries();

}

