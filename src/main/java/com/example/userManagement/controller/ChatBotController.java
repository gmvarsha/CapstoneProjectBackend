package com.example.userManagement.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatBotController {
	
    @PostMapping("/chatbot")
    public ChatResponse handleChat(@RequestBody ChatRequest request) {
        // Process the user's message and generate a response
        String userMessage = sanitizeMessage(request.getMessage());
        String botResponse = generateResponse(userMessage);

        return new ChatResponse(botResponse);
    }

    private String sanitizeMessage(String message) {
        // Example of sanitizing input to prevent injection attacks
        return message.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    private String generateResponse(String message) {
        // Enhanced response generation
        message = message.toLowerCase();

        if (message.contains("log in") || message.contains("log out") || message.contains("register")) {
            return "To log in, use the login Button. To log out, click on the Menu icon and select 'Log Out.' To register, Click on Sign Up and go to the registration page and fill out the form.";
        } else if (message.contains("view flights") || message.contains("source") || message.contains("destination")) {
            return "You can view flights by entering your source and destination in the search bar.";
        } else if (message.contains("filter flights") || message.contains("price range") || message.contains("departure time") || message.contains("arrival time") || message.contains("number of stops") || message.contains("flight type")) {
            return "Use the filters on the search results page to narrow down flights by price range, departure/arrival time, number of stops, and flight type.";
        } else if (message.contains("book tickets") || message.contains("select seats") || message.contains("view bookings")) {
            return "To book tickets, select a flight and choose your seats from the seating map. and you can view booking details in the my bookings tab.";
        } else if (message.contains("sort flights") || message.contains("price")) {
            return "You can sort flights by price from lowest to highest or highest to lowest on the search results page.";
        } else if (message.contains("send query") || message.contains("contact admin")) {
            return "Submit your queries through the 'help' section, and the admin will respond to you with in 24hrs.";
        } else if (message.contains("web check-in") || message.contains("check in")) {
            return "Perform web check-in by clicking on check-in option under menu. Once web check-in is complete, you will receive a confirmation message with your booking details and seat assignment.";
        } else if (message.contains("view user queries") || message.contains("manage queries")) {
            return "Admins can view and respond to user queries in the admin panel.";
        } else if (message.contains("view passenger details") || message.contains("checked-in passengers") || message.contains("pending check-in")) {
            return "Admins can view passenger details, including checked-in and pending passengers, in the check-in panel.";
        } else if (message.contains("booking status") || message.contains("assign seats")) {
            return "Admins can confirm booking statuses and assign seats if not already done through web check-in in the admin panel.";
        } else {
            return "I'm not sure how to assist with that. Can you provide more details or clarify your request?";
        }
    }
}

	class ChatRequest {
	    private String message;

	    // Getters and Setters
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }
	}

	class ChatResponse {
	    private String reply;

	    public ChatResponse(String reply) {
	        this.reply = reply;
	    }

	    // Getter
	    public String getReply() {
	        return reply;
	    }
	}


