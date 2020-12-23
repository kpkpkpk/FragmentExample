package com.example.fragmentexample;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

public class InputFragment extends Fragment implements View.OnClickListener {

    private Button button1,button2,button3;
    private EditText editText;
    private MessageFragment messageFragment;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button1=getView().findViewById(R.id.button1);
        button2=getView().findViewById(R.id.button2);
        messageFragment= (MessageFragment) getFragmentManager().findFragmentById(R.layout.message_fragment);
        button3=getView().findViewById(R.id.button3);
        editText=getView().findViewById(R.id.editText);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int clickedNum=0;
        switch(v.getId()){
            case R.id.button1:
                clickedNum=1;
                break;
            case R.id.button2:
                clickedNum=2;
                break;
            case R.id.button3:
                clickedNum=3;
                break;
        }
        String output="Hi, you tapped button "+clickedNum;
        if(messageFragment!=null&&messageFragment.isInLayout()){
            messageFragment.setMessage(output);
        }else{
            Intent intent=new Intent(getActivity().getApplicationContext(),MessageActivity.class);
            intent.putExtra("OUTPUT",output);
            startActivity(intent);
        }
    }
}
