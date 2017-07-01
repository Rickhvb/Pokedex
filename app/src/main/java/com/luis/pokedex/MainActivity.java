package com.luis.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
/**
 *
 * Describes the List of Pokemon screen
 */
public class MainActivity extends AppCompatActivity {

    int[] image; //to storage the images of each pokemon
    String[] pokemons; //to storage each pokemon name
    String[] numbers; //to storage the description of each pokemon
    ArrayList<String> listPokemons;
    ListViewAdapter adapter; //helps to display the pokemon list
    EditText editSearch; //to do the search of a pokemon in the list
    ListView listView; //displays the pokemon list
    ArrayList<ListPokemon> arraylist = new ArrayList<ListPokemon>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pokémon");

        //creates all the information about pokemon
        fillData();

        //dislpays a toast with a little info
        LayoutInflater layoutInflater = getLayoutInflater();
        int layout = R.layout.toast;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.toast_layout_root);
        View nview = layoutInflater.inflate(layout, viewGroup);
        TextView text = (TextView) nview.findViewById(R.id.texto);
        text.setText("Text");
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(nview);
        toast.show();

        //creates a list with name, description and image for each pokemon in the list
        listView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < pokemons.length; i++) {
            ListPokemon lp = new ListPokemon(pokemons[i], numbers[i], image[i]);
            arraylist.add(lp);
        }
        adapter = new ListViewAdapter(this, arraylist);
        listView.setAdapter(adapter);

        //editSearch to search for specific pokemon in the list
        editSearch = (EditText) findViewById(R.id.inputSearch);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                //makes a search on the list with the filter
                String text = editSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
        });
    }


    //The MainActivity screen closes to another screen displays
    @Override
    public void finish() {
        Intent intent = new Intent();
        setResult(1, intent);
        super.finish();
    }

    //Strings to storage the 151 pokemons with name, description and image
    private void fillData(){
        pokemons = new String[]{
                "Bulbasaur", "Ivysaur", "Venusaur" , "Charmander" , "Charmeleon" , "Charizard" , "Squirtle" ,
                "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
                "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans",
                "Arbok", "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran - Female", "Nidorina",
                "Nidoqueen", "Nidoran - Male", "Nidorino", "Nidoking", "Clefairy", "Clefable", "Vulpix",
                "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat", "Oddish", "Gloom", "Vileplume",
                "Paras", "Parasect", "Venonat", "Venomoth", "Diglett" , "Dugtrio" , "Meowth" , "Persian" ,
                "Psyduck" , "Golduck" , "Mankey" , "Primeape" , "Growlithe" , "Arcanine" , "Poliwag" , "Poliwhirl" ,
                "Poliwrath" , "Abra" , "Kadabra" , "Alakazam" , "Machop" , "Machoke" , "Machamp" , "Bellsprout" ,
                "Weepinbell" , "Victreebel" , "Tentacool" , "Tentacruel" , "Geodude" , "Graveler" , "Golem" ,
                "Ponyta" , "Rapidash" , "Slowpoke" , "Slowbro" , "Magnemite" , "Magneton" , "Farfetch'd" ,
                "Doduo" , "Dodrio" , "Seel" , "Dewgong" , "Grimer" , "Muk" , "Shellder" , "Cloyster" ,
                "Gastly" , "Haunter" , "Gengar" , "Onix" , "Drowzee" , "Hypno" , "Krabby" , "Kingler" ,
                "Voltorb" , "Electrode" , "Exeggcute" , "Exeggutor" , "Cubone" , "Marowak" , "Hitmonlee" ,
                "Hitmonchan" , "Lickitung" , "Koffing" , "Weezing" , "Rhyhorn" , "Rhydon" , "Chansey" ,
                "Tangela" , "Kangaskhan" , "Horsea" , "Seadra" , "Goldeen" , "Seaking" , "Staryu" , "Starmie" ,
                "Mr. Mime" , "Scyther" , "Jynx" , "Electabuzz" , "Magmar" , "Pinsir" , "Tauros" , "Magikarp" ,
                "Gyarados" , "Lapras" , "Ditto" , "Eevee" , "Vaporeon" , "Jolteon" , "Flareon" , "Porygon" ,
                "Omanyte", "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno", "Zapdos",
                "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo", "Mew" };
        image = new int[]{
                R.drawable.pic001, R.drawable.pic002, R.drawable.pic003, R.drawable.pic004, R.drawable.pic005, R.drawable.pic006,
                R.drawable.pic007, R.drawable.pic008, R.drawable.pic009, R.drawable.pic010, R.drawable.pic011, R.drawable.pic012,
                R.drawable.pic013, R.drawable.pic014, R.drawable.pic015, R.drawable.pic016, R.drawable.pic017, R.drawable.pic018,
                R.drawable.pic019, R.drawable.pic020, R.drawable.pic021, R.drawable.pic022, R.drawable.pic023, R.drawable.pic024,
                R.drawable.pic025, R.drawable.pic026, R.drawable.pic027, R.drawable.pic028, R.drawable.pic029, R.drawable.pic030,
                R.drawable.pic031, R.drawable.pic032, R.drawable.pic033, R.drawable.pic034, R.drawable.pic035, R.drawable.pic036,
                R.drawable.pic037, R.drawable.pic038, R.drawable.pic039, R.drawable.pic040, R.drawable.pic041, R.drawable.pic042,
                R.drawable.pic043, R.drawable.pic044, R.drawable.pic045, R.drawable.pic046, R.drawable.pic047, R.drawable.pic048,
                R.drawable.pic049, R.drawable.pic050, R.drawable.pic051, R.drawable.pic052, R.drawable.pic053, R.drawable.pic054,
                R.drawable.pic055, R.drawable.pic056, R.drawable.pic057, R.drawable.pic058, R.drawable.pic059, R.drawable.pic060,
                R.drawable.pic061, R.drawable.pic062, R.drawable.pic063, R.drawable.pic064, R.drawable.pic065, R.drawable.pic066,
                R.drawable.pic067, R.drawable.pic068, R.drawable.pic069, R.drawable.pic070, R.drawable.pic071, R.drawable.pic072,
                R.drawable.pic073, R.drawable.pic074, R.drawable.pic075, R.drawable.pic076, R.drawable.pic077, R.drawable.pic078,
                R.drawable.pic079, R.drawable.pic080, R.drawable.pic081, R.drawable.pic082, R.drawable.pic083, R.drawable.pic084,
                R.drawable.pic085, R.drawable.pic086, R.drawable.pic087, R.drawable.pic088, R.drawable.pic089, R.drawable.pic090,
                R.drawable.pic091, R.drawable.pic092, R.drawable.pic093, R.drawable.pic094, R.drawable.pic095, R.drawable.pic096,
                R.drawable.pic097, R.drawable.pic098, R.drawable.pic099, R.drawable.pic100, R.drawable.pic101, R.drawable.pic102,
                R.drawable.pic103, R.drawable.pic104, R.drawable.pic105, R.drawable.pic106, R.drawable.pic107, R.drawable.pic108,
                R.drawable.pic109, R.drawable.pic110, R.drawable.pic111, R.drawable.pic112, R.drawable.pic113, R.drawable.pic114,
                R.drawable.pic115, R.drawable.pic116, R.drawable.pic117, R.drawable.pic118, R.drawable.pic119, R.drawable.pic120,
                R.drawable.pic121, R.drawable.pic122, R.drawable.pic123, R.drawable.pic124, R.drawable.pic125, R.drawable.pic126,
                R.drawable.pic127, R.drawable.pic128, R.drawable.pic129, R.drawable.pic130, R.drawable.pic131, R.drawable.pic132,
                R.drawable.pic133, R.drawable.pic134, R.drawable.pic135, R.drawable.pic136, R.drawable.pic137, R.drawable.pic138,
                R.drawable.pic139, R.drawable.pic140, R.drawable.pic141, R.drawable.pic142, R.drawable.pic143, R.drawable.pic144,
                R.drawable.pic145, R.drawable.pic146, R.drawable.pic147, R.drawable.pic148, R.drawable.pic149, R.drawable.pic150,
                R.drawable.pic151,
        };
        numbers = new String[]{"National Pokedex Number#001", "National Pokedex Number#002", "National Pokedex Number#003", "National Pokedex Number#004",
                "National Pokedex Number#005", "National Pokedex Number#006", "National Pokedex Number#007", "National Pokedex Number#008",
                "National Pokedex Number#009", "National Pokedex Number#010", "National Pokedex Number#011", "National Pokedex Number#012",
                "National Pokedex Number#013", "National Pokedex Number#014", "National Pokedex Number#015", "National Pokedex Number#016",
                "National Pokedex Number#017", "National Pokedex Number#018", "National Pokedex Number#019", "National Pokedex Number#020",
                "National Pokedex Number#021", "National Pokedex Number#022", "National Pokedex Number#023", "National Pokedex Number#024",
                "National Pokedex Number#025", "National Pokedex Number#026", "National Pokedex Number#027", "National Pokedex Number#028",
                "National Pokedex Number#029", "National Pokedex Number#030", "National Pokedex Number#031", "National Pokedex Number#032",
                "National Pokedex Number#033", "National Pokedex Number#034", "National Pokedex Number#035", "National Pokedex Number#036",
                "National Pokedex Number#037", "National Pokedex Number#038", "National Pokedex Number#039", "National Pokedex Number#040",
                "National Pokedex Number#041", "National Pokedex Number#042", "National Pokedex Number#043", "National Pokedex Number#044",
                "National Pokedex Number#045", "National Pokedex Number#046", "National Pokedex Number#047", "National Pokedex Number#048",
                "National Pokedex Number#049", "National Pokedex Number#050", "National Pokedex Number#051", "National Pokedex Number#052",
                "National Pokedex Number#053", "National Pokedex Number#054", "National Pokedex Number#055", "National Pokedex Number#056",
                "National Pokedex Number#057", "National Pokedex Number#058", "National Pokedex Number#059", "National Pokedex Number#060",
                "National Pokedex Number#061", "National Pokedex Number#062", "National Pokedex Number#063", "National Pokedex Number#064",
                "National Pokedex Number#065", "National Pokedex Number#066", "National Pokedex Number#067", "National Pokedex Number#068",
                "National Pokedex Number#069", "National Pokedex Number#070", "National Pokedex Number#071", "National Pokedex Number#072",
                "National Pokedex Number#073", "National Pokedex Number#074", "National Pokedex Number#075", "National Pokedex Number#076",
                "National Pokedex Number#077", "National Pokedex Number#078", "National Pokedex Number#079", "National Pokedex Number#080",
                "National Pokedex Number#081", "National Pokedex Number#082", "National Pokedex Number#083", "National Pokedex Number#084",
                "National Pokedex Number#085", "National Pokedex Number#086", "National Pokedex Number#087", "National Pokedex Number#088",
                "National Pokedex Number#089", "National Pokedex Number#090", "National Pokedex Number#091", "National Pokedex Number#092",
                "National Pokedex Number#093", "National Pokedex Number#094", "National Pokedex Number#095", "National Pokedex Number#096",
                "National Pokedex Number#097", "National Pokedex Number#098", "National Pokedex Number#099", "National Pokedex Number#100",
                "National Pokedex Number#101", "National Pokedex Number#102", "National Pokedex Number#103", "National Pokedex Number#104",
                "National Pokedex Number#105", "National Pokedex Number#106", "National Pokedex Number#107", "National Pokedex Number#108",
                "National Pokedex Number#109", "National Pokedex Number#110", "National Pokedex Number#111", "National Pokedex Number#112",
                "National Pokedex Number#113", "National Pokedex Number#114", "National Pokedex Number#115", "National Pokedex Number#116",
                "National Pokedex Number#117", "National Pokedex Number#118", "National Pokedex Number#119", "National Pokedex Number#120",
                "National Pokedex Number#121", "National Pokedex Number#122", "National Pokedex Number#123", "National Pokedex Number#124",
                "National Pokedex Number#125", "National Pokedex Number#126", "National Pokedex Number#127", "National Pokedex Number#128",
                "National Pokedex Number#129", "National Pokedex Number#130", "National Pokedex Number#131", "National Pokedex Number#132",
                "National Pokedex Number#133", "National Pokedex Number#134", "National Pokedex Number#135", "National Pokedex Number#136",
                "National Pokedex Number#137", "National Pokedex Number#138", "National Pokedex Number#139", "National Pokedex Number#140",
                "National Pokedex Number#141", "National Pokedex Number#142", "National Pokedex Number#143", "National Pokedex Number#144",
                "National Pokedex Number#145", "National Pokedex Number#146", "National Pokedex Number#147", "National Pokedex Number#148",
                "National Pokedex Number#149", "National Pokedex Number#150", "National Pokedex Number#151",};
    }


}
