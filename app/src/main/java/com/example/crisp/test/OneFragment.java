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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    getFiles();
  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      System.out.println(songFiles);
      System.out.println("afs");
      View view = inflater.inflate(R.layout.fragment_one, container, false);
      TextView lv = (TextView) view.findViewById(R.id.songList);
      ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.fragment_one, songFiles);
      lv.setAdapter(adapter);
      adapter.notifyDataSetChanged();
      return view;
  }

private ArrayList<File> songFiles = new ArrayList<File>();

  public void getFiles() {
    File dir = new File("storage/extSdCard/Music/");
    boolean success = true;

    if (!dir.exists()) {
      success = dir.mkdir();
    }

    File[] tempList = dir.listFiles();
    List<File> files = new ArrayList<File>(Arrays.asList(tempList));

    for (int i = 0; i < files.size(); i++) {

      File file = files.get(i);
      String fileExt = splitExt(file.getName());

      if (!file.isDirectory() && fileExt.equals("mp3")) {
        songFiles.add(file);
      }
      else if(file.isDirectory()){
        File newDir = new File(file.toString());
        File[] tempList2 = newDir.listFiles();
        List<File> newFiles = new ArrayList<File>(Arrays.asList(tempList2));

        files.addAll(newFiles);
      }

    }
        System.out.println(songFiles);
  }

  public static String splitExt(String args) {
    String filenameArray[] = args.split("\\.");
    return (filenameArray[filenameArray.length-1]);
  }

}

