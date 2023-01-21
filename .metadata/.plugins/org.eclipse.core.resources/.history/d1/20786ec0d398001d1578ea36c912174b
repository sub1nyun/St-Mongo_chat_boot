package com.cos.chatapp;

import java.time.LocalDateTime;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor // 생성자
@RestController // 데이터 리턴을 위한 서버
public class ChatController {
	
	private final ChatRepository chatRepository;
	
	//TEXT_EVENT_STREAM_VALUE -> SSE 프로토콜
	// -> 데이터가 새로 생길때마다 지속적으로 보내줌(응답 유지)
	@GetMapping(value = "/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Chat> getMsg(@PathVariable String sender, @PathVariable String receiver) {
		return chatRepository.mFindBySender(sender, receiver)
				.subscribeOn(Schedulers.boundedElastic());
	}
	
	//데이터를 넣어주는 요청
	@PostMapping("/chat") //Mono -> 데이터를 한 번만 리턴 
	// 타입을 void로 해도 되지만 결과 데이터를 보기 위해서 Mono로 했음
	public Mono<Chat> setMsg(@RequestBody Chat chat) { 
		chat.setCreatedAt(LocalDateTime.now());
		return chatRepository.save(chat);
	}
}
