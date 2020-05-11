package com.karaoke.game;

import java.util.Set;
import java.util.HashSet;

/**
 * Stores all karaoke game data.
 */
public class Game {

  private long id;
  private Set<User> users = new HashSet<User>();
  private Thread gameThread;

  public Game(long id) {
    this.id = id;
  }

  public void start() {

    loop();
  }

  private void loop() {
    while (users.size() >= 2) {

    }
  };

  private boolean isValid() {
    return (users.size() >= 2 && true);
  }

  public void addNewUser(User newUser) {
    users.add(newUser);
  }

  public void removeUser(User user) {
    users.remove(user);
  }

  public long getId() {
    return id;
  }

  public Set<User> getUsers() {
    return users;
  }

  public int getNumberOfPlayers() {
    return users.size();
  }

}
