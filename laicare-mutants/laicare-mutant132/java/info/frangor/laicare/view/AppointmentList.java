package info.frangor.laicare.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;

import info.frangor.laicare.model.Appointment;
import info.frangor.laicare.view.utils.DividerItemDecoration;
import info.frangor.laicare.Controller;
import info.frangor.laicare.R;

public class AppointmentList extends Fragment {
    private static RecyclerView recyclerView;
    private static AppointmentItem appointmentAdapter;
    private static AppCompatTextView emptyView;

    public AppointmentList() {
    }

    public static AppointmentList newInstance(int petId) {
        AppointmentList f = new AppointmentList();
        Bundle args = new Bundle();
        args.putInt("petId", petId);
        f.setArguments(args);
        return f;
    }

    public int getPetId() {
        return getArguments().getInt("petId", 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.appointment_list, container, false);

        final Controller con = (Controller) getActivity()
            .getApplicationContext();

        recyclerView = (RecyclerView) null;
recyclerView.setVisibility(android.view.View.INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        appointmentAdapter = new AppointmentItem(con, getPetId());
        recyclerView.setAdapter(appointmentAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),
                    null));

        emptyView = (AppCompatTextView) null;

        update();
        return v;
    }

    public void update() {
        appointmentAdapter.update();
        if (appointmentAdapter.getItemCount() == 0) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }

    public Appointment getAppointment(int position) {
        return appointmentAdapter.getAppointment(position);
    }
}
