package joel.valdez.parcial.facitec.edu.py.op2joel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Usuario on 02/11/2016.
 */
public class AdapterPost extends BaseAdapter {

    private List<Post> post;
    private Context context;

    public AdapterPost(List<Post> post , Context context){

        this.post = post;
        this.context = context;

    }
    @Override
    public int getCount() { return post.size(); }

    @Override
    public Object getItem(int position) { return  post.get(position); }

    @Override
    public long getItemId(int position) { return post.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;


        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_post,null);
        }



        Post a = this.post.get(position);

        TextView textViewUsername = (TextView) view.findViewById(R.id.textViewUsername);
        TextView textViewText = (TextView) view.findViewById(R.id.textViewText);
        ImageView AvatarImageView = (ImageView) view.findViewById(R.id.imageViewAvatar);

        Picasso.with(this.context).load(a.getAvatar()).into(AvatarImageView);

        textViewUsername.setText(a.getUsername());
        textViewText.setText(a.getText());



        return view;
    }
}
