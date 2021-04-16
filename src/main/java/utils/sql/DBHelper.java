package utils.sql;

/**
 * @Author hezhensheng
 * @Date 2021/4/6
 * @Description
 */
public class DBHelper {

    public static void main(String[] args) {
        System.out.println(shard("1579593319"));
    }

    public static long shard(String shardingKey) {
        int hashValue = shardingKey.hashCode() & Integer.MAX_VALUE;
        return hashValue % 100;
    }
}
