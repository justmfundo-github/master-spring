package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole{

	@Override
	public void up() {
		System.out.println("PacMan go Up");		
	}

	@Override
	public void down() {
		System.out.println("PacMan go Down");
	}

	@Override
	public void left() {
		System.out.println("PacMan go Left");
	}

	@Override
	public void right() {
		System.out.println("PacMan go Right");
	}

}
