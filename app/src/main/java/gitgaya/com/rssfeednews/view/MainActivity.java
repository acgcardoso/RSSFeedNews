package gitgaya.com.rssfeednews.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import gitgaya.com.rssfeednews.R;
import gitgaya.com.rssfeednews.viewmodel.RSSFeedActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ArrayList<String> rssLinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJn = findViewById(R.id.btnJn);
        Button btnCinemaBlend = findViewById(R.id.btnCinemaBlend);
        btnJn.setOnClickListener(this);
        btnCinemaBlend.setOnClickListener(this);

        rssLinks.add("http://feeds.tsf.pt/TSF-Ultimas");
        rssLinks.add("http://feeds.jn.pt/JN-Desporto");
        //rssLinks.add("http://www.cinemablend.com/rss_review.php");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnJn:
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(0)));
                break;

            case R.id.btnCinemaBlend:
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(1)));
                break;
        }
    }
}

