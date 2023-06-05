package sg.edu.rp.c346.id22011587.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    EditText etIndexElement;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedColour = alColours.get(position); //Get the selected colour from the ArrayList
                Toast.makeText(MainActivity.this, selectedColour, Toast.LENGTH_SHORT).show(); //Display a Toast Message with the selected colour
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString(); //Get the text from the EditText
                //alColours.add(colour); //Add the colour to the ArrayList
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos >= 0 && pos < alColours.size()) {
                    alColours.remove(pos);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos >= 0 && pos < alColours.size()) {
                    String colour = etElement.getText().toString();
                    alColours.set(pos, colour);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}