package com.example.livedataviewmodelobserverappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NameViewModel viewModel;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvName);
        editText = findViewById(R.id.edName);

        viewModel = new ViewModelProvider(
                MainActivity.this,
                new NameViewModelFactory())
                .get(NameViewModel.class);

       // This works as well
        /*viewModel = ViewModelProviders.of(
                   this,
                   new NameViewModelFactory())
                   .get(NameViewModel.class);
     */
        // Observes when data changes
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String newName) {

                textView.setText(newName);
            }
        };

        //Observe the LiveData, pass in the LifeCycle Owner (this Activity)
        // as the LifeCycleOwner and the Observer
        viewModel.getCurrentName().observe(this, nameObserver);

        Button button = findViewById(R.id.btName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editText.getText().toString();
                viewModel.getCurrentName().setValue(newName);
            }
        });
    }
}