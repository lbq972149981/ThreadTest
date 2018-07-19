package example;
/**
 * 不可变对象
 */
public class ImmutableObjectPerson {
   private final String name;
   private final String sex;

   public ImmutableObjectPerson(String name, String sex) {
      this.name = name;
      this.sex = sex;
   }

   public String getName() {
      return name;
   }
   public String getSex() {
      return sex;
   }
}