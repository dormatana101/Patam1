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
    // public static Tile new Tile(char letter, int score) {
    //     return new Tile(letter, score);
    // }
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
            this.Tiles = new Tile[] {new Tile('A', 1),new Tile('B', 3),new Tile('C', 3),new Tile('D', 2),new Tile('E', 1),new Tile('F', 4),new Tile('G', 2),new Tile('H', 4),new Tile('I', 1),new Tile('J', 8),new Tile('K', 5),new Tile('L', 1),new Tile('M', 3),new Tile('N', 1),new Tile('O', 1),new Tile('P', 3),new Tile('Q', 10),new Tile('R', 1),new Tile('S', 1),new Tile('T', 1),new Tile('U', 1),new Tile('V', 4),new Tile('W', 4),new Tile('X', 8),new Tile('Y', 4),new Tile('Z', 10)};

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
            if(size()==0)
                return null;
            Random random = new Random();
            int randomLetter;
            do { 
                randomLetter = random.nextInt(26);
            }while(this.Letters[randomLetter]==0);
            this.Letters[randomLetter]--;
            return this.Tiles[randomLetter];
            
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
                this.Letters[index_letter]--;
                return this.Tiles[index_letter];
            }
            else
            {
                return null;
            }     
        }
        public void put(Tile t){
            int [] Letters_clone = new int[] {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
            if(t!=null){
                int index_letter= t.letter-'A';
                if(this.Letters[index_letter]!=Letters_clone[index_letter])
                {
                    this.Letters[index_letter]++;
                }
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
