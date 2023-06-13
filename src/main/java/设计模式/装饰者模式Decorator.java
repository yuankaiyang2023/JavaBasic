package 设计模式;

/**
 * 抽象组件
 * 
 * 具体组件
 * 
 * 抽象装饰类
 * 
 * 具体装饰类
 * 
 * 装饰者模式在IO里很常见 ，多重装饰，灵活扩展子类功能,减少多个子类的重复代码
 * 
 * @author Administrator
 *
 */
public class 装饰者模式Decorator {
	public static void main(String[] args) {
		Drink c = new Coffee();
		System.out.println(c.info() + "-----" + c.cost());
		Drink milk = new Milk(c);
		System.out.println(milk.info() + "----" + milk.cost());
		Drink sugar = new Sugar(c);
		System.out.println(sugar.info() + "----" + sugar.cost());
		Drink sugar2 = new Sugar(milk);
		System.out.println(sugar2.info() + "----" + sugar2.cost());
		System.out.println(milk.cost());

	}
}

interface Drink {
	double cost();

	String info();

	
}

class Coffee implements Drink {
	private String name = "Coffee";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

abstract class Decorator implements Drink { // 房子装修完后还要还你一个房子
	Drink drink;

	public Decorator(Drink drink) {
		this.drink = drink;

	}

	@Override
	public double cost() {
		return drink.cost() + 0.1;// 抽象父类提供简单装饰，子类重写会覆盖
	}

	@Override
	public String info() {
		return drink.info() + "加点开水吧，我没钱";// 抽象父类提供简单装饰，子类重写会覆盖
	}

}

class Milk extends Decorator {

	public Milk(Drink drink) {
		super(drink);

	}

	@Override
	public double cost() {
		// return this.drink.cost();
		// return super.drink.cost();
		return drink.cost() + 40;
	}

	@Override
	public String info() {
		return drink.info() + "加入了牛奶";
	}

}

class Sugar extends Decorator {
	public Sugar(Drink drink) {
		super(drink);

	}

	@Override
	public double cost() {
		// return this.drink.cost();
		// return super.drink.cost();
		装饰();
		
		return drink.cost() + 20;
	}

	@Override
	public String info() {
		
		return drink.info() + "加入了糖";
	}

	public void 装饰() {
		System.out.println("装饰了一下");

	}
}
