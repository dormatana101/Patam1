package test;
import java.util.Objects;
import java.util.Random;
public class Tile {
    public final char letter;
    public final int int_score;
    private Tile(char char_letter ,int int_score){
        this.letter = char_letter;
        this.int_score = int_score;
    }
    public static Tile createTile(char letter, int score) {
        return new Tile(letter, score);
    }
    @Override
    public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tile tile = (Tile) obj; 
            return letter == tile.letter && int_score == tile.int_score;
        
    }
    @Override
    public int hashCode() {
        return Objects.hash( letter , int_score);
    }
	
    public static class Bag{
        public int[] Letters ;
        public Tile[] Tiles ;
        private static Bag bag = null;
        private Bag(){
            this.Letters = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
            this.Tiles = new Tile[] {createTile('A', 1),createTile('B', 3),createTile('C', 1),createTile('D', 2),createTile('E', 1),createTile('F', 4),createTile('G', 2),createTile('H', 4),createTile('I', 1),createTile('J', 8),createTile('K', 5),createTile('L', 1),createTile('M', 3),createTile('N', 1),createTile('O', 1),createTile('P', 3),createTile('Q', 10),createTile('R', 1),createTile('S', 1),createTile('T', 1),createTile('U', 1),createTile('V', 4),createTile('W', 4),createTile('X', 8),createTile('Y', 4),createTile('Z', 10)};

        }
        public static Bag getBag() 
        {
            if(bag==null)
            {
                bag=new Bag();
            }
            return bag;
            
        }
        public Tile getRand(){
            boolean flag = true;
            for (int letter : Letters) {
                if(letter!=0)
                    flag=false;
            }
            if(flag)
                return null;
            Random random = new Random();
            int randomLetter = random.nextInt(26);
            if(this.Letters[randomLetter]==0) return null;
            else{
                this.Letters[randomLetter]=--this.Letters[randomLetter];
                return this.Tiles[randomLetter];
            }
            
        }
        public Tile getTile(char c){
            if(c=='_')
                return null;
            if(c<'A'||c>'Z'){
                return null;
            }
            boolean flag = true;
            for (int letter : Letters) {
                if(letter!=0)
                    flag=false;
            }
            if(flag)
                return null;
            int index_letter= c-'A';
            if(this.Letters[index_letter]!=0)
            {
                this.Letters[index_letter]=--this.Letters[index_letter];
                return this.Tiles[index_letter];
            }
            else
            {
                return null;
            }     
        }
        public void put(Tile t){
            int [] Letters_clone = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
            int index_letter= t.letter-'A';
            if(this.Letters[index_letter]!=Letters_clone[index_letter])
            {
                this.Letters[index_letter]++;
            }
        }
        public int size(){
            int count=0;
            for (int x : Letters) {
                count+=x;
            }
            return count;
        }
        public int[] getQuantities() {
            return this.Letters.clone();
        }
    }
}
