package com.example.crisp.test;

/**
 * Created by crisp on 9/26/2017.
 */

public class Song {


  public Song(long songID, String songTitle, String songArtist) {
    id=songID;
    title=songTitle;
    artist=songArtist;
  }

  private long id;
  private String title;
  private String artist;

  public long getID(){return id;}
  public String getTitle(){return title;}
  public String getArtist(){return artist;}
}
