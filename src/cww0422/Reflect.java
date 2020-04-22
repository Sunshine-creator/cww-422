package cww0422;
 class Cat {
    private String name;
    public Cat(){
        this.name="小猫";
    }
    public Cat(String name) {
        this.name = name;
    }
    public void eat(String food){
        System.out.println(this.name + "正在吃" + food);
    }
}
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {  //反射获取类对象
//     Class catClass = Class.forName("cww0422.Reflect");  //通过字符串获取到类，参数是类的全限定类名，类名加上包名
//        Cat cat = new Cat("小黑");  //通过实例来获取
//        Class catClass2=cat.getClass();
//        System.out.println(catClass==catClass2);
//        Class catClass3 =Cat.class; //通过类来获取
//        System.out.println(catClass==catClass3)
        //通过类对象创建实例
        Class catClass = Class.forName("cww0422.Reflect");  //表示cat类对象
       Cat cat= (Cat)catClass.newInstance();
       cat.eat("牛肉");
    }
}
