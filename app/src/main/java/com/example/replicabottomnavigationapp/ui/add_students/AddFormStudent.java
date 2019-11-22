package com.example.replicabottomnavigationapp.ui.add_students;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.replicabottomnavigationapp.MainActivity;
import com.example.replicabottomnavigationapp.R;
import com.example.replicabottomnavigationapp.modelclass.Student;

public class AddFormStudent extends Fragment implements RadioGroup.OnCheckedChangeListener,View.OnClickListener{

    private AddFormStudentViewModel mViewModel;


    private EditText editTextStudentName, editTextAddress, editTextAge;
    private RadioGroup radioGroup;
    private Button btnsubmit;
    private String studentname, gender, address, age;

    public static AddFormStudent newInstance() {
        return new AddFormStudent();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_form_student_fragment, container, false);

        editTextStudentName  = root.findViewById(R.id.studentname);
        editTextAddress      = root.findViewById(R.id.address);
        editTextAge          = root.findViewById(R.id.age);
        radioGroup           = root.findViewById(R.id.gender);
        btnsubmit            = root.findViewById(R.id.buttonsave);

        radioGroup.setOnCheckedChangeListener(this);
        btnsubmit.setOnClickListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddFormStudentViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.radiomale)
        {
            gender = "Male";
        }
        if(checkedId == R.id.radiofemale)
        {
            gender = "Female";
        }
        if(checkedId == R.id.radioother)
        {
            gender = "Other";
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonsave)
        {
            studentname   = editTextStudentName.getText().toString();
            age           = editTextAge.getText().toString();
            address       = editTextAddress.getText().toString();

            if(validate())
            {
                MainActivity.students.add(new Student(studentname,gender,age,address));
                Toast.makeText(getContext(),"Student Infomation Inserted", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean validate(){
        if(TextUtils.isEmpty(studentname))
        {
            editTextStudentName.setError("Please Enter your name");
            editTextStudentName.requestFocus();
            return false;
        }

        if(!TextUtils.isDigitsOnly(age))
        {
            editTextAge.setError("Please Enter your age in Numbers only");
            editTextAge.requestFocus();
            return false;
        }


        if(TextUtils.isEmpty(age))
        {
            editTextAge.setError("Please Enter your age");
            editTextAge.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(address))
        {
            editTextAddress.setError("Please Enter your address");
            editTextAddress.requestFocus();
            return false;
        }

        if(TextUtils.isEmpty(gender))
        {
            Toast.makeText(getContext(), "Please select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        return  true;
    }


}
