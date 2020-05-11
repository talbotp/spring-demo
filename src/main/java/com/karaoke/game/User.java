package com.karaoke.game;

import java.util.concurrent.atomic.AtomicLong;

public class User {

  private static final AtomicLong idCounter = new AtomicLong();

  private final String name;
  private final long id = idCounter.getAndIncrement();
  private String hostname;
  private long score;
  private long gameId;

  public User(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this)
      return true;

    if (!(other instanceof User))
      return false;

    return name.equals(((User) other).name);
  }

  public String getName() {
    return name;
  }

   public long getId() {
    return id;
  }

  public long getScore() {
    return score;
  }

  public void setScore(long score) {
    this.score = score;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public long getGameId() {
    return gameId;
  }

}
