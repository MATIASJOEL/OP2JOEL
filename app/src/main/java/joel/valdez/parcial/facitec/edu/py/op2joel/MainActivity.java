package joel.valdez.parcial.facitec.edu.py.op2joel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    ListView PostListview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PostListview = (ListView)findViewById(R.id.listViewPost);
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://servidor-monkydevs.rhcloud.com").build();


        PostService servicio = restAdapter.create(PostService.class);

        servicio.obtenerPost( new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                Log.i("RESULTADO", post.getUsername());

                //TODO AVATAR

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.getMessage());

                Toast.makeText(getApplicationContext(), error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
