package com.example.crisp.test;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OneFragment extends Fragment {

  public OneFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_one, container, false);
  }
}

//  private ArrayList<File> songFiles = new ArrayList<File>();
//
//
//  public void getFiles() {
//    File dir = new File("storage/extSdCard/Music/");
//    boolean success = true;
//
//    if (!dir.exists()) {
//      success = dir.mkdir();
//    }
//
//    File[] tempList = dir.listFiles();
//
//    List<File> files = new ArrayList<File>(Arrays.asList(tempList));
//    for (int i = 0; i < files.size(); i++) {
//      File file = files.get(i);
//      String fileExt = splitExt(file.getName());
//      if (!file.isDirectory() && fileExt.equals("mp3")) {
//        songFiles.add(file);
//      }
//      else if(file.isDirectory()){
//        File newDir = new File(file.toString());
//        File[] tempList2 = newDir.listFiles();
//        List<File> newFiles = new ArrayList<File>(Arrays.asList(tempList2));
//        files.addAll(newFiles);
//      }
//
//    }
//    System.out.println(songFiles);
//  }
//
//  public static String splitExt(String args) {
//    String filenameArray[] = args.split("\\.");
//    return (filenameArray[filenameArray.length-1]);
//  }



  //  public Array getFilesFromDirectory(){
//    for (File file: filePath) {
//
//    }
//  }


//  private ArrayList<SongDetails> getSongsFromDirectory(File f){
//    ArrayList<SongDetails> songs = new ArrayList<SongDetails>();
//    if (!f.exists() || !f.isDirectory()) return songs;
//
//    File[] files = f.listFiles(new Mp3Filter());
//
//    for (File file : files){
//      if (file.isDirectory()){
//        songs.addAll(getSongsFromDirectory(file));
//      }
//      else{
//        SongDetails detail=new SongDetails();
//        detail.setIcon(R.drawable.ic_launcher);
//        String fileName = file.getName();
//        detail.setSong(fileName);
//        detail.setArtist(fileName);
//        detail.setAlbum(fileName);
//        songs.add(detail);
//      }
//    }
//
//    return songs;
//  }
//
//  class Mp3Filter implements FileFilter {
//    public boolean accept(File file){
//      return (file.isDirectory() || file.getName().toUpperCase().endsWith(".MP3"));
//    }
//  }
//
//  @Override
//  public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                           Bundle savedInstanceState){
//    View view = inflater.inflate(R.layout.fragment_one, container, false);
//    ListView SngList = (ListView) view.findViewById(R.id.songList);
//    File f=new File("/sdcard/");
//    ArrayList<SongDetails> Songinfo = getSongsFromDirectory(f);
//    if (songinfo.size()>0){
//      SngList.setAdapter(new CustomAdapter(Songinfo));
//      return view;
//    }
//    else return null;
//
//    return null;
//  }
