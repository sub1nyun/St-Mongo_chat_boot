package com.cos.chatapp;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "chat") //Table과 유사함
public class Chat {

	// 몽고 DB가 기본적으로 id를 만들어주긴 하는데 Bson 타입이라 String으로 하는것이 편함
	@Id
	private String id; 
	private String msg;
	private String sender; // 보내는 사람
	private String receiver; // 받는 사람 -> 귓속말 
	private Integer roomNum; //(채팅) 방 번호 -> 같은 방에 있다면 같은 메세지를 볼 수  있도록
	
	private LocalDateTime createdAt;
	
	
	
}
