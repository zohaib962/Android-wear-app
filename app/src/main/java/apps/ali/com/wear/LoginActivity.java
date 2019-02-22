package apps.ali.com.wear;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends WearableActivity {

    private EditText userNameET;
    private EditText passwordET;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mBeaconReference;

    private ChildEventListener mChaldEventListener;

    List<UserModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub2);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                userNameET = (EditText) stub.findViewById(R.id.Username);
                passwordET = (EditText) stub.findViewById(R.id.Password);

            }
        });

        setAmbientEnabled();
        setServer();
    }

    private void setServer()
    {
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mBeaconReference=mFirebaseDatabase.getReference().child("users");

        mList=new ArrayList<>();

        mChaldEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mList.add(dataSnapshot.getValue(UserModel.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mBeaconReference.addChildEventListener(mChaldEventListener);



    }
    public void openMainActivity(View view)
    {        boolean flag=false;

        Log.d("hello",String.valueOf(mList.size()));

        String username=userNameET.getText().toString();
        String userpass=passwordET.getText().toString();
        for (int i=0;i<mList.size();i++)
        {
            UserModel mUserDatamodel=mList.get(i);

            if(mUserDatamodel.getUsername().equals(username) && mUserDatamodel.getUserPassword().equals(userpass))
            {
                flag=true;
               // Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("username",username);
                editor.putString("password",userpass);
                editor.putString("phone",mUserDatamodel.getPhone());
                editor.commit();

                Intent intent= new Intent(this, MainActivity.class);
                startActivity(intent);
            }

        }

        if(flag==true) {
           // Toast.makeText(this, "Login UnSuccessful", Toast.LENGTH_SHORT).show();
        }


    }

}
