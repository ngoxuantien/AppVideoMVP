package com.example.appvideo.Fragment.Seting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.appvideo.Activity.MainActivity;
import com.example.appvideo.Fragment.ChangePFragment;
import com.example.appvideo.R;
import com.example.appvideo.Session.Session;
import com.example.appvideo.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserFragment extends Fragment implements Serializable {
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseUser userfb = auth.getCurrentUser();
    User user = new User();

    Button updateUser;
    RelativeLayout button;
    TextView textView1, textView2, textView3, textView4, textView5;
    EditText editText1, editText2, editText3, editText4, editText5;
    ImageView edit1, edit2, edit3, edit4, edit5;
    ViewSwitcher viewSwitcher1, viewSwitcher2, viewSwitcher3, viewSwitcher4, viewSwitcher5;
    DatabaseReference databaseReference;
    private  Bundle bundle = new Bundle();
    private com.example.appvideo.FirebaseConection.FirebaseUser firebaseUser;
    Session session;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userinfor, container, false);
        firebaseUser = new com.example.appvideo.FirebaseConection.FirebaseUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        button = view.findViewById(R.id.repairP);
updateUser= view.findViewById(R.id.updateUser);
session = new Session(view.getContext());

        textView1 = view.findViewById(R.id.text1);
        textView2 = view.findViewById(R.id.text2);
        textView3 = view.findViewById(R.id.text3);
        textView4 = view.findViewById(R.id.text4);
        textView5 = view.findViewById(R.id.text5);

        editText1 = view.findViewById(R.id.editext1);
        editText2 = view.findViewById(R.id.editext2);
        editText3 = view.findViewById(R.id.editext3);
        editText4 = view.findViewById(R.id.editext4);
        editText5 = view.findViewById(R.id.editext5);

        edit1 = view.findViewById(R.id.edit1);
        edit2 = view.findViewById(R.id.edit2);
        edit3 = view.findViewById(R.id.edit3);
        edit4 = view.findViewById(R.id.edit4);
        edit5 = view.findViewById(R.id.edit5);


        if (session.getTypeUser() == 1) {
         //   user = (User) getArguments().getSerializable("User");//// lấy dữ liệu từ bundle
         user=   session.getSession();
        //    bundle.putSerializable("user",user);
            Toast.makeText(view.getContext(), "Lỗihhhhhh" + user.getNameuser(), Toast.LENGTH_SHORT).show();
            editText1.setText(user.getNameuser().toString());
            editText2.setText(user.getEmailuser().toString());
            editText3.setText(user.getDateofbirthuser().toString());
            editText4.setText(user.getPlaceuser().toString());
            editText5.setText(user.getGenderuser().toString());

            textView1.setText(user.getNameuser().toString());
            textView2.setText(user.getEmailuser().toString());
            textView3.setText(user.getDateofbirthuser().toString());
            textView4.setText(user.getPlaceuser().toString());
            textView5.setText(user.getGenderuser().toString());


        } else {
            ///// lấy dữ liệu từ facebook/////
            editText1.setText(userfb.getDisplayName());
            editText1.setText(userfb.getEmail());
        }


        setButton(view);
        setEdit1(view);
        setEdit2(view);
        setEdit3(view);
        setEdit4(view);
        setEdit5(view);
       setClickBTupdate(view);
        return view;
    }
    private  void setClickBTupdate(View view){
        // /posts/$postid simultaneously

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String key = databaseReference.child("users").push().getKey();
                // Post post = new Post(userId, username, title, body);
                firebaseUser.updateUserObject(new User(user.getId(),textView1.getText().toString(),textView2.getText().toString(),textView3.getText().toString(),textView4.getText().toString(),textView5.getText().toString(),user.getPassword()));
//                HashMap postValues = new HashMap<>();
//                postValues.put("dateofbirthuser",textView3.getText().toString());
//                postValues.put("emailuser",textView2.getText().toString());
//                postValues.put("genderuser",textView5.getText().toString());
//             //   postValues.put("id",user.getId()+"");
//                postValues.put("nameuser",textView1.getText().toString());
//             //  postValues.put("password",user.getPassword());
//                postValues.put("placeuser",textView4.getText().toString());
////                Map<String, Object> childUpdates = new HashMap<>();
////                childUpdates.put("/users/" + "MWyfSIQMAGz8w2YPuRT", postValues);
////              //  childUpdates.put("/user-posts/" + user.getId()  + "/" + key, postValues);
//
//                databaseReference.child(user.getId()+"").updateChildren(postValues).addOnSuccessListener(new OnSuccessListener() {
//                    @Override
//                    public void onSuccess(Object o) {
//                        Toast.makeText(view.getContext(),"thanh cong",Toast.LENGTH_SHORT);
//                    }
//                });
                User useredit= new User(user.getId(),textView1.getText().toString(),textView2.getText().toString(),textView3.getText().toString(),textView4.getText().toString(),textView5.getText().toString(),user.getPassword());
                session.clearSession();
                session.createSession(useredit);


            }
        });

    }

    private void setEdit1(View view) {
        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView1.setText(editText1.getText().toString());
                viewSwitcher1 = view.findViewById(R.id.viewSwitcher1);
                viewSwitcher1.showNext();
            }
        });


    }

    private void setEdit2(View view) {
        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView2.setText(editText2.getText().toString());
                viewSwitcher2 = view.findViewById(R.id.viewSwitcher2);
                viewSwitcher2.showNext();
            }
        });


    }

    private void setEdit3(View view) {
        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView3.setText(editText3.getText().toString());
                viewSwitcher3 = view.findViewById(R.id.viewSwitcher3);
                viewSwitcher3.showNext();
            }
        });


    }

    private void setEdit4(View view) {
        edit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView4.setText(editText4.getText().toString());
                viewSwitcher4 = view.findViewById(R.id.viewSwitcher4);
                viewSwitcher4.showNext();
            }
        });


    }

    private void setEdit5(View view) {
        edit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView5.setText(editText5.getText().toString());
                viewSwitcher5 = view.findViewById(R.id.viewSwitcher5);
                viewSwitcher5.showNext();
            }
        });


    }

    private void setButton(View view) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2= null;

                fragment2=new ChangePFragment();
            //   fragment2.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framelayoutuser, fragment2).addToBackStack(null).commit();
            }
        });
    }
}
