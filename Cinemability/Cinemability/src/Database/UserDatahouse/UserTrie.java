package Database.UserDatahouse;
import java.util.Vector;

import Model.Movies.Movies;
import Model.User.User;


public class UserTrie{
    
    Vector <User> userList = new Vector<User>();
    Vector<Integer> BucketforPointer = new Vector<Integer>();
    final int MAX = (int) (2e5 + 10);
    int[][] trie = new int[MAX][300];
    int[] Count = new int[MAX];
    User[] End = new User[MAX];
    int pointer = 0;
   

    public void Insert(String str, User obj){
        int node = 1;
        for (char ch : str.toCharArray()){
            int edge = (int)ch;
            if (trie[node][edge] == 0){
                if (!BucketforPointer.isEmpty()){
                    trie[node][edge] = (int)BucketforPointer.lastElement();
                    BucketforPointer.remove(BucketforPointer.size() - 1);
                }else trie[node][edge] = ++pointer;
            }
            node = trie[node][edge];
            Count[node]++;
        }
        End[node] = obj;
    }

    public User search(String str){
        int node = 1;
        for (char ch : str.toCharArray()){
            int edge = (int)ch;
            if (trie[node][edge] == 0)return null;
            node = trie[node][edge];
        }
        return End[node];
    }
   
    public void delete(String str){

        if(search(str) != null){
            int node = 1;
            for (char ch : str.toCharArray()){
                int edge = (int)ch;
                int Tempnode = trie[node][edge];
                if (Count[trie[node][edge]] == 1){
                    BucketforPointer.add(trie[node][edge]);
                    trie[node][edge] = 0;
                }
                node = Tempnode;
                Count[node]--;
            }
            End[node] = null;
        }
        
    }

    void getAllUser(int node){
        if (End[node] != null){
            User user = End[node];
            userList.add(user);
        }
        for (int edge = 0; edge < 300; edge++){
            if(trie[node][edge] != 0){
                getAllUser(trie[node][edge]);
            }
        }
    }

    public Vector <User> ShowAllUser(){
        userList.clear();
        getAllUser(1);
        return userList;
    }
}
