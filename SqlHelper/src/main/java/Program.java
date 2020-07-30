public class Program {
    public static void main(String[] args)
    {
        String sql = SqlBuilder.create().select().column(User::getUserName).from().table(User.class).Build();
        System.out.println(sql);
    }
}
