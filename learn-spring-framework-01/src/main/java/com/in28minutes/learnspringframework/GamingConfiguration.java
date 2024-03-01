package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

@Configuration
public class GamingConfiguration {
	@Bean
	public GamingConsole game() {
		PacManGame pacManGame = new PacManGame();
		return pacManGame;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		GameRunner gameRunner = new GameRunner(game());
		return gameRunner;
	}

}
