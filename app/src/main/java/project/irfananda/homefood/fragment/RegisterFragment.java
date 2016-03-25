package project.irfananda.homefood.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import project.irfananda.homefood.R;
import project.irfananda.homefood.activity.MainActivity;

public class RegisterFragment extends Fragment{

    private View mProgressView;
    private View mRegisterFormView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        Button sign_up = (Button) v.findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        TextView txt_sign_in = (TextView) v.findViewById(R.id.txt_sign_in);
        txt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.mainFrame, new LoginFragment());
                ft.commit();
            }
        });


        mRegisterFormView = v.findViewById(R.id.register_form);
        mProgressView = v.findViewById(R.id.register_progress);

        return v;
    }
}
