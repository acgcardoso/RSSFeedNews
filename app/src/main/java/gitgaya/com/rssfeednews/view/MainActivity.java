package gitgaya.com.rssfeednews.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

import gitgaya.com.rssfeednews.R;
import gitgaya.com.rssfeednews.model.Textreadwrite;
import gitgaya.com.rssfeednews.viewmodel.RSSFeedActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    ArrayList<String> rssLinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            rssLinks.add("http://feeds.tsf.pt/TSF-Ultimas");
            rssLinks.add("http://feeds.jn.pt/JN-Desporto");
            rssLinks.add("http://www.xl.pt/meteorologia/syndication/?pais=1");
            rssLinks.add("https://www.noticiasaominuto.com/rss/fama");

            if (id == R.id.btnRecent) {
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(0)));
                Toast.makeText(MainActivity.this, "Ultimas Noticias", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.btnSports) {
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(1)));
                Toast.makeText(MainActivity.this, "Desporto", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.btnMeteo) {
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(2)));
                Toast.makeText(MainActivity.this, "Meteorologia", Toast.LENGTH_SHORT).show();
            }

            else if (id == R.id.favoritos) {
                startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(3)));
                Toast.makeText(MainActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();
            }


            else if (id == R.id.settings) {
                startActivity(new Intent(MainActivity.this, Textreadwrite.class));
                Toast.makeText(MainActivity.this, "Definições", Toast.LENGTH_SHORT).show();
            }


            dl.closeDrawer(GravityCompat.START);

            return true;
        });
    }

    @Override  public boolean onOptionsItemSelected(MenuItem item) {
        // return abdt.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.btnRecent) {
            startActivity(new Intent(MainActivity.this, RSSFeedActivity.class).putExtra("rssLink", rssLinks.get(0)));
            Toast.makeText(MainActivity.this, "Ultimas Noticias", Toast.LENGTH_SHORT).show();
        }
        return abdt.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);
    }
}