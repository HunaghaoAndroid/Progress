package com.sheepm.copyxiami.application;

import android.app.Application;
import android.content.Intent;
import android.os.Parcelable;

import com.sheepm.copyxiami.Utils.Constants;
import com.sheepm.copyxiami.Utils.MediaUtil;
import com.sheepm.copyxiami.Utils.OtherUtil;
import com.sheepm.copyxiami.bean.Mp3Info;
import com.sheepm.copyxiami.service.MusicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Myapp extends Application {
	
	private static List<Mp3Info> infos;
	
	public static boolean isPlay = false;
	
	//stateģ3��ֵ  0���������   1���б�ѭ��  2�ǵ���ѭ��
	public static int state =2;
	
	public static int position; 
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		infos= MediaUtil.getMp3Infos(getApplicationContext());
		if (!OtherUtil.isServiceRunning(getApplicationContext(), Constants.MUSIC_SERVICE)) {
			startService();
		}
		
	}
	
	private void startService(){
		Intent service = new Intent();
		service.setClass(getApplicationContext(), MusicService.class);
		service.putParcelableArrayListExtra("mp3Infos",(ArrayList<? extends Parcelable>) infos);
		getApplicationContext().startService(service);
	}
	
	public static void getRandom(){
		Random random = new Random();
		position = random.nextInt(infos.size());
	}

}
