package com.example.crisp.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.crisp.test.R;
//import com.example.crisp.test.OneFragment;
import com.example.crisp.test.TwoFragment;
import com.example.crisp.test.ThreeFragment;

public class MainActivity extends AppCompatActivity {

  private TabLayout tabLayout;
  private ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager = (ViewPager) findViewById(R.id.viewpager);
    setupViewPager(viewPager);

    tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
    getFiles();
  }

//  View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//    System.out.println(songFiles);
//    System.out.println("afs");
//    View view = inflater.inflate(R.layout.fragment_one, container, false);
//    ListView lv = (ListView)view.findViewById(R.id.songList);
//    ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.fragment_one, R.id.songList, songFiles);
//    lv.setAdapter(adapter);
//    adapter.notifyDataSetChanged();
//    return view;
//  }

  private void setupViewPager(ViewPager viewPager) {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    adapter.addFragment(new OneFragment(), "Songs");
    adapter.addFragment(new TwoFragment(), "Playlists");
    adapter.addFragment(new ThreeFragment(), "Search");
    viewPager.setAdapter(adapter);
  }

  class ViewPagerAdapter extends FragmentPagerAdapter {
      private final List<Fragment> mFragmentList = new ArrayList<>();
      private final List<String> mFragmentTitleList = new ArrayList<>();


      public ViewPagerAdapter(FragmentManager manager) {
      super(manager);
    }

      @Override
      public Fragment getItem(int position) {
        return mFragmentList.get(position);
      }

      @Override
      public int getCount() {
        return mFragmentList.size();
      }

      public void addFragment(Fragment fragment, String title) {
         mFragmentList.add(fragment);
         mFragmentTitleList.add(title);
      }

      @Override
      public CharSequence getPageTitle(int position) {
          return mFragmentTitleList.get(position);
      }
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
//        System.out.println(songFiles);
      }

  public static String splitExt(String args) {
    String filenameArray[] = args.split("\\.");
    return (filenameArray[filenameArray.length-1]);
  }

}
