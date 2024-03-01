package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up(); // calling the up command of the game directly
			
			context.getBean(GameRunner.class).run();   // using GameRunner class to call the game commands
		}
	}

}
