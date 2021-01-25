package reflect.demo7;

public class UserController
{
  private UserService userService;

  public UserService getUserService()
  {
    return userService;
  }

  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }
}
