package com.luis.pokedex;

/**
 *
 * Describes a List of pokemon
 */
public class ListPokemon {
    private String pokemon;
    private String number;
    private int image;

    /**
     Constructs a pokemon with name, number and image
     @param pokemon the pokemon name
     @param number the pokemon number
     @param image the pokemon image
     */
    public ListPokemon(String pokemon, String number, int image){
        this.pokemon = pokemon;
        this.number = number;
        this.image = image;
    }
    /**
     Gets the name of a pokemon
     @return the pokemon name
     */
    public String getPokemon() {
        return this.pokemon;
    }

    /**
     Gets the number of a pokemon
     @return the pokemon number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     Gets the image of a pokemon
     @return the pokemon image
     */
    public int getImage() {
        return this.image;
    }
}
