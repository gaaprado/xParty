package xparty.prado.com.myapplication.Control;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import xparty.prado.com.myapplication.R;
import xparty.prado.com.myapplication.Model.Usuario;


/**
 * Created by Prado on 25/07/2016.
 */
public class ProfileActivity extends Activity {

    private Usuario user;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_profile);

        Usuario user = getIntent().getParcelableExtra("usuario");
        String id = user.getId();
        String nome = user.getNome();
        TextView nomeView = (TextView) findViewById(R.id.nomeText);
        nomeView.setText(nome);
        Uri uri = Uri.parse("http://graph.facebook.com/" + id + "/picture?type=large");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.facePicutre);
        draweeView.setImageURI(uri);



    }

}

