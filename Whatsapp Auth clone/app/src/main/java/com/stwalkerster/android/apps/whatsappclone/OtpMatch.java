package com.stwalkerster.android.apps.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import android.widget.EditText;

import java.util.concurrent.TimeUnit;

public class OtpMatch extends AppCompatActivity {
String verificationId;
EditText otps;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_match);
        mAuth = FirebaseAuth.getInstance();

        String no = getIntent().getStringExtra("Number");
        sendVerificationCode(no);
        otps = findViewById(R.id.otp);

    }

    public void sendVerificationCode(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60, //validation of ssec
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }

    public PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if(code != null){
                otps.setText(code);
                verifyCode(code);
            }
        }



        @Override
        public void onVerificationFailed(@org.jetbrains.annotations.NotNull FirebaseException e) {
            Toast.makeText(OtpMatch.this, e.getMessage(), Toast.LENGTH_SHORT).show();


        }


    };

    public void verifyCode(String code) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);

        signInWithCredential(credential);

    }

    public void signInWithCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(OtpMatch.this,home.class));
                            Toast.makeText(OtpMatch.this, "Done", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(OtpMatch.this, "Nhi Hua", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
