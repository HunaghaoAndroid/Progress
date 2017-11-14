package com.sheepm.copyxiami.broadcast;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.sheepm.copyxiami.Utils.Constants;
import com.sheepm.copyxiami.application.Myapp;

public class PhoneBroadcastReceiver extends BroadcastReceiver {

	private String TAG = "PhoneBroadcastReceiver";

	/**
	 * ֮�����ж������Ƿ񲥷ţ�����Ϊ���ֻ�Ǵ򿪽����û���ţ��ᱨһ������ sending message to a Handler on a dead
	 * thread
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
			Log.i("---�����绰", "�����绰");
			if (Myapp.isPlay) {
				Message msg = Message.obtain();
				msg.obj = context;
				handler.sendMessage(msg);
			}
		} else {
			if (Myapp.isPlay) {
				Message msg = Message.obtain();
				msg.obj = context;
				handler.sendMessage(msg);
			}
			// �������
			TelephonyManager tManager = (TelephonyManager) context
					.getSystemService(Service.TELEPHONY_SERVICE);
			tManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		}

	}

	/**
	 * �绰״̬����
	 */
	PhoneStateListener listener = new PhoneStateListener() {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);
			switch (state) {
			// �Ҷ�
			case TelephonyManager.CALL_STATE_IDLE:
				break;

			//����
			case TelephonyManager.CALL_STATE_OFFHOOK:

				break;
			//����
			case TelephonyManager.CALL_STATE_RINGING:

				break;

			default:
				break;
			}
		}

	};

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Context context = (Context) msg.obj;
			Intent phonepause = new Intent();
			phonepause.setAction(Constants.ACTION_PAUSE);
			context.sendBroadcast(phonepause);
		}

	};

}
