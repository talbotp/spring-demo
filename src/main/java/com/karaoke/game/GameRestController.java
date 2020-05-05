package com.karaoke.game;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handle HTTP requests for the Karaoke game.
 */
@RestController
public class GameRestController {

  @PostMapping("/join_game")
  public void joinGame() { }

  @PostMapping("/choose_song")
  public void choose_song() { }

  @DeleteMapping("/leave_game")
  public void leaveGame() { }

}
