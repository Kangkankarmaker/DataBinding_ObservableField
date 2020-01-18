package kangkan.developer.observablefield;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kangkan.developer.observablefield.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);



        final student aStudent =new student("Kangkan Karmaker",22);
        binding.setAStudent(aStudent);

        aStudent.setImageUrl("https://untearable-trays.000webhostapp.com/image/mohera.png");

        
     /*   binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: 1/16/2020
                aStudent.setName(s.toString());

            }
        });*/

    }



    public class student{
        public final ObservableField<String> name=new ObservableField<>();
        private int age;
        private String imageUrl;

        public student(String name, int age) {
            this.name.set(name);
            this.age = age;
        }


        public void setName(String name) {
            this.name.set(name);
        }

        public int getAge() {
            return age;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView iv, String url)
    {
        Glide.with(iv.getContext())
                .load(url)
                .fitCenter()
                .into(iv);
    }


}
