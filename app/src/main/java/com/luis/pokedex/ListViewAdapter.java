package com.luis.pokedex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 *
 * Describes a ListView Adapter to storage the pokemon list
 */

//BaseAdapter Class to create a custom Adapter for displaying a custom list item.
public class ListViewAdapter extends BaseAdapter {

    Context context; //the current context of the app
    LayoutInflater inflater; //to show objects
    private List<ListPokemon> listOfPokemon = null; //List type with a ListPokemon
    private ArrayList<ListPokemon> arrayList; //arrayList of ArrayList type with a ListPokemon


    /**
     Constructs a ListAdapter to storage a list of Pokemon with the context
     @param context the context
     @param listOfPokemon the list of pokemon
     */
    public ListViewAdapter(Context context, List<ListPokemon> listOfPokemon) {
        this.context=context;
        this.listOfPokemon = listOfPokemon;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<ListPokemon>();
        this.arrayList.addAll(listOfPokemon);
    }

    //access to each element of the list
    public class ViewHolder{
        TextView pokemon;
        TextView number;
        ImageView image;
    }

    /**
     Gets the size of the list
     @return the size of the list
     */
    @Override
    public int getCount(){
        return listOfPokemon.size();
    }

    /**
     Gets the specified pokemon on the list
     @return the pokemon on the list
     */
    @Override
    public ListPokemon getItem(int position) { //returns a pokemon
        return listOfPokemon.get(position);
    }

