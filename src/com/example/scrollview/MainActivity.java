package com.example.scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	private TextView tv;
	private ScrollView scroll;
	private Button up;
	private Button down;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		up = (Button)findViewById(R.id.up);
		down = (Button)findViewById(R.id.down);
		up.setOnClickListener(this);
		down.setOnClickListener(this);
		tv = (TextView)findViewById(R.id.content);
		tv.setText(getResources().getString(R.string.content));
		scroll = (ScrollView)findViewById(R.id.scroll);
		scroll.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				
				case MotionEvent.ACTION_MOVE:
					/*
					 * getScrollY() ---�����������ľ���
					 * getMeasuredHeight()
					 * getHeight()
					 * 
					 */
					//����״̬
					if(scroll.getScrollY() <= 0)
					{
						Log.i("tag", "����");
					}
					//�ײ�״̬
					//TextView���ܸ߶�<=��Ļ�ĸ߶�+�������Ĺ�������
					if(scroll.getChildAt(0).getMeasuredHeight()<=scroll.getHeight()+scroll.getScrollY())
					{
						Log.i("tag", "�ײ�");
						Log.i("tag", "scroll.getChildAt(0).getMeasuredHeight()="+scroll.getChildAt(0).getMeasuredHeight()+
								"scroll.getHeight()"+scroll.getHeight()+"scroll.getScrollY()"+scroll.getScrollY());
						tv.append(getResources().getString(R.string.content));
					}
					break;
				}
				return false;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//scrollTo�ĳ�ʼ�ж�λ�����Թ�����ͼ��ʼλ��(�̶�)
		//scrollBy�ĳ�ʼ�ж�λ������ǰһ�εģ���̬��
		case R.id.up:
			scroll.scrollBy(0, -30);
			break;

		case R.id.down:
			scroll.scrollBy(0, 30);
			break;
		}
	}
}
