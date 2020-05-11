package com.karaoke.game;

import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Handle HTTP requests for the Karaoke game.
 */
@RestController
public class GameController {

  private static final AtomicLong idCounter = new AtomicLong();
  private static final Logger logger = LoggerFactory.getLogger(GameController.class);

  private Map<Long, Game> activeGames = new ConcurrentHashMap<>();

  @Autowired
  private Environment env;

  /************************************************************
   * REST API
   ************************************************************/

  @PostMapping("/join_game")
  public void joinGame(@RequestParam("name") String name) {
    User userToAdd = new User(name);
    addUserToGame(userToAdd);
  }

  @PostMapping("/choose_song")
  public void choose_song() {
  }

  @DeleteMapping("/leave_game")
  public void leaveGame(@RequestParam("name") String name) {
    User userToLeave = new User("name");
    removeUserFromGame(userToLeave);
  }

  @GetMapping("/t1")
  public ResponseEntity<Object> t1() {
    logger.info("I like turtles");
    return ResponseEntity.ok().body("wtf");
  }

  /*
   * Private Functions
   */

  /**
   * Trivial queueing method, simply find the next non full game.
   */
  private void addUserToGame(User user) {
    int maxSize = maxPlayersPerGame();
    for (Game game : activeGames.values()) {
      if (game.getNumberOfPlayers() < maxSize) {
        game.addNewUser(user);
        logger.debug("User " + user.getName() + " has joined game with id=" + game.getId());
        return;
      }
    }
    // Case when no games at all or all games are full.
    Game newGame = createGame();
    newGame.addNewUser(user);
    activeGames.put(newGame.getId(), newGame);
    newGame.start();
    logger.debug("User " + user.getName() + " has joined a new game with id=" + newGame.getId());
  }

  private Game createGame() {
    long gameId = idCounter.incrementAndGet();
    Game newGame = new Game(gameId);
    activeGames.put(gameId, newGame);
    logger.debug("New game has been created with id=" + gameId);
    return newGame;
  }

  private int maxPlayersPerGame() {
    return Integer.parseInt(env.getRequiredProperty("game.karaoke.max_players"));
  }

  private void removeUserFromGame(User user) {
    Game usersGame = activeGames.get(user.getGameId());

    if (usersGame == null) {
      logger.error("Trying to remove user with game id=" + user.getGameId() + " that does not exist,");
      return;
    }

    if (usersGame.getNumberOfPlayers() <= 1) {
      activeGames.remove(user.getGameId());
      logger.info("Destroyed game id=" + user.getGameId() + " when removing user id=" + user.getId());
    } else {
      usersGame.removeUser(user);
      logger.info("Removed user id=" + user.getId() + " from game id=" + user.getGameId());
    }
  }

}
