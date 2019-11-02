import com.leyou.utils.JWTUtil;

/**
 * 作者：刘时明
 * 时间：2019/11/2-18:28
 * 作用：
 */

public class JWT
{
    public static void main(String[] args)
    {
        String token = JWTUtil.createJWT(1005);
        System.out.println(token);


    }
}
