package com.example.ticketapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ticketapp.R;
import com.example.ticketapp.activities.ActiveTicketActivity;
import com.example.ticketapp.activities.OpenTicketActivity;

import java.util.ArrayList;

public class SupportFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  rootView = inflater.inflate(R.layout.fragment_support, container, false);

        listView = (ListView)rootView.findViewById(R.id.listbuttons);

        ArrayList<String> buttonIntList = new ArrayList<>();

        buttonIntList.add("Open a Ticket");
        buttonIntList.add("Active Tickets");
        buttonIntList.add("Live Support");
        buttonIntList.add("F.A.Q.");
        buttonIntList.add("Suggestions");

        ArrayAdapter buttonListAdapter = new ArrayAdapter(getContext(), R.layout.button_item_list, buttonIntList);

        listView.setAdapter(buttonListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
            switch (pos){
                case 0:
                    Intent openTicket = new Intent(getActivity(), OpenTicketActivity.class);
                    startActivity(openTicket);
                    break;
//                    OpenTicketFragment openTicketFragment = new OpenTicketFragment();
//                    getActivity()
//                            .getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.fragment_container, openTicketFragment, "openTicketFragment")
//                            .addToBackStack(null)
//                            .commit();
//                    break;

                case 1:
                    Intent activeTicket = new Intent(getActivity(), ActiveTicketActivity.class);
                    startActivity(activeTicket);
                    break;
//                    ActiveTicketFragment activeTicketFragment = new ActiveTicketFragment();
//                    getActivity()
//                            .getSupportFragmentManager()
//                            .beginTransaction()
//                            .replace(R.id.fragment_container, activeTicketFragment, "openTicketFragment")
//                            .addToBackStack(null)
//                            .commit();
//                    break;
            }

            }
        });

        return rootView;
    }
}
