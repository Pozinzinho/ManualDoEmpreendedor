package com.example.manoel.manualdoempreendedor.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manoel.manualdoempreendedor.Entidades.Formulario_5w2h;
import com.example.manoel.manualdoempreendedor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Fragmento_when extends Fragment {

    private Formulario_5w2h formulario_5w2h;
    private View view;
    private AdapterView.OnItemSelectedListener onItemSelectedListener;
    private Button btnSalvarWhen;
    private String uId = "";
    private EditText texto_When;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmento_when, container, false);

        btnSalvarWhen = (Button) view.findViewById(R.id.btnSalvarWhen);
        texto_When = (EditText) view.findViewById(R.id.editTextWhen);

        btnSalvarWhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user1 = FirebaseAuth.getInstance().getCurrentUser();
                uId = user1.getUid();


                formulario_5w2h = new Formulario_5w2h();
                formulario_5w2h.setuID(uId);
                formulario_5w2h.setWhen(texto_When.getText().toString().trim());

                formulario_5w2h.updateWhen();

                Toast.makeText(getApplicationContext(), "Formulário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }
}