    /**
     Gets the position of a pokemon
     @return the position of a pokemon in the list
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * Gets an updated list of pokemons acording to the searchbar
     * @param position the position of a pokemon in the list
     * @param view each layout information of a pokemon
     * @param parent the information of each pokemon
     * @return the view with the list of pokemon
     */
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.mylist, null); //shows the list of pokemon
            // Locate the TextViews in myList.xml
            holder.pokemon = (TextView) view.findViewById(R.id.name);
            holder.number = (TextView) view.findViewById(R.id.number);
            // Locate the ImageView in myList.xml
            holder.image = (ImageView) view.findViewById(R.id.icon);
            view.setTag(holder); //method to storage items in a list
        } else {
            holder = (ViewHolder) view.getTag(); //recover items of a list
        }
        // Set the results into TextViews
        holder.pokemon.setText(listOfPokemon.get(position).getPokemon());
        holder.number.setText(listOfPokemon.get(position).getNumber());
        // Set the results into ImageView
        holder.image.setImageResource(listOfPokemon.get(position)
                .getImage());
        // Listen for ListView Item Click, displaying each pokemon related to the list
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (listOfPokemon.get(position).getPokemon() == ("Bulbasaur") ) {
                    Intent intent = new Intent(context, Bulbasaur.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Ivysaur") {
                    Intent intent = new Intent(context, Ivysaur.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Venusaur") {
                    Intent intent = new Intent(context, Venusaur.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Charmander") {
                    Intent intent = new Intent(context, Charmander.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Charmeleon") {
                    Intent intent = new Intent(context, Charmeleon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Charizard") {
                    Intent intent = new Intent(context, Charizard.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Squirtle") {
                    Intent intent = new Intent(context, Squirtle.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Wartortle") {
                    Intent intent = new Intent(context, Wartortle.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Blastoise") {
                    Intent intent = new Intent(context, Blastoise.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Caterpie") {
                    Intent intent = new Intent(context, Caterpie.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Metapod") {
                    Intent intent = new Intent(context, Metapod.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Butterfree") {
                    Intent intent = new Intent(context, Butterfree.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Weedle") {
                    Intent intent = new Intent(context, Weedle.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kakuna") {
                    Intent intent = new Intent(context, Kakuna.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Beedrill") {
                    Intent intent = new Intent(context, Beedrill.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Pidgey") {
                    Intent intent = new Intent(context, Pidgey.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Pidgeotto") {
                    Intent intent = new Intent(context, Pidgeotto.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Pidgeot") {
                    Intent intent = new Intent(context, Pidgeot.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Rattata") {
                    Intent intent = new Intent(context, Rattata.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Raticate") {
                    Intent intent = new Intent(context, Raticate.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Spearow") {
                    Intent intent = new Intent(context, Spearow.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Fearow") {
                    Intent intent = new Intent(context, Fearow.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Ekans") {
                    Intent intent = new Intent(context, Ekans.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Arbok") {
                    Intent intent = new Intent(context, Arbok.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Pikachu") {
                    Intent intent = new Intent(context, Pikachu.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Raichu") {
                    Intent intent = new Intent(context, Raichu.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Sandshrew") {
                    Intent intent = new Intent(context, Sandshrew.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Sandslash") {
                    Intent intent = new Intent(context, Sandslash.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidoran - Female") {
                    Intent intent = new Intent(context, NidoranF.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidorina") {
                    Intent intent = new Intent(context, Nidorina.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidoqueen") {
                    Intent intent = new Intent(context, Nidoqueen.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidoran - Male") {
                    Intent intent = new Intent(context, NidoranM.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidorino") {
                    Intent intent = new Intent(context, Nidorino.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Nidoking") {
                    Intent intent = new Intent(context, Nidoking.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Clefairy") {
                    Intent intent = new Intent(context, Clefairy.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Clefable") {
                    Intent intent = new Intent(context, Clefable.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Vulpix") {
                    Intent intent = new Intent(context, Vulpix.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Ninetales") {
                    Intent intent = new Intent(context, Ninetales.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Jigglypuff") {
                    Intent intent = new Intent(context, Jigglypuff.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Wigglytuff") {
                    Intent intent = new Intent(context, Wigglytuff.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Zubat") {
                    Intent intent = new Intent(context, Zubat.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Golbat") {
                    Intent intent = new Intent(context, Golbat.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Oddish") {
                    Intent intent = new Intent(context, Oddish.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Gloom") {
                    Intent intent = new Intent(context, Gloom.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Vileplume") {
                    Intent intent = new Intent(context, Vileplume.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Paras") {
                    Intent intent = new Intent(context, Paras.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Parasect") {
                    Intent intent = new Intent(context, Parasect.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Venonat") {
                    Intent intent = new Intent(context, Venonat.class);
                    context.startActivity(intent);  }
                if (listOfPokemon.get(position).getPokemon() == "Venomoth") {
                    Intent intent = new Intent(context, Venomoth.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Diglett") {
                    Intent intent = new Intent(context, Diglett.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Dugtrio") {
                    Intent intent = new Intent(context, Dugtrio.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Meowth") {
                    Intent intent = new Intent(context, Meowth.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Persian") {
                    Intent intent = new Intent(context, Persian.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Psyduck") {
                    Intent intent = new Intent(context, Psyduck.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Golduck") {
                    Intent intent = new Intent(context, Golduck.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Mankey") {
                    Intent intent = new Intent(context, Mankey.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Primeape") {
                    Intent intent = new Intent(context, Primeape.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Growlithe") {
                    Intent intent = new Intent(context, Growlithe.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Arcanine") {
                    Intent intent = new Intent(context, Arcanine.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Poliwag") {
                    Intent intent = new Intent(context, Poliwag.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Poliwhirl") {
                    Intent intent = new Intent(context, Poliwhirl.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Poliwrath") {
                    Intent intent = new Intent(context, Poliwrath.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Abra") {
                    Intent intent = new Intent(context, Abra.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kadabra") {
                    Intent intent = new Intent(context, Kadabra.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Alakazam") {
                    Intent intent = new Intent(context, Alakazam.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Machop") {
                    Intent intent = new Intent(context, Machop.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Machoke") {
                    Intent intent = new Intent(context, Machoke.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Machamp") {
                    Intent intent = new Intent(context, Machamp.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Bellsprout") {
                    Intent intent = new Intent(context, Bellsprout.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Weepinbell") {
                    Intent intent = new Intent(context, Weepinbell.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Victreebel") {
                    Intent intent = new Intent(context, Victreebel.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Tentacool") {
                    Intent intent = new Intent(context, Tentacool.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Tentacruel") {
                    Intent intent = new Intent(context, Tentacruel.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Geodude") {
                    Intent intent = new Intent(context, Geodude.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Graveler") {
                    Intent intent = new Intent(context, Graveler.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Golem") {
                    Intent intent = new Intent(context, Golem.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Ponyta") {
                    Intent intent = new Intent(context, Ponyta.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Rapidash") {
                    Intent intent = new Intent(context, Rapidash.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Slowpoke") {
                    Intent intent = new Intent(context, Slowpoke.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Slowbro") {
                    Intent intent = new Intent(context, Slowbro.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Magnemite") {
                    Intent intent = new Intent(context, Magnemite.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Magneton") {
                    Intent intent = new Intent(context, Magneton.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Farfetch'd") {
                    Intent intent = new Intent(context, Farfetchd.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Doduo") {
                    Intent intent = new Intent(context, Doduo.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Dodrio") {
                    Intent intent = new Intent(context, Dodrio.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Seel") {
                    Intent intent = new Intent(context, Seel.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Dewgong") {
                    Intent intent = new Intent(context, Dewgong.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Grimer") {
                    Intent intent = new Intent(context, Grimer.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Muk") {
                    Intent intent = new Intent(context, Muk.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Shellder") {
                    Intent intent = new Intent(context, Shellder.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Cloyster") {
                    Intent intent = new Intent(context, Cloyster.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Gastly") {
                    Intent intent = new Intent(context, Gastly.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Haunter") {
                    Intent intent = new Intent(context, Haunter.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Gengar") {
                    Intent intent = new Intent(context, Gengar.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Onix") {
                    Intent intent = new Intent(context, Onix.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Drowzee") {
                    Intent intent = new Intent(context, Drowzee.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Hypno") {
                    Intent intent = new Intent(context, Hypno.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Krabby") {
                    Intent intent = new Intent(context, Krabby.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kingler") {
                    Intent intent = new Intent(context, Kingler.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Voltorb") {
                    Intent intent = new Intent(context, Voltorb.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Electrode") {
                    Intent intent = new Intent(context, Electrode.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Exeggcute") {
                    Intent intent = new Intent(context, Exeggcute.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Exeggutor") {
                    Intent intent = new Intent(context, Exeggutor.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Cubone") {
                    Intent intent = new Intent(context, Cubone.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Marowak") {
                    Intent intent = new Intent(context, Marowak.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Hitmonlee") {
                    Intent intent = new Intent(context, Hitmonlee.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Hitmonchan") {
                    Intent intent = new Intent(context, Hitmonchan.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Lickitung") {
                    Intent intent = new Intent(context, Lickitung.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Koffing") {
                    Intent intent = new Intent(context, Koffing.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Weezing") {
                    Intent intent = new Intent(context, Weezing.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Rhyhorn") {
                    Intent intent = new Intent(context, Rhyhorn.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Rhydon") {
                    Intent intent = new Intent(context, Rhydon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Chansey") {
                    Intent intent = new Intent(context, Chansey.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Tangela") {
                    Intent intent = new Intent(context, Tangela.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kangaskhan") {
                    Intent intent = new Intent(context, Kangaskhan.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Horsea") {
                    Intent intent = new Intent(context, Horsea.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Seadra") {
                    Intent intent = new Intent(context, Seadra.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Goldeen") {
                    Intent intent = new Intent(context, Goldeen.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Seaking") {
                    Intent intent = new Intent(context, Seaking.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Staryu") {
                    Intent intent = new Intent(context, Staryu.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Starmie") {
                    Intent intent = new Intent(context, Starmie.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Mr. Mime") {
                    Intent intent = new Intent(context, MrMime.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Scyther") {
                    Intent intent = new Intent(context, Scyther.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Jynx") {
                    Intent intent = new Intent(context, Jynx.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Electabuzz") {
                    Intent intent = new Intent(context, Electabuzz.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Magmar") {
                    Intent intent = new Intent(context, Magmar.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Pinsir") {
                    Intent intent = new Intent(context, Pinsir.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Tauros") {
                    Intent intent = new Intent(context, Tauros.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Magikarp") {
                    Intent intent = new Intent(context, Magikarp.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Gyarados") {
                    Intent intent = new Intent(context, Gyarados.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Lapras") {
                    Intent intent = new Intent(context, Lapras.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Ditto") {
                    Intent intent = new Intent(context, Ditto.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Eevee") {
                    Intent intent = new Intent(context, Eevee.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Vaporeon") {
                    Intent intent = new Intent(context, Vaporeon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Jolteon") {
                    Intent intent = new Intent(context, Jolteon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Flareon") {
                    Intent intent = new Intent(context, Flareon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Porygon") {
                    Intent intent = new Intent(context, Porygon.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Omanyte") {
                    Intent intent = new Intent(context, Omanyte.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Omastar") {
                    Intent intent = new Intent(context, Omastar.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kabuto") {
                    Intent intent = new Intent(context, Kabuto.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Kabutops") {
                    Intent intent = new Intent(context, Kabutops.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Aerodactyl") {
                    Intent intent = new Intent(context, Aerodactyl.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Snorlax") {
                    Intent intent = new Intent(context, Snorlax.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Articuno") {
                    Intent intent = new Intent(context, Articuno.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Zapdos") {
                    Intent intent = new Intent(context, Zapdos.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Moltres") {
                    Intent intent = new Intent(context, Moltres.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Dratini") {
                    Intent intent = new Intent(context, Dratini.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Dragonair") {
                    Intent intent = new Intent(context, Dragonair.class);
                    context.startActivity(intent);  }
                if (listOfPokemon.get(position).getPokemon() == "Dragonite") {
                    Intent intent = new Intent(context, Dragonite.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Mewtwo") {
                    Intent intent = new Intent(context, Mewtwo.class);
                    context.startActivity(intent); }
                if (listOfPokemon.get(position).getPokemon() == "Mew") {
                    Intent intent = new Intent(context, Mew.class);
                    context.startActivity(intent); }
            }
        });

        return view;
    }

    // Filter method to search for a pokemon entered by the user
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        listOfPokemon.clear();
        if (charText.length() == 0) {
            listOfPokemon.addAll(arrayList); //if the search bar is empty, the list is with all pokemon
        } else {
            for (ListPokemon lp : arrayList) {
                if (lp.getPokemon().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    listOfPokemon.add(lp); //includes the pokemon with the specific charText on the list
                }
            }
        }
        notifyDataSetChanged(); //updates the list and dislpays
    }
}