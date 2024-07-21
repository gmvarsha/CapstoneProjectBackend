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
            "JOIN users u ON uq.user_id = u.id LEFT JOIN\r\n"
            + "    reply r ON uq.user_query_id = r.user_query_id\r\n"
            + "WHERE\r\n"
            + "    r.user_query_id IS NULL order by uq.user_query_id desc", nativeQuery = true)
List<Map<String, Object>> getAllQueries();

@Query(value="SELECT uq.user_query_id as userQueryId, uq.user_id as userId,uq.user_queries as userQueries,r.admin_reply as adminReply FROM user_query uq LEFT JOIN reply r ON uq.user_query_id= r.user_query_id WHERE uq.user_id=:userId order by uq.user_query_id desc",nativeQuery=true)
List<Map<String, Object>> getQueriesByUserId(Long userId);

}

