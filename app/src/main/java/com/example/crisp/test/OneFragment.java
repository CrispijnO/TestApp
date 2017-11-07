package com.example.crisp.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;


public class OneFragment extends Fragment {

  public OneFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getFiles();
  }

  private ArrayList<String> songFiles = new ArrayList<String>();


  public void getFiles(){
    File dir = new File("storage/extSdCard/Music/");
    boolean success = true;
    if (!dir.exists()){
      success = dir.mkdir();
      Log.d("nee", "ja");
    }
    File[] files = dir.listFiles();
    for (File file : files) {
      Log.d(file.toString(), "getFiles() returned: " );
    }
  }



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
}
