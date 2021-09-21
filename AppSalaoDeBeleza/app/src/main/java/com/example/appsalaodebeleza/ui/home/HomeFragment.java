package com.example.appsalaodebeleza.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appsalaodebeleza.ClienteDAO;
import com.example.appsalaodebeleza.ClienteDTO;
import com.example.appsalaodebeleza.R;

public class HomeFragment extends Fragment {
    EditText editTextNomeCliente;
    EditText editTextTelefoneCliente;
    EditText editTextEmailCliente;
    EditText editTextEnderecoCliente;
    Button buttonSalvar;
    private com.example.appsalaodebeleza.ui.home.HomeViewModel homeViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(com.example.appsalaodebeleza.ui.home.HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        buttonSalvar = root.findViewById(R.id.buttonSalvar);
        editTextNomeCliente = root.findViewById(R.id.editTextNomeCliente);
        editTextTelefoneCliente = root.findViewById(R.id.editTextTelefoneCliente);
        editTextEmailCliente = root.findViewById(R.id.editTextEmailCliente);
        editTextEnderecoCliente = root.findViewById(R.id.editTextEnderecoCliente);
        //Evento botão salvar
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClienteDTO clienteDTO = new ClienteDTO(
                        editTextNomeCliente.getText().toString(),
                        editTextTelefoneCliente.getText().toString(),
                        editTextEmailCliente.getText().toString(),
                        editTextEnderecoCliente.getText().toString());
                ClienteDAO clienteDAO = new ClienteDAO(getActivity().getApplicationContext());
                try {
                    if (clienteDAO.inserir(clienteDTO) > 0) {
                        Toast.makeText(getActivity().getApplicationContext(), "Inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.d("Erro-ao-inserir: ", ex.toString());
                    Toast.makeText(getActivity().getApplicationContext(), "Erro ao Inserir: ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

