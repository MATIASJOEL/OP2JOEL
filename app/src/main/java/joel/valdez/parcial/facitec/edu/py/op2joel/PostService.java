package joel.valdez.parcial.facitec.edu.py.op2joel;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Usuario on 12/10/2016.
 */
public interface PostService {
    @GET("/servicio/posts.json")
    void obtenerPost( Callback<Post> post);


}
