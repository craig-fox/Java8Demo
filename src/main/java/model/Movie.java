package main.java.model;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * User: foxc
 * Date: 20/06/14
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
  private String name;
  private Duration runningTime;
  private int stars;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Duration getRunningTime() {
    return runningTime;
  }

  public void setRunningTime(Duration runningTime) {
    this.runningTime = runningTime;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }
}
