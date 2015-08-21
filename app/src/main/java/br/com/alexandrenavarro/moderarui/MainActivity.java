package br.com.alexandrenavarro.moderarui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

/**
 * Created by alexandrenavarro on 21/08/15.
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SeekBar mSeekBar;

    private View view1;
    private View view2;
    private View view3;
    private View view5;
    private int[] starColorView1 = {106, 120, 184};
    private int[] starColorView2 = {214, 79, 152};
    private int[] starColorView3 = {164, 29, 33};
    private int[] starColorView5 = {40, 58, 152};

    private int[] endColorView1 = {254, 255, 186};
    private int[] endColorView2 = {254, 233, 152};
    private int[] endColorView3 = {251, 189, 0};
    private int[] endColorView5 = {198, 214, 158};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        view1 = findViewById(R.id.view_1);
        view2 = findViewById(R.id.view_2);
        view3 = findViewById(R.id.view_3);
        view5 = findViewById(R.id.view_5);


        setBackgroundColor(view1, Color.rgb(starColorView1[0], starColorView1[1], starColorView1[2]));
        setBackgroundColor(view2, Color.rgb(starColorView2[0], starColorView2[1], starColorView2[2]));
        setBackgroundColor(view3, Color.rgb(starColorView3[0], starColorView3[1], starColorView3[2]));
        setBackgroundColor(view5, Color.rgb(starColorView5[0], starColorView5[1], starColorView5[2]));


        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("MainActivity", "position seekbar " + i);
                changeColor(view1, i, starColorView1, endColorView1);
                changeColor(view2, i, starColorView2, endColorView2);
                changeColor(view3, i, starColorView3, endColorView3);
                changeColor(view5, i, starColorView5, endColorView5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.more_information) {
            MoreInformationDialogFragment.newInstance().show(getSupportFragmentManager(), "more_information");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeColor(View view, int additionalValue, int[] starColorView, int[] endColorView) {
//        int color = (Integer) view.getTag();
//        color += additionalValue;
//        view.setBackgroundColor(color);

        int red = getColorTransition(starColorView[0], endColorView[0], additionalValue);
        int green = getColorTransition(starColorView[1], endColorView[1], additionalValue);
        int blue = getColorTransition(starColorView[2], endColorView[2], additionalValue);


        view.setBackgroundColor(Color.rgb(red, green, blue));

    }

    private int getColorTransition(float inicialPosition, float endPosition, float position) {
        return Math.round(inicialPosition + (endPosition - inicialPosition) * position / 100);
    }


    private void setBackgroundColor(View view, int color) {
        view.setBackgroundColor(color);
    }


}