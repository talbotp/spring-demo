package com.karaoke.game;

import org.springframework.beans.factory.annotation.Value;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Stores all karaoke game logic.
 */
public class Game {

  private long id;
  private Set<User> users = new HashSet<User>();

  public Game(long id) {
    this.id = id;
  }

  public void newUser(User newUser) {
    users.add(newUser);
  }

  public void removeUser() {
  }

}
