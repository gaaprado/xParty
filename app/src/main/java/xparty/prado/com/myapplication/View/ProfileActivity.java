package xparty.prado.com.myapplication.View;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.login.widget.ProfilePictureView;
import xparty.prado.com.myapplication.R;


/**
 * Created by Prado on 25/07/2016.
 */
public class ProfileActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ProfilePictureView picture = (ProfilePictureView) findViewById(R.id.facePicutre);
        String userId = AccessToken.getCurrentAccessToken().getUserId();
        picture.setProfileId(userId);

    }

}
