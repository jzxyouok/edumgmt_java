// 抽象类一般都是作为父、基类来用的
public abstract class DesignedPage implements Window{

             public void draw(){}

             public void putColor(){}
             // 见文档
             public void fagongzi(){
            	 System.out.println("发工资了");
             }
             // 自己加了抽象方法 子类里必须实现
             public abstract Integer xiabanle();

     }