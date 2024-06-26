package Database.UserDatahouse;

import java.util.Vector;

import Model.User.User;

public class UserTrie {

    Vector <User> userList = new Vector<User>();
    class Trienode{
        User user = null;
        Trienode[] trienode = new Trienode[300];
        int Counter = 0;
    }

    Trienode rootNode;
    public UserTrie(){
        rootNode = new Trienode();
    }
    public void Insert(String str, User user){
        Trienode node = rootNode;
        for (char ch: str.toCharArray()){
            int edge = (int)ch;
            if(node.trienode[edge] == null){
                node.trienode[edge] = new Trienode();
            }
            node = node.trienode[edge];
            node.Counter++;
        }
        node.user = user;
    }

    public User Search(String Email){
        Trienode node = rootNode;
        for (char ch: Email.toCharArray()){
            int edge = (int)ch;
            if(node.trienode[edge] == null)return null;
            node = node.trienode[edge];
        }
        return node.user;
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
    }

    void getAllUser(Trienode node){
        if (node.user != null){
            userList.add(node.user);
        }
        for (int i = 0; i < 300; i++){
            if (node.trienode[i] != null){
                getAllUser((node.trienode[i]));
            }
        }
    }

    public Vector <User> ShowAllUser(){
        userList.clear();
        getAllUser(rootNode);
        return userList;
    }

}
