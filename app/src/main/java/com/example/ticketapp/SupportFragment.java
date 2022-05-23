package com.example.ticketapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Array;
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
        return rootView;
    }
}
