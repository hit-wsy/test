import java.util.ArrayList;

//用户类
class User {
    public String ID;//用户ID
    public ArrayList<User> friends;//与用户有社交关系的其他用户构成的集合
    public User(String id) { this.ID = id;}
    public void addFriends(ArrayList list) {
        friends.addAll(list);
    }
    public void addFriends(User friend) {
        if (friends.contains(friend)) return;
        friends.add(friend);
    }
} 