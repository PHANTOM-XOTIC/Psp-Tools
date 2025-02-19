package org.ppsspp.ppsspp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import org.antlr.v4.runtime.*;
import me.ibrahimsn.particle.*;
import io.github.rosemoe.sora.*;
import javaxml.*;
import org.jetbrains.kotlin.*;
import com.google.gson.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.textmate.core.*;
import io.github.rosemoe.sora.textmate.languageconfiguration.*;
import arabware.libs.getThumbnail.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class FilesActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String subtitle = "";
	private String Folder = "";
	private double position = 0;
	private boolean chack = false;
	private String info = "";
	private String UpFolder = "";
	private boolean DC = false;
	private String Android = "";
	private String path = "";
	private String psp = "";
	private String CreateFolder = "";
	private String mainfile = "";
	private String hsi = "";
	private String datammm = "";
	
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> File_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> game = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap_games = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout back;
	private ListView listview2;
	private ImageView imageview1;
	private TextView textview1;
	private RelativeLayout _drawer_relativeLayout;
	private LinearLayout _drawer_particleView;
	private LinearLayout _drawer_ui1;
	private ScrollView _drawer_vscroll2;
	private LinearLayout _drawer_linear12;
	private LinearLayout _drawer_linear14;
	private LinearLayout _drawer_linear15;
	private TextView _drawer_gamedownload;
	private LinearLayout _drawer_gamedownload_path;
	private TextView _drawer_emu;
	private LinearLayout _drawer_ppsspp;
	private TextView _drawer_textview17;
	private LinearLayout _drawer_githubs;
	private TextView _drawer_textview25;
	private LinearLayout _drawer_linear17;
	private TextView _drawer_textview19;
	private LinearLayout _drawer_setting;
	private LinearLayout _drawer_about;
	private LinearLayout _drawer_about_your_mobile;
	private LinearLayout _drawer_Telegram;
	private LinearLayout _drawer_shell;
	private LinearLayout _drawer_keyboardinstall;
	private TextView _drawer_textview23;
	private LinearLayout _drawer_exit;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview13;
	private ImageView _drawer_download;
	private TextView _drawer_drawer_game;
	private ImageView _drawer_iconppsspp;
	private TextView _drawer_drawer_psp;
	private ImageView _drawer_icongithub;
	private TextView _drawer_drawer_git;
	private ImageView _drawer_iconpathdownload;
	private TextView _drawer_textview26;
	private ImageView _drawer_setting_icon;
	private TextView _drawer_drawer_sti;
	private ImageView _drawer_abouticon;
	private TextView _drawer_drawer_ab;
	private ImageView _drawer_iconabout_your_mobile;
	private TextView _drawer_drawer_ab2;
	private ImageView _drawer_iconTelegram;
	private TextView _drawer_drawer_tel;
	private ImageView _drawer_iconshell;
	private TextView _drawer_drawer_cdm;
	private ImageView _drawer_iconkeyboard;
	private TextView _drawer_textview24;
	private ImageView _drawer_iconexit;
	private TextView _drawer_drawer_by;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private AlertDialog.Builder Dialog;
	private SharedPreferences d;
	private SharedPreferences one;
	private SharedPreferences img;
	private Intent i = new Intent();
	private TimerTask if_timerask;
	private AlertDialog.Builder dialog3;
	private ProgressDialog progdialogninjacoder;
	private MediaPlayer mp3pp;
	private AlertDialog.Builder dialogmain;
	private AlertDialog.Builder dialog;
	private Intent myint = new Intent();
	private Intent mobile = new Intent();
	private Intent sring = new Intent();
	private Intent telgp = new Intent();
	private Intent telch = new Intent();
	private Intent myshell = new Intent();
	private Intent aubot = new Intent();
	private Intent pspgamemaster = new Intent();
	private Intent github = new Intent();
	private Intent main11 = new Intent();
	private AlertDialog.Builder w1;
	private ProgressDialog ptfileexserting;
	private AlertDialog.Builder ptexsert;
	private TimerTask TIMERASKMAIN;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.files);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(FilesActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		back = findViewById(R.id.back);
		listview2 = findViewById(R.id.listview2);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		_drawer_relativeLayout = _nav_view.findViewById(R.id.relativeLayout);
		_drawer_particleView = _nav_view.findViewById(R.id.particleView);
		_drawer_ui1 = _nav_view.findViewById(R.id.ui1);
		_drawer_vscroll2 = _nav_view.findViewById(R.id.vscroll2);
		_drawer_linear12 = _nav_view.findViewById(R.id.linear12);
		_drawer_linear14 = _nav_view.findViewById(R.id.linear14);
		_drawer_linear15 = _nav_view.findViewById(R.id.linear15);
		_drawer_gamedownload = _nav_view.findViewById(R.id.gamedownload);
		_drawer_gamedownload_path = _nav_view.findViewById(R.id.gamedownload_path);
		_drawer_emu = _nav_view.findViewById(R.id.emu);
		_drawer_ppsspp = _nav_view.findViewById(R.id.ppsspp);
		_drawer_textview17 = _nav_view.findViewById(R.id.textview17);
		_drawer_githubs = _nav_view.findViewById(R.id.githubs);
		_drawer_textview25 = _nav_view.findViewById(R.id.textview25);
		_drawer_linear17 = _nav_view.findViewById(R.id.linear17);
		_drawer_textview19 = _nav_view.findViewById(R.id.textview19);
		_drawer_setting = _nav_view.findViewById(R.id.setting);
		_drawer_about = _nav_view.findViewById(R.id.about);
		_drawer_about_your_mobile = _nav_view.findViewById(R.id.about_your_mobile);
		_drawer_Telegram = _nav_view.findViewById(R.id.Telegram);
		_drawer_shell = _nav_view.findViewById(R.id.shell);
		_drawer_keyboardinstall = _nav_view.findViewById(R.id.keyboardinstall);
		_drawer_textview23 = _nav_view.findViewById(R.id.textview23);
		_drawer_exit = _nav_view.findViewById(R.id.exit);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_download = _nav_view.findViewById(R.id.download);
		_drawer_drawer_game = _nav_view.findViewById(R.id.drawer_game);
		_drawer_iconppsspp = _nav_view.findViewById(R.id.iconppsspp);
		_drawer_drawer_psp = _nav_view.findViewById(R.id.drawer_psp);
		_drawer_icongithub = _nav_view.findViewById(R.id.icongithub);
		_drawer_drawer_git = _nav_view.findViewById(R.id.drawer_git);
		_drawer_iconpathdownload = _nav_view.findViewById(R.id.iconpathdownload);
		_drawer_textview26 = _nav_view.findViewById(R.id.textview26);
		_drawer_setting_icon = _nav_view.findViewById(R.id.setting_icon);
		_drawer_drawer_sti = _nav_view.findViewById(R.id.drawer_sti);
		_drawer_abouticon = _nav_view.findViewById(R.id.abouticon);
		_drawer_drawer_ab = _nav_view.findViewById(R.id.drawer_ab);
		_drawer_iconabout_your_mobile = _nav_view.findViewById(R.id.iconabout_your_mobile);
		_drawer_drawer_ab2 = _nav_view.findViewById(R.id.drawer_ab2);
		_drawer_iconTelegram = _nav_view.findViewById(R.id.iconTelegram);
		_drawer_drawer_tel = _nav_view.findViewById(R.id.drawer_tel);
		_drawer_iconshell = _nav_view.findViewById(R.id.iconshell);
		_drawer_drawer_cdm = _nav_view.findViewById(R.id.drawer_cdm);
		_drawer_iconkeyboard = _nav_view.findViewById(R.id.iconkeyboard);
		_drawer_textview24 = _nav_view.findViewById(R.id.textview24);
		_drawer_iconexit = _nav_view.findViewById(R.id.iconexit);
		_drawer_drawer_by = _nav_view.findViewById(R.id.drawer_by);
		net = new RequestNetwork(this);
		Dialog = new AlertDialog.Builder(this);
		d = getSharedPreferences("d", Activity.MODE_PRIVATE);
		one = getSharedPreferences("one", Activity.MODE_PRIVATE);
		img = getSharedPreferences("img", Activity.MODE_PRIVATE);
		dialog3 = new AlertDialog.Builder(this);
		dialogmain = new AlertDialog.Builder(this);
		dialog = new AlertDialog.Builder(this);
		w1 = new AlertDialog.Builder(this);
		ptexsert = new AlertDialog.Builder(this);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Folder.equals(FileUtil.getExternalStorageDir())) {
					finishAffinity();
				}
				else {
					UpFolder = Folder.substring((int)(0), (int)(Folder.lastIndexOf("/")));
					Folder = UpFolder;
					_RefreshData();
				}
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				position = _position;
				if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
					Folder = liststring.get((int)(_position));
					_RefreshData();
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".ini") || (liststring.get((int)(_position)).endsWith(".txt") || (liststring.get((int)(_position)).endsWith(".xml") || (liststring.get((int)(_position)).endsWith(".go") || (liststring.get((int)(_position)).endsWith(".java") || (liststring.get((int)(_position)).endsWith(".py") || liststring.get((int)(_position)).endsWith(".cpp"))))))) {
						i.putExtra("file", liststring.get((int)(_position)));
						i.putExtra("save", liststring.get((int)(_position)));
						i.setClass(getApplicationContext(), IniActivity.class);
						startActivity(i);
					}
					if (liststring.get((int)(_position)).endsWith(".apk")) {
						try {
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
													Uri uri = androidx.core.content.FileProvider.getUriForFile(getApplicationContext(),
															FilesActivity.this.getPackageName() + ".provider", new java.io.File(liststring.get((int)(_position))));
													Intent intent = new Intent(Intent.ACTION_VIEW);
													intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
													intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
													intent.setDataAndType(uri, "application/vnd.android.package-archive");
													startActivity(intent);
								
											} else {
													Intent intent = new Intent(Intent.ACTION_VIEW);
													intent.setDataAndType(Uri.fromFile( new java.io.File(liststring.get((int)(_position)))),
															"application/vnd.android.package-archive");
													intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
													startActivity(intent);
											}
							
						} catch (Exception rr) {
							showMessage (rr.toString());
						}
					}
					if (liststring.get((int)(_position)).endsWith(".png") || (liststring.get((int)(_position)).endsWith(".jpg") || (liststring.get((int)(_position)).endsWith(".tk") || liststring.get((int)(_position)).endsWith(".apng")))) {
						if (img.getString("i1", "").equals("onimg")) {
							final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
							View inflate = getLayoutInflater().inflate(R.layout.image,null); 
							dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
							dialog1.setView(inflate);
							LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
							ImageView hsigamerlol = (ImageView) inflate.findViewById(R.id.hsigamerlol);
							ImageView close = (ImageView) inflate.findViewById(R.id.close);
							LinearLayout user1 = (LinearLayout) inflate.findViewById(R.id.user1);
							try {
								hsigamerlol.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
							} catch (Exception e) {
								 
							}
							{
								android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
								SketchUi.setColor(0xFFFFFFFF);float lt = getDip(22);
								float rt = getDip(22);
								float rb = getDip(0);
								float lb = getDip(0);
								SketchUi.setCornerRadii(new float[]{
										lt,lt,rt ,rt,rb,rb ,lb,lb });
								SketchUi.setStroke((int)getDip(1) ,0xFF008DCD);
								user1.setElevation(getDip(5));
								user1.setBackground(SketchUi);
							}
							close.setImageResource(R.drawable.close_file);
							close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
											
										dialog1.dismiss();
									
									}
							});
							dialog1.setCancelable(true);
							dialog1.show();
						}
						else {
							if (img.getString("i1", "").equals("offimg")) {
								try {
									i.setClass(getApplicationContext(), ImageviewerActivity.class);
									i.putExtra("hsig", liststring.get((int)(_position)));
									startActivity(i);
								} catch (Exception e) {
									 
								}
							}
							else {
								
							}
						}
					}
					if (liststring.get((int)(_position)).endsWith(".iso") || liststring.get((int)(_position)).endsWith(".cso")) {
						i.setClass(getApplicationContext(), PpssppActivity.class);
						i.putExtra("path", liststring.get((int)(_position)));
						startActivity(i);
					}
					if (liststring.get((int)(_position)).endsWith(".gif")) {
						final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
						View inflate = getLayoutInflater().inflate(R.layout.gifviewr,null); 
						dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						dialog1.setView(inflate);
						LinearLayout li1 = (LinearLayout) inflate.findViewById(R.id.li1);
						LinearLayout gifmod = (LinearLayout) inflate.findViewById(R.id.gifmod);
						ImageView by = (ImageView) inflate.findViewById(R.id.by);
						{
							android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
							SketchUi.setColor(0xFFFFFFFF);float lt = getDip(22);
							float rt = getDip(22);
							float rb = getDip(0);
							float lb = getDip(0);
							SketchUi.setCornerRadii(new float[]{
									lt,lt,rt ,rt,rb,rb ,lb,lb });
							SketchUi.setStroke((int)getDip(1) ,0xFF008DCD);
							li1.setElevation(getDip(5));
							li1.setBackground(SketchUi);
						}
						try {
							
							boolean largeSize = true;
							
							java.io.File file = new java.io.File(liststring.get((int)(_position)));
							
							
							java.io.InputStream stream = null;
							    try {
								        stream = new java.io.FileInputStream(file);
								    } catch (IOException e) {
								        e.printStackTrace();
								    }
							          
							
							GifDecoderView view = new GifDecoderView(getApplicationContext(), stream);                 
							
							DisplayMetrics displayMetrics = new DisplayMetrics();
							        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
							        int height = displayMetrics.heightPixels;
							        int width = displayMetrics.widthPixels;
							
							
							view.setScaleType(ImageView.ScaleType.FIT_CENTER);
							
							if (largeSize) {
								view.setMinimumWidth(width);
								view.setMinimumHeight(height);
							}
							gifmod.removeAllViews();
							gifmod.addView(view);
						} catch (Exception e) {
							 
						}
						by.setImageResource(R.drawable.close_file);
						by.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										
									dialog1.dismiss();
								
								}
						});
						dialog1.setCancelable(true);
						dialog1.show();
					}
					if (liststring.get((int)(_position)).endsWith(".mp3")) {
						try {
							    mp3pp = new MediaPlayer();
							        mp3pp.setDataSource(liststring.get((int)(_position)));
							        mp3pp.prepare();
							    } catch (java.io.IOException e) {
							        e.printStackTrace();
							    }
						final AlertDialog.Builder alert = new AlertDialog.Builder(FilesActivity.this, AlertDialog.THEME_HOLO_LIGHT); 
						    final Button btn = new Button(getApplicationContext()); 
						    btn.setText("⏮");
						    btn.setPadding(0,0,0,0);
						    btn.setLayoutParams(new LinearLayout.LayoutParams(155, 85));
						    final Button btn2 = new Button(getApplicationContext()); 
						    btn2.setText("⏭");
						    btn2.setPadding(0,0,0,0);
						    btn2.setLayoutParams(new LinearLayout.LayoutParams(155, 85));
						    final Button btn3 = new Button(getApplicationContext()); 
						    btn3.setLayoutParams(new LinearLayout.LayoutParams(110, 85));
						    btn3.setText("▶️");
						    btn3.setPadding(0,0,0,0);
						    alert.setTitle("MediaPlayer:".concat(liststring.get((int)(_position))));
						    
						    final SeekBar seek = new SeekBar(getApplicationContext()); 
						    LinearLayout parent = new LinearLayout(getApplicationContext()); parent.setLayoutParams(new android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, 250)); parent.setOrientation(LinearLayout.VERTICAL); 
						    LinearLayout parent2 = new LinearLayout(getApplicationContext()); parent2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT)); parent.setOrientation(LinearLayout.VERTICAL); 
						    parent.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
						    
						    parent.addView(seek);
						    parent2.addView(btn);
						    parent2.addView(btn2);
						    parent2.addView(btn3);
						    parent.addView(parent2);
						    alert.setCancelable(false);
						    
						    seek.setMax((int)mp3pp.getDuration()/90); 
						    
						    final Handler mHandler = new Handler();
						    runOnUiThread(new Runnable() {
							     
							         @Override
							         public void run() {
								              if(mp3pp != null){
									                   int mCurrentPosition = mp3pp.getCurrentPosition() / 90;
									                   seek.setProgress(mCurrentPosition);
									               }
								              mHandler.postDelayed(this, 90);
								          }
							    });
						    seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
							     
							             @Override
							             public void onStopTrackingTouch(SeekBar seekBar) {
								      
								              }
							     
							             @Override
							             public void onStartTrackingTouch(SeekBar seekBar) {
								      
								              }
							     
							                 @Override
							                 public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {                
								                      if(mp3pp != null && fromUser){
									                           mp3pp.seekTo(progress * 90);
									                       }
								                  }
							         });
						     
						    btn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)500, 0xFF2196F3));
						    btn2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)500, 0xFF2196F3));
						    btn3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)500, 0xFF2196F3));
						   
						  btn3.setOnTouchListener(new View.OnTouchListener() {
							     @Override
							     public boolean onTouch(View v, MotionEvent event) {
								      switch (event.getAction()){
									       case MotionEvent.ACTION_DOWN:{
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn3);
										        scaleX.setPropertyName("scaleX");
										        scaleX.setFloatValues(0.9f);
										        scaleX.setDuration((int)5);
										        scaleX.start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn3);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues(0.9f);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        break;
										       }
									       case MotionEvent.ACTION_UP:{
										        
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn3);
										scaleX.setPropertyName("scaleX");
										scaleX.setFloatValues((float)1);
										        scaleX.setDuration((int)5);
										scaleX.
										start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn3);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues((float)1);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        
										        break;
										       }
									      }
								      return false;
								     }
							    });
						    btn.setOnTouchListener(new View.OnTouchListener() {
							     @Override
							     public boolean onTouch(View v, MotionEvent event) {
								      switch (event.getAction()){
									       case MotionEvent.ACTION_DOWN:{
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn);
										        scaleX.setPropertyName("scaleX");
										        scaleX.setFloatValues(0.9f);
										        scaleX.setDuration((int)5);
										        scaleX.start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues(0.9f);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        break;
										       }
									       case MotionEvent.ACTION_UP:{
										        
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn);
										        scaleX.setPropertyName("scaleX");
										        scaleX.setFloatValues((float)1);
										        scaleX.setDuration((int)5);
										        scaleX.start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues((float)1);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        
										        break;
										       }
									      }
								      return false;
								     }
							    });
						    btn2.setOnTouchListener(new View.OnTouchListener() {
							     @Override
							     public boolean onTouch(View v, MotionEvent event) {
								      switch (event.getAction()){
									       case MotionEvent.ACTION_DOWN:{
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn2);
										        scaleX.setPropertyName("scaleX");
										        scaleX.setFloatValues(0.9f);
										        scaleX.setDuration((int)5);
										        scaleX.start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn2);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues(0.9f);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        break;
										       }
									       case MotionEvent.ACTION_UP:{
										        
										        ObjectAnimator scaleX = new ObjectAnimator();
										        scaleX.setTarget(btn2);
										        scaleX.setPropertyName("scaleX");
										        scaleX.setFloatValues((float)1);
										        scaleX.setDuration((int)5);
										        scaleX.start();
										        
										        ObjectAnimator scaleY = new ObjectAnimator();
										        scaleY.setTarget(btn2);
										        scaleY.setPropertyName("scaleY");
										        scaleY.setFloatValues((float)1);
										        scaleY.setDuration((int)5);
										        scaleY.start();
										        
										        break;
										       }
									      }
								      return false;
								     }
							    });
						    if (mp3pp.isPlaying()) {
							     btn3.setText("⏸");
							    }
						    else {
							     btn3.setText("▶️");
							    }
						    btn.setOnClickListener(new View.OnClickListener() {
							     @Override
							     public void onClick(View _view) {
								       
								     }
							    });
						    
						    btn2.setOnClickListener(new View.OnClickListener() {
							     @Override
							     public void onClick(View _view) {
								       
								     }
							    });
						    btn3.setOnClickListener(new View.OnClickListener() {
							     @Override
							     public void onClick(View _view) {
								      if (mp3pp.isPlaying()) {
									       btn3.setText("▶️");
									       mp3pp.pause();
									      }
								      else {
									       btn3.setText("⏸");
									       mp3pp.start();
									      }
								     }
							    });
						    final String _btn9 = ("Exit");
						    alert.setPositiveButton(_btn9, new DialogInterface.OnClickListener() {
							          @Override
							          public void onClick(DialogInterface _dialog, int _which) {
								           mp3pp.reset();
								      
								     }
							         });
						    seek.setProgressTintList(ColorStateList.valueOf(0xFFFF9800));
						    
						    seek.getThumb().setColorFilter((0xFFFF9800), PorterDuff.Mode.MULTIPLY);
						    
						    alert.setView(parent);
						    final AlertDialog bb = alert.create();
						    bb.show();
					}
					if (liststring.get((int)(_position)).endsWith(".pt")) {
						ptexsert.setTitle("install pt data?");
						ptexsert.setIcon(R.drawable.ptdata);
						ptexsert.setMessage("are you exsert PT data?");
						datammm = Uri.parse(liststring.get((int)(_position))).getLastPathSegment();
						ptexsert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								ptfileexserting = new ProgressDialog(FilesActivity.this);
								ptfileexserting.setTitle("installing PT DATA....");
								ptfileexserting.setMessage("install path:".concat(" ".concat(datammm)));
								ptfileexserting.setCanceledOnTouchOutside(true);
								TIMERASKMAIN = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												while(true) {
													try {
														String fileZip = liststring.get((int)(_position));
														        java.io.File destDir = new java.io.File("/sdcard/psp/");
														        byte[]  buffer = new byte[1024] ;
														        try {
															        java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(fileZip));
															        java.util.zip.ZipEntry zipEntry = zis.getNextEntry();
															
															
															        while (zipEntry != null) {
																             java.io.File newFile = newFile(destDir, zipEntry);
																             if (zipEntry.isDirectory()) {
																	                 if (!newFile.isDirectory() && !newFile.mkdirs()) {
																		                     throw new java.io.IOException("Failed to create directory " + newFile);
																		                 }
																	             } else {
																	                 // fix for Windows-created archives
																	                 java.io.File parent = newFile.getParentFile();
																	                 if (!parent.isDirectory() && !parent.mkdirs()) {
																		                     throw new java.io.IOException("Failed to create directory " + parent);
																		                 }
																	
																	                 // write file content
																	                 java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
																	                 int len;
																	                 while ((len = zis.read(buffer)) > 0) {
																		                     fos.write(buffer, 0, len);
																		                 }
																	                 fos.close();
																	             }
																         zipEntry = zis.getNextEntry();
																        }
															        zis.closeEntry();
															        zis.close();
														} catch (Exception e) {
															  showMessage(e.toString());
															   }
														SketchwareUtil.showMessage(getApplicationContext(), "✅");
														_RefreshData();
													} catch (Exception e) {
														SketchwareUtil.CustomToast(getApplicationContext(), e.toString(), 0xFFFFFFFF, 16, 0xFF212121, 30, SketchwareUtil.BOTTOM);
													}
													ptfileexserting.dismiss();
													break;
												}
											}
										});
									}
								};
								_timer.schedule(TIMERASKMAIN, (int)(2000));
								ptfileexserting.show();
							}
						});
						ptexsert.setNegativeButton("No", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						ptexsert.create().show();
					}
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dialog,null); 
				dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog1.setView(inflate);
				LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
				LinearLayout folder = (LinearLayout) inflate.findViewById(R.id.folder);
				LinearLayout file = (LinearLayout) inflate.findViewById(R.id.file);
				LinearLayout runpsp = (LinearLayout) inflate.findViewById(R.id.runpsp);
				LinearLayout open = (LinearLayout) inflate.findViewById(R.id.open);
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF424242);SketchUi.setCornerRadius(getDip(10));
					SketchUi.setStroke((int)getDip(0) ,0xFFF44336);
					bg.setElevation(getDip(5));
					bg.setBackground(SketchUi);
				}
				folder.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
								
							dialog.setTitle("ساخت پوشه ");
						dialog.setIcon(R.drawable.iconnewppsspp_4);
						dialog.setMessage("ایا میخواهید یک پوشه جدید ایجاد کنید..");
						final EditText edittext1= new EditText(FilesActivity.this);
						LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
						edittext1.setHint("name folder...");
						edittext1.setHintTextColor(0xFF000000);
						edittext1.setTextSize((float)16);
						edittext1.setTextColor(0xFFF44336);
						((EditText)edittext1).setError("Error plestype text");
						edittext1.setLayoutParams(lpar);
						dialog.setView(edittext1);
						dialog.setPositiveButton("بله", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								try {
									CreateFolder = edittext1.getText().toString();
									if (!FileUtil.isFile(Folder.concat("/".concat(CreateFolder.concat("/"))))) {
										FileUtil.makeDir(Folder.concat("/".concat(CreateFolder.concat("/"))));
										_RefreshData();
									}
									else {
										
									}
								} catch (Exception e) {
									 
								}
							}
						});
						dialog.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
						dialog1.dismiss();
						
						}
				});
				file.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
								
							_file();
						dialog1.dismiss();
						
						}
				});
				runpsp.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
								
							i.setClass(getApplicationContext(), PpssppActivity.class);
								startActivity(i);
								dialog1.dismiss();
						
						}
				});
				open.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
								
							_drawer.openDrawer(GravityCompat.START);
						dialog1.dismiss();
						
						}
				});
				dialog1.setCancelable(true);
				dialog1.show();
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_drawer_gamedownload_path.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pspgamemaster.setClass(getApplicationContext(), GamemasterActivity.class);
				startActivity(pspgamemaster);
			}
		});
		
		_drawer_ppsspp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PsprunActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_githubs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				github.setAction(Intent.ACTION_VIEW);
				github.setData(Uri.parse("https://github.com/Ninjacoderhsi/Psp-Tools"));
				startActivity(github);
			}
		});
		
		_drawer_linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					psp = "/sdcard/psp/";
					if (checkPermission(pathToRealUri(psp))) {
						 if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
								      
							progdialogninjacoder = new ProgressDialog(FilesActivity.this);
							progdialogninjacoder.setTitle("PSP Tools");
							progdialogninjacoder.setMessage("در حال اماده سازی");
							progdialogninjacoder.setCanceledOnTouchOutside(false);
							fromStorage = false;
							try {
								Uri mUri = Uri.parse(pathToRealUri(psp));
								
								String fileName = "psptoolsdata.zip";
								
								androidx.documentfile.provider.DocumentFile dFile = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), mUri);
								           Uri mUri2 = Uri.parse(mUri.toString()+ "%2" + fileName);
								          androidx.documentfile.provider.DocumentFile  dFile2 = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), mUri2);
								            
								  try {              
									
									androidx.documentfile.provider.DocumentFile file = dFile.findFile("psptoolsdata.zip");
									   android.provider.DocumentsContract.deleteDocument(getApplicationContext().getContentResolver(), file.getUri());
									
									                    android.provider.DocumentsContract.deleteDocument(getApplicationContext().getContentResolver(), mUri2);
									
									
								} catch (FileNotFoundException e) {
									                } catch (Exception e2) {
									                }
								
								
								dFile2 = dFile.createFile("data/zip", fileName);
								            mUri = dFile2.getUri();
								        
								        
								        
								        if (copyAsset(fileName, mUri)) {
									           
									        } else {
									            
									        }
								
								                
								      } catch (Exception re){}      
							            
							        
							        
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											String fileZip = "/sdcard/psp/psptoolsdata.zip";
											        java.io.File destDir = new java.io.File(psp);
											        byte[]  buffer = new byte[1024] ;
											        try {
												        java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(fileZip));
												        java.util.zip.ZipEntry zipEntry = zis.getNextEntry();
												
												
												        while (zipEntry != null) {
													             java.io.File newFile = newFile(destDir, zipEntry);
													             if (zipEntry.isDirectory()) {
														                 if (!newFile.isDirectory() && !newFile.mkdirs()) {
															                     throw new java.io.IOException("Failed to create directory " + newFile);
															                 }
														             } else {
														                 // fix for Windows-created archives
														                 java.io.File parent = newFile.getParentFile();
														                 if (!parent.isDirectory() && !parent.mkdirs()) {
															                     throw new java.io.IOException("Failed to create directory " + parent);
															                 }
														
														                 // write file content
														                 java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
														                 int len;
														                 while ((len = zis.read(buffer)) > 0) {
															                     fos.write(buffer, 0, len);
															                 }
														                 fos.close();
														             }
													         zipEntry = zis.getNextEntry();
													        }
												        zis.closeEntry();
												        zis.close();
											} catch (Exception e) {
												  showMessage(e.toString());
												   }
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(5000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											fromStorage = false;
											             try {
														                 
												Uri uri = Uri.parse(pathToRealUri("/sdcard/psp/"));
												
												androidx.documentfile.provider.DocumentFile dfile = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), uri);
																	 
														androidx.documentfile.provider.DocumentFile file = dfile.findFile("psptoolsdata.zip");
												   android.provider.DocumentsContract.deleteDocument(getApplicationContext().getContentResolver(), file.getUri());
														///showMessage("Deleted ✔️ تم الحذف");
														                } catch (FileNotFoundException e) {
														              showMessage("not found 🚫 غير موجود");
														                } catch (Exception e2) {
														                }
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(9000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال استخراج دیتا .....");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(3000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال نصب دیتا ......");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(4000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال پاک سازی دیتا های غیر ضروری..");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(6000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.dismiss();
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(12000));
							progdialogninjacoder.show();
									        
								    } else {
								      
								    progdialogninjacoder = new ProgressDialog(FilesActivity.this);
							progdialogninjacoder.setTitle("Psp tools");
							progdialogninjacoder.setMessage("در حال اماده سازی...");
							copyOneFileFromAssets("psptoolsdata.zip", path);
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											final String _fileZip=("/sdcard/psp/psptoolsdata.zip");
											final String _destDir=(psp);
															
															try
															{
																	java.io.File outdir = new java.io.File(_destDir);
																	java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(_fileZip));
																	java.util.zip.ZipEntry entry;
																	String name, dir;
																	while ((entry = zin.getNextEntry()) != null)
																	{
																			name = entry.getName();
																			if(entry.isDirectory())
																			{
																					mkdirs(outdir, name);
																					continue;
																			}
																			
																			/* this part is necessary because file entry can come before
* directory entry where is file located
* i.e.:
* /foo/foo.txt
* /foo/
*/
																			
																			dir = dirpart(name);
																			if(dir != null)
																			mkdirs(outdir, dir);
																			
																			extractFile(zin, outdir, name);
																	}
																	zin.close();
															}
															catch (java.io.IOException e)
															{
																	e.printStackTrace();
															}
															
															
													}
													private  void extractFile(java.util.zip.ZipInputStream in, java.io.File outdir, String name) throws java.io.IOException
													{
															byte[] buffer = new byte[4096];
															java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(outdir, name)));
															int count = -1;
															while ((count = in.read(buffer)) != -1)
															out.write(buffer, 0, count);
															out.close();
													}
													
													private void mkdirs(java.io.File outdir, String path)
													{
															java.io.File d = new java.io.File(outdir, path);
															if(!d.exists())
															d.mkdirs();
													}
													
													private String dirpart(String name)
													{
															int s = name.lastIndexOf(java.io.File.separatorChar);
															return s == -1 ? null : name.substring(0, s);
														
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(5000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											FileUtil.deleteFile("/sdcard/psp/psptoolsdata.zip");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(9000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال استخراج دیتا .....");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(3000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال نصب دیتا ......");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(4000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.setMessage("در حال پاک سازی دیتا های غیر ضروری..");
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(6000));
							if_timerask = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											progdialogninjacoder.dismiss();
										}
									});
								}
							};
							_timer.schedule(if_timerask, (int)(12000));
							progdialogninjacoder.show();  
								    }
					}
					else {
						askPermission(pathToUri(psp));
					}
				} catch (Exception e) {
					 
				}
			}
		});
		
		_drawer_setting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sring.setClass(getApplicationContext(), SettingppssppActivity.class);
				startActivity(sring);
			}
		});
		
		_drawer_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				aubot.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(aubot);
			}
		});
		
		_drawer_about_your_mobile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mobile.setClass(getApplicationContext(), AboutMobileYouActivity.class);
				startActivity(mobile);
			}
		});
		
		_drawer_Telegram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Dialog.setTitle("PSP TOOLS");
				Dialog.setIcon(R.drawable.ic_splash);
				Dialog.setMessage("جهت حمایت کردن ما در تلگرام ما رو حمایت کنید با عضویت در کانال حمایت کننده و گروه و کانال سازنده برنامه جهت دریافت اپدیت های شگفت انگیز");
				Dialog.setPositiveButton("کانال تلگرام سازنده برنامه", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						telgp.setAction(Intent.ACTION_VIEW);
						telgp.setData(Uri.parse("https://t.me/psptoolsapp"));
						startActivity(telgp);
					}
				});
				Dialog.setNegativeButton("کانال حمایتی ما", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						main11.setAction(Intent.ACTION_VIEW);
						main11.setData(Uri.parse("https://t.me/ppsspp1"));
						startActivity(main11);
					}
				});
				Dialog.setNeutralButton("گروه ما", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						telch.setAction(Intent.ACTION_VIEW);
						telch.setData(Uri.parse("https://t.me/psptools"));
						startActivity(telch);
					}
				});
				Dialog.create().show();
			}
		});
		
		_drawer_shell.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				myshell.setClass(getApplicationContext(), ShellemuActivity.class);
				startActivity(myshell);
			}
		});
		
		_drawer_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
			}
		});
	}
	
	private void initializeLogic() {
		Folder = FileUtil.getExternalStorageDir();
		_RefreshData();
		if (true) {
			     getSupportActionBar().hide();
		}
		else {
					getSupportActionBar().show();
		}
		_drawer_vscroll2.setHorizontalScrollBarEnabled(false);
		_drawer_vscroll2.setVerticalScrollBarEnabled(false);
		_drawer_vscroll2.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
		
		listview2.setHorizontalScrollBarEnabled(false);
		listview2.setVerticalScrollBarEnabled(false);
		listview2.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
		textview1.setText(textview1.getText().toString());
		
		TextPaint paint = textview1.getPaint();
		
		float width = paint.measureText(textview1.getText().toString()); 
		
		Shader textShader = new LinearGradient(0, 0, width,textview1.getTextSize(), new int[]{ 
			
			Color.parseColor("#FFFFB100"), Color.parseColor("#FFFF8211"), 
			
			/*

 //More Colors 

Color.parseColor("#64B678"), Color.parseColor("#478AEA"), Color.parseColor("#8446CC"), 

*/
			
			
		}, null,Shader.TileMode.CLAMP); 
		
		/* By EPIC Technical Tricks YT */
		
		textview1.getPaint().setShader(textShader);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =FilesActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF212121);
		}
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
		 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFFFF5722".replace("0xFF" , "#"))));
		try {
			 if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
					      
				if (one.getString("y1", "").equals("")) {
					one.edit().putString("y1", "1").commit();
					final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
					View inflate = getLayoutInflater().inflate(R.layout.android11,null); 
					dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					dialog1.setView(inflate);
					androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview1);
					LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
					LinearLayout p1 = (LinearLayout) inflate.findViewById(R.id.p1);
					TextView no = (TextView) inflate.findViewById(R.id.no);
					TextView ok = (TextView) inflate.findViewById(R.id.ok);
					bg.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, 0xFFFFFFFF));
					p1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, 0xFFFF9800));
					cardview1.setCardBackgroundColor(0xFF424242);
					cardview1.setRadius((float)25);
					cardview1.setCardElevation((float)3);
					no.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									
								dialog1.dismiss();
							
							}
					});
					ok.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									
								path = "/sdcard/psp";
							if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
								    try {
									        
									       if (permission()) {	   
										if (FileUtil.isExistFile(path)) {
											FileUtil.makeDir(path);
										}          
												                } else {
												                  RequestPermission_Dialog();
										
												                }
									        
									        
									    } catch (Exception e) {
									               
									    }
										                
									         } else {
								
								if (FileUtil.isExistFile(path)) {
									FileUtil.makeDir(path);
								}
								
							}
							dialog1.dismiss();
							
							}
					});
					dialog1.setCancelable(false);
					dialog1.show();
				}
				else {
					
				}
						        
					    } else {
					      
					       
					    }
		} catch (Exception e) {
			 
		}
	}
	
	@Override
	public void onBackPressed() {
		w1.setTitle("Psp Tools");
		w1.setMessage("Exit in App?");
		w1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		w1.setNeutralButton("no", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		w1.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		setTheme(android.R.style.Theme_Material);
		
		_drawer_download.setImageResource(R.drawable.icon_game);
		_drawer_iconppsspp.setImageResource(R.drawable.iconppssppv2);
		_drawer_icongithub.setImageResource(R.drawable.newicongithub);
		_drawer_abouticon.setImageResource(R.drawable.aboutapp);
		_drawer_iconTelegram.setImageResource(R.drawable.newicontelegram);
		_drawer_setting_icon.setImageResource(R.drawable.newiconsetting);
		_drawer_iconabout_your_mobile.setImageResource(R.drawable.aboutphonenew);
		_drawer_iconexit.setImageResource(R.drawable.newiconexit);
		_drawer_iconshell.setImageResource(R.drawable.newiconshell);
		_drawer_iconpathdownload.setImageResource(R.drawable.psppathdownload);
		_drawer_iconkeyboard.setImageResource(R.drawable.keyboardpathernan);
		_fab.setImageResource(R.drawable.newiconsetting);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setNavigationBarColor(Color.parseColor("0xFF212121".replace("0xFF" , "#")));
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_gamedownload_path.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_gamedownload_path.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_ppsspp.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_ppsspp.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_githubs.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_githubs.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_linear17.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_linear17.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_setting.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_setting.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_about_your_mobile.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_about_your_mobile.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_Telegram.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_Telegram.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_shell.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_shell.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_keyboardinstall.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_keyboardinstall.setBackground(SketchUi_RD);
		}
		
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_exit.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_exit.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xBB424242);float lt = getDip(0);
			float rt = getDip(31);
			float rb = getDip(31);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			_drawer_about.setElevation(getDip(1));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFF9800}), SketchUi, null);
			_drawer_about.setBackground(SketchUi_RD);
		}
		Dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		dialog3 = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		dialogmain = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		w1 = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		ptexsert = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
	}
	public void _RefreshData() {
		
		File_map.clear();
		subtitle = Folder;
		FileUtil.listDir(Folder, liststring);
		Collections.sort(liststring, String.CASE_INSENSITIVE_ORDER);
		position = 0;
		for(int _repeat52 = 0; _repeat52 < (int)(liststring.size()); _repeat52++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", liststring.get((int)(position)));
				File_map.add(_item);
			}
			
			position++;
		}
		final class FileComparator implements Comparator<String> {
			public int compare(String f1, String f2) {
				if(f1 == f2) return 0;
				if(FileUtil.isDirectory(f1) && FileUtil.isFile(f2))
				return -1;
				if(FileUtil.isFile(f1) && FileUtil.isDirectory(f2))
				return 1;
				return f1.compareToIgnoreCase(f2);
			}
		}
		Collections.sort(liststring, new FileComparator());
		listview2.setAdapter(new Listview2Adapter(File_map));
		((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _getApkIcon(final String _path, final ImageView _imageview) {
		try { 
			
			
				
			android.content.pm.PackageManager packageManager = this.getPackageManager();
			android.content.pm.PackageInfo packageInfo = packageManager.getPackageArchiveInfo(_path, 0);
			packageInfo.applicationInfo.sourceDir = _path;
			packageInfo.applicationInfo.publicSourceDir = _path;
			_imageview.setImageDrawable(packageInfo.applicationInfo.loadIcon(packageManager));
			packageInfo = null;
			packageManager = null;
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void _setBitmapFromVideo(final ImageView _imageview, final String _path) {
		class ContextClass {
			
			private Context myContext;
			
			public ContextClass(Context activity) {
				myContext = activity;
			}
			
			public ContextClass(Fragment fragment) {
				myContext = fragment.getActivity();
			}
			
			public ContextClass(DialogFragment fragment) {
				myContext = fragment.getActivity();
			}
			
			public final Context getContext() {
				return myContext;
			}
		}
		_imageview.setImageBitmap(new VideoThumbnail(new ContextClass(this).getContext()).fromPath(_path));
	}
	
	
	public void _mm() {
	}
	/*
Code Edited by Hichem Soft
The Code Fixed By Ninja Coder
youtube channel : Hichem Soft
*/
	@Override
	    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		  super.onActivityResult(_requestCode, _resultCode, _data);
		            
		if (_requestCode == new_folder){
			    if (_resultCode == Activity.RESULT_OK) {
				            if (_data != null) {
					              final Uri uri2 = _data.getData();
					if (Uri.decode(uri2.toString()).endsWith(":")) {
						SketchwareUtil.showMessage(getApplicationContext(), "⛔");
						askPermission(uri2.toString());
					}
					else {
						final int takeFlags = i.getFlags()
						            & (Intent.FLAG_GRANT_READ_URI_PERMISSION
						            | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						// Check for the freshest data.
						getContentResolver().takePersistableUriPermission(uri2, takeFlags);
						
						
						 
						
						
					}
					
					       } else {
					        
					   }
				       } else {
				      
				 
				 
				   }
		}
		
		
		if (_requestCode == 2000) {
				      if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
						        if (Environment.isExternalStorageManager()) {
								          
								        } else {
								
								        }
						      }
				    
		}
		
		
		
		       
		
	}
	
	// solve android 11 sdcard permissions
	
	
	 public void RequestPermission_Dialog() {
		    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
				      try {
						        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        intent.addCategory("android.intent.category.DEFAULT");
						        intent.setData(Uri.parse(String.format("package: ", new Object[]{getApplicationContext().getPackageName()})));
						        startActivityForResult(intent, 2000);
						      } catch (Exception e) {
						        Intent obj = new Intent();
						        obj.setAction(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        startActivityForResult(obj, 2000);
						      }
				    } else {
				      androidx.core.app.ActivityCompat.requestPermissions(FilesActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
				    }
		  }
	
	  public boolean permission() {
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) { // R is Android 11
				      return Environment.isExternalStorageManager();
				    } else {
				      int write = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
				      int read = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
				
				      return write == android.content.pm.PackageManager.PERMISSION_GRANTED
				          && read == android.content.pm.PackageManager.PERMISSION_GRANTED;
				    }
	} 
	
	// ask permissions request
	
	public void askPermission(final String _uri) {
			
		if (fromStorage) {
			i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
		}
			i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						i.setAction(Intent.ACTION_OPEN_DOCUMENT_TREE);
						    i.putExtra(android.provider.DocumentsContract.EXTRA_INITIAL_URI, Uri.parse(_uri));
						        startActivityForResult(i, new_folder);
		}
	
	// check permissions of path if accepted 
	
	
	public boolean checkPermission(final String _uri) {
				Uri muri = Uri.parse(_uri);
				    dFile = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), muri);
				                    
				if (dFile.canRead() && dFile.canWrite()) {
						return true ;
				}
				return false ;
		}
	
	// simple path to UriTree path
	
	
	public String pathToRealUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}	
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	
	// simple path to UriTree path 2
	
	public String pathToUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3AAndroid/document/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	// ccopy file from path to path
	
	private boolean copyAsset(final String assetFilename, final Uri targetUri) {
		  			try{
			  				int count;
			  				InputStream input = null;
					OutputStream output = null;
			  				
			  				ContentResolver content = getApplicationContext().getContentResolver();
						  
			            input = getApplicationContext().getAssets().open(assetFilename);
						
			            output = content.openOutputStream(targetUri);
			            
			            
			  				byte data[] = new byte[1024];
			  				while ((count = input.read(data))>0) {
				  					output.write(data, 0, count);
				  			}
			  				output.flush();
			  				output.close();
			  				input.close();
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), "success ✔️ نجاح ");
							 
			  		}catch(Exception e){
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), e.toString());
							  return false;
			  		}
		
		return true;
	}
	
	
	public boolean copyFiles(Context context, Uri fileUri, Uri targetUri)
	    {
		        		InputStream is = null;
				OutputStream os = null;
		
		
		try {
					try {
							
				ContentResolver content = context.getContentResolver();
				            is = content.openInputStream(fileUri);
				            os = content.openOutputStream(targetUri);
							           
				        byte[] buffer = new byte[1024];
				        int length;
				        while ((length = is.read(buffer)) > 0) {
					            os.write(buffer, 0, length);
					        }
							
				    } finally {
				        is.close();
				        os.close();
				    } 
		} catch (IOException e) {
								return false;
					}
			
		return true;
	}
	
	
	private boolean fromStorage = false;
	  final static int REQUEST_CODE = 333;
	  final static  int OLD_REQUEST = 2000;
	  private SharedPreferences sha;
	private Intent ninjacoderuser = new Intent();
		private  Uri muri;
		private String uriFor1 = "";
		private String uriFor2 = "";
		private  
		androidx.documentfile.provider.DocumentFile dFile;
		private double PermissionNumber;
		private  static final int new_folder = 43;
	{
	}
	
	
	public void _classgif() {
	}
	
	public class GifDecoder {
		
		    public static final int STATUS_OK = 0;
		
		    public static final int STATUS_FORMAT_ERROR = 1;
		
		    public static final int STATUS_OPEN_ERROR = 2;
		
		    protected static final int MAX_STACK_SIZE = 4096;
		    protected InputStream in;
		    protected int status;
		    protected int width; // full image width
		    protected int height; // full image height
		    protected boolean gctFlag; // global color table used
		    protected int gctSize; // size of global color table
		    protected int loopCount = 1; // iterations; 0 = repeat forever
		    protected int[] gct; // global color table
		    protected int[] lct; // local color table
		    protected int[] act; // active color table
		    protected int bgIndex; // background color index
		    protected int bgColor; // background color
		    protected int lastBgColor; // previous bg color
		    protected int pixelAspect; // pixel aspect ratio
		    protected boolean lctFlag; // local color table flag
		    protected boolean interlace; // interlace flag
		    protected int lctSize; // local color table size
		    protected int ix, iy, iw, ih; // current image rectangle
		    protected int lrx, lry, lrw, lrh;
		    protected Bitmap image; // current frame
		    protected Bitmap lastBitmap; // previous frame
		    protected byte[] block = new byte[256]; // current data block
		    protected int blockSize = 0; // block size last graphic control extension info
		    protected int dispose = 0; // 0=no action; 1=leave in place; 2=restore to bg; 3=restore to prev
		    protected int lastDispose = 0;
		    protected boolean transparency = false; // use transparent color
		    protected int delay = 0; // delay in milliseconds
		    protected int transIndex; // transparent color index
		    // LZW decoder working arrays
		    protected short[] prefix;
		    protected byte[] suffix;
		    protected byte[] pixelStack;
		    protected byte[] pixels;
		    protected Vector<GifFrame> frames; // frames read from current file
		    protected int frameCount;
		
		    private  class GifFrame {
			            public GifFrame(Bitmap im, int del) {
				                    image = im;
				                    delay = del;
				            }
			
			            public Bitmap image;
			            public int delay;
			    }
		
		
		    public int getDelay(int n) {
			            delay = -1;
			            if ((n >= 0) && (n < frameCount)) {
				                    delay = frames.elementAt(n).delay;
				            }
			            return delay;
			    }
		
		
		    public int getFrameCount() {
			            return frameCount;
			    }
		
		
		    public Bitmap getBitmap() {
			            return getFrame(0);
			    }
		
		
		    public int getLoopCount() {
			            return loopCount;
			    }
		    protected void setPixels() {
			
			            int[] dest = new int[width * height];
			
			            if (lastDispose > 0) {
				                    if (lastDispose == 3) {
					                            // use image before last
					                            int n = frameCount - 2;
					                            if (n > 0) {
						                                    lastBitmap = getFrame(n - 1);
						                            } else {
						                                    lastBitmap = null;
						                            }
					                    }
				                    if (lastBitmap != null) {
					                            lastBitmap.getPixels(dest, 0, width, 0, 0, width, height);
					                            if (lastDispose == 2) {
						                                    // fill last image rect area with background color
						                                    int c = 0;
						                                    if (!transparency) {
							                                            c = lastBgColor;
							                                    }
						                                    for (int i = 0; i < lrh; i++) {
							                                            int n1 = (lry + i) * width + lrx;
							                                            int n2 = n1 + lrw;
							                                            for (int k = n1; k < n2; k++) {
								                                                    dest[k] = c;
								                                            }
							                                    }
						                            }
					                    }
				            }
			            int pass = 1;
			            int inc = 8;
			            int iline = 0;
			            for (int i = 0; i < ih; i++) {
				                    int line = i;
				                    if (interlace) {
					                            if (iline >= ih) {
						                                    pass++;
						                                    switch (pass) {
							                                    case 2:
							                                            iline = 4;
							                                            break;
							                                    case 3:
							                                            iline = 2;
							                                            inc = 4;
							                                            break;
							                                    case 4:
							                                            iline = 1;
							                                            inc = 2;
							                                            break;
							                                    default:
							                                            break;
							                                    }
						                            }
					                            line = iline;
					                            iline += inc;
					                    }
				                    line += iy;
				                    if (line < height) {
					                            int k = line * width;
					                            int dx = k + ix; // start of line in dest
					                            int dlim = dx + iw; // end of dest line
					                            if ((k + width) < dlim) {
						                                    dlim = k + width; // past dest edge
						                            }
					                            int sx = i * iw; // start of line in source
					                            while (dx < dlim) {
						                                    // map color and insert in destination
						                                    int index = ((int) pixels[sx++]) & 0xff;
						                                    int c = act[index];
						                                    if (c != 0) {
							                                            dest[dx] = c;
							                                    }
						                                    dx++;
						                            }
					                    }
				            }
			            image = Bitmap.createBitmap(dest, width, height, android.graphics.Bitmap.Config.ARGB_4444);
			    }
		    public Bitmap getFrame(int n) {
			            if (frameCount <= 0)
			                    return null;
			            n = n % frameCount;
			            return ((GifFrame) frames.elementAt(n)).image;
			    }
		    public int read(InputStream is) {
			            init();
			            if (is != null) {
				                    in = is;
				                    readHeader();
				                    if (!err()) {
					                            readContents();
					                            if (frameCount < 0) {
						                                    status = STATUS_FORMAT_ERROR;
						                            }
					                    }
				            } else {
				                    status = STATUS_OPEN_ERROR;
				            }
			            try {
				                    is.close();
				            } catch (Exception e) {
				            }
			            return status;
			    }      
		    protected void decodeBitmapData() {
			            int nullCode = -1;
			            int npix = iw * ih;
			            int available, clear, code_mask, code_size, end_of_information, in_code, old_code, bits, code, count, i, datum, data_size, first, top, bi, pi;
			            if ((pixels == null) || (pixels.length < npix)) {
				                    pixels = new byte[npix]; // allocate new pixel array
				            }
			            if (prefix == null) {
				                    prefix = new short[MAX_STACK_SIZE];
				            }
			            if (suffix == null) {
				                    suffix = new byte[MAX_STACK_SIZE];
				            }
			            if (pixelStack == null) {
				                    pixelStack = new byte[MAX_STACK_SIZE + 1];
				            }                
			            data_size = read();
			            clear = 1 << data_size;
			            end_of_information = clear + 1;
			            available = clear + 2;
			            old_code = nullCode;
			            code_size = data_size + 1;
			            code_mask = (1 << code_size) - 1;
			            for (code = 0; code < clear; code++) {
				                    prefix[code] = 0; // XXX ArrayIndexOutOfBoundsException
				                    suffix[code] = (byte) code;
				            }               
			            datum = bits = count = first = top = pi = bi = 0;
			            for (i = 0; i < npix;) {
				                    if (top == 0) {
					                            if (bits < code_size) {
						                                    // Load bytes until there are enough bits for a code.
						                                    if (count == 0) {
							                                            // Read a new data block.
							                                            count = readBlock();
							                                            if (count <= 0) {
								                                                    break;
								                                            }
							                                            bi = 0;
							                                    }
						                                    datum += (((int) block[bi]) & 0xff) << bits;
						                                    bits += 8;
						                                    bi++;
						                                    count--;
						                                    continue;
						                            }                               
					                            code = datum & code_mask;
					                            datum >>= code_size;
					                            bits -= code_size;                               
					                            if ((code > available) || (code == end_of_information)) {
						                                    break;
						                            }
					                            if (code == clear) {
						                                    // Reset decoder.
						                                    code_size = data_size + 1;
						                                    code_mask = (1 << code_size) - 1;
						                                    available = clear + 2;
						                                    old_code = nullCode;
						                                    continue;
						                            }
					                            if (old_code == nullCode) {
						                                    pixelStack[top++] = suffix[code];
						                                    old_code = code;
						                                    first = code;
						                                    continue;
						                            }
					                            in_code = code;
					                            if (code == available) {
						                                    pixelStack[top++] = (byte) first;
						                                    code = old_code;
						                            }
					                            while (code > clear) {
						                                    pixelStack[top++] = suffix[code];
						                                    code = prefix[code];
						                            }
					                            first = ((int) suffix[code]) & 0xff;
					                            if (available >= MAX_STACK_SIZE) {
						                                    break;
						                            }
					                            pixelStack[top++] = (byte) first;
					                            prefix[available] = (short) old_code;
					                            suffix[available] = (byte) first;
					                            available++;
					                            if (((available & code_mask) == 0) && (available < MAX_STACK_SIZE)) {
						                                    code_size++;
						                                    code_mask += available;
						                            }
					                            old_code = in_code;
					                    }
				                    // Pop a pixel off the pixel stack.
				                    top--;
				                    pixels[pi++] = pixelStack[top];
				                    i++;
				            }
			            for (i = pi; i < npix; i++) {
				                    pixels[i] = 0; // clear missing pixels
				            }
			    }        
		    protected boolean err() {
			            return status != STATUS_OK;
			    }       
		    protected void init() {
			            status = STATUS_OK;
			            frameCount = 0;
			            frames = new Vector<GifFrame>();
			            gct = null;
			            lct = null;
			    }        
		    protected int read() {
			            int curByte = 0;
			            try {
				                    curByte = in.read();
				            } catch (Exception e) {
				                    status = STATUS_FORMAT_ERROR;
				            }
			            return curByte;
			    }       
		    protected int readBlock() {
			            blockSize = read();
			            int n = 0;
			            if (blockSize > 0) {
				                    try {
					                            int count = 0;
					                            while (n < blockSize) {
						                                    count = in.read(block, n, blockSize - n);
						                                    if (count == -1) {
							                                            break;
							                                    }
						                                    n += count;
						                            }
					                    } catch (Exception e) {
					                            e.printStackTrace();
					                    }
				                    if (n < blockSize) {
					                            status = STATUS_FORMAT_ERROR;
					                    }
				            }
			            return n;
			    }        
		    protected int[] readColorTable(int ncolors) {
			            int nbytes = 3 * ncolors;
			            int[] tab = null;
			            byte[] c = new byte[nbytes];
			            int n = 0;
			            try {
				                    n = in.read(c);
				            } catch (Exception e) {
				                    e.printStackTrace();
				            }
			            if (n < nbytes) {
				                    status = STATUS_FORMAT_ERROR;
				            } else {
				                    tab = new int[256]; // max size to avoid bounds checks
				                    int i = 0;
				                    int j = 0;
				                    while (i < ncolors) {
					                            int r = ((int) c[j++]) & 0xff;
					                            int g = ((int) c[j++]) & 0xff;
					                            int b = ((int) c[j++]) & 0xff;
					                            tab[i++] = 0xff000000 | (r << 16) | (g << 8) | b;
					                    }
				            }
			            return tab;
			    }       
		    protected void readContents() {
			            // read GIF file content blocks
			            boolean done = false;
			            while (!(done || err())) {
				                    int code = read();
				                    switch (code) {
					                    case 0x2C: // image separator
					                            readBitmap();
					                            break;
					                    case 0x21: // extension
					                            code = read();
					                            switch (code) {
						                            case 0xf9: // graphics control extension
						                                    readGraphicControlExt();
						                                    break;
						                            case 0xff: // application extension
						                                    readBlock();
						                                    String app = "";
						                                    for (int i = 0; i < 11; i++) {
							                                            app += (char) block[i];
							                                    }
						                                    if (app.equals("NETSCAPE2.0")) {
							                                            readNetscapeExt();
							                                    } else {
							                                            skip(); // don't care
							                                    }
						                                    break;
						                            case 0xfe:// comment extension
						                                    skip();
						                                    break;
						                            case 0x01:// plain text extension
						                                    skip();
						                                    break;
						                            default: // uninteresting extension
						                                    skip();
						                            }
					                            break;
					                    case 0x3b: // terminator
					                            done = true;
					                            break;
					                    case 0x00: // bad byte, but keep going and see what happens break;
					                    default:
					                            status = STATUS_FORMAT_ERROR;
					                    }
				            }
			    }      
		    protected void readGraphicControlExt() {
			            read(); // block size
			            int packed = read(); // packed fields
			            dispose = (packed & 0x1c) >> 2; // disposal method
			            if (dispose == 0) {
				                    dispose = 1; // elect to keep old image if discretionary
				            }
			            transparency = (packed & 1) != 0;
			            delay = readShort() * 10; // delay in milliseconds
			            transIndex = read(); // transparent color index
			            read(); // block terminator
			    }       
		    protected void readHeader() {
			            String id = "";
			            for (int i = 0; i < 6; i++) {
				                    id += (char) read();
				            }
			            if (!id.startsWith("GIF")) {
				                    status = STATUS_FORMAT_ERROR;
				                    return;
				            }
			            readLSD();
			            if (gctFlag && !err()) {
				                    gct = readColorTable(gctSize);
				                    bgColor = gct[bgIndex];
				            }
			    }        
		    protected void readBitmap() {
			            ix = readShort(); // (sub)image position & size
			            iy = readShort();
			            iw = readShort();
			            ih = readShort();
			            int packed = read();
			            lctFlag = (packed & 0x80) != 0; // 1 - local color table flag interlace
			            lctSize = (int) Math.pow(2, (packed & 0x07) + 1);
			            interlace = (packed & 0x40) != 0;
			            if (lctFlag) {
				                    lct = readColorTable(lctSize); // read table
				                    act = lct; // make local table active
				            } else {
				                    act = gct; // make global table active
				                    if (bgIndex == transIndex) {
					                            bgColor = 0;
					                    }
				            }
			            int save = 0;
			            if (transparency) {
				                    save = act[transIndex];
				                    act[transIndex] = 0; // set transparent color if specified
				            }
			            if (act == null) {
				                    status = STATUS_FORMAT_ERROR; // no color table defined
				            }
			            if (err()) {
				                    return;
				            }
			            decodeBitmapData(); // decode pixel data
			            skip();
			            if (err()) {
				                    return;
				            }
			            frameCount++;
			            // create new image to receive frame data
			            image = Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_4444);
			            setPixels(); // transfer pixel data to image
			            frames.addElement(new GifFrame(image, delay)); // add image to frame
			            // list
			            if (transparency) {
				                    act[transIndex] = save;
				            }
			            resetFrame();
			    }
		    protected void readLSD() {
			            // logical screen size
			            width = readShort();
			            height = readShort();
			            // packed fields
			            int packed = read();
			            gctFlag = (packed & 0x80) != 0; // 1 : global color table flag
			            // 2-4 : color resolution
			            // 5 : gct sort flag
			            gctSize = 2 << (packed & 7); // 6-8 : gct size
			            bgIndex = read(); // background color index
			            pixelAspect = read(); // pixel aspect ratio
			    }       
		    protected void readNetscapeExt() {
			            do {
				                    readBlock();
				                    if (block[0] == 1) {
					                            // loop count sub-block
					                            int b1 = ((int) block[1]) & 0xff;
					                            int b2 = ((int) block[2]) & 0xff;
					                            loopCount = (b2 << 8) | b1;
					                    }
				            } while ((blockSize > 0) && !err());
			    }       
		    protected int readShort() {
			            // read 16-bit value, LSB first
			            return read() | (read() << 8);
			    }
		    protected void resetFrame() {
			            lastDispose = dispose;
			            lrx = ix;
			            lry = iy;
			            lrw = iw;
			            lrh = ih;
			            lastBitmap = image;
			            lastBgColor = bgColor;
			            dispose = 0;
			            transparency = false;
			            delay = 0;
			            lct = null;
			    }
		    protected void skip() {
			            do {
				                    readBlock();
				            } while ((blockSize > 0) && !err());
			    }
	}
	
	public class GifDecoderView extends ImageView {
		
		private boolean mIsPlayingGif = false;
		
		private GifDecoder mGifDecoder;
		
		private Bitmap mTmpBitmap;
		
		final Handler mHandler = new Handler();
		
		
		    
		
		final Runnable mUpdateResults = new Runnable() {
			    public void run() {
				        if (mTmpBitmap != null && !mTmpBitmap.isRecycled()) {
					            GifDecoderView.this.setImageBitmap(mTmpBitmap);
					        }
				    }
		};
		
		public GifDecoderView(Context context, InputStream stream) {
			    super(context);
			    playGif(stream);
		}
		
		private void playGif(InputStream stream) {
			    mGifDecoder = new GifDecoder();
			    mGifDecoder.read(stream);
			
			    mIsPlayingGif = true;
			
			    new Thread(new Runnable() {
				        public void run() {
					            final int n = mGifDecoder.getFrameCount();
					            final int ntimes = mGifDecoder.getLoopCount();
					            int repetitionCounter = 0;
					            do {
						                for (int i = 0; i < n; i++) {
							                    mTmpBitmap = mGifDecoder.getFrame(i);
							                    int t = mGifDecoder.getDelay(i);
							                    mHandler.post(mUpdateResults);
							                    try {
								                        Thread.sleep(t);
								                    } catch (InterruptedException e) {
								                        e.printStackTrace();
								                    }
							                }
						                if(ntimes != 0) {
							                    repetitionCounter ++;
							                }
						            } while (mIsPlayingGif && (repetitionCounter <= ntimes));
					        }
				    }).start();
		}
		
		public void stopRendering() {
			    mIsPlayingGif = true;
		}
	}
	
	public class GifMovieView extends View {
		
		private Movie mMovie;
		
		private long mMoviestart;
		
		public GifMovieView(Context context, InputStream stream) {
			    super(context);
			
			    mMovie = Movie.decodeStream(stream);        
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			    canvas.drawColor(Color.TRANSPARENT);
			    super.onDraw(canvas);
			    final long now = SystemClock.uptimeMillis();
			
			    if (mMoviestart == 0) { 
				        mMoviestart = now;
				    }
			
			    final int relTime = (int)((now - mMoviestart) % mMovie.duration());
			    mMovie.setTime(relTime);
			    mMovie.draw(canvas, 10, 10);
			    this.invalidate();
		}
	}
	
	{
	}
	
	
	public void _CircleImage(final ImageView _view, final double _radius) {
		Bitmap bm = ((android.graphics.drawable.BitmapDrawable)_view.getDrawable()).getBitmap();
		
		_view.setImageBitmap(getRoundedCornerBitmap(bm, ((int)_radius)));
		
	}
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = pixels;
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint); 
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN)); 
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}
	
	
	public void _asster() {
	}
	private void copyAllFilesAssets(String assetsFolder, String outPath) {
		    AssetManager assetManager = getAssets();
		    String[] files = null;
		    try {
			        files = assetManager.list(assetsFolder);
			    } catch (java.io.IOException e) {
			        
			    }
		    if (files != null) for (String filename : files) {
			        java.io.InputStream in = null;
			        java.io.OutputStream out = null;
			        try {
				          in = assetManager.open(assetsFolder+"/"+filename);
				          java.io.File outFile = new java.io.File(outPath, filename);
				          if (!(outFile.exists())) {// File does not exist...
					                out = new java.io.FileOutputStream(outFile);
					                copyFile(in, out);
					                showMessage("success !");
					          }
				        } catch(java.io.IOException e) {
				            showMessage(e.toString());
				        }     
			        finally {
				            if (in != null) {
					                try {
						                    in.close();
						                } catch (java.io.IOException e) {
						                    // NOOP
						                }
					            }
				            if (out != null) {
					                try {
						                    out.close();
						                } catch (java.io.IOException e) {
						                    // NOOP
						                }
					            }
				        }  
			    }
	}
	private void copyFile(java.io.InputStream in, java.io.OutputStream out) throws java.io.IOException {
		    byte[] buffer = new byte[1024];
		    int read;
		    while((read = in.read(buffer)) != -1){
			      out.write(buffer, 0, read);
			    }
	}
	
	private void copyOneFileFromAssets(final String assetFilename, final String assetSavePath) {
		  			try{
			  				int count;
			  				java.io.InputStream input = getAssets().open(assetFilename);
			  				java.io.OutputStream output = new  java.io.FileOutputStream(assetSavePath+"/"+assetFilename);
			  				byte data[] = new byte[1024];
			  				while ((count = input.read(data))>0) {
				  					output.write(data, 0, count);
				  			}
			  				output.flush();
			  				output.close();
			  				input.close();
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), "success ");
			  		}catch(Exception e){
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), "failed !");
			  		}
	}
	{
	}
	
	
	public void _unzip() {
	}
	private boolean zipEntryMatch(String zeName, java.io.File[]  files, String path){
		    for(int i = 0; i < files.length; i++){
			        if((path + files[i] .getName()).equals(zeName)){
				            return true;
				        }
			    }
		    return false;
	}
	
	    public static class ZipUtils {
		
		        private final List<java.io.File> fileList;
		
		        private List<String> paths;
		
		        public ZipUtils() {
			            fileList = new ArrayList<>();
			            paths = new ArrayList<>(25);
			        }
		
		        public void zipIt(java.io.File sourceFile, java.io.File zipFile) {
			            if (sourceFile.isDirectory()) {
				                byte[]  buffer = new byte[1024] ;
				                java.io.FileOutputStream fos = null;
				                java.util.zip.ZipOutputStream zos = null;
				
				                try {
					
					
					
					                    String sourcePath = sourceFile.getParentFile().getPath();
					                    generateFileList(sourceFile);
					
					                    fos = new java.io.FileOutputStream(zipFile);
					                    zos = new java.util.zip.ZipOutputStream(fos);
					
					                    System.out.println("Output to Zip : " + zipFile);
					                    java.io.FileInputStream in = null;
					
					                    for (java.io.File file : this.fileList) {
						                        String path = file.getParent().trim();
						                        path = path.substring(sourcePath.length());
						
						                        if (path.startsWith(java.io.File.separator)) {
							                            path = path.substring(1);
							                        }
						
						                        if (path.length() > 0) {
							                            if (!paths.contains(path)) {
								                                paths.add(path);
								                                java.util.zip.ZipEntry ze = new java.util.zip.ZipEntry(path + "");
								                                zos.putNextEntry(ze);
								                                zos.closeEntry();
								                            }
							                            path += "/";
							                        }
						
						                        String entryName = path.substring((int)(0), (int)(path.lastIndexOf("/")))+ "/" + file.getName();
						                        System.out.println("File Added : " + entryName);
						                        java.util.zip.ZipEntry ze = new java.util.zip.ZipEntry(entryName);
						
						                        zos.putNextEntry(ze);
						                        try {
							                            in = new java.io.FileInputStream(file);
							                            int len;
							                            while ((len = in.read(buffer)) > 0) {
								                                zos.write(buffer, 0, len);
								                            }
							                        } finally {
							                            in.close();
							                        }
						                    }
					
					                    zos.closeEntry();
					                    System.out.println("Folder successfully compressed");
					
					                } catch (java.io.IOException ex) {
					                    ex.printStackTrace();
					                } finally {
					                    try {
						                        zos.close();
						                    } catch (java.io.IOException e) {
						                        e.printStackTrace();
						                    }
					                }
				            }
			        }
		
		        protected void generateFileList(java.io.File node) {
			
			            if (node.isFile()) {
				                fileList.add(node);
				            }
			            if (node.isDirectory()) {
				                java.io.File[]  subNote = node.listFiles();
				                for (java.io.File filename : subNote) {
					                    generateFileList(filename);
					                }
				            }
			        }
		    }
	public  java.io.File newFile(java.io.File destinationDir, java.util.zip.ZipEntry zipEntry) throws java.io.IOException {
		    java.io.File destFile = new java.io.File(destinationDir, zipEntry.getName());
		
		    String destDirPath = destinationDir.getCanonicalPath();
		    String destFilePath = destFile.getCanonicalPath();
		
		    if (!destFilePath.startsWith(destDirPath + java.io.File.separator)) {
			        throw new java.io.IOException("Entry is outside of the target dir: " + zipEntry.getName());
			    }
		
		    return destFile;
	}
	
	
	public void _file() {
		dialogmain.setTitle("فایل جدید");
		dialogmain.setIcon(R.drawable.ptdata);
		dialogmain.setMessage("ایا میخواهید یک فایل جدید ایجاد کنید؟");
		final EditText edittext2= new EditText(FilesActivity.this);
		LinearLayout.LayoutParams lparr = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		edittext2.setHint("name file...");
		edittext2.setHintTextColor(0xFF000000);
		edittext2.setTextSize((float)16);
		edittext2.setTextColor(0xFFF44336);
		((EditText)edittext2).setError("Error plestype text");
		edittext2.setLayoutParams(lparr);
		dialogmain.setView(edittext2);
		dialogmain.setPositiveButton("بله", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				try {
					
					mainfile = edittext2.getText().toString();
					if (mainfile.equals("")) {
						_file();
					}
					else {
						if (!mainfile.contains("/")) {
							FileUtil.writeFile(Folder.concat("/".concat(mainfile)), "");
							_RefreshData();
						}
						else {
							if (FileUtil.isExistFile(Folder.concat("/".concat(mainfile)))) {
								_RefreshData();
							}
							else {
								
							}
							_RefreshData();
						}
					}
				} catch (Exception e) {
					 
				}
			}
		});
		dialogmain.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialogmain.create().show();
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom_files, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear13 = _view.findViewById(R.id.linear13);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xBB424242);SketchUi.setCornerRadius(getDip(9));
				linear1.setElevation(getDip(5));
				android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFF44336}), SketchUi, null);
				linear1.setBackground(SketchUi_RD);
			}
			
			textview1.setText(textview1.getText().toString());
			
			TextPaint paint = textview1.getPaint();
			
			float width = paint.measureText(textview1.getText().toString()); 
			
			Shader textShader = new LinearGradient(0, 0, width,textview1.getTextSize(), new int[]{ 
				
				Color.parseColor("#FFFFB100"), Color.parseColor("#FFFF8211"), 
				
				/*

 //More Colors 

Color.parseColor("#64B678"), Color.parseColor("#478AEA"), Color.parseColor("#8446CC"), 

*/
				
				
			}, null,Shader.TileMode.CLAMP); 
			
			/* By EPIC Technical Tricks YT */
			
			textview1.getPaint().setShader(textShader);
			if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
				imageview1.setImageResource(R.drawable.folder);
			}
			else {
				if (liststring.get((int)(_position)).endsWith(".png") || liststring.get((int)(_position)).endsWith(".jpg")) {
					imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".tk") || liststring.get((int)(_position)).endsWith(".tk")) {
						imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
					}
					else {
						if (liststring.get((int)(_position)).endsWith(".mp4") || (liststring.get((int)(_position)).endsWith(".acc") || liststring.get((int)(_position)).endsWith(".mp5"))) {
							_setBitmapFromVideo(imageview1, liststring.get((int)(_position)));
						}
						else {
							if (liststring.get((int)(_position)).endsWith(".ini")) {
								imageview1.setImageResource(R.drawable.inipath);
							}
							else {
								/////
								if (liststring.get((int)(_position)).endsWith(".nomedia")) {
									imageview1.setImageResource(R.drawable.unknown);
								}
								else {
									if (liststring.get((int)(_position)).endsWith(".ISO") || liststring.get((int)(_position)).endsWith(".iso")) {
										imageview1.setImageResource(R.drawable.isofile);
									}
									else {
										if (liststring.get((int)(_position)).endsWith(".cso")) {
											imageview1.setImageResource(R.drawable.csofile);
										}
										else {
											if (liststring.get((int)(_position)).endsWith(".zip")) {
												imageview1.setImageResource(R.drawable.zipfile);
											}
											else {
												if (liststring.get((int)(_position)).endsWith(".rar")) {
													imageview1.setImageResource(R.drawable.rarfile);
												}
												else {
													if (liststring.get((int)(_position)).endsWith(".apk")) {
														_getApkIcon(liststring.get((int)(_position)), imageview1);
													}
													else {
														if (liststring.get((int)(_position)).endsWith(".xml") || (liststring.get((int)(_position)).endsWith(".txt") || liststring.get((int)(_position)).endsWith(".json"))) {
															imageview1.setImageResource(R.drawable.xml_code);
														}
														else {
															if (liststring.get((int)(_position)).endsWith(".gif")) {
																imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
															}
															else {
																if (liststring.get((int)(_position)).endsWith(".lua")) {
																	imageview1.setImageResource(R.drawable.languagelua);
																}
																else {
																	if (liststring.get((int)(_position)).endsWith(".cpp")) {
																		imageview1.setImageResource(R.drawable.languagecpp);
																	}
																	else {
																		if (liststring.get((int)(_position)).endsWith(".java")) {
																			imageview1.setImageResource(R.drawable.languagejava);
																		}
																		else {
																			if (liststring.get((int)(_position)).endsWith(".go")) {
																				imageview1.setImageResource(R.drawable.languagego);
																			}
																			else {
																				if (liststring.get((int)(_position)).endsWith(".py")) {
																					imageview1.setImageResource(R.drawable.languagepython);
																				}
																				else {
																					if (liststring.get((int)(_position)).endsWith(".mp3")) {
																						hsi = liststring.get((int)(_position));
																						
																					}
																					else {
																						if (liststring.get((int)(_position)).endsWith(".pt")) {
																							imageview1.setImageResource(R.drawable.ptdata);
																						}
																						else {
																							imageview1.setImageResource(R.drawable.file);
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			try {
				//ARGHOZALI
				
				Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(700); linear1.startAnimation(animation); animation = null;
			} catch (Exception e) {
				 
			}
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}