package com.kh.forest.chat.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/broadcasting")
public class Chatting {
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	private static Map<String, Session> chatting = new HashMap<String, Session>(); 
	
	private String chatUser = null;
	
	@OnOpen
	public void onOpen(Session session) throws IOException{			
				
		String chatUser = session.getQueryString();
		//현재 채팅에 합류한 사람의 세션을 담아둔다
		chatting.put(chatUser, session);
		
		clients.add(session);				
		//sendNotice(chatUser + "님이 입장하셨습니다. 현재 사용자 " + clients.size() + "명");
		//System.out.println("채팅 참여자 : " + chatting.get(chatUser));
	}
	
	@OnMessage
	public void onMsg(String message, Session session) throws IOException{
			
		String[] chatVal = message.split("[$]");
		//System.out.println("sender : " + chatVal[0]);
		//System.out.println("message : " + chatVal[1]);
		//System.out.println("toUser :" + chatVal[2]);
		
		synchronized(clients) {
			for(Session client : clients) {
				System.out.println(client);
				if(!client.equals(session)){
					chatUser = session.getQueryString();
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	public void sendNotice(String message) throws IOException{
		String userName = "server";			
		//System.out.println(userName + " : " + message);
		
		synchronized(clients) {
			for(Session client : clients) {
				client.getBasicRemote().sendText(userName + " : " + message);
			}
		}
		
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		
		chatUser = session.getQueryString();
		chatting.remove(chatUser);
		clients.remove(session);
		//sendNotice(chatUser + "님이 퇴장하셨습니다. 현재 사용자 " + clients.size() + "명");
	}
	
}
