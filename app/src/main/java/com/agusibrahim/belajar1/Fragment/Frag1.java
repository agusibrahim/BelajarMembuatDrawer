package com.agusibrahim.belajar1.Fragment;
import android.support.v4.app.Fragment;
import android.view.*;
import android.os.*;
import com.agusibrahim.belajar1.*;

public class Frag1 extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag1, container, false);
	}
}
