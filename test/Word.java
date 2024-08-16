package test;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Word {
    public int col;
    public int row;
    public Tile[] tiles ;
    public boolean vertical; // false = ofek(------>)
	public Word(Tile[] t , int row , int col , boolean vertical){
        this.tiles = t;
        this.row=row;
        this.col = col;
        this.vertical = vertical;
    }
    public Tile[] getTile(){
        return this.tiles;
    }
    public int getCol(){
        return this.col;
    }
    public int getRow(){
        return this.row;
    }
    public boolean getVertical(){
        return this.vertical;
    }

    @Override
    public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Word word = (Word) obj; 
            return this.col == word.col && this.row == word.row && this.vertical == word.vertical && Arrays.equals(this.tiles,word.tiles);
        
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.tiles, this.row,this.col,this.vertical);
    }
}
