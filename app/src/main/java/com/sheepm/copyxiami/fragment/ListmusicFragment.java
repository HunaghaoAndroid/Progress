package com.sheepm.copyxiami.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.sheepm.copyxiami.R;
import com.sheepm.copyxiami.Utils.Constants;
import com.sheepm.copyxiami.Utils.MediaUtil;
import com.sheepm.copyxiami.adapter.LocalMusicAdapter;
import com.sheepm.copyxiami.bean.Mp3Info;

import java.util.List;

public class ListmusicFragment extends Fragment implements OnItemClickListener{
	
	private View view;
	private LocalMusicAdapter adapter;
	private ListView mp3lists;
	private List<Mp3Info> infos;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_localmusic, container, false);
		
		mp3lists = (ListView) view.findViewById(R.id.mp3lists);
		infos= MediaUtil.getMp3Infos(getActivity());
		adapter = new LocalMusicAdapter(getActivity(), infos);
		mp3lists.setAdapter(adapter);
		mp3lists.setOnItemClickListener(this);
		return view;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent broadcast = new Intent();
		broadcast.setAction(Constants.ACTION_LIST_SEARCH);
		broadcast.putExtra("id", infos.get(position).getId());
		broadcast.putExtra("position", position);
		getActivity().sendBroadcast(broadcast);
	}

}
