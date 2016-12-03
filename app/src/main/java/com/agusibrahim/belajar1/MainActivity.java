package com.agusibrahim.belajar1;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v4.widget.*;
import android.support.v7.widget.*;
import android.support.design.widget.*;
import android.view.*;
import android.support.v4.view.*;
import android.widget.Toast;
import android.content.res.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.agusibrahim.belajar1.Fragment.*;

public class MainActivity extends AppCompatActivity 
{
	private DrawerLayout mDrawer;
	private Toolbar toolbar;
	private NavigationView nvDrawer;
	private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		toolbar=(Toolbar) findViewById(R.id.mytoolbar);
		setSupportActionBar(toolbar);
		mDrawer=(DrawerLayout) findViewById(R.id.drawer_layout);
		nvDrawer=(NavigationView) findViewById(R.id.naView);
		setupDrawer(nvDrawer);
		drawerToggle= setupDrawerToggle();
		mDrawer.addDrawerListener(drawerToggle);
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.konten, new Frag1()).commit();
		nvDrawer.getMenu().getItem(0).setChecked(true);
    }
	private void setupDrawer(NavigationView nview){
		nview.setNavigationItemSelectedListener(
			new NavigationView.OnNavigationItemSelectedListener(){
				public boolean onNavigationItemSelected(MenuItem menu){
					Terpilih(menu);
					return true;
				}
			});
	}
	private ActionBarDrawerToggle setupDrawerToggle(){
		return new ActionBarDrawerToggle(this, mDrawer, toolbar,
		R.string.drawer_buka, R.string.drawer_tutup);
	}
	private void Terpilih(MenuItem menu){
		Class fragclass=Frag1.class;
		Fragment frag = null;
		switch(menu.getItemId()){
			case R.id.frag1:
				fragclass=Frag1.class;
				break;
			case R.id.frag2:
				fragclass=Frag2.class;
				break;
			case R.id.frag3:
				fragclass=Frag3.class;
				break;
			case R.id.frag4:
				fragclass=Frag4.class;
				break;
		}
		try{
			frag=(Fragment) fragclass.newInstance();
		}catch(Exception e){}
		FragmentManager fm=getSupportFragmentManager();
		fm.beginTransaction().replace(R.id.konten, frag).commit();
		menu.setChecked(true);
		setTitle(menu.getTitle());
		mDrawer.closeDrawers();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){
			case android.R.id.home:
				mDrawer.openDrawer(GravityCompat.START);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
}


