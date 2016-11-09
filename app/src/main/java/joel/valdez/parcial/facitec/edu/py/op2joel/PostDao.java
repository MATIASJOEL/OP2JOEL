package joel.valdez.parcial.facitec.edu.py.op2joel;

import android.content.Context;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Usuario on 14/09/2016.
 */
public class PostDao {

    public PostDao(Context context){
        DATABASE.init(context);

    }

    public void crear(Post p){

        try {
            DATABASE.getPostDao().create(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Post seleccionar(int id){

        try {
            return DATABASE.getPostDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public List<Post> seleccionarTodos(){
        try {
            return DATABASE.getPostDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public List<Post> eliminar(){



        return null;
    }


}
