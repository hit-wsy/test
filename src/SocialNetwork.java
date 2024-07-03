import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private ArrayList<String> nodes = new ArrayList<String>();
    //such as {"a","b","c","d"} 表示微信社交网络中的用户集合
    private ArrayList<String> edges = new ArrayList<String>();
    //such as {"a-b", "a-d", "c-d"} 表示社交网络中社交关系的集合
    //检查用户uID1和uID2之间是否存在社交关系
    public boolean checkExist(String uID1, String uID2) {
        if (edges.contains(uID1 + "-" + uID2)
                || edges.contains(uID2 + "-" + uID1)) return true;
        return false;
    }
    //在用户uID和用户friendID之间添加一条代表社交关系的边
    public void addRelation(String uID, String friendID) {
        edges.add(uID + "-" + friendID);
    }
    //向社交网络中增加一个用户
    public void addUser(String id) {
        nodes.add(id);
    }
    //检查社交网络中是否已包含某个用户
    public boolean findUser(String id) {
        if (nodes.contains(id)) return true;
        return false;
    }
    //将社交网络转化为字符串形式
    @Override
    public String toString() {
        return edges.toString(); // such as "[a-b, a-d, c-d]"
    }
    //根据用户列表userList生成他们之间的社交网络并输出为字符串
    public static String generateSocialNetwork(List<User> userList) {
        SocialNetwork sn = new SocialNetwork();
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (!sn.findUser(u.ID))
                sn.addUser(u.ID);
            List<User> friends = u.friends;
            for (int j = 0; j < friends.size(); j++) {
                User friend = friends.get(j);
                if (!sn.findUser(friend.ID))
                    sn.addUser(friend.ID);
                if (sn.checkExist(friend.ID, u.ID))
                    continue;
                sn.addRelation(u.ID, friend.ID);
            }
        }
        return sn.toString();
    }
}