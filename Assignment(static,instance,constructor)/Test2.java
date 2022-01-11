public class Test2{

{
System.out.println("This is Instance Block");
}

static{
System.out.println("This is Static Block");
}

public Test2(){
System.out.println("This is Constructor");
}


public static void main(String[] args){


new Test2();

}
}