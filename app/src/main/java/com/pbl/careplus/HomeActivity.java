package com.pbl.careplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class HomeActivity extends AppCompatActivity {

    private Animation animationRight;
    private Animation animationLeft;
    private ImageButton openButtonMenu;
    private ImageButton closeButtonMenu;
    private RelativeLayout menuLayout;

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private ScheduleFragment scheduleFragment;

    private ImageButton homeButton;
    private ImageButton accountButton;
    private ImageButton scheduleButton;
    private ImageButton recordButton;

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        scheduleFragment = new ScheduleFragment();

        openButtonMenu = findViewById(R.id.open_menu_button);
        closeButtonMenu = findViewById(R.id.close_Button_menu);
        menuLayout = findViewById(R.id.menu_layout);

        homeButton = findViewById(R.id.home_button_menu);
        accountButton = findViewById(R.id.Account_button_menu);
        scheduleButton = findViewById(R.id.Schedule_button_menu);
        recordButton = findViewById(R.id.record_button_menu);

        animationRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
        animationLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);

        loadFragment(new HomeFragment());
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new HomeFragment();
                loadFragment(fragment);
                menuLayout.startAnimation(animationRight);
                openButtonMenu.setVisibility(View.VISIBLE);
            }
        });
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new AccountFragment();
                loadFragment(fragment);
                menuLayout.startAnimation(animationRight);
                openButtonMenu.setVisibility(View.VISIBLE);
            }
        });
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new ScheduleFragment();
                loadFragment(fragment);
                menuLayout.startAnimation(animationRight);
                openButtonMenu.setVisibility(View.VISIBLE);
            }
        });

        openButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(menuLayout.getVisibility() == View.GONE) {
                    openButtonMenu.setVisibility(View.GONE);
                    menuLayout.setVisibility(View.VISIBLE);
                    menuLayout.startAnimation(animationLeft);
                } else {
                    menuLayout.setVisibility(View.GONE);
                }
            }
        });

        closeButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(menuLayout.getVisibility() == View.VISIBLE) {
                    menuLayout.setVisibility(View.GONE);
                    menuLayout.startAnimation(animationRight);
                    openButtonMenu.setVisibility(View.VISIBLE);
                } else {
                    menuLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
