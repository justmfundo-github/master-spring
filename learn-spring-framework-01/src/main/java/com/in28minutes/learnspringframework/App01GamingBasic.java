package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacManGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		MarioGame marioGame = new MarioGame();
		SuperContraGame superContraGame = new SuperContraGame();
		PacManGame pacManGame = new PacManGame(); //1: Object Creation
		//GameRunner gameRunner = new GameRunner(marioGame);
		GameRunner gameRunner = new GameRunner(pacManGame); //2: Object creation + Wiring of dependencies
		// Game is a dependency of GameRunner
		
		gameRunner.run();
	}

}
