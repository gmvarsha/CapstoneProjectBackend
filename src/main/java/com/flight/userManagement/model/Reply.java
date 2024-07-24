package com.flight.userManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private Long replyId;
    
    @Column(name="admin_reply",nullable = false)
    private String adminReply;

    @Column(name="user_query_id")
    private Long userQueryId;
    
    @Column(name="user_id")
    private Long userId;

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public String getAdminReply() {
		return adminReply;
	}

	public void setAdminReply(String adminReply) {
		this.adminReply = adminReply;
	}

	public Long getUserQueryId() {
		return userQueryId;
	}

	public void setUserQueryId(Long userQueryId) {
		this.userQueryId = userQueryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
   
}
