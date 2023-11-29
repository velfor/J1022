public class Main {

    public static void main(String[] args) {
        //наполняем коробки
	    Box<Apple> ba1 = new Box<>();
	    for(int i = 0; i < 10; i++){
	        ba1.addFruit(new Apple());
        }
        Box<Apple> ba2 = new Box<>();
        for(int i = 0; i < 10; i++){
            ba2.addFruit(new Apple());
        }
        //сравниваем веса
        System.out.println(ba1.compare(ba2));
        //перекладываем
        ba1.move(ba2);
        //weight() и isEmpty
        System.out.println(ba1.weight());
        System.out.println(ba1.isEmpty());

        System.out.println(ba2.weight());
        System.out.println(ba2.isEmpty());
    }
}
