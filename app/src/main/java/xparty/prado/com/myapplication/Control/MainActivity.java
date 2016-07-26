package xparty.prado.com.myapplication.Control;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import xparty.prado.com.myapplication.Model.Usuario;
import xparty.prado.com.myapplication.R;
import com.facebook.FacebookSdk;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;


public class MainActivity extends Activity {

    private CallbackManager callbackManager;
    private AccessToken accessToken;
    private Usuario user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);

        LoginButton faceLogin = (LoginButton) findViewById(R.id.faceLogin);
        faceLogin.setReadPermissions(Arrays.asList("public_profile"));


        faceLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken = AccessToken.getCurrentAccessToken();
                createUser();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void createUser(){
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {

                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {

                        try {
                            String id = AccessToken.getCurrentAccessToken().getUserId();
                            String nome = object.getString("name");
                            String email = object.getString("email");

                            user = new Usuario();
                            user.setId(id);
                            user.setNome(nome);
                            user.setEmail(email);

                            Intent intent = new Intent(MainActivity.this, Navigation_Activity.class);
                            intent.putExtra("usuario", user);
                            startActivity(intent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name, email");
        request.setParameters(parameters);
        request.executeAsync();
    }


}
