package Database.DataStructure.Trie.ObjectbasedTrieImplementation;
import java.util.Vector;
import Model.Movies.Movies;

public class Trie {

    Vector <Movies> userList = new Vector<Movies>();
    class Trienode{
        Vector <Movies> movie = new Vector<Movies>();
        Trienode[] trienode = new Trienode[300];
        int Counter = 0;
        boolean isMovie = false;
    }

    Trienode rootNode;
    public Trie(){
        rootNode = new Trienode();
    }
    public void Insert(String str, Movies movie){
        Trienode node = rootNode;
        for (char ch: str.toCharArray()){
            int edge = (int)ch;
            if(node.trienode[edge] == null){
                node.trienode[edge] = new Trienode();
            }
            node = node.trienode[edge];
            node.Counter++;
        }
        if (str == movie.Title)node.isMovie = true;
        node.movie.add(movie);
    }

    public Vector <Movies> Search(String Email){
        Trienode node = rootNode;
        for (char ch: Email.toCharArray()){
            int edge = (int)ch;
            if(node.trienode[edge] == null)return null;
            node = node.trienode[edge];
        }
        return node.movie;
    }

    void DeleteUser(String Email){
        Trienode node = rootNode;
        if(Search(Email) == null)return;
        for (char ch: Email.toCharArray()){
            int edge = (int)ch;
            Trienode temporaryNode = node.trienode[edge];
            if(temporaryNode.Counter == 1)node.trienode[edge] = null;
            if(node != rootNode)node.Counter--;
            node = temporaryNode;
        }
        node.movie.clear();
    }

    void getAllMovie(Trienode node){
        if (node.movie != null && node.isMovie){
            userList.add(node.movie.lastElement());
        }
        for (int i = 0; i < 300; i++){
            if (node.trienode[i] != null){
                getAllMovie(node.trienode[i]);
            }
        }
    }

    public Vector <Movies> ShowAllMoviesSortedBasedOnMovieTitle(){
        userList.clear();
        getAllMovie(rootNode);
        return userList;
    }

}
