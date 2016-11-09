package joel.valdez.parcial.facitec.edu.py.op2joel;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.oss.datahelper.DataBaseManager;

import java.sql.SQLException;

/**
 * Created by Usuario on 14/09/2016.
 */
public class DATABASE {

private static final String DB_NAME = "agenda.sqlite";
    private static final int DB_VERSION = 1;

    public static void init(Context context){

        DataBaseManager.init(context, DB_NAME, DB_VERSION);
        ConnectionSource source = DataBaseManager.getInstance().getHelper().getConnectionSource();  //aqui hacer try-catch
        try {
            TableUtils.createTableIfNotExists(source, Post.class);
            //demas tablas
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Dao<Post, Integer> getPostDao(){
        try {
            return DataBaseManager.getInstance().getHelper().getDao(Post.class);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    }
