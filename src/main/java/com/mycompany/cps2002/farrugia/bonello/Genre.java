
package com.mycompany.cps2002.farrugia.bonello;

/**
 *
 * @author Farrugia, Bonello
 */
public class Genre {
    
    /**
     * Potential book genres are enumerated here.
     */
    public static enum genre{
        FICTION,
        BIOGRAPHY,
        ACTION,
        ADVENTURE,
        MYSTERY,
        UNKNOWN
    }
    
    final private genre gen;
    
    /**
     * Genre constructor. Initialises the genre to "genre".
     * @param gen The genre.
     */
    public Genre(genre gen){
        this.gen = gen;
    }
    
    /**
     * Empty constructor for Genre. Initialises to "unknown".
     */
    public Genre(){
        this.gen = genre.UNKNOWN;
    }
    
    /**
     * Returns the genre.
     * @return The genre.
     */
    public genre getGenre(){
        return this.gen;
    }
    
    /**
     * Returns the genre as a string.
     * @return The genre in string format.
     */
    @Override
    public String toString(){
        return gen.toString();
    }
    
}
