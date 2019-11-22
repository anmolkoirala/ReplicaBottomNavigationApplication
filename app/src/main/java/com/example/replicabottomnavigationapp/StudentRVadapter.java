package com.example.replicabottomnavigationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.replicabottomnavigationapp.modelclass.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRVadapter  extends RecyclerView.Adapter<StudentRVadapter.MyHolder>{

    List<Student> listStudent = new ArrayList<>();
    Context context;

    public StudentRVadapter(List<Student> listStudent, Context context) {
        this.listStudent = listStudent;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_listdisplay,parent,false);
        MyHolder myholder = new MyHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        final  Student finalStudentList = listStudent.get(position);

        holder.studentnme.setText(finalStudentList.getFullname());
        holder.age.setText(finalStudentList.getAge());
        holder.address.setText(finalStudentList.getAddress());
        holder.gender.setText(finalStudentList.getGender());
        holder.imageview.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_delete));

        String gender = finalStudentList.getGender();

        if(gender == "Male"){
            holder.imageview.setImageResource(R.drawable.man);
        }
        else if(gender == "Female"){
            holder.imageview.setImageDrawable(context.getResources().getDrawable(R.drawable.woman));
        }
        else{
            holder.imageview.setImageDrawable(context.getResources().getDrawable(R.drawable.woman));
        }


        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Hey "+ finalStudentList.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student students = listStudent.get(position);

                listStudent.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,listStudent.size());
                Toast.makeText(context,"Student " + students.getFullname() + " has been Removed",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageview,delete;
        TextView studentnme,age,address,gender;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageview   = itemView.findViewById(R.id.stimage);
            studentnme  = itemView.findViewById(R.id.stfullname);
            age         = itemView.findViewById(R.id.st_age);
            address     = itemView.findViewById(R.id.staddress);
            gender      = itemView.findViewById(R.id.stgender);
            delete      = itemView.findViewById(R.id.stdelete);

        }
    }

}
