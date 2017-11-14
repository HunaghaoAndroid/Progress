package com.sheepm.copyxiami.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sheepm.copyxiami.R;

public class LocalMusicFragment extends Fragment{
	
	private View view;
	private ListmusicFragment listmusicFragment = new ListmusicFragment();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.localmusic, container, false);
		replaceFragment(listmusicFragment);
		return view;
	}
	
	/**
	 * �л�fragment��ͼ
	 * 
	 * @param fragment
	 */
	@SuppressLint("NewApi")
	public void replaceFragment(Fragment fragment) {
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = getChildFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.localmusic, fragment);
		transaction.commit();
	}


}
