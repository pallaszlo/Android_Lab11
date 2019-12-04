package ro.sapi.retrofitapp2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        final TextView textView2 = findViewById(R.id.textView2);

        JSONPlaceHolderApi service = NetworkService.getRetrofitInstance().create(JSONPlaceHolderApi.class);
        Call<Post> call_1 = service.getPostWithID(1);
        call_1.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();

                textView.append(post.getId() + "\n");
                textView.append(post.getUserId() + "\n");
                textView.append(post.getTitle() + "\n");
                textView.append(post.getBody() + "\n");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.append("Error occurred while getting request!");
                t.printStackTrace();
            }
        });



    }
}
