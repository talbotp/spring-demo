package com.karaoke.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.concurrent.atomic.AtomicLong;

public class GameManager {

  private static final AtomicLong idCounter = new AtomicLong();

  @Autowired
  private Environment env;

  public int maxPlayersPerGame() {
    return Integer.parseInt(env.getRequiredProperty("game.karaoke.max_players"));
  }



}
