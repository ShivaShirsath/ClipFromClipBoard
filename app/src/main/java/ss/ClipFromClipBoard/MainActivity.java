package ss.ClipFromClipBoard;

import android.content.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
	ClipboardManager clipboard;
	TextView tv;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		
		tv=findViewById(R.id.tv);

        ( (FloatingActionButton)findViewById(R.id.fab) )
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
					clipboard.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
							@Override
							public void onPrimaryClipChanged() {
								tv.setText(clipboard.getText().toString());
								tv.setText(tv.getText().toString().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", ""));
								clipboard.setText(tv.getText().toString());
							}
						});
                    Toast.makeText(MainActivity.this, tv.getText().toString()+"\nis Copy to ClipBoard.", Toast.LENGTH_LONG).show();
                }
            });
    }
}
