package br.com.bossini.fatec_ipi_pdm_tarde_chat_auth_firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText senhaEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText = findViewById(R.id.loginEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        mAuth = FirebaseAuth.getInstance();
    }

    public void irParaCadastro(View view) {
        Intent intent =
                new Intent (this,
                        NovoUsuarioActivity.class);
        startActivity(intent);
    }

    public void fazerLogin (View view){
        String login =
                loginEditText.getText().toString();
        String senha =
                senhaEditText.getText().toString();
        mAuth.signInWithEmailAndPassword(
                login,
                senha
        )
        .addOnSuccessListener((authResult) ->
                startActivity(
                    new Intent (
                            this,
                            ChatActivity.class
                    )
                )
        )
        .addOnFailureListener((exception) -> exception.printStackTrace());
    }
}
