package com.sheepm.copyxiami.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sheepm.copyxiami.R;

/**
 * �ҵ� ����
 * 
 * @author sheepm
 * 
 */
public class MyFragment extends Fragment implements OnClickListener {
	private View view;
	private LinearLayout mMymusic;
	private LocalMusicFragment localMusicFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_my, container, false);
		initView();

		setOnclickListener();
		return view;
	}

	private void setOnclickListener() {
		mMymusic.setOnClickListener(this);
	}

	private void initView() {
		mMymusic = (LinearLayout) view.findViewById(R.id.mymusic);
	}

	/**
	 * �л�fragment��ͼ
	 * 
	 * @param fragment
	 */
	@SuppressLint("NewApi")
	public void replaceFragment(Fragment fragment) {
		FragmentTransaction transaction = getActivity().getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_main, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.mymusic:
				localMusicFragment = new LocalMusicFragment();
				replaceFragment(localMusicFragment);
			
			break;

		default:
			break;
		}
	}

}
