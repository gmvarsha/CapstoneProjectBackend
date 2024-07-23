package com.example.userManagement.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.userManagement.DTO.QueryRequest;
import com.example.userManagement.service.UserQueriesService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserQueriesController {

    @Autowired
    private UserQueriesService userQueriesAndWebCheckinService;

    @PostMapping("/query")
    public ResponseEntity<String> sendQuery(@RequestBody QueryRequest queryRequest) throws Exception {
    	String message=userQueriesAndWebCheckinService.saveQuery(queryRequest);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/getAllQueries")
    public  ResponseEntity<List<Map<String, Object>>> getQueries() {
    	List<Map<String,Object>> queries = userQueriesAndWebCheckinService.getAllQueries();
        return ResponseEntity.ok(queries);
    }
    
    @GetMapping("/queries/{userId}")
    public List<Map<String, Object>> getQueriesByUserId(@PathVariable Long userId) {
        return userQueriesAndWebCheckinService.getQueriesByUserId(userId);
    }
}
