package com.example.viewpager_transformer_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 pager=findViewById(R.id.view_pager);
        CustomAdapter adapter=new CustomAdapter(this);
        pager.setAdapter(adapter);
        pager.setPageTransformer(new ViewPager2.PageTransformer() {

            private static final float MIN_SCALE = 0.85f;
            private static final float MIN_ALPHA = 0.5f;
            @Override
            public void transformPage(@NonNull View view, float position) {
                /**
                 * For instagram story transition
                 * Rotate in circular way
                 *use below code
                 */

               view.setCameraDistance(20000);

                if(position<-1){
                   view.setAlpha(0);
                }
                else if(position<=0){
                    view.setAlpha(1);
                    view.setPivotX(view.getWidth());
                    view.setRotationY(-90*Math.abs(position));
                }else if(position<=1){
                    view.setAlpha(1);
                    view.setPivotX(0);
                    view.setRotationY(90*Math.abs(position));
                }
                else{
                    view.setAlpha(0);
                }




                /**
                 * For Zoom out PageTransformer Animation
                 *
                 */
             /*   int pageWidth = view.getWidth();
                int pageHeight = view.getHeight();

                if (position < -1) { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    view.setAlpha(0f);

                } else if (position <= 1) { // [-1,1]
                    // Modify the default slide transition to shrink the page as well
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                    float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                    if (position < 0) {
                        view.setTranslationX(horzMargin - vertMargin / 2);
                    } else {
                        view.setTranslationX(-horzMargin + vertMargin / 2);
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);

                    // Fade the page relative to its size.
                    view.setAlpha(MIN_ALPHA +
                            (scaleFactor - MIN_SCALE) /
                                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

                } else { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    view.setAlpha(0f);
                }

   */


            }
        });

    }
}